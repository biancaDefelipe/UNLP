; leer un caracter de teclado y: 
;   -Si es "R" leer un string que termina
;    en "." (incluirlo)
;   -Si es "i" imprimir el último string leido en la 
;    impresora por PIO
;   -Si es "f" terminar el programa imprimiendo
;    en pantalla "fin del programa"
      
pa equ 30h
pb equ 31h
ca equ 32h
cb equ 33h



org 1000h
car db ?
flag db 0
msj db "fin del programa"
fin_msj db ? 
longitud db 0
cadena db ? 


org 3000h
rut_f: mov bx, offset msj
mov al, offset fin_msj - offset msj 
int 7
mov flag, 1
ret 

org 4000h 
rut_r: mov bx, offset cadena 
leo: int 6
mov al, [bx]
inc bx 
inc longitud
cmp al, '.'
jnz leo
ret

org 5000h 
rut_i: mov bx, offset cadena 
imprimo:cmp longitud, 0
      jz final 
      
      
        ; espero a que se libere
      poll:in al, pa
            and al, 1
            jnz poll
        ; mando caracater al puerto pb 
      mov al, [bx]
      out pb, al 
        ; pongo strobe en 1
      in al, pa
      or al, 02h
      out pa, al 
        ; vuelvo a poner strobe en 0
      in al, pa
      and al, 0fdh
      out pa, al 
        ; paso al sig caracter y deceremento longitud
      inc bx
      dec longitud
      jmp imprimo
final:ret

org 2000h
;      inicializo impresora
mov al, 0fdh
out ca, al 
mov al, 0 
out cb, al 
in al, pa
and al, 0fdh; fuerzo strobe en 0
out pa, al 

loop: cmp flag, 0
jnz fin 
mov bx, offset car 
int 6
mov dl, [bx] 
cmp dl, 'R'
jz es_r
cmp dl, 'f'
jz es_f
cmp dl, 'i'
jz es_i
jmp loop

es_r: push ax 
call rut_r
pop ax
jmp loop

es_f: push ax
call rut_f
pop ax
jmp loop

es_i: push ax
call rut_i
pop ax
jmp loop

fin:int 0
end




