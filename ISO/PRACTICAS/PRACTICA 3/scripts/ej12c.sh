#calculadora que ejecute las 4 operaciones básicas: +, - ,*, %.
# Esta calculadora debe funcionar recibiendo la operación y los números como parámetros
#!/bin/bash

if [ $# -ne 3 ]; then
	exit 1
else
	echo "Resultado: $(expr $1 $2 $3)" 
fi
exit 0
