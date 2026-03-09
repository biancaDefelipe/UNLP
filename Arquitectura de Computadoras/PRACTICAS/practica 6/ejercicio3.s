;Escriba un programa que realice la suma de dos números enteros (de un dígito cada uno) utilizando dos subrutinas: La 
;denominada ingreso del ejercicio anterior (ingreso por teclado de un dígito numérico) y otra denominada 
;resultado, que muestre en la salida estándar del simulador (ventana Terminal) el resultado numérico de la suma de 
;los dos números ingresados (ejercicio similar al ejercicio 7 de Práctica 2).


.data 
CONTROL:       .word32  0x10000
DATA:          .word32  0x10008
msj: .asciiz    "ingrese un numero entero de un digito "
msjError: .asciiz "no se ingreso un numero valido"
res: .word 00



.code
;                         INICIALIZO PILA Y OTRAS COSAS
daddi $sp, $0, 0x400
lwu $s0, DATA ($0)
lwu $s1, CONTROL ($0)


;                          IMPRIMO TEXTO INCIAL
daddi $t0, $0, msj
sd $t0, 0($s0)
daddi $t0, $0, 4
sd $t0, 0($s1)


daddi $t0, $0, 6 
sd $t0, 0($s1) 


;                          LEO OPERANDOS 

      jal ingreso 


fin: halt 



ingreso: daddi $sp, $sp, -8     ; hago un push de $ra
        sd   $ra, 0($sp)

        daddi $t4, $0, 2
       
  leer: daddi $t0, $0, 8 ; cod 8 = leo un num

        sd $t0, 0($s1)             ; CONTROL = 8  

        ld $a0, 0($s0)   ; cargo el num en $a0

;           VERIFICACION
        daddi $t1, $0, 0
        slti $t1, $a0, 0       ;0x30 = 0 
        bnez $t1, error

        slti $t1, $a0, 9       ;0x39 = 9 
        beqz $t1, error

        daddi $sp, $sp, -8
        sd $a0, 0($sp)         ; pusheo num1 y num2
        
        daddi $t4, $t4, -1
        bnez $t4,  leer

       jal resultado 
       ld $ra, 0($sp) ; hago un pop de $ra
       daddi $sp, $sp, 8
    ; vuelvo a poner la dir de retorno de esta subrut
    

      j fin
 
error:   ; limpio pantalla 
            daddi $t0, $0, 6 

            sd $t0, 0($s1) 


            daddi $t0, $0, msjError
            sd $t0, 0($s0)
            daddi $t0, $0, 4
             sd $t0, 0($s1)

          ; limpio pantalla 
            daddi $t0, $0, 6 
            sd $t0, 0($s1) 

          
           j leer

fin: jr $ra


resultado: ; PILA = NUM2
           ;        NUM1
           ;        Ret de la subrutina anterior

;           TOMO NUM2
           ld $t0, 0($sp)
           daddi $sp, $sp, 8
;           TOMO NUM1
           ld $t1, 0($sp)
           daddi $sp, $sp, 8

           dmul $v0, $t0, $t1

          

;          limpio pantalla 
            daddi $t0, $0, 6 

            sd $t0, 0($s1) 

;          IMPRIMO RESULTADO

sd $v0, 0($s0)
daddi $t0, $0, 1
sd $t0, 0($s1)


;          limpio pantalla 
            daddi $t0, $0, 6 

            sd $t0, 0($s1) 


jr $ra


