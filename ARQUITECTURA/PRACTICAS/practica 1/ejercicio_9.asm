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