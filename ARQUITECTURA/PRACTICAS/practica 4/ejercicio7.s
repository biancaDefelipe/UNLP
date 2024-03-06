;Escribir un programa que recorra una TABLA de diez números enteros y determine cuántos elementos son mayores que X. 
;El resultado debe almacenarse en una dirección etiquetada CANT. El programa debe generar además otro arreglo llamado RES 
;cuyos elementos sean ceros y unos. Un ‘1’ indicará que el entero correspondiente en el arreglo TABLA es mayor que X, 
;mientras que un ‘0’ indicará que es menor o igual.

.data
tabla: .word 10, 25, 20, 3, 2, 1, 9, 4, 30, 5
res: .word 0,0,0,0,0,0,0,0,0,0
x: .word 5 
cant: .word 0 
long: .word 10 


.code 

ld r1, long(r0)   ; r1= long
ld r2, cant(r0)   ; r2= cant 
dadd r3, r3, r0   ; r3= puntero para avanzar entre los elemntos de la tabla 
daddi r10, r10, 1 ; r10= 1(para poner en 1 x elemento de la tabla)
dadd r9, r9, r0   ; r9= flag (0=>el numero es mayor / 1 =>el numero es menor )

sigo: ld r4, tabla(r3)      ;tomo un elemento de la tabla 
      slti r9, r4, 5 ;si es el elemento es menor a x, r9= 1
      daddi r1, r1, -1      ;decremento LONG 
      bne r9, r0, es_menor  ;si r9 es distinto de 0 entonces el numero es menor 
      ; si el numero es mayor:
      daddi r2, r2, 1       ;incremento CANT
      sd r10, res(r3)       ;guardo '1' en la posición del arreglo 'res' corresponfiente
es_menor: andi r9, r9, 0  ;fuerzo r9 a 0
          daddi r3, r3, 8   ; avanzo al sig elemento
          bnez r1, sigo     ; si no llego al final sigo procesando elementos 
    sd r2, cant(r0)         ;guardo lo que tengo en r2 en la posicion CANT 
    halt