pa equ 30h
pb equ 31h
ca equ 32h
cb equ 33h

org 1000h
car db ?

org 3000h 
ini_imp: mov al, 0fdh; 
out ca, al 
mov al, 0 
out cb, al 
in al, pa
; fuerzo strobe 
and al, 0fdh 
out pa, al 
ret

org 4000h
; fuerzo strobe a 1
imprimo:in al, pa
or al, 02h
out pa, al 
in al,pa
; vuelvo a poner strobe en 0 
and al, 0fdh 
out pa, al 
ret 

org 2000h 
mov cl, 35h ;cantidad de caracteres a imprimir
push ax
call ini_imp
pop ax

mov bx, offset car
loop:int 6
poll: in al, pa
and al, 01h
jnz poll
mov al, [bx]
out pb, al 

push ax
call imprimo 
pop ax
dec cl
cmp cl, 30h
jnz loop
int 0 
end 








