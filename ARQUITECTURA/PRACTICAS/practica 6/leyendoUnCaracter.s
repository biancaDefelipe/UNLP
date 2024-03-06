.data 
texto: .asciiz "Ingrese un texto. Para que el texto se imprima ingrese la tecla ENTER" ; El mensaje a mostrar
CONTROL: .word32 0x10000 
DATA: .word32 0x10008 

textoInput: .asciiz  " "


.text 

; IMPRIMIR MENSAJE INICIAL
lwu $s0, DATA($zero) ; $s0 = dirección de DATA

daddi $t0, $zero, texto ; $t0 = dirección del mensaje a mostrar

sd $t0, 0($s0) ; DATA recibe el puntero al comienzo del mensaje

lwu $s1, CONTROL($zero) ; $s1 = dirección de CONTROL

daddi $t0, $zero, 4 ; $t0 = 4 -> función 4: salida de una cadena ASCII

sd $t0, 0($s1) ; CONTROL recibe 4 y produce la salida del mensaje

; LEER UN CARACTER

daddi $t1, $zero, 9        ; t1= cod.op 9 para leer un char 
sd $t1, 0($s1)             ; CONTROL = 9 (leo un caracter)
LBU $t1, 0($s0)            ; t1 = caracter ingresado

 ; LIMPIAR PANTALLA
daddi $t0, $zero, 6 ; $t0 = 6 -> función 6: limpiar pantalla alfanumérica 

sd $t0, 0($s1) ; CONTROL recibe 6 y limpia la pantalla
    
 ; IMPRIMIR CARACTER LEIDO
sb $t1, textoInput($zero)   ; guardo 8 bits menos significativos de t1 en texto_input
 

DADDI $s3, $zero, textoInput ; $s3 = dir de caracter 

      SD $s3, 0($s0)              ; DATA = dir de CARACTER

      DADDI $t1, $zero, 4
      SD $t1, 0($s1)              ; mando cod.op 4 a control para que imprima 
halt