.data 

A: .word 0
B: .word 0
C: .word 0
res: .word 0
control: .word32 0x10000
data: .word32 0x10008


.code
lw $s0, control($0)
lw $s1, data ($0) 

daddi $s2, $0, 8
;leo a
sd $s2, 0($s0)
ld $a0, 0($s1)
sd $a0, A($0)
;leo b
sd $s2, 0($s0) 

ld $a1, 0($s1)
sd $a1, B($0)
;leo c
sd  $s2, 0($s0)
ld $a2, 0($s1)
sd $a2, C($0) 

jal calculo
sd $v0, res($0) 

sd $v0, 0($s1)
daddi $t0, $0, 2
sd $t0, 0($s0)


halt
calculo:
; (c-a)^b
dsub $v0, $a2, $a0
dadd $t0, $0, $v0
daddi $a1, $a1, -1
potencia: dmul $v0, $t0, $v0
        daddi $a1, $a1, -1
        bnez $a1, potencia 

jr $ra