

;Escribir un programa que permita ingresar 5 caracteres por teclado, 
;mostrando el mensaje "Ingrese 5 caracteres a buscar en la cadena"
; por cada uno de ellos debe invocar a una subrutina ULTPOS que recibe 
;la dirección de comienzo de la cadena y el carácter ingresado, 
;la misma debe devolver la última posición del carácter en la cadena, si no existe devolver -1
; los valores retornados se deben almacenar en una tabla en memoria.
.data 
cadena: .asciiz "ole ole ole ole taylor taylor"
msj: .asciiz     "ingrese 5 caracteres"
data: .word 0x10008
control: .word 0x10000
tabla: .word 0 

.code 
ld $s0, data($0)
ld $s1, control($0)
daddi $s2, $0, 9     ; cod para leer caracter
daddi $s3, $0, 4     ; cod para imprimir msj 



; imprimo msj 

daddi $t0, $0, msj 
sd $t0, 0($s0)
sd $s3, 0($s1)


daddi $s4, $0, 5
daddi $s5, $0, 0    ; desplazamiento para tabla 

; leo un carcater 
  loop: sd $s2, 0($s1)
        lbu $a0, 0($s0)
        daddi $a1, $0, cadena 

        jal ultpos
        sd $v0, tabla($s5)
        daddi $s4, $s4, -1
        daddi $s5, $s5, 8 
        bnez $s4, loop

    halt



ultpos: daddi $v0, $0, -1   
        daddi $t0, $0, 0         ; t0=pos


     seguir: lbu $t1, 0($a1)
        bne $t1, $a0, saltar
        ; si son iguales guardo la pos
        dadd $v0, $0, $t0
        saltar: daddi $a1, $a1, 1
                daddi $t0, $t0, 1
                bnez $t1, seguir 

                jr $ra
