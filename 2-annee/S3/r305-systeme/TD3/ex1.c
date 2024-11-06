#define NB_THREADS 3
pthread_t tid[NB_THREADS];
int thread_execute = 0;
/* Fonction executée par les threads.
L'argument et la valeur de retour sont de type void*,
ce qui nécessite des conversions de type. */
void *routine(void *i) {
    int n = *((int *) i);
    // aujourd'hui sous Linux les identifiants sont numériques
    printf("Thread numéro %d, ID %lu\n", n, pthread_self());
    thread_execute = 1;
    return NULL;
}
int main() {
    int i;
    int arg[3];
    for (i = 0; i < NB_THREADS; i++) {
        arg[i]=i;
        if (pthread_create(&tid[i], NULL, routine, (void *) &arg[i]) != 0)
            { fprintf(stderr, "Erreur création thread numéro %d.\n", i); exit(1); }
        }
        printf("Thread initial d'ID %lu\n", pthread_self());
        if (thread_execute)
            printf("Des threads annexes ont été exécutés.\n");
        else
            printf("Aucun thread annexe n'a été exécuté.\n");
    return 0;
}


// Combien au maximum, avec ce programme, y a-t-il de threads s’exécutant en parallèle (ou en
// concurrence s’il n’y a pas assez de ressources) ?

// 4

// Énumérez toutes les variables et dites par quels threads elles sont directement utilisables.

// dans routine le void *i, n  sont utilisé par chaque thread oxiliaire
// i -> que par le thread initial 

// Comment un thread pourrait lire ou modifier la variable n d’un autre thread ?