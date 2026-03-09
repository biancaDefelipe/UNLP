.data
data:     .word32 0x10008
control:  .word32 0x10000
valor:    .double 2.5
x:        .double 0.0
res:      .double 0.0
msj:      .asciiz "el resultado es: "


.code
ld $s0, control($0)
ld $s1, data($0)
; leo un caracter
daddi $t0, $0, 8
sd $t0, 0($s0)

; lo guardo en f1 y en x 
ld $t1, 0($s1)
mtc1 $t1, f1
cvt.d.l f1, f1
;l.d f1, 0($s1)
s.d f1, x($0)


; comparo a ver si es mayor o menor 
l.d f2, valor($0)
c.lt.d f1, f2
bc1t es_menor

c.eq.d f1, f2
bc1f es_mayor

; si los numeros son iguales imprime 0.0
mtc1 r0, f5
cvt.d.l f4, f5
j imprimir 


es_mayor: ; (x-valor)*x
            sub.d f3, f1, f2  ; f3= x - valor 
            mul.d f4, f3, f1

            j imprimir 





es_menor: ; (valor -x)/x
            sub.d f3, f2, f1
            div.d f4, f3, f1
            j imprimir 
            


imprimir: 
         daddi $t0, $0, msj
         sd $t0, 0($s1)

         daddi $t0, $0, 4
         sd $t0, 0($s0)

         s.d f4, 0($s1)
         daddi $t0, $0, 3
         sd $t0, 0($s0)

halt


