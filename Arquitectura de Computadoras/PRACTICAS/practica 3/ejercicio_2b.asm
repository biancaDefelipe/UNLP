pa equ 30h
pb equ 31h 
ca equ 32h
cb equ 33h 

org 1000h
msj db "ORANIZACION Y ARQUITECTURA DE COMPUTADORAS"
fin db ?


org 2000h 
    ; PA
    ; pongo strobe en 0 y busy en 1 en 
mov al, 11111101b
out ca, al 
    ; PB 
    ; pongo todos los bits de pb en salida
mov al, 00000000b
out cb, al 

    ; copio direccion de inicio del msj en bx
mov bx, offset msj 


; tomo estado y me fijo si esta libre 
poll: in al, pa
      and al, 1
      jnz poll

; si esta libre le mando 1 letra
mov al, [bx]
out pb, al 

; pongo strobe en 1 para que imprima 
  ; tomo estado
in al, pa 
  ; fuerzo bit de strobe a 1
or al, 2
out pa, al 


; una vez que imprimo 
; vuelvo a poner strobe en 0
in al, pa 
and al, 253; 253 =11111101
out pa, al

; tomo la siguiente letra
inc bx
; me fijo si no llegue al final 
cmp bx, offset fin
jnz poll

int 0 
end 





