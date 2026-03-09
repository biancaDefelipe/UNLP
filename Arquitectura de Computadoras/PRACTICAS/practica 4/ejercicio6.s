; Escribir un programa que lea tres números enteros A, B y C de la memoria 
; de datos y determine cuántos de ellos son iguales 
; entre sí (0, 2 o 3). El resultado debe quedar almacenado en la dirección de memoria D.

.data
A: .word 12
B: .word 12
C: .word 12
D: .word 0

.code
ld r1, A(r0)
ld r2, B(r0)
ld r3, C(r0)
ld r4, D(r0)

bne r1,r2, cmpAyB
daddi r4, r4, 1

cmpAyB: bne r1, r3, cmpByC
daddi r4, r4, 1

cmpByC: bne r2, r3, fin
daddi r4, r4, 1

fin: sd r4, D(r0)

halt

