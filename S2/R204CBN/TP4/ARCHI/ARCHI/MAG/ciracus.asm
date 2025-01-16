		LOAD_A_VAL #20
loop	LOAD_B_VAL #1
		AND_B_A
		JMPZ pair
		LOAD_B_VAL #3
		MUL_A_B
		LOAD_B_A
		INC_B
		LOAD_A_B
		JMP loop
pair	LOAD_B_A
		DIV_B_VAL #2
		LOAD_A_B
		JMP loop