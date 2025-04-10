                      .data
cerotex:              .asciiz   "Cero"
unotex:               .asciiz   "Uno"
dostex:               .asciiz   "Dos"
trestex:              .asciiz   "Tres"
cuatrotex:            .asciiz   "Cuatro"
CONTROL:              .word32  0x10000
DATA:                 .word32  0x10008
   ;
                      .code
                      lwu    $a0, DATA($zero)
                      daddi  $a1, $zero, 9
                      lwu    $a2, CONTROL($zero)
                      daddi  $a3, $zero, 4
                      jal    ingre
;  �Copiar en otro registro?
                      jal   muestra
                      halt
    ;
        ingre:        sd   $a1, ($a2)
                      lbu  $v0, ($a0)
                      daddi  $v0, $v0, - 0x30
                      dadd  $t2, $v0, $zero
                      slti  $t3, $t2, 0
                      bnez  $t3, ingre
                      daddui $t2, $t2, - 10
                      slti  $t3, $t2, 0 
                      beqz  $t3, ingre
                      jr   $ra
    ;
      muestra:        beq  $v0, $zero,  ceroo
                      daddi  $v0,  $v0, -1 
                      beqz  $v0,  unoo
                      daddi  $v0,  $v0, -1
                      beqz  $v0,  doso
                      daddi  $v0,  $v0, -1
                      beqz  $v0,  treso
                      daddi  $v0,  $v0, -1
                      daddi  $t4, $t4, cuatrotex
                      sd   $t4, ($a0)
                      sd   $a3, ($a2)
                      j     afuera
        ceroo:       daddi  $t4, $t4, cerotex
                     sd   $t4, ($a0)
                     sd   $a3, ($a2)
                     j     afuera
         unoo:       daddi  $t4, $t4, unotex
                     sd   $t4, ($a0)
                     sd   $a3, ($a2)
                     j     afuera
         doso:       daddi  $t4, $t4, dostex
                     sd   $t4, ($a0)
                     sd   $a3, ($a2)
                     j     afuera
        treso:       daddi  $t4, $t4, trestex
                     sd   $t4, ($a0)
                     sd   $a3, ($a2)
       afuera:       jr   $ra