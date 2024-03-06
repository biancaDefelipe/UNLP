;Escriba un programa que calcule el resultado de elevar un valor en punto flotante a la potencia indicada por un 
;exponente que es un número entero positivo. Para ello, en el programa principal se solicitará el ingreso de la base (un 
;número en punto flotante) y del exponente (un número entero sin signo) y se deberá utilizar la subrutina 
;a_la_potencia para calcular el resultado pedido (que será un valor en punto flotante). Tenga en cuenta que 
;cualquier base elevada a la 0 da como resultado 1. Muestre el resultado numérico de la operación en la salida estándar 
;del simulador (ventana Terminal).


.data 
CONTROL:          .word32 0x10000
DATA:             .word32 0x10008
msjBase:         .asciiz "numero en pujnto flotante para la base : "
msjExponente:    .asciiz "numero entero sin signo para el exponente: "
RES:               .double 0.0
BASE:              .double 0.0
EXPONENTE:         .word 0



.code
;                         INICIALIZO PILA Y OTRAS COSAS
daddi $sp, $0, 0x400
lwu $s1, CONTROL($0)
lwu $s0, DATA($0)


;                          IMPRIMO MENSAJE BASE
daddi $t0, $0, msjBase
sd $t0, 0($s0)

daddi $t1, $0, 4
sd $t1, 0($s1)


;                          LEO BASE
daddi $t1, $0, 8
sd $t1, 0($s1)
l.d f1, 0($s0)           ;f1 = base 
s.d f1, BASE($0)


;                        LIMPIO LA PANTALLA 
daddi $t1, $0, 6 
sd $t1, 0($s1) 

;                          IMPRIMO MENSAJE EXPONENTE
daddi $t0, $0, msjExponente
sd $t0, 0 ($s0)

daddi $t1, $0, 4
sd $t1, 0($s1)


;                          LEO EXPONENTE
daddi $t1, $0, 8
sd $t1, 0($s1)
ld $t1, 0($s0)           ;$t1 = base 
sd $t1, EXPONENTE($0)

;                        LIMPIO LA PANTALLA 
daddi $t0, $0, 6 
sd $t0, 0($s1) 


; llamo a la subrut 
jal a_la_potencia

; guardo resultado en res
s.d f2, RES($0)

;                              IMPRIMO RESULTADO 

s.d f2, 0($s0)
daddi $t0, $0, 3
sd $t0, 0($s1)

halt 


a_la_potencia:
; cargo base en f1 y exponente en t1
        l.d f1, BASE($0)
        ld $t1, EXPONENTE($0)              


        daddi $v0, $0, 0                    ; inicializo res en 0
       

        beqz $t1, exponenteCero            ;si exp es cero el resultado va ser 1

        mov.d f2, f1                        ;primera iteracion afuera para ver si el exp es 1 
        daddi $t1, $t1, -1
        beqz $t1,  terminar
        loop: mul.d f2, f2, f1                
            daddi $t1, $t1, -1
            bnez $t1, loop
        j terminar

        exponenteCero: daddi $v0, $0, 1
                      mtc1 $v0, f2
                      cvt.d.l f2, f2
                   
    

        terminar:
              
              jr $ra






