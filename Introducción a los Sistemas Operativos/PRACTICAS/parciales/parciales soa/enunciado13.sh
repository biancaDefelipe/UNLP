#!/bin/bash
#archivo="/var/log/any-service/error.log"

if [ $# -ne 1 ]; then 
	echo "este script debe recibir un parametro" 
	exit 1 
fi
dirDestino=$1
#dirLog="/var/log/any-service"
dirLog="/var/log/dir1"

#dirArch="/var/log/any-service/error.log"
dirArch="/var/log/dir1/error.log"

#dirUsrService=" /var/log/usr-service"
dirUsrService="/var/log/dir2"
#sigo=0

#pongo las verificaciones de dirArch y dirLog afuera por si alguien llega a borrar el directorio o algo, en cada vuelta del while verifico 
#while [ $sigo -eq 0 ]; 
while :  
do 
	if [ -d "$dirDestino" ]; then 
		if [ -d "$dirLog" ]; then 
			if [ -f "$dirArch" ]; then 
			      
				lineas=$(grep -c "FATAL ERROR" "$dirArch")
				if [ $lineas -gt 0 ]; then 
					#tengo que comprimir todo y mandarlos al dirDestino
					echo "pesos destino : $1"
					echo "dir origen: $dirUsrService"
					if [ -d "/var/log/dir2" ] && [ "$(ls -A /var/log/dir2)" ]; then
					    #tar -cPfz -C /var/log/dir3/ /var/log/dir2/ ESTO NO FUNCIONA NO SE PQ
					    tar -cPzf "$dirDestino/compressed.tar.gz" -C /var/log dir2
					else
					    echo "El directorio /var/log/dir2 no existe o está vacío."
					    exit 1  # Termina el script con un código de error
					fi
					
					
					
					echo "cantidad de lineas que continen la cadena FATAL ERROR: $lineas"
					#((sigo++))
					
					exit 0
				else
					echo "no hay ninguna linea que contenga la cadena fatal error..."
				fi
			else
				echo "no se encuentra el archivo $dirArch, :("
			fi 
		else
			echo "no se encuentra el directorio $dirLog :( "
		fi
	else
		echo "no se encuentra el directorio de destino $dirDestino, crealo porfas"
	
	fi
	sleep 180
done 
exit 0
