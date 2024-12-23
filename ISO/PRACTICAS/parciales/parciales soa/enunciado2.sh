#!/bin/bash

#arreglo=($(find ~/dir1 -name "*.conf"))
arreglo=($(find ~/dir1 -name "*.conf" | cut -d'/' -f5 | cut -d'.' -f1))


cantidad(){
	echo "cantidad de elementos del arreglo: ${#arreglo[@]}"
}

verArchivos(){
	for elem in ${arreglo[@]};
 do
	echo $elem 
	
done 
}
existe(){
	if [ $# -ne 1 ]; then 
		"esta funcion debe recibir el nombre de un archivo"
		return 1
	else 
		for arch in "${arreglo[@]}";
		do
			#if [[ "$(basename "$arch")" == "$1" ]];then 
			if [[ $arch == $1 ]]
				echo "se encontro el archivo $1 em el directorio /etc"
				return 0
			fi 
		done
		echo "El archivo $1 no existe en el directorio en /etc"		
		return 1
	fi 
}	
eliminar(){

if [ $# -ne 2 ]; then 
	echo "esta funcion debe recibir 2 parametros" 
	exit 1	
else
	indice=0
	for arch in "${arreglo[@]}";
	do
		#name=$( basename "$arch" | cut -d'.' -f1)
		#echo $name
		#if [[ $name == $1 ]]; then 
		if [[ $arch == $1 ]]; then 
		
			echo "se encontro el archivo $1 em el directorio /etc"
			if [[ $2 == "lógico" ]]; then 
				#unset arreglo[indice]
				echo "se selecciono el borrado logico"
				arreglo=("$arreglo[@]/$1}}")
				echo " todo el arreglo ${arreglo[@]}"
				
			elif [ $2 == "físico" ]]; then 
				arreglo=("$arreglo[@]/$1}")
				if [ rm "~/dir/$1" ]; then 
					echo "el archivo $1 ha sido borrado" 
				else 
					echo "no se logró eliminar el archivo $1" 
					
				fi 
			else
				echo "solo se reconocen los modos de eliminacion lógico y físico" 
			fi 
			
		else
			((indice++))
		fi 
	done 
fi 


}



cantidad
echo "------------------------------------------"
verArchivos
echo "------------------------------------------"
eliminar taylor lógico
echo "------------------------------------------"
verArchivos
exit 0
