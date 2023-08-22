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