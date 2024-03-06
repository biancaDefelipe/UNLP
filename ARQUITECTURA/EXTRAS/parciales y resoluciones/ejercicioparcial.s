.data
DATA:     .word 0x10008
CONTROL:  .word 0x10000
VALOR:    .double  2.5
MSJ:      .asciiz "EL RESULTADO ES "


.code 
LD $s0, DATA($0)
LD $s1, CONTROL($0)
L.D f0, VALOR($0)

; LEO NUM
DADDI $t1, $0, 8
SD $t1, 0($s1)
L.D f1, 0($s0)

C.LT.D f1, f0
BC1T ES_MENOR

C.EQ.D f1, f0
BC1F ES_MAYOR 

; SI ES IGUAL EL RESULTADO ES 0 
DADDI $t1, $t0, 0
MTC1 $t1, f3
CVT.D.L f3, f3
J IMPRIMIR

ES_MENOR: 
        ADD.D f2, f0, f1
        DIV.D f3, f2, f1
        J IMPRIMIR 

ES_MAYOR: 
        ADD.D f2,f1, f0
        MUL.D f3, f2, f1
        J IMPRIMIR 

IMPRIMIR: 
        DADDI $t1, $0, MSJ
        SD $t1, 0($s0)
        DADDI $t1, $0, 4
        SD $t1, 0($s1)

        S.D f3, 0($s0)
        DADDI $t1, $0, 3
        SD $t1, 0($t1)

HALT