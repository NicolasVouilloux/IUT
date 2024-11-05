.DATA

	a		REAL8 ?
	b		REAL8 ?
	c		REAL8 ?
	x		REAL8 ?
	tmp		REAL8 ?

.CODE
	polynome2int PROC

		; la fonction appelante passe a dans RCX, b dans RDX,
		; c dans R8 et x dans R9

		MOVSD			a,XMM0		;RCX
		MOVSD			b,XMM1		;RDX
		MOVSD			c,XMM2		;R8
		MOVSD			x,XMM3		;R9

		; ici IMUL fait une multiplication entière signée de RAX
		; (64 bits) par un autre registre ou une autre variable
		; entière de 64 bits et stocke le résultat sur 128 bits dans
		; RDX:RAX mais on supposera ici que le résultat tient sur
		; 64 bits seulement (soit RAX)
			
		MOVSD	XMM0,x
		MULSD	XMM0,x			; calcul de n^2
		MULSD	XMM0,a					; calcul de a*n^2
		MOVSD	tmp,XMM0		; stockage du résultat temporaire

		MOVSD XMM0,x
		MULSD XMM0,b				; calcul de b*n

		ADDSD XMM0,tmp			; calcul de a*n^2 + b*n
		ADDSD XMM0,c			; calcul de a*n^2 + b*n + c

		RET					; le résultat à retourner est dans RAX

	polynome2int ENDP
END