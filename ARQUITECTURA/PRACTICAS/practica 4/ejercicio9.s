
.data
x: .word 3
y: .word 4
a: .word 2
.code

ld r1, a(r0)    ; r1= a
ld r2, x(r0)    ; r2= x
ld r3, y(r0)    ; r3= y

sigo: beqz r1, fin        ;mientras a no sea cero, sigo
      dadd r2, r2, r3     ;r2 = r2 + r3
      daddi r1, r1, -1    ;decremento r1(a)
     
      j sigo 
      sd r2, x(r0)        ;guardo r2 en x

fin: halt