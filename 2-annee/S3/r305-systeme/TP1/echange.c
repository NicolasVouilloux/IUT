#include <stdio.h>

void echange1(float *a,float *b){
    float temp =*a;
    *a = *b;
    *b = temp;
}

int main(){
    float pi = 2.71828, e = 3.14259;
    printf("Avant echange : pi = %f,e = %f.\n",pi,e);
    echange1(&pi,&e);
    printf("Apres echange : pi = %f,e = %f.\n",pi,e);
    return 0;
}