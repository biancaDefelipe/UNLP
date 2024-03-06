org 1000h
msj db "ingrese un numero "
fin_msj db ?

org 1700h
num1 db ? 
num2 db ?
decena db '0'
unidad db 0h
res db ?
org 2000h
mov bx, offset msj 
mov al, offset fin_msj - offset msj 
int 7
mov bx, offset num1
int 6
mov bx, offset msj 
;mov al, offset fin_msj - offset msj 
int 7
mov bx, offset num2
int 6
mov dl, num1
sub dl, 30h
add dl, num2
cmp dl, 3Ah
js imprimir 
sub dl, 10
inc decena
imprimir: mov unidad, dl
mov bx, offset decena
mov al, 2
int 7
int 0 
end

