org 1000h
numeros db "cero  " 
        db "uno   "
        db "dos   "
        db "tres  "
        db "cuatro"
        db "cinco "
        db "seis  "
        db "siete "
        db "ocho  "
        db "nueve "
msj db "ingrese un numero "
fin_msj db ?

org 1700h
num db ? 

org 2000h
mov cl, 0 ; inicializo contador de veces consecutivas que se lee 0
seguir: mov bx, offset msj 
        mov al, offset fin_msj - offset msj 
        int 7
        mov bx, offset num
        int 6
        cmp num, 30h
        jnz no_cero
        inc cl
        jmp buscar_num
        ; si no es cero reinicio el contador
no_cero: mov cl, 0

buscar_num: mov bx, offset numeros
            mov al, 6
            mov dl, 30h
loop: cmp num, dl
      jz mostrar
      add bx, 6 ; paso al siguiente num
      inc dl
      jmp loop
mostrar: int 7
        cmp cl, 2
        jnz seguir
int 0
end
        
