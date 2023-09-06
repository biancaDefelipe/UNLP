org 1000h
msj db "Ingrese un numero"
fin_msj db ?
adv db "caracter no valido"
fin_adv db ?

org 1700h
num db ?

org 3000h
es_num: mov cl, [bx]
mov dl, 0ffh; primero supongo que si es un numero
cmp cl, 58
jns no_es
cmp cl, 48
js no_es
jmp final
no_es: mov dl, 00h; cargo 0 en dl si el caracter no esta entre 0 y 9 (si no es numero)
final:ret

org 2000h
mov bx, offset msj
mov al, offset fin_msj - offset msj
int 7
mov bx, offset num 
int 6
call es_num
cmp dl, 0ffh
jnz advertencia 
mov al, 1
int 7
jmp fin
advertencia: mov bx, offset adv
mov al, offset fin_adv- offset adv
int 7
fin: int 0
end