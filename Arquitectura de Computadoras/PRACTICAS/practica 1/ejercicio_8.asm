; 8a)
org 1000h
cadena db "arquitectura"
       db 00
org 3000h
longitud: mov dx, 0 ; inicializo contador en 0
     loop:mov ah, [bx]
          cmp ah, 00h
          jz fin
          inc dx
          inc bx
          jmp loop
      fin:ret

org 2000h
mov bx, offset cadena
call longitud
hlt
end
; 8b)
org 1000h
cadena db "aBcDE1#!"
     db 00
     
org 3000h
contar_min: mov dx, 00h
loop:mov ah, [bx]
cmp ah, 00h
jz fin
cmp ah, 61h
js sigo
cmp ah, 7ah
jns sigo
inc dx
sigo: inc bx
jmp loop
fin:ret

org 2000h
mov bx, offset cadena 
call contar_min
hlt
end

; 8c
org 1000h 
res db ?
char db "b"

org 3000h
es_vocal:mov al, 00fh
cmp ah, 41h ; A
jz fin
cmp ah, 45h ; E
jz fin
cmp ah, 49h ; I
jz fin
cmp ah, 4Fh ; O
jz fin
cmp ah, 55h ; U
jz fin
cmp ah, 61h ; a
jz fin
cmp ah, 65h ;e
jz fin
cmp ah, 67h ;i
jz fin
cmp ah, 6fh ;o
jz fin
cmp ah, 75h ;u
jz fin

mov al, 00h 
fin: ret

org 2000h
mov ah, char
call es_vocal
mov res, al
hlt
end

; 8d
org 3000h
contar_vocales:mov cx, 0
loop: mov ah, byte ptr[bx]
cmp ah, 0 ; me fijo si termine de recorrer la cadena 
jz fin
call es_vocal
cmp al, 0ffh
jnz sigo
inc cx
sigo:inc bx
jmp loop
fin:ret

org 4000h 
es_vocal:mov al, 00fh
cmp ah, 41h ; A
jz fin
cmp ah, 45h ; E
jz fin
cmp ah, 49h ; I
jz fin
cmp ah, 4Fh ; O
jz fin
cmp ah, 55h ; U
jz fin
cmp ah, 61h ; a
jz fin
cmp ah, 65h ;e
jz fin
cmp ah, 67h ;i
jz fin
cmp ah, 6fh ;o
jz fin
cmp ah, 75h ;u
jz fin

mov al, 00h 
fin: ret
org 2000h
mov bx, offset cadena
call contar_vocales
mov resultado, cx
HLT
END

; 8e
org 1000h 
cad db "abbcde!"
    db 0
car db "b"

org 3000h
contar_car: mov bx, sp
  ; recupero char buscado
add bx, 4 
mov al, [bx]
  ; recupero inicio de cadena
sub bx, 2 
; inicializo contador 
mov cl, 0

mov dx, [bx]
mov bx, dx
loop:mov dl, [bx]
cmp dl, 0 ; me fijo si llego al final
jz fin
inc bx ; sino incremento bx
cmp al, dl
jnz no_es_char
inc cl
no_es_char:jmp loop
fin:ret

org 2000h
mov al, car
push ax 
mov ax, offset cad
push ax
call contar_car

hlt
end

; 8f
org 1000h 
cad db "abpde!"
    db 0
ori dw 'p'
remp dw 'c'

org 3000h
reemplazar_car: mov bx, sp
  ; recupero char original
add bx, 6
mov al, [bx]
  ; recupero char para reemplazar
sub bx, 2 
mov ah, [bx]
  ;obtengo dir de incio de la cadena
sub bx, 2
mov dx, [bx]
mov bx, dx

loop:mov dl, [bx]
cmp dl, 0 ; me fijo si llego al final
jz fin
inc bx ; sino incremento bx
cmp al, dl
jnz no_es_char
dec bx
mov [bx], ah
jmp fin
no_es_char:jmp loop
fin:ret

org 2000h
mov ax, ori
push ax 
mov ax, remp
push ax
mov ax, offset cad
push ax
call reemplazar_car

hlt
end
