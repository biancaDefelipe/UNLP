#!/bin/bash
#solicite al usuario 2 números, los lea de la entrada Standard e imprima la multiplicación, suma, resta y cual es el mayor de los números leídos.
echo  "ingrese dos numeros: "
read num1 num2

echo "multiplicaion: $num1  x $num2 = `expr $num1 \* $num2`"
echo "suma: $num1 + $num2 = `expr $num1 + $num2`"
echo "resta: $num1 -  $num2 = `expr $num1 - $num2`"

if [ $num1 -gt $num2]; then 
  echo "$num1 es mayor que $num2"
elif [$num2 -gt $num1]; then 
  echo "$num2 es mayor que $num1"
else
  echo "ambos numeros son iguales"
fi 
 
