#!/bin/bash
if [ $# -eq 2 ]; then
  num1=$1
  num2=$2
  echo "multiplicaion: $num1  x $num2 = `expr $num1 \* $num2`"
  echo "suma: $num1 + $num2 = `expr $num1 + $num2`"
  echo "resta: $num1 -  $num2 = `expr $num1 - $num2`"

  if [ $num1 -gt $num2 ]; then 
    echo "$num1 es mayor que $num2"
  elif [ $num2 -gt $num1 ]; then 
    echo "$num2 es mayor que $num1"
  else
    echo "ambos numeros son iguales"
  fi
  exit 0
else     
  exit 1    #esta bien esto? poner el exit y dsp el fi 
fi 
