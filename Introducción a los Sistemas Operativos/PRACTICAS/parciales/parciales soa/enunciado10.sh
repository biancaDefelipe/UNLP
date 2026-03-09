#!/bin/bash 

if [ $# -lt 1 ]; then 
	echo "este script debe recibir al menos 1 parametro"
	exit 1
fi 
inexistentes=0
for elem in "$@"; 
do 
	if [ -f "$elem" ]; then 
		gzip "$elem"
		echo "el archivo $elem ha sido comprimido"
	
	elif [ -d "$elem" ]; then 
		if [ -r "$elem" ]; then 
			tar -czf "${elem}.tar.gz"  "$elem"
			echo "el directorio "$elem" ha sido empaquetado y comprimido" 
		fi
		if [ -w "$elem" ]; then 
			rm -rf "$elem"
			echo "el directorio "$elem" ha sido ha sido eliminado"
		fi 
	else
		echo "el archivo $elem no existe en el filesystem" 
		((inexistentes++))
	fi 
done 

echo "cantidad de archivos inexistentes: $inexistentes"  
exit 0 
