#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <sys/wait.h>

void handler(int sig){
    if(sig == SIGTERM){
        printf("PID : %d\n",getpid());
        exit(0);
    }
}

int main(){
    const int TABSIZE = 20;
    unsigned char arr[TABSIZE];
    srandom(time(NULL));
    int i;
    int status = 0;

    signal(SIGTERM,handler);
    //entasser du foin
    for (i=0; i<TABSIZE; i++)
        arr[i] = (unsigned char) (random() %255) +1;
    
    //cacher l'aiguille
    printf("Enter a number between 0 and %d: ",TABSIZE);
    scanf("%d", &i);
    if(i >= 0 && i < TABSIZE) arr[i] = 0;
    // creating number of child to search in array
    int nbChild;
    printf("Enter a number of child to make: ");
    scanf("%d", &nbChild);
    // giving space for every child to look in
    for (i =0;i<nbChild;i++){
        if (fork()==0){
            for (int j=i*TABSIZE/nbChild;j<(i+1)*TABSIZE/nbChild;j++){   
                putc('.', stdout); fflush(stdout);
                if (arr[j]==0)
                    exit(1);
            }
            exit(0);
        }
    }
    //creating as many wait as there is child adn testing the return
    for (i=0;i<nbChild;i++){
        wait(&status);
        if (WIFEXITED(status)&& WEXITSTATUS(status)){
            printf("The child found the needle\n");
            kill(0,SIGTERM);
        }
        else 
            printf("This child didnt found the needle\n");
    }
    return 0;
}