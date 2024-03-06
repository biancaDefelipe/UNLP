.data
cadena: .asciiz "HolAaaa"
cadenaMAYUS: .asciiz "         "


.code 

daddi $a0, $0, cadena 
jal mayuscula

halt 

mayuscula: 
    loop:  lbu $t0, 0($a0)
            beq $t0, $0, fin


            slti $t1, $t0, 0x61
            bnez  $t1, no_es
            slti $t1, $t0, 0x7b
            beqz $t1, no_es
; si no es minuscula copio lo que ya estaba y sigo recorriendo
            daddi $t1, $t0, -0x20
            j seguir
            
    no_es: daddi $t1, $t0, 0
    seguir: sb $t1, cadenaMAYUS($a0)
            daddi $a0, $a0, 1
            j loop  
    fin: jr $ra
