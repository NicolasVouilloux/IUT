#include <sys/socket.h>

int main(){
    int sockfd[2];
    if (socketpair(AF_UNIX,SOCK_STREAM,0,sockfd)<0){
        perror("bind error");
        exit(1);
    }
    if (fork == 0){
        while (1){
            close(sockfd[1]) 
            write(sockfd[0],&x,sizeof(x));
            read(sockfd[0],&x,sizeof(x));
            write(sockfd[0],&x,sizeof(x));
        }
    }
    close(sockfd[0])
    while(1){
        write(sockfd[1],&x,sizeof(x));
        read(sockfd[1],&x,sizeof(x));
        write(sockfd[1],&x,sizeof(x));
    }
    return 0;
}