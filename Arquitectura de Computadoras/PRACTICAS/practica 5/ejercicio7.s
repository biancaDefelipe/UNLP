.data
num: .word 6
tabla: .word 1, 2, 3, 9, 12, 5, 6, 8, 4, 20
cant: .word 10 
cantMayores: .word 0

.code

ld $a0, num ($zero)                       ;$a0 = 6
ld $a1, cant ($zero)                      ;$a1 = cantida de elemetos 
daddi $a2, $zero, tabla                    ;$a2 = dir de inicio de la tabla 

jal cant_mayores
sd $v0, cantMayores($zero)
halt

cant_mayores: dadd $v0, $zero, $zero      ;$v0 = 0 
              dadd $t0, $t0, $zero        ;$t0 = flag para ver si llegue al final
              dadd $t1, $zero, $zero      ;$t1 = fla para ver si el elem es menor

              

        lazo: ld $t4, 0($a2)              ;$t4 = elemento actual de la tabla 
              slt $t1, $t4, $a0           ; comparo elem actual con el numero pasado por parametro
              bnez $t1, menor_igual          ; si es mas chico salto a menor
              dsub $t1, $t4, $a0
              beqz  $t1, menor_igual

              daddi $v0, $v0, 1


        menor_igual: daddi $a1, $a1, -1         ;decremento cantidad de elementos a procesar 
               andi $t1, $t1, 0           ;fuerzo flag para saber si es menor a 0
               daddi $a2, $a2, 8          ;avanzo al siuiente elemento en la tabla 

               dsub $t0, $a1,  $zero           ;slti $t0, $a1, 0 ;me fijo si llegue al final 
               bnez $t0, lazo              ;beqz $t0, lazo             ; si no termina salto a lazo 
               
               jr $ra