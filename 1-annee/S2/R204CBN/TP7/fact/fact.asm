.CODE
	factoto PROC
				
			MOV RAX,1
			MOV RBX,2
		
boucle:		CMP RBX,RCX
			JA fin
		
			MUL RBX
			INC RBX
			JMP boucle

fin:		RET ; le r�sultat � retourner est dans RAX

	factoto ENDP
END