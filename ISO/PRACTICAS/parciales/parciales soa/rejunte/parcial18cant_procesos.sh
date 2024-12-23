#!/bin/bash

if [ $# -lt 1 ]; then 
	echo " este script debe recibir 1 parametro" 
	exit 2
fi 


esta_logueado(){
	if [ $# -ne 1 ]; then
		echo " esta funcion debe recibir 1 parametro"
		return 1
	else
		if  [	$(who | cut -d' ' -f1 | grep $1 | wc -l)  -lt 1 ]; then 
			echo "el usurio no esta logueado" 
			return 1
		else 
			echo "el usuario esta logueado" 
			return 0
		fi
	fi 
}

cant_procesos(){
	esta_logueado $1
	if [ $? -eq 0 ]; then
		return $(ps -aux | grep -w $1 | wc -l)
	else
		return 0
	fi

}

uso_de_procesos(){
	cant_procesos $1
	if [ $? -ge 10 ]; then
		return 0
	fi
	return 1

}

usuarios=("$@")
echo "fecha y hora $(date)" >> "/var/log/registro_procesos.log"
#tambien puedo hacer $* en vez d meterlos en un arreglo
for user in "${usuarios[@]}"; do
	uso_de_procesos $user
	if [ $? -eq 0 ]; then
		echo "usuario $user" >> "/var/log/registro_procesos.log"
	fi
done
exit 0
	

			
