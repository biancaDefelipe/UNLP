; Modifique el programa de modo que las coordenadas y color del punto sean 
; ingresados por teclado.

.data 
coorX:    .byte 0 ; coordenada X de un punto 
coorY:    .byte 0 ; coordenada Y de un punto 
color:    .byte 0 ; color: máximo rojo + máximo azul => magenta 
CONTROL:  .word32 0x10000 
DATA:     .word32 0x10008 
msjX:     .asciiz   "ingrese coordenada x: "
msjY:     .asciiz   "ingrese coordenada y: "
msjRGB:   .ascii    "ingrese tres valores para el color (r, g, b)"

 
.text 
lwu $s6, CONTROL($zero) ; $s6 = dirección de CONTROL 
lwu $s7, DATA($zero) ; $s7 = dirección de DATA 

daddi $t0, $zero, 7 ; $t0 = 7 -> función 7: limpiar pantalla gráfica 
sd $t0, 0($s6) ; CONTROL recibe 7 y limpia la pantalla gráfica 

;--------------------------------------------LEO COOR Y 
;                            imprimo msj
daddi $t0, $0, msjY  
sd $t0, 0($s7)
daddi $t0, $0, 4
sd $t0, 0($s6)
;                             leo
daddi $t0, $0, 8
sd $t0, 0($s6)
lbu $t1, 0($s7)
SB $t1, coorY($0)
;                          limpio pantalla
daddi $t1, $0, 6 
sd $t1, 0($s1) 

;--------------------------------------------LEO COOR X
daddi $t0, $0, msjX  
sd $t0, 0($s7)
daddi $t0, $0, 4
sd $t0, 0($s6)
;                             leo
daddi $t0, $0, 8
sd $t0, 0($s6)
lbu $t1, 0($s7)
SB $t1, coorX($0)
;                          limpio pantalla
daddi $t1, $0, 6 
sd $t1, 0($s1) 

;--------------------------------------------LEO COLOR
;                            imprimo msj
daddi $t0, $0, msjRGB
sd $t0, 0($s7)
daddi $t0, $0, 4
sd $t0, 0($s6)

jal leerRGB




;lbu $s0, coorX($zero) ; $s0 = valor de coordenada X 
;sb $s0, 5($s7) ; DATA+5 recibe el valor de coordenada X 

;lbu $s1, coorY($zero) ; $s1 = valor de coordenada Y 
;sb $s1, 4($s7) ; DATA+4 recibe el valor de coordenada Y 

;lwu $s2, color($zero) ; $s2 = valor de color a pintar 
; sw $s2, 0($s7) ; DATA recibe el valor del color a pintar 

; daddi $t0, $zero, 5 ; $t0 = 5 -> función 5: salida gráfica 
; sd $t0, 0($s6) ; CONTROL recibe 5 y produce el dibujo del punto 
 
 DADDI $t0, $zero, 7
    SD $t0, 0($s6)
    
    LBU $s0, coorX($zero)
    SB $s0, 5($s7)

    LBU $s1, coorY($zero)
    SB $s1, 4($s7)

    LWU $s2, color($zero)
    sw $s2, 0($s7)
    
    DADDI $t0, $zero, 5
    SD $t0, 0($s6)         

halt



leerRGB:; leo rgb (no leo alfa pq no se usa en este simulador)
;daddi $t3, $0, 3            ;cantidad de numeros a leer
;daddi $t4, $0, 0            ; desplazamiento

  DADDI $a0, $0, 0    ;CONTADORES PARA LEER
    DADDI $a1, $0, 4
loop:  LOOP: DADDI $t1, $0, 8
        SB $t1, 0($s6) 
        LBU $t3, 0($s7) 
        SB $t3, color($a0)
        DADDI $a0, $a0, 1   ;AVANZO AL SIGUIENTE BYTE
    bne $a0, $a1 ,LOOP



;                             leo
       ; daddi $t0, $0, 8
       ; sd $t0, 0($s6)
       ; lbu $t1, 0($s7)
       ;  SB $t1, color($s4)
        ;lbu $t2, 0($s7)
        ;sb $t2, color( $t4)
       ; sb $s7, color($t4) 

       ; daddi $t4, $t4, 1
       ; daddi $t3, $t3, -1
       ; bnez $t3, loop
jr $ra


;                             leo
daddi $t0, $0, 8
sd $t0, 0($s6)
lbu $t1, 0($s7)
SB $t1, coorY($0)