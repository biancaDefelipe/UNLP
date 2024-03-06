.data
num1: .word 2
num2: .word 3

res: .word 0

.code
ld r1, num1(r0)
ld r2, num2(r0)
dadd r3, r0, r0      ; inicalizo r3 en 0
sigo: dadd r3, r3, r1 
daddi r2, r2, -1
bnez r2, sigo 
sd r3, res(r0)
halt