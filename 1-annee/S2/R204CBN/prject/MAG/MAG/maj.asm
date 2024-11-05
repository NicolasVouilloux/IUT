		LOADSI #1        
		LOADBADRSI       


LOOP
		LOADSI #1        
		LOADADRSIB    
		LOADASI          
		CMPB #97        
JMPPZ 		MAJUSCULE  



CONTINUE	INCSI             
		LOADSI #1          
		LOADADRSIB    
		LOADASI           
		CMPB #0           
		JMPPZ fin        
		JMP LOOP        

MAJUSCULE	SUBB #32          
		LOADDIADRSI       
		JMP CONTINUE      


fin		JMP fin      