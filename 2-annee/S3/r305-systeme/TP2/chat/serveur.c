/* SERVEUR. Lancer ce programme en premier (pas d'arguments). */

#include <stdio.h>                  /* fichiers d'en-tête classiques */
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <signal.h>
#include <string.h>
#include <fcntl.h>
#include <errno.h>

#include <sys/socket.h>             /* fichiers d'en-tête "réseau" */
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>

#define PORT_SERVEUR 5015           /* Numéro de port pour le serveur */
#define MAX_CLIENTS   128           /* Nombre maximum de clients */
#define BUFFER_SIZE  1024           /* Taille maximum des messages */

int main(int argc, char *argv[]) {

  /* 1. On déroute les signaux */

  /* 2. On crée la socket d'écoute. */
    fd_set ensemble;
    void FD_ZERO(fd_set *set);

    int sserver= socket(AF_INET,SOCK_STREAM);
  /* 3. On prépare l'adresse du serveur. */
    struct sockaddr_in saclient={0};
    saclient.sin_family= AF_INET;
    saclient.sin_family= htons(PORT_SERVEUR);
    saclient.sin_family=inet_addr("127.0.0.1");

  /* 4. On attache la socket a l'adresse du serveur. */
    bind(sserver,(struct sockaddr*)&saclient,sizeof(saclient));
  /* 5. Enregistrement auprès du système. */
    listen(sserver,999);
  while (1) {
    printf("Serveur en attente de nouveaux clients ou messages.\n");

    /* 6. Si on a reçu une demande sur la socket d'écoute... */
    int accSD = accept(sserver,NULL,NULL);
    /* 7. Si on a reçu des données sur une socket de service... */
    
  }

  /* 8. On termine et libère les ressources. */

  return 0;
}
