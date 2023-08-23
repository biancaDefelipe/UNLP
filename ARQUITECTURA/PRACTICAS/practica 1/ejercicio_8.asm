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