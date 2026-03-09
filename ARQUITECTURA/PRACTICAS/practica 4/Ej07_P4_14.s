                     .data
TABLA:        .word 1,4,5,6,6,8,2,2,9,10
RES:            .word 1,1,1,1,1,1,1,1,1,1
X:                 .word 4
LONG:         .word 10
CANT:         .word 0
MASK:         .word 0x8000
                     .code
                      LD   R1, LONG(R0) ;r1= long
                      LD   R2, X(R0)    ;r2=x
                      LD   R7, MASK(R0) ;r7=mask
                      DADD  R3, R0, R0  ;r3=puntero 
                      DADD  R5, R0, R0
SIGO:            LD    R4, TABLA(R3) ; tomo un elemento de la tabla 
                      DSUB R4, R4, R2 ; resto cant al elemento que tome de la tabla
                      BEQZ R4, IGMEN ;si es r4 quedo en 0 es el nmismo num 
                      AND  R4, R4, R7 ; aplico mask 
                      BNEZ  R4,  IGMEN
                      DADDI R5, R5, 1
                      J  MAYOR
IGMEN:         SD  R0, RES(R3)
MAYOR:        DADDI  R1, R1, -1
                      DADDI  R3, R3, 8
                      BNEZ    R1, SIGO
                      SD  R5, CANT(R0)
                      HALT
