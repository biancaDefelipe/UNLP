; 9a
org 1000h
num db 88h
org 3000h
rotarizq: add ah, ah
adc ah, 0
ret
org 2000h
mov ah, num
call rotarizq
hlt
end

; 9b
org 1000h
num db 88h
cant db 2h

org 3000h
rotarizq: add ah, ah
adc ah, 0
ret

org 4000h
rotarizq_n: cmp dh, 0
jz fin
call rotarizq
dec dh
jmp rotarizq_n

fin:ret
org 2000h
mov ah, num
mov dh, cant
call rotarizq_n
hlt
end

; 9c

org 1000h
num db 88h
cant db 6h

org 3000h
rotarizq: add ah, ah
adc ah, 0
ret

org 4000h
rotarizq_n: cmp dh, 0
jz fin
call rotarizq
dec dh
jmp rotarizq_n
fin:ret
org 5000h
rotarder_n: mov dh, 8
sub dh, bh
call rotarizq_n
ret

org 2000h
mov ah, num
mov bh, cant
call rotarder_n
hlt
end