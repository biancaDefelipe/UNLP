.data 
base: .double 5.58
altura: .double 13.47
sup: .double 0.0

.code 
l.d f1, base($zero)   ; f1 = base
l.d f2, altura($zero) ; f2 = altura

mul.d f3, f2, f1      ;f3 = altura*base
daddi $t0, $zero, 2   ;$t0 = 2
mtc1 $t0, f4          ;f4 = 2 (entero)
cvt.d.l f5, f4        ;f5 = 2.0 (entero)
div.d f6, f3, f5      ;f6 = (base*altura)/2
s.d f6, sup($zero)    ;sup = f6
halt