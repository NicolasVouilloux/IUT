#define SIZE 20
int tab[SIZE];

void * bulle(void * arg) { 
    for (int i=0;i<SIZE-1;i++){
        for (int j=i;j<SIZE-1;j++){
            if(tab[j]>tab[j+1]){
                tab[j+1] += tab[j];
                tab[j]=tab[j+1]-tab[j];
                tab[j+1]-=tab[j];
            }
        }
    }
}
void * plomb(void * arg) {
    for (int i=SIZE-1;i>1;i--){
        for (int j=i;j>1;j--){
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
    for (i = SIZE-1; i > 0; i ) {
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