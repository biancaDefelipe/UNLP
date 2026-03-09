
pic EQU 20H 
eoi EQU 20H
f10 EQU 10

org 40
ip_f10 dw rut_f10

org 1000h 
letra db ?



org 2000h
cli
mov al, 0FEh; deshabilito todo menos f10
out pic +1, al
mov al, f10
out pic +4, al 
mov dh, 41h
mov bx, offset letra
sti

reiniciar:mov dh, 41h ; codigo de A
loop: cmp dh, 5Bh; codigo de [
      jz reiniciar
      inc dh
      jmp loop


org 3000h
rut_f10: push ax
         push dx
         mov letra, dh
         ; configuro impresion
         mov al,1
         int 7
         mov al, eoi
         out eoi, al 
         pop dx
         pop ax
         iret
end
         
         


