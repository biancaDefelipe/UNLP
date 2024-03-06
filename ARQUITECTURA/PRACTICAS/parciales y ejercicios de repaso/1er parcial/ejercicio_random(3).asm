;Escribir un programa para MSX88 que deberá utilizar las luces de la siguiente forma.
; Leer caracteres continuamente en un lazo, y según el carácter leído 
; realizar las siguientes funciones:
; a. Si el carácter es “w” (ASCII 119), 
;    sumar 1 al byte que indica qué luces se prenden y apagan
;    (Ej: de 01000101 a 01000110)
; b. Si el carácter es “s” (ASCII 115), 
;    invertir el byte que indica qué luces se prenden y apagan (Ej:
;    de 01000101 a 10111010)
; c. Si el carácter es “q” (ASCII 113),
;    mostrar el mensaje “Fin del programa.” y finalizar el mismo.
;d. Si el carácter no es ninguno de los anteriores, 
;   mostrar el mensaje “Comando inválido”
;   Las funciones ”a”, “b”, “c” y “d” deben implementarse 
;   utilizando subrutinas. (8 ptos)


pio equ 30h 
org 1000h 
msj_invalido db "comando invalido"
msj_fin_programa db "fin del programa"
caracter db ?
flag db 0

org 3000h 
rut_w: push ax
in al, pio +1
add al, 1
out pio +1, al
pop ax
ret 


org 4000h 
rut_s: push ax
in al, pio +1
not al 
out pio +1, al 
pop ax
ret

org 5000h
rut_q: push ax
mov bx, offset msj_fin_programa
mov al, offset caracter - offset msj_fin_programa
int 7
mov flag, 1
pop ax
ret

org 6000h 
rut: push ax
mov bx, offset msj_invalido
mov al, offset msj_fin_programa - offset msj_invalido
int 7 
pop ax
ret 

org 2000h 
mov al, 0
out pio +3, al 


loop: cmp flag, 0
      jnz fin
      mov bx, offset caracter
      int 6 
      mov al, [bx]
      cmp al, 'w'
      jz es_w

      cmp al, 's'
      jz es_s

      cmp al, 'q'
      jz es_q

      call rut
      jmp loop
      
      es_w: call rut_w
      jmp loop
      es_s: call rut_s
      jmp loop
      es_q: call rut_q
      jmp loop

fin: int 0 
end
