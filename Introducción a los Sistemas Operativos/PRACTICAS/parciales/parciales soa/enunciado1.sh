#!/bin/bash

cont=0
while [ $cont -lt 10 ] 
do
	if [ -n  $(pgrep -x  "apache") ]; then 
		((cont++))
		echo "se esta ejecutando el comando update notifier, con= $cont"
	fi
	sleep 5
done 
