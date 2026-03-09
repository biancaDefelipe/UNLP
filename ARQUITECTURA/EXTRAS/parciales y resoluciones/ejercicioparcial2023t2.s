.data
control: .word32 0x10000
data: .word32 0x10008
cad_msg: .asciiz 'Cadena con reemplazos:'
minu_msg: .asciiz 'Letras convertidas a minuscula: '
A: .asciiz 'CadeNA ←enTRADa→!!!'
B: .asciiz ''

    .text
daddi $sp,$sp,0x400         ;incializar pila
daddi $a0,$0,A              ;$a0 = dir a
daddi $a1,$0,B              ;$a1 = dir b 
daddi $a2,$0,cad_msg        ;$a2 = dir cad_msg
daddi $a3,$0,minu_msg       ;$a3 = minu_msg
lwu $s6,control($0)         ;$s6 = control
lwu $s7,data($0)            ;$s7 = data
jal procesar_cadena
halt

##recibe dir de A en $a0
##recibe dir de B en $a1
#1.apilar dir de a y b para luego salvar e imprimir
procesar_cadena: 
#guardar direcciones para recorrer
dadd $s0,$0,$a0                     ;$s0 = dir A
dadd $s1,$0,$a1                     ;$s1 = dir B
loop: daddi $sp,$sp,-8              ;salvar $a0
sd $a0,0($sp)

lbu $a0,0($s0)                      ;$a0 = letra act
beqz $a0,fincadena

#------------------------------------------------------------------------

##recibe parametro $a0 un caracter
#llamar a es_mayu, devuelve 1 si es mayuscula, 0 en caso contrario
daddi $sp,$sp,-8                    ;$sp - 8
sd $ra,0($sp)                       ;salvar $ra

jal es_mayu

ld $ra,0($sp)                       ;recuperar $ra
daddi $sp,$sp,8                     ;$sp + 8
#si $v0 = 0, fue minuscula
beqz $v0,minuscula                  ;si $v0 = 0 salta a minuscula, no tiene que convertir nada

#------------------------------------------------------------------------

##recibe caracter mayuscula como parametro y devuelve la minuscula correspondiente en $v0
daddi $sp,$sp,-8                    ;$sp - 8
sd $ra,0($sp)                       ;salvar $ra

jal convertir_minu

ld $ra,0($sp)                       ;recuperar $ra
daddi $sp,$sp,8                     ;$sp + 8

sb $v0,0($s0)                       ;$s0(dir A) se reemplaza por la minuscula
sb $v0,0($s1)                       ;guardar en B la minscula convertida
daddi $s1,$s1,1                     ;avanzar en array de B

#------------------------------------------------------------------------

minuscula: daddi $s0,$s0,1          ;avanzar en array de A
j loop                              ;salta a loop

#------------------------------------------------------------------------
##recibe como parametro en $a0 dir de A
##recibe como parametro en $a1 dir de B
##recibe como parametro en $a2 dir de cad_msg
##recibe como paraemtros en $a3 dir de minu_msg

fincadena: daddi $sp,$sp,8
ld $a0,0($sp)            ;recuperar $a0

daddi $sp,$sp,-8                    ;salvar $ra
sd $ra,0($sp)

jal imprimir

ld $ra,0($sp)
daddi $sp,$sp,8                     ;recuperar $ra
jr $ra
#------------------------------------------------------------------------
##recibe parametro $a0 un caracter
#llamar a es_mayu, devuelve 1 si es mayuscula, 0 en caso contrario
es_mayu: slti $t0,$a0,0x41          ;si 0x41 > $a0(caracter act) => $t0 = 1 si no $t0 = 0
bnez $t0,nomayus                    ;si $t0 = 1 salta
slti $t0,$a0,0x5A                   ;si 0x5A > $a0(caracter act) => $t0 = 1 si no $t0 = 0
beqz $t0,nomayus                    ;si $t0 = 0 salta
daddi $v0,$0,1                      ;$v0 = 1
j sig
nomayus: daddi $v0,$0,0             ;$v0 = 0
sig: jr $ra

#------------------------------------------------------------------------
##recibe caracter mayuscula como parametro y devuelve la minuscula correspondiente en $v0
convertir_minu: daddi $v0,$a0,0x20      ;$a0 + 0x20 = minscula correspondiente
jr $ra
#------------------------------------------------------------------------
##recibe como parametro en $a0 dir de A
##recibe como parametro en $a1 dir de B
##recibe como parametro en $a2 dir de cad_msg
##recibe como paraemtros en $a3 dir de minu_msg
imprimir: daddi $t0,$0,4        ;$t0 = funcion 4(imprimir asciiz)
sd $a2,0($s7)                   ;data = dir de cad_msg
sd $t0,0($s6)                   ;control = funcion 4

sd $a0,0($s7)                   ;data = dir de A
sd $t0,0($s6)                   ;control = funcion 4

sd $a3,0($s7)                   ;data = dir de minu_msg
sd $t0,0($s6)                   ;control = funcion 4

sd $a1,0($s7)                   ;data = dir de B
sd $t0,0($s6)                   ;control = funcion 4

jr $ra
#------------------------------------------------------------------------