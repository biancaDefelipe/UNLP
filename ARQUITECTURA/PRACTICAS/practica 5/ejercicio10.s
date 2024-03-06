Usando la subrutina escrita en el ejercicio anterior, escriir la subrutina CONTAR_VOC, que recibe una cadena 
terminada en cero y devuelve la cantidad de vocales que tiene esa cadena.


.data
cadena: .asciiz "contAndo..."
vocales: .asciiz "aeiouAEIOU"
cant: .word  0

.code
ld $a0, cadena($zero)
jal contar_voc


contar_voc: 
; tomar un caracter de la cadena 
; pasarselo a es_vocal
; llamar a es_vocal
; segun si me devuelve 1 o 0 incrementar variable
; retornar



es_vocal: daddi $v0, $zero, 0         ; inicializo $v0 en 0
          daddi $t0, $zero, 0         ; puntero para recorrer 'vocales'

    loop: lbu $t4, vocales($t0)
          beqz $t4, fin               ;si llegue al final, salto a 'fin'
          beq $t4, $a0, si_es     

          daddi $t0, $t0, 1
          j loop   
    
    si_es: daddi $v0, $v0, 1
    fin: jr $ra
