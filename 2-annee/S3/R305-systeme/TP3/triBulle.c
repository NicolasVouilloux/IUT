
#include <stdio.h>             /* fichiers d'en-tête classiques */
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <errno.h>
#include <time.h>
#include <pthread.h>


#define SIZE 20
unsigned int tab[SIZE];

void * bulle(void * arg) { 
    for (int i=0;i<SIZE-1;i++){
        for (int j=0;j<SIZE-1-i;j++){
            if(tab[j]>tab[j+1]){
                tab[j+1] += tab[j];
                tab[j]=tab[j+1]-tab[j];
                tab[j+1]-=tab[j];
            }
        }
    }
}
void * plomb(void * arg) {
    for (int i=0;i<SIZE-1;i++){
        for (int j=SIZE-1;j>i;j--){
            if(tab[j]<tab[j-1]){
                tab[j-1] += tab[j];
                tab[j]=tab[j-1]-tab[j];
                tab[j-1]-=tab[j];
            }
        }
    }
}

void shuffle() {
    int i, j, temp;
    for (i = SIZE-1; i > 0; i --) {
        j = random() % (i + 1);
        temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
    }
}

int main() {
    int i;
    pthread_t bulle_id,plomb_id;
    srandom(time(NULL));
    for (i = 0; i < SIZE; i++) tab[i] = i + 1;
    for (i = 0; i < 3000; i++) {
        shuffle();
        if (pthread_create(&bulle_id, NULL, bulle, NULL) != 0) exit(1);
        if (pthread_create(&plomb_id, NULL, plomb, NULL) != 0) exit(1);
        pthread_join(bulle_id, NULL);
        pthread_join(plomb_id, NULL);
    }
    for (i = 0; i < SIZE; i++) printf("%d ", tab[i]);
    putchar('\n');
    return 0;
}