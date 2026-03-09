#!/bin/bash 

#creo el txt
salida="/var/listado.txt"
>"$salida" 				#redireccion destructiva pq no me dice que no tengo que truncar el arch

#uso getent  passwd para acceder a los usuarios 
# uso grep '/bin/bash' para quedarme con las lineas de usuario cuyo shell sea bash
# uso cut -d: -f6 para quedarme con la columna 6 (donde esta el home) usando : como #delimitador 


for userhome in $(getent passwd | grep '/bin/bash' ); do 
	home=$(getent passwd | grep '/bin/bash'| cut -d: -f6)
	username=$(getent passwd | grep '/bin/bash'| )
	echo $userhome #para probar
	if [ -d "$userhome/mailDir" ]; then 
		echo "encontre 1 usuario q cumple"
		
		#usuario=$($getent passwd | grep '/bin/bash' | cut -d: -f1)
		usuario=$(basename "$userhome")
		echo $usuario
		echo "$usuario" >> $salida
		
	fi
done 

echo "termine"
