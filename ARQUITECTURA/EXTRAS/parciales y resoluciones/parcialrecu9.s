.data

tabla:    .word 4, 11, 18, 6, 17, 28, 9, 0, 11, 23, 15, 6, 37, 29, 14
mayor:    .word 10
cantidad: .word 15
nuevo:    .word 0


.code 
ld $t0, tabla($0)
ld $t1, nuevo($0)
ld $t2, cantidad ($0)
ld $t3, mayor($0)
daddi $t4, $0, 0   ;puntero para avanzar en tabla 
daddi $t5, $0, 0   ; cantidad de elemento de 'nuevo'
daddi $t7, $0, 0   ; flag
daddi $t8, $0, 0


loop: ld $t6, tabla ($t4)     ; tomo un elemento de tabla 
      slt $t7, $t6, $t3      
      bnez $t7, seguir
      
      ; si es mayor: 
      sd $t6, nuevo ($t8)   ; lo guardo en nuevo
      daddi $t8, $t8, 8
      daddi $t5, $t5, 1 
      

      seguir: daddi $t4, $t4, 8      ; avanzo al siguiente elem
              daddi $t2, $t2, -1     ; decremento cantidad de elementos a procesar
              daddi $t7, $0, 0       ; reseteo flag 
              bnez $t2, loop

    sd $t5, cantidad($0)
    halt