.CODE
	pgcd PROC
				
			MOV EAX,EDX

boucle:		MOV EDX,0
			DIV ECX
			MOV EAX,ECX
			MOV ECX,EDX
			CMP EDX,0
			JNE boucle

			RET ; le r�sultat � retourner est dans RAX

	pgcd ENDP
END
