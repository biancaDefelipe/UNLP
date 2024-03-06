.data
cadena: .asciiz "adbdcdedfdgdhdid" ; cadena a analizar
car: .asciiz "d" ; caracter buscado
cant: .word 0 ; cantidad de veces que se repite el caracter car en cadena.



.code
lbu r1, car(r0)             ;r1 = caracter buscado
dadd r2, r0, r0             ;r2= puntero a un elemento de la tabla
dadd r3, r0, r0             ;r3= cantidad de veces que se repite el caracter
;lbu r4, cadena(r2)          ;r4= 1 caracter de la cadena 


;loop: beqz r4, fin          ;como es un asciiz puedo chequearsi llegue al final comparanco con cero
       
;      daddi r2, r2, 1       ;avanzo en la tabla
;      bne r4, r1, sigo      ;si no son iguales salto a fin
;      sd r3, cant(r0)
      
      
;      daddi r3,r3,1         ;sino, incremento cantidad de veces que se repite
;sigo: lbu r4, cadena(r2)    ;r4= 1 caracter de la cadena 
;      j loop
      
loop: lbu r4, cadena(r2)
      beqz r4, fin
      daddi r2, r2, 1
      bne r4, r1, loop
      
      daddi r3, r3, 1
      j loop

fin: sd r3, cant(r0)
halt