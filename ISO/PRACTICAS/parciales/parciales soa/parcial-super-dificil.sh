#!/bin/bash


if [ "$#" -lt 2 ]; then
    echo "este script requiere de al menos 2 parametros"
    exit 1
fi


fecha="$1"
shift #corro todos los ars para la izq eliminando el primero
arreglo_ips=("$@") # me quedo con todas las ips


archivo_logs="/var/log/nginx/access.${fecha}.log"

# me fijo si existe 
if [ ! -f "$archivo_logs" ]; then
    echo "error: no hay un archivo de log para la fecha $fecha"
    exit 2
fi


for ip in "${arreglo_ips[@]}"; do
    # cuento cant de accesos por ip y lo imprimo en pantalla 
    # el ^ es para que agarre la el numero que representa la ip solo si esta al prinicipio (no se que tanto cambia pero por las dudas)
    access_count=$(grep "^$ip -" "$archivo_logs" | wc -l)
    
    # imprimir usando -e para q agarre caracteres especiales y el \t es para el tab
    echo -e "$ip\t$access_count"
done
exit 0
