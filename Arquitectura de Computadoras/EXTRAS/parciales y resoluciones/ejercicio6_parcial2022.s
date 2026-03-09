; Escribir ña subrutina MIN_MAX que recibe la dirección de comienzo de una tabla 
; y la cantidad de elementos y devuelve el valor máximo y el minimo de dicha tabla.
; Usando la subrutina implementar un programa que obtenga el min y el max de 2 tablas
; Por ultimo, imprimir en la pantalla gráfica un punto de color Verde (0,255,0) en 
; la coordenada (minimo_tabla2, maximo_tabla2) y otro de color azul (0,0, 255) en la 
; coordenada (minimo_tabla1, maximo_tabla1).Usar la convencción para nombrar a los 
;registros 

.data
tabla1:  .word 5, 4, 3, 10, 8, 7
tabla2:  .word 4, 2, 49, 15, 1, 9


data:    .word32 0x10008
control: .word32 0x10000
verde:   .byte 0, 255, 0, 0
azul:     .byte 0, 0, 255, 0


.code
; inicializar cosas
lw $s0, data($0)
lw $s1, control($0)


; obtengo min_max de tabla1
daddi $a0, $0, tabla1
daddi $a1, $0, 6
jal min_max
dadd $s2, $0, $v0  ; s2 = min tabla1
dadd $s3, $0, $v1  ; s3 = max tabla1

; obtengo min_max de tabla2
daddi $a0, $0, tabla2
daddi $a1, $0, 6
jal min_max
dadd $s4, $0, $v0  ; s2 = min tabla2
dadd $s5, $0, $v1  ; s3 = max tabla2

; imprimo en pantalla grafica 
;                limpio pnatalla grafica
daddi $t0, $0, 7
sd $t0, 0($s1)


;     pinto color verde
;lbu $t0, verde($0)
lw $t0, verde($0)
sw $t0, 0($s0)

sb $s5, 4($s0)   ; cargo y2
sb $s5, 5($s0)   ; cargo x2

daddi $t0, $0,5
sd $t0 ,0($s1)

;     pinto color azul
;lbu $t0, azul($0)
lw $t0, azul($0)
sw $t0, 0($s0)

sb $s2, 4($s0)   ; cargo y1
sb $s3, 5($s0)   ; cargo x1

daddi $t0, $0,5
sd $t0, 0($s1)





halt





min_max: 
; recibe en $a0 la dir de comienzo
; recibe en $a1 la cantidad de elementos 
daddi $v0,$0, 1000 ; t1= min
daddi $v1, $0, 0  ; t2= max

daddi $t3, $0, 0

loop: lbu $t0, 0($a0)
      slt $t3, $t0, $v0
      bnez $t3, actualizar_min

      slt $t3, $v1, $t0
      bnez $t3, actualizar_max
      
      j seguir



      actualizar_min: dadd $v0, $0, $t0
                      daddi $t3, $t3, -1 ; reinicio flag
                      j seguir
      actualizar_max: dadd $v1, $0, $t0
                      daddi $t3, $t3, -1
                      j seguir 
     seguir: 
            daddi $a0, $a0, 8 ; avanzo al siguiente
            daddi $a1, $a1, -1 ; me fijo si llegue al final
            bnez $a1, loop

jr $ra