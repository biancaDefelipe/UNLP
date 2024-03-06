;  modifique el programa de modo que el mensaje a mostrar sea ingresado por teclado en lugar de ser un mensaje fijo.

.data 
texto: .asciiz "Ingrese un texto. Para que el texto se imprima ingrese la tecla ENTER (maxiimo 40 caract)" ; El mensaje a mostrar
CONTROL: .word32 0x10000 
DATA: .word32 0x10008 

textoInput: .asciiz  "                                        "

 
.text 
;               IMPRIMO TEXTO INCIAL
lwu $s0, DATA($zero) ; $s0 = dirección de DATA

daddi $t0, $zero, texto ; $t0 = dirección del mensaje a mostrar

sd $t0, 0($s0) ; DATA recibe el puntero al comienzo del mensaje

lwu $s1, CONTROL($zero) ; $s1 = dirección de CONTROL

daddi $t0, $zero, 4 ; $t0 = 4 -> función 4: salida de una cadena ASCII

sd $t0, 0($s1) ; CONTROL recibe 4 y produce la salida del mensaje

;              LIMPIO LA PANTALLA

daddi $t0, $zero, 6 ; $t0 = 6 -> función 6: limpiar pantalla alfanumérica 

sd $t0, 0($s1) ; CONTROL recibe 6 y limpia la pantalla


;              LOOP DE LECTURA DE CARACTERES
;//////////////////
DADDI $s4, $zero, 13               ; s4= ascii de la tecla enter
 DADDI $t4, $zero, 0        ; reg de desplazamiento 
seguir: DADDI $t0, $zero, 9        ; t0= cod.op 9 para leer un char 
       


        SD $t0, 0($s1)             ; CONTROL = 9 (leo un caracter)

        LBU $t1, 0($s0)            ; t1 = caracter ingresado

        beq $t1, $s4, terminar     ; si t1 es igual al ascii de enter entonces tengo que terminar
        ; sino guardo el caracter e  incremento desplazamiento 
     
        sb $t1, textoInput($t4)   ; guardo 8 bits menos significativos de t1 en texto_input

        daddi $t4, $t4, 1
        j seguir


            ; si termine, limpio la pantalla
terminar: daddi $t0, $zero, 6 ; $t0 = 6 -> función 6: limpiar pantalla alfanumérica 
          sd $t0, 0($s1) ; CONTROL recibe 6 y limpia la pantalla

          daddi $t0, $zero, textoInput  ; $t0 = dirección del mensaje a mostrar
          sd $t0, 0($s0) ; DATA recibe el puntero al comienzo del mensaje

          daddi $t0, $zero, 4 ; $t0 = 4 -> función 4: salida de una cadena ASCII

          sd $t0, 0($s1) ; CONTROL recibe 4 y produce la salida del mensaje
halt