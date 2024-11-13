int main(){
	struct sockaddr_in sa={ //sockaddr_in est le type d'addresse qu'on va utiliser (internet (in)) et on fait un structure de internet socket
			sa.sin_family=t AF_INET;
			sa.sin_port= htons(5015); //cast en version net(htons) de 5015 pour preciser que port
			sa.sin_addr.s_addr= htons(INADDR_ANY); //voir cours pour la vrai syntaxe c'est marqué
	};

	int slis=socket(AF_INET,SOCK_STREAM,0);
	if(bind(slis,(struct sockaddr*) & sa, sizeof(sa))==-1){ //c'est pour le com ligne 2 que la on cast en sockaddr générique car bind prend un truc generique puis se refere 
															// aux parametres de la structure
		perror("bind error");exit(1);}	
		
	char buff[256];
	listen(slis,7);
	int sc;
	fd_set master,temp;
	int maxfd=slis; //premier argument de select = socket avec la plus grande valeur donc on garde ça au cas ou
	FD_ZERO(&master);
	FD_SET(slis,&master);

	while(1){
		temp=master;
		select(maxfd+1,&temp,NULL,NULL,NULL); //select retire tous les descriptors qui sont pas prets
												//c'est pour ça qu'on va avoir une temporaire -> pour le remettre a 
												// son état de base avant traitement
		//  /!\exemple ce que qu'on va utiliser  : FD_ISSET(fd,&temp) test si fd est dans le temp
		for(int fd=0; fd<=maxfd ; fd++){ //parcourir tous les sockets du set (c des int donc on peut juste faire comme ça)
			if(!FD_ISSET(fd,&temp))continue; //si pas selectionné on degage (retourne a l'attente)
			if(fd==slis){ //on va accepter que si le socket actuel est celui du serveur, le seul qui listen enft
				sc=accept(slis,NULL,NULL); // ne va pas foirer grace au if precedent
				FD_SET(sc,&master); 
				max_fd = (maxfd > sc) ? maxfd : sc ; //si maxfd > sc maxfd=maxfd sinon maxfd=sc
				continue;
			} //from now on, tjrs dans le loop et on parcours toujours les sockets mais juste pas le serv
			nb=read(fd,buff,sizeof(buff));
			if(nb<=0){
				shutdown(fd,SHUT_RDWR);
				close(fd);
				FD_CLR(fd,&master);
				continue; //à noter que les continue retournent en haut du for, pas du while
			}
			for(int i=0;i<nb;i++){ //maintenant qu'on sait qu'on nous a envoyé un message
				buff[i]=toupper(buff[i]); //on le met en majuscule
			}
			//write(fd,buff,nb); //et on le renvoie
			for (int cl = 0;cl<=maxfd;cl++){
				if(!FD_ISSET(cl,&master))continue;
				if(cl==fd || cl==se)continue;
				write(cl,buff,nb);
				//send it to every member of the group
			}
		
		}
	}
}
/*
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
//////////           /////////////////////////            /////////////////////////////////////
//////////           /////////////////////////            ////////////////////////////////////////////
//////////  (a)      /////////////////////////  (a)       ///////////////////////////////////////////
//////////           /////////////////////////            ////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
///////////////////                                       ////////////////////////////////////////////////////////
///////////////////////                               ////////////////////////////////////////////////////
//////////////////////////            i             /////////////////////////////////////////////////
//////////////////////////////        i          ///////////////////////////////////////////
/////////////////////////////////     i     ////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
*/

/* 1. On crée la socket du client. */

    struct sockaddr_in saserv={};
    saserv.sin_family= AF_INET;
    saserv.sin_port= htons(PORT_SERVEUR); 
    saserv.sin_addr.s_addr= htons(INADDR_ANY); //mettre le parametre
	
    char buffer[BUFFER_SIZE]={0};
    int sclient=socket(AF_INET,SOCK_STREAM,0);


  /* 3. On demande une connexion au serveur, tant qu'on y arrive pas. */
    while(1){
    int nb=connect(sclient,(struct sockaddr*) & saserv, sizeof(saserv));
        if(nb==-1){perror("bind error");exit(1);}	
        if(nb==0) break;
    }
  /* 4. On communique. */
    while(1){

      int nb1=read(0,buffer,sizeof(buffer));
      write(sclient,buffer,nb1);
      int nb=read(sclient,buffer,sizeof(buffer)); //peut être bloqué dans les 2 read
                                                  //fork ou multiplexing
      if(nb>0){
        write(1,buffer,nb);
      }else{write(0,"erreur",6);}
      
    }
    
  /* 5. On termine et libère les ressources. */
