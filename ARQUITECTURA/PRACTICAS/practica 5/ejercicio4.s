.data
peso: .double 75.7
altura: .double 1.73
imc: .double 0.0
estado: .word 0
infrapeso: .double 18.5
normal: .double 25.0
sobrepeso: .double 30.0


.code
l.d f1, infrapeso($zero)  ;f1= 18.5
l.d f2, normal($zero)     ;f2= 25
l.d f3, sobrepeso($zero)  ;f3=30.0

l.d f4, peso($zero)
l.d f5, altura($zero)

mul.d f6, f5, f5          ;f6= altura*altura 
div.d f7, f4, f6          ;f7= (altura*altura)/ peso 

c.lt.d f7, f1
bc1t p_bajo 

c.lt.d f7, f2
bc1t p_normal

c.lt.d f7, f3
bc1t p_sobrepeso


s.d f7, imc($zero)
daddi $t0, $zero, 4
sd $t0, estado($zero)
j fin

p_bajo: s.d f7, imc($zero)
daddi $t0, $zero, 1
sd $t0, estado($zero)
j fin

p_normal: s.d f7, imc($zero)
daddi $t0, $zero, 2
sd $t0, estado($zero)
j fin 

p_sobrepeso: s.d f7, imc($zero)
daddi $t0, $zero, 3
sd $t0, estado($zero)
j fin


fin: halt 