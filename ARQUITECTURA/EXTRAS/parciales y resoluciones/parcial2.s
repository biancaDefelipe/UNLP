.data

.code 
daddi $t7, $0, 6
daddi $t7, $t7, 57
siguiente: daddi $t7, $t7, -1
            bnez $t7, siguiente 

halt 