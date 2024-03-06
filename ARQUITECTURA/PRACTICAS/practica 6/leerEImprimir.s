.data
CONTROL:    .word 0x1000
DATA:       .word 0x1008
CARACTER:   .byte 0

.code 
lwu $s0, CONTROL($zero)
lwu $s1, DATA ($zero)



LOOP: DADDI $t1, $zero, 9        ; t1= cod.op 9 
      SD $t1, 0($s0)             ; CONTROL = 9

      LBU $t1, 0($s1)            ; t1 = caracter ingresado
      


      SB $t1, CARACTER ($zero)   ; guardo 8 bits menos significativos de t1 en caracter 

      DADDI $s3, $zero, CARACTER  ; $s3 = dir de caracter 

      SD $s3, 0($s1)              ; DATA = dir de CARACTER

      DADDI $t1, $zero, 4
      SD $t1, 0($s0)              ; mando cod.op 4 a control para que imprima 


      J LOOP

HALT 

    
