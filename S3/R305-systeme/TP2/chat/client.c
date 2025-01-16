/* CLIENT. Donner l'adresse IP et un pseudo en paramètre */
/* exemple "client 127.0.0.1 dr.ced", lancer en dernier. */

#include <stdio.h>             /* fichiers d'en-tête classiques */
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <errno.h>

#include <sys/socket.h>        /* fichiers d'en-tête "réseau" */
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>

#define PORT_SERVEUR 5015      /* Numéro de port pour le serveur */
#define BUFFER_SIZE  1024      /* Taille maximum des messages */

int main(int argc, char *argv[]) {

    char buffer[BUFFER_SIZE]={0};

  /* 1. On crée la socket du client. */
    int sclient=socket(AF_INET,SOCK_STREAM,0);


  /* 2. On prépare l'adresse du serveur. */
    struct sockaddr_in saserv={0};
    saserv.sin_family= AF_INET;
    saserv.sin_port= htons(PORT_SERVEUR); 
    saserv.sin_addr.s_addr= inet_addr("127.0.0.1"); //mettre le parametre

  /* 3. On demande une connexion au serveur, tant qu'on y arrive pas. */
    int res = connect(sclient,(struct sockaddr*)&saserv,sizeof(saserv));
    
  /* 4. On communique. */
  if (fork()==0){
    while(1){
      int nbRecu = read(0,buffer,sizeof(buffer));
      if(nbRecu<=0){
        break;
      }
      write(sclient,buffer,nbRecu);  
    }
    close(sclient);
    exit(0);
  }
  while(1){
    int nbRecu = read(sclient,buffer,sizeof(buffer));
    if(nbRecu<=0){
        break;
    }
    write(1,buffer,nbRecu);
  }
  close(sclient);
  /* 5. On termine et libère les ressources. */
  close(sclient);
  return 0;
}
