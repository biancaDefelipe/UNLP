org 1000h 
num1 dw 5h
num2 dw 3h


org 3000h
swap: mov bx, sp
; recupero dir de num1
add bx, 4 
mov ax, [bx] 
; recupero dir de num2
sub bx, 2
mov cx, [bx]

; tomo valor de num1
mov bx, ax
mov ax, [bx]

; backup de bx
mov dx, bx

; tomo valor de num2
mov bx, cx
mov cx, [bx]

; hago el swap
mov word ptr [bx], ax; dir de num2=valor de num1
mov bx, dx
mov word ptr [bx], cx; dir de num1= valor de num2
ret

org 2000h 
mov ax, offset num1
push ax
mov ax, offset num2
push ax
call swap
hlt 
end