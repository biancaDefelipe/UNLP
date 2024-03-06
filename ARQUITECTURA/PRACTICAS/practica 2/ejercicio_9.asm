org 1000h; 
msj_permitido db "acceso permitido" 
        fin_1 db ?
msj_denegado db "acceso denegado"
      fin_2  db ?
            
clave_1 db "1234"

clave_input db ?
org 3000h

org 2000h; 

; leo clave de 4 digitos
mov ah, 04h;
mov bx, offset clave_1
mov bx, offset clave_input 
loop: int 6
inc bx
dec ah 
jnz loop

mov bx, offset clave_1
mov ah, 4
; agarro 1 caract de clave_1
check: mov dh, [bx]

; agarro 1 caract carac de input
add bx, 4 
sub dh, [bx]
jnz denegado
; si coincide agarro otro caract 
sub bx, 3
dec ah
jnz check
jmp permitido

denegado: mov bx, offset msj_denegado
mov al, offset fin_2 - offset msj_denegado
int 7
jmp fin

permitido: mov bx, offset msj_permitido 
mov al, offset fin_1 - offset msj_permitido
int 7
jmp fin 

fin: int 0
end

 