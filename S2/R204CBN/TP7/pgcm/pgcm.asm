.CODE		
	ppcm PROC
				MOV		AX,CX
				MOV		BX,DX

boucleEXT:		CMP		AX,BX
				JE fin

boucleINT1		CMP		AX,BX
				JAE boucleINT2
				ADD		AX,CX