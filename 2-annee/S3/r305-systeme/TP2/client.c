#include <stdio.h>             /* fichiers d'en-tête classiques */
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <errno.h>

#include <time.h>

#include <sys/socket.h>        /* fichiers d'en-tête "réseau" */
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>

#define PORT_SERVEUR 5015      /* Numéro de port pour le serveur */
#define BUFFER_SIZE  1024      /* Taille maximum des messages */



int main(int argc, char *argv[]) {

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

  return 0;
}