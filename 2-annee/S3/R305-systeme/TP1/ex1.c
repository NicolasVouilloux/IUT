#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <sys/wait.h>


int main(){
    const int TABSIZE = 10;
    unsigned char arr[TABSIZE];
    srandom(time(NULL));
    int i;
    int status = 0;
    //entasser du foin
    for (i=0; i<TABSIZE; i++)
        arr[i] = (unsigned char) (random() %255) +1;
    
    //cacher l'aiguille
    printf("Enter a number between 0 and %d: ",TABSIZE);
    scanf("%d", &i);
    if(i >= 0 && i < TABSIZE) arr[i] = 0;
    
    // math to learn and understand int j=i*TABSIZE/N;j<(i+1)*TABSIZE/N;J++;
    pid_t child = fork();
    if (child == 0){
        for (i = 0; i<(TABSIZE/2);i++){
            if (arr[i]==0)
                exit(1);           
        }
    }
    else{
        for (i = (TABSIZE/2); i<(TABSIZE);i++){
            if (arr[i]==0)
                printf("The parent found the needle in %d\n",i);
        }
    }
    wait(&status);
        if (WIFEXITED(status)&& WEXITSTATUS(status))
            printf("The child found the needle in %d\n",i);
    return 0;
}