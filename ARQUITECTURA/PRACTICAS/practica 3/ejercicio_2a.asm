pa equ 30h
pb equ 31h 
ca equ 32h
cb equ 33h 

org 1000h
letra db "A"

org 2000h 
    ; PA
    ; pongo strobe en 0 y busy en 1 en 
mov al, 253
out ca, al 
    ; PB 
    ; pongo todos los bits de pb en salida
mov al, 0
out cb, al 

; tomo estado y me fijo si esta libre 
poll: in al, pa
and al, 1
jnz poll

; si esta libre le mando la letra
mov al, letra
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

int 0 
end 





