.data
cadena: .asciiz "adbdcdedfdgdhdid" ; cadena a analizar
car: .asciiz "d" ; caracter buscado
cant: .word 0 ; cantidad de veces que se repite el caracter car en cadena.

.code
daddi r5, r0, 0
lbu r2, car(r0) ; Guardo en R2 el caracter a comparar
daddi r3, r0, 0 ; Guardo en R3 la cantidad

loop: 	lbu r1, cadena(r5) ; Guardo el caracter en r1 de la posición r5
      	beqz r1, fin ; Si caracter = 0 -> salto a fin
        daddi r5, r5, 1 ; Avanzo al siguiente caracter r5+1
	    bne r1, r2, no_es ; Si caracter = r2 -> no es igual
      	daddi r3, r3, 1 ; Si es, sumo +1
no_es: 	j loop
fin:	sd r3, cant(r0)
halt