volatile unsigned int count = 0;
volatile int step = 1;
void HandlAlarm(int sig){
    printf("%u\n",count);
    alarm(1);
}
void HUSR(int sig){
    if (sig == SIGUR1)
        count = 1;
    else 
        step = -step;    
}
int main() {
    signal(SIGUR2, HUSR);
    signal(SIGUR1,HandlAlarm);
    alarm(1);
    for (count = 1; count > 0; count += step);
    return 0;
}