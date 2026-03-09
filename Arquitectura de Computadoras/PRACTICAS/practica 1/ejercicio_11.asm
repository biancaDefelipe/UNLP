; 11a
org 1000h 
num1 dw 6h
num2 dw 2h


org 3000h
div: mov bx, sp
; recupero num1
add bx, 4 
mov ax, [bx]
; recupero num2
sub bx, 2
mov cx, [bx]

; inicializo contador
mov dh, 0

; me fijo que ninguno de lo op. sea 0
cmp ax, 0
jz fin
cmp cx, 0 
jz fin
inc dh
; resto divisor -dividendo hasta que sea menor que el divisor 

loop:sub ax, cx
cmp cx, ax
js sigo
jz sigo

fin:ret
sigo: inc dh
jmp loop

org 2000h 
mov ax,  num1
push ax
mov ax, num2
push ax
call div
hlt 
end


; 11b
org 1000h 
num1 db 5h
num2 db 2h


org 3000h
; me fijo si alguno de los num es cero
resto: cmp ah, 0
jz fin
cmp al, 0
jz fin

div:sub al, ah
js resto
inc cl
jmp div 
res:add al, ah ; recupero resto 
mov dl, al
fin: ret 

org 2000h 
mov al,  num1

mov ah, num2

call resto
hlt 
end

