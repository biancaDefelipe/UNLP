pa equ 30h
pb equ 31h
ca equ 32h
cb equ 33h

eoi equ 20h 
imr equ 21h 
int0 equ 24h

id_f10 equ 10

org 40
ip_f10 dw rut_f10

org 1000h
termine db 0
cant db 0
cadena db ? 

org 3000h
rut_f10: mov al, 0ffh
out imr, al 
mov termine,1
mov al, eoi
out eoi, al 
iret

org 2000h
cli 

mov al, 0feh
out imr, al 
mov al, id_f10
out int0, al 

mov al, 0fdh
out ca, al 
mov al, 0
out cb, al
in al, pa 
and al, 0fdh
out pa, al 

sti 

mov bx, offset cadena 
leer: int 6
inc bx
inc cant 
cmp termine, 0
jz leer

mov bx, offset cadena 
poll: in al, pa 
and al, 1
jnz poll
mov al, [bx]
out pb, al 

in al, pa 
or al, 02h
out pa, al

in al, pa
and al, 0fdh
out pa, al 

inc bx
dec cant 
jnz poll

int 0
end




