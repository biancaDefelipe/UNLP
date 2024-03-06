org 1000h
signo db ?
num db ?
org 3000h
restar: cmp dl, 30h
jz fin
dec dl
dec cl
jmp restar
fin:ret

org 2000h
mov bx, offset num 
int 6
mov cl, num
int 6
mov dl, num 
mov ah, 2Bh; 2B ='+'
cmp cl, dl
jns seguir
mov al, cl
mov cl, dl
mov dl, al 
mov ah, 2Dh; 2B ='-'
seguir: call restar
;mov res, cl
mov num, cl
mov signo, ah 
mov bx, offset signo
mov al, 2
int 7
int 0
end
