; falta corregir!
org 1000h 
minus db 41h
mayus db 61h 

org 2000h
mov bx, offset mayus 
mov ax, 2
imprimir:int 7
inc mayus
inc minus
cmp mayus, 5Bh
jnz imprimir 
int 0
end


