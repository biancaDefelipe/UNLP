.data
data: .word 0x10008
control: .word 0x10000
valor: .double 2.5
msj: .asciiz "el resultado es "

.code 
ld $s0, control ($0)
ld $s1, data($0)
l.d f1, valor ($0)

daddi $t1, $0, 8
sd $t1, 0($s0)
l.d f2, 0($s1)

c.le.d f2, f1
bc1f es_mayor
sub.d f1, f1, f2
div.d f1, f1, f2
j sigue 

es_mayor: sub.d f1, f2, f1
          mul.d f1, f1, f2 

    sigue: daddi $t0, $0, 4
           daddi $t1, $0, msj 
           sd $t1, 0($s1)
           sd $t0, 0($s0)
           daddi $t0, $v0, 3
           s.d f1, 0($s1)
           sd $t0, 0($s0)

    halt

