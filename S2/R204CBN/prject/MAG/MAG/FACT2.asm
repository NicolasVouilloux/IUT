		LOAD_A_VAL #5
		LOAD_B_A
loop	DEC_B
		JMPZ fin
		MUL_A_B
		JMP loop
fin		NOP