eoi equ 20h 
imr equ 21h 
int2 equ 26h
hand_e equ 41h
hand_d equ 40h 


id_hand equ 10

org 40
ip_hand dw rut_hand

org 1000h
msj db "UNIVERSIDAD NACIONAL DE LA PLATA"
fin db ?

org 3000h
rut_hand: mov al, [bx]
out hand_d, al 
inc bx
dec cl 
mov al, eoi
out eoi, al 
iret

org 2000h

cli 
mov al, 0fbh
out imr, al 
mov al, id_hand
out int2, al 

in al, hand_e
or al, 80h
out hand_e, al 
mov bx, offset msj 
mov cl, offset fin- offset msj 

sti 
 
loop:cmp cl, 0
jnz loop


int 0
end




