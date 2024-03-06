               .data
     texto:    .asciiz "HHHHHHHHHH" ; El mensaje a mostrar
   CONTROL:    .word32 0x10000
      DATA:    .word32 0x10008
               .text
               lwu $s0, DATA(r0) ;     $s0 = dirección de DATA
               ;daddi $t0, $0, texto ;  $t0 = dirección del mensaje a mostrar
               ;sd $t0, 0($s0) ;        DATA recibe el puntero al comienzo del mensaje
               lwu $s1, CONTROL(r0) ;  $s1 = dirección de CONTROL
               daddi $t0, $0, 6 ;      $t0 = 6 -> función 6: limpiar pantalla alfanumérica
               sd $t0, 0($s1) ;        CONTROL recibe 6 y limpia la pantalla
               daddi $t5, $0, 0
               daddi r15, $0, 10
      sigo:    daddi  $t0, $0, 9
               sd $t0, 0($s1)
               lbu $t2, 0($s0)
               sb $t2, texto($t5)
               daddi $t5, $t5, 1
               daddi r15, r15, -1
               bnez  r15, sigo
               daddi $t0, $0, texto
               sd  $t0, 0($s0)
               daddi $t0, $0, 4 ;      $t0 = 4 -> función 4: salida de una cadena ASCII
               sd $t0, 0($s1) ;        CONTROL recibe 4 y produce la salida del mensaje
               halt