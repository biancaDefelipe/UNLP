;Escriba un programa que utilice sucesivamente dos subrutinas: La primera, denominada ingreso, debe solicitar el 
;ingreso por teclado de un número entero (de un dígito), verificando que el valor ingresado realmente sea un dígito. La 
;segunda, denominada muestra, deberá mostrar en la salida estándar del simulador (ventana Terminal) el valor del 
;número ingresado expresado en letras (es decir, si se ingresa un ‘4’, deberá mostrar ‘CUATRO’). Establezca el pasaje 
;de parámetros entre subrutinas respetando las convenciones para el uso de los registros y minimice las detenciones 
;del cauce (ejercicio similar al ejercicio 6 de Práctica 2).


.data 
CONTROL:       .word32  0x10000
DATA:          .word32  0x10008
msj: .asciiz    "ingrese un numero entero de un digito "
msjError: .asciiz "no se ingreso un numero valido"
cero: .asciiz   "cero"
uno: .asciiz    "uno"
dos: .asciiz    "dos"
tres: .asciiz   "tres"
cuatro: .asciiz "cuatro"
cinco: .asciiz  "cinco"
seis: .asciiz   "seis"
siete: .asciiz  "siete"
ocho: .asciiz   "ocho"
nueve: .asciiz  "nueve"

.code
;                         INICIALIZO PILA Y OTRAS COSAS
daddi $sp, $0, 0x400
lwu $s0, DATA ($0)
lwu $s1, CONTROL ($0)

; flag 
daddi $a1, $0, 0

;                          IMPRIMO TEXTO INCIAL
daddi $t0, $0, msj
sd $t0, 0($s0)
daddi $t0, $0, 4
sd $t0, 0($s1)


daddi $t0, $0, 6 
sd $t0, 0($s1) 


;                          LOOP PRINCIPAL 

loop: bnez $a1, fin
      jal ingreso 
      j loop

fin: halt 


ingreso: 
        daddi $t0, $0, 8 ; cod 8 = leo un num

        sd $t0, 0($s1)             ; CONTROL = 8  

        ld $a0, 0($s0)   ; cargo el num en $a0

;           VERIFICACION
        daddi $t1, $0, 0
        slti $t1, $a0, 0       ;0x30 = 0 
        bnez $t1, terminar

        slti $t1, $a0, 9       ;0x39 = 9 
        beqz $t1, terminar

        daddi $sp, $sp, -8     ; hago un push de $ra
        sd   $ra, 0($sp)
       jal muestra 
       ld $ra, 0($sp) ; hago un pop de $ra
       daddi $sp, $sp, 8
    ; vuelvo a poner la dir de retorno de esta subrut
    

      j fin
 
terminar:   ; limpio pantalla 
            daddi $t0, $0, 6 

            sd $t0, 0($s1) 

            daddi $a1, $0, 1
            daddi $t0, $0, msjError
            sd $t0, 0($s0)
            daddi $t0, $0, 4
             sd $t0, 0($s1)

          ; limpio pantalla 
            daddi $t0, $0, 6 
            sd $t0, 0($s1) 

          


fin: jr $ra


muestra: 
; mostrar el digito ingresado expresado el letras 

  ; limpio pantalla 
            daddi $t0, $0, 6 

            sd $t0, 0($s1) 
daddi $t1, $0, cero     ; t1= dir de etiqueta cero
daddi $t2, $0, 8        ; t2= 8
dmul $t3, $t2, $a0      ; t3= cuanto me quiero desplazar desde el cero

;dadd $t1, $t1,  $t3     ; t1= dir del ascii a imprimir 
;sd $t1, 0($s0)          ; se la envio a DATA
daddi $t4, $t3, cero
sd $t4, 0($s0)

daddi $t0, $0, 4        ; t0= codOp 4 ( imprimir un asciiz)
sd $t0, 0($s1)          ; le digo a control que imprima 

 ; limpio pantalla 
            daddi $t0, $0, 6 

            sd $t0, 0($s1) 
jr $ra