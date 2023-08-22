; 6a)
   org 1000h
num1 db 3
num2 db 5
res dw ?

      org 2000h
mov ax, 0
mov cl, num1
cmp cl, 0
jz fin
mov ch, 0
mov dl, num2
loop: cmp dl, 0
      jz fin
      add ax, cx
      dec dl
      jmp loop
fin:mov res, ax
    hlt
    end

; 6b)
   org 1000h
num1 db 3
num2 db 5
res dw ?

  org 3000h
mul: mov ax,0
     cmp dl, 0
     jz fin
     mov ch, 0
loop:add ax, cx
      dec dl
      jnz loop
fin: ret
      org 2000h
mov cl, num1
mov dl, num2
call mul
mov res, ax
hlt 
end

; 6c)
   org 1000h
num1 dw 3h
num2 dw 5h
res dw ?

  org 3000h
mul: mov ax,0
;obtengo num1
;   bx=dir de num1
     mov bx, cx
;   cx= contenido de num1
     mov cx, [bx]
;obtengo num2
;   bx= dir num2
     mov bx, dx
;   dx= contenido de num2
     mov dx, [bx]
     cmp dl, 0
     jz fin
loop:add ax, cx
      dec dx
      jnz loop
fin: ret
      org 2000h
mov cx, offset num1
mov dx, offset num2
call mul
mov res, ax
hlt 
end









