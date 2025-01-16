#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <sys/wait.h>


int main(){
    const int TABSIZE = 20;
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
    int nbChild;
    printf("Enter a number of child to make: ");
    scanf("%d", &nbChild);

    for (i =0;i<nbChild;i++){
        if (fork()==0){
            for (int j=i*TABSIZE/nbChild;j<(i+1)*TABSIZE/nbChild;j++){   
                if (arr[j]==0)
                    exit(1);
            }
            exit(0);
        }
    }
    for (i=0;i<nbChild;i++){
        wait(&status);
        if (WIFEXITED(status)&& WEXITSTATUS(status))
            printf("The child found the needle\n");
        else 
            printf("This child didnt found the needle\n");
    }
    return 0;

}