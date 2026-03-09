;5a)
org 1000h
a dw 5h
b dw 3h
c dw 2h
d dw ?

org 2000h
mov ax, a
add ax, b
sub ax, c
mov d, ax
hlt
end.

;5b)
org 1000h
a dw 5h
b dw 3h
c dw 2h
d dw ?

org 3000h
calculo: mov ax, a
add ax, b
sub ax, c
mov d, ax
ret

org 2000h
call calculo
hlt
end.

;5c)
        org 1000h
a dw 5h
b dw 3h
c dw 2h
d dw ?
        org 3000h
;recibo a, b y c en ax, bx y cx y devuelvo el resultado en dx
calculo: mov dx, ax
add dx, bx
sub dx, cx
ret

      org 2000h
mov ax, a
mov bx, b
mov cx, c
call calculo
mov d, dx
hlt 
end


; 5d
;En el inciso b se utilizan variables globales por ende el codigo no es reutilizable 
;En el inciso c se utiliza el pasaje de parametros por registro y por valor por ende puedo
;reutilizar la subrutina con los numeros que yo quiera simplemente modificando los parametros que 
;le envio a traves de los registros ax, bx, y cx