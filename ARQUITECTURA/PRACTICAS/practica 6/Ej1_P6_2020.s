.data
texto:	.asciiz	"Hola, Mundo!"		; El mensaje a mostrar
CONTROL:	.word32	0x10000
DATA:	.word32	0x10008
	
	.text
	lwu	$s0, DATA(r0)	; $s0 = direcci�n de DATA
	daddi	$t0, $0, texto	; $t0 = direcci�n del mensaje a mostrar
	sd	$t0, 0($s0)	; DATA recibe el puntero al comienzo del mensaje

	lwu	$s1, CONTROL(r0)	; $s1 = direcci�n de CONTROL
	daddi	$t0, $0, 6	; $t0 = 6 -> funci�n 6: limpiar pantalla alfanum�rica
	sd	$t0, 0($s1)	; CONTROL recibe 6 y limpia la pantalla

	daddi	$t0, $0, 4	; $t0 = 4 -> funci�n 4: salida de una cadena ASCII
	sd	$t0, 0($s1)	; CONTROL recibe 4 y produce la salida del mensaje
	halt
