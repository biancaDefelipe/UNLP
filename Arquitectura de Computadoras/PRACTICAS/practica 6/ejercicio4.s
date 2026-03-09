; Escriba un programa que solicite el ingreso por teclado de una clave (sucesión de cuatro caracteres) utilizando la 
; subrutina char de ingreso de un carácter. Luego, debe comparar la secuencia ingresada con una cadena almacenada 
; en la variable clave. Si las dos cadenas son iguales entre si, la subrutina llamada respuesta mostrará el texto 
; “Bienvenido” en la salida estándar del simulador (ventana Terminal). En cambio, si las cadenas no son iguales, la 
; subrutina deberá mostrar “ERROR” y solicitar nuevamente el ingreso de la clave.



.data 
CONTROL:       .word32  0x10000
DATA:          .word32  0x10008
msjBienvenido:  .asciiz  "Bienvenido"
msjError:       .asciiz  "ERROR"
clave:          .asciiz "12aB"
input:          .asciiz "    "


.code

;                         INICIALIZO PILA Y OTRAS COSAS
daddi $sp, $0, 0x400
lwu $s0, DATA ($0)
lwu $s1, CONTROL ($0)




leerInput: 
            daddi $s2, $0, 4
            daddi $a0, $0, 0                   ;$a0 = desplazamiento
            ;                 LEO LA CLAVE 
            loop: 
                jal char 
                daddi $s2, $s2, -1
                bnez $s2, loop
            ;                COMPARO QUE SEA IGUAL

            ;daddi $t0, $0, 0
            daddi $v0, $0, 0                ; flag a pasarle a respuesta 
            ;daddi $t4, $0, 4

            recorrer: ld $t1, clave($0)
                      ld $t2, input($0)
                      dsub $t0, $t1, $t2
                      ;daddi $t4, $t4, -1 
                      ;beqz $t4, final 

                      ;bne $t0, $t2, distintas
                      bnez $t0, distintas 

            distintas: daddi $v0, $v0, 1

            final:  ;daddi $sp, $sp, -8     ; hago un push de $ra
                    ;sd   $ra, 0($sp)
                    jal respuesta 
                    ;ld $ra, 0($sp)         ; hago un pop de $ra
                    ;daddi $sp, $sp, 8

            bnez $v0, leerInput

                
 

char: daddi $t1, $0, 9              ; t1= cod.op 9 
      sd $t1, 0($s1)              ; CONTROL = 9

      lbu $t1, 0($s0)              ; t1 = caracter ingresado

      sb $t1, input($a0)            ; guardo 8 bits menos significativos de t1 en input
      daddi $a0, $a0, 1    
      
      jr $ra



respuesta: 
            bnez $v0, error
            daddi $t0, $0, msjBienvenido ; $s3 = dir de caracter 
            sd $t0, 0($s1)              ; DATA = dir de msjBienvenido
            daddi $t1, $0, 4
            sd $t1, 0($s0)              ; mando cod.op 4 a control para que imprima 
            j fin
         
            error: 
                daddi $t0, $0, msjError ; $s3 = dir de caracter 
                sd $t0, 0($s1)              ; DATA = dir de msjError
                daddi $t1, $0, 4
                sd $t1, 0($s0)              ; mando cod.op 4 a control para que imprima 

            fin:
                jr $ra
                
