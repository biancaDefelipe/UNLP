
.data
cadena1: .asciiz "cadena"
cadena2: .asciiz "cadEna"
res: .word 0

.code
daddi $a0, $zero, cadena1
daddi $a1, $zero, cadena2

jal comparar
sd $v0, res($zero)
halt


;recibe dir de cadena1 en $a0 y dir de cadena2 en $a1
comparar: 
daddi $v0, $zero, 0                         ;$v0 = pos actual de las cadenas  

sigo: lbu $t4, 0($a0)
      lbu $t5, 0($a1)

      beqz $t4, fin_cadena1
      beqz $t5, fin

      bne $t4, $t5, fin
      
      daddi $a0, $a0, 1
      daddi $a1, $a1, 1
      
      daddi $v0, $v0, 1

      j sigo
fin_cadena1: beqz $t5, fin
            daddi $v0, $zero, -1
 
fin: jr $ra

