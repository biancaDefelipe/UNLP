.data
leet_letras: .asciiz "a, e, i, o, s, t"
leet_car:    .asciiz "4, 3, 1, 0, 5, 7"

fin: .asciiz "." ; 2eh
data:  .word 0x10008
control:  .word 0x10000
str_original .asciiz "                                          " ; 40 caract max
str_leet .asciiz "                                          "



msj: .ascii "ingrese una cadena de no mas 40 caracteres."
.code
ld $s0, data($0)
ld $s1, control($0)

                    ;imprimo mensaje inicial e inicializo cosas
daddi $t0, $0, msj
sd $t0, 0($s0)
daddi $t0, $0, 4
sd $t0, 0($s1)
daddi $sp, $0, 0x400


;                   paso parametros y llamo a la subrutina para leer cadena 
ld $a0, fin($0)
daddi $a1, $0, str_original
jal str_read

;                   llamo a la subrut que me arma la nueva cadena 
jal str_leet

; limpio la pantall 
daddi $t0, $0, 6
sd $t0, 0($s1)   

daddi $t0, $0,  str_leet
sd $t0, 0($s0)
daddi $t0, $0, 4
sd $t0, 0($s1)   ; imprimo nueva cadena 

halt 
; termino 


str_read
    ; lee caracteres y los guarda en un string hasta que se lee el caracter de fin 
    ; el caracter de fin y la dir del string se pasan por parmetro 
    ; el string terminado deben terminar en cero

    loop:  dadd $t2, $0, 0  
            daddi $t0, $0, $9   ; leo
            sd $t0, 0($s1)

            ld $t1, 0($s0)      ; cargo char en $t1
            dsub $t2, $t0, $a0  ; me fijo si es = a '.'
            bnez $t2, seguir     ; sino es igual sigo 
            j terminar
            seguir: sd $t1 , 0($a1)
                    daddi $a1, $a1, 8 ; avanzo una posicion
                    j loop
    
    terminar: jr $ra







car_let: 
; recibe un caracter y lo convierte a su equivalente leet si es necesario. 
; si no tiene equivalente leet devolver el caracter original 


; recibo en a0 el caracter

    daddi $t0, $0, $0
    dadd $v0, $0, $a0

    buscar: ld $t2, leet_letras($t0)
            dsub $t3, $t2, $a0

            bnez $t3, no_es
            ld $v0, leet_car ($t0)

            j listo
         
    no_es:  daddi $t0, $0, 8
            bnez $t2, buscar 

    listo: jr $ra

str_leet: 
; recibe un string terminado en 0 y convierte sus caracteres a leet

; recibo dir de origen del string en $a0

daddi $s0, $0, 0
recorrer:   lbu $s1, 0($a0)
; hago lugar en la puila para guardad $ra
            daddi $sp, $sp, -8
            sd $ra, 0($sp)
            
    ; llamo a la subrut que me reemplaza el caracter de ser necesario
            jal car_let 
            sd $v0, str_leet($t1)
            ; desapilo $ra
            ld $ra, 0($sp)
            daddi $s0, s0, 8


            bnez $t1, recorrer
