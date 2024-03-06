; Escribir un programa que utilizando el puerto PA del PIO 
;reciba una cadena de 5 caracteres desde un dispositivo generico.Este
; dispositivo envia la cadena de a un caracter a la vez.Los caracteres se
; deben recibir desde el dispositivo uno por uno, esperando 10 segundos 
; entre cada recepción.El programa debe finalizar cuando se han recibido 
; todos los caracteres de la cadena o cuando se presiona la tecla F10

pic equ 30h 
imr equ 21h 
n_f10 equ 10 
n_clk equ 20

pa equ 30h 
ca equ 32h
timer_cont equ 10h 
timer_comp equ 11h 

org 40 
ip_f10 dw rut_f10

org 80 
ip_timer dw rut_clk

org 1000h
car db ?
    db ?
    db ? 
    db ?
    db ? 
can db 30h 

org 3000h 
rut_clk: push al 
in al, pa 
mov [bx], al 
inc bx
inc cant 
mov al, 0 
out timer_cont, al 
mov al, 20h 
out pic, al 
pop ax
iret

org 4000h 
rut_f10: push ax
mov al, 0ffh 
out imr, al 
mov al, 20h 
out pic, al 
pop ax
iret

org 2000h 
mov al, 0ffh 
out ca, al 

cli
mov al , 0fdh
out imr, al 

mov al, n_clk

sti 