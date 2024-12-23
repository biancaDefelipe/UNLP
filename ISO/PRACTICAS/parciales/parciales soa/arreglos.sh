distros=(Ubuntu Linux Mint 1234 Deepin Manjaro Elementary)
echo "----------IMPRIMIENDO EL ERREGLO INCIAL---------------"

for i in "${distros[@]}"
do 0
	echo $i

echo "----------IMRPRIMIENDO 3 ELEMENTOS DEL ARREGLO COMENZANDO DESDE LA POS 0----------"
 
echo ${distros[@]:0:3}

#añadir un elemento por delante 
distros=(Arch  "${distros[@]}")
echo "----------IMPRIMEINDO EL ARREGLO DESPUEWS DE AGREGAR ARCH AL PRINCIPIO----------"
for i in "${distros[@]}"
do
 	echo $i
done 

#AÑADIR UN ELEMENTO AL FINAL 
distros=("${distros[@]}" Kali)
echo "----------IMPRIMIENDO EL ARREGLO DESPUES DE AGRERGAR KALI AL FINAL----------"
for i in "${distros[@]"
do
	echo $i
done 

#ALIMINACION DE ELEMENTOS 
#con unset borrpo elemento dejando la posicion vacia (cuando hago uyn for no me la muestra) 
unset distros[0]
echo "----------IMPRIMRINEDO EL ARREGLO DESPUES DE BORRAR  ARCH---------"
for i in "${distros[@]"
	echo $i
done 
 
#para borrar una posicion puedo hacer un corrimiento 

distros=(Arch "${distros[@]")
#voy a eliminar 1234
distros=("${distros[@]:0:3}" "${distros[@]:4}")
echo "----------IMPRIMIENDO EL ARREGLO DESPUES DE BORRAR  1234----------"
for i in "${distros[@]}"
do
	echo $i
done 
