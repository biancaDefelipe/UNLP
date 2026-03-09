

.data
car: .ascii "i"
vocales: .asciiz "aeiouAEIOU"
flag: .word 0

.code
lbu $a0, car($zero)
jal es_vocal
sd $v0, flag($zero)
halt 



es_vocal: daddi $v0, $zero, 0         ; inicializo $v0 en 0
          daddi $t0, $zero, 0         ; puntero para recorrer 'vocales'

    loop: lbu $t4, vocales($t0)
          beqz $t4, fin               ;si llegue al final, salto a 'fin'
          beq $t4, $a0, si_es     

          daddi $t0, $t0, 1
          j loop   
    
    si_es: daddi $v0, $v0, 1
    fin: jr $ra





