#!/bin/bash



for user in $(cat /etc/passwd); do 
	
	home=$(echo "$user" | cut -d: -f6)
	echo " el HOME es $home"
	shell=$(echo "$user" | cut -d: -f7)
	
	if [ -d "$home"  ]; then
		if [  $(ls $home | grep mailDir | wc -l) -gt 0 ] && [ $shell="bash" ]; then 
			echo "$(echo "$user" | cut -d':' -f1)" >> "/var/log/listado.txt"
		fi 
	else
		echo " no existe el HOME" 
	fi 
done

exit 0


