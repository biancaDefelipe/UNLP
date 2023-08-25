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

