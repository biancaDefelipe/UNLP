   .data
valor: .double 10.00
control: .word 0x10000
data: .word 0x10008
msj: .asciiz 'el resultado es:'

    .text
##cargar control y data
ld $s6,control($0)
ld $s7,data($0)

##leer flotante(X)
daddi $t0,$0,8  ;funcion 8(leer numero)
sd $t0,0($s6)   ;control = funcion 8
l.d f0,0($s7)   ;f0 = X

##ver si es mayor o menor a valor
#en f0 tenemos X y en f1 tendremos Valor
l.d f1,valor($0)    ;f1 = valor
c.lt.d f1,f0        ;si f0 > f1 => fp=1 si no fp=0
bc1t mayor          ;si fp = 1 salta

##si X fue menor a valor sigue
#hace (valor-x)/x
sub.d f1,f1,f0      ;resta f1(valor)-f0(x)
div.d f1,f1,f0      ;divide f1(valor-x) / f0(x)
j print             ;salta a imprimir

##si fue mayor f0(X) con f1(valor)
#hace (X-valor)*X
mayor: sub.d f1,f0,f1   ;resta f0(x)-f1(valor)
mul.d f1,f1,f0          ;multiplica f1(x-valor) * f0(X)

##imprime
print: daddi $t0,$0,msj
sd $t0,0($s7)
daddi $t0,$0,4
sd $t0,0($s6)
daddi $t0,$0,3   ;funcion 3 imprimir punto flotante
s.d f1,0($s7)            ;data = numero calculado
sd $t0,0($s6)           ;control = funcion 3
halt
