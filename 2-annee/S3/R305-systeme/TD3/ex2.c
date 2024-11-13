void* product(void* res){
    // int j;
    // int v=0;
    // int *y_i = (int *)res;
    int i=((int *)res)-y;
    for (i=0;j<NB_C;j++)
        y[i]+= A[i][j]*x[j];
    //y_i=v;
    return NULL;   
}



int main(){
    //initialyse array A x y 
    int i,j;
    ptthread_t tid[NB_L];
    // for(j=0;j<NB_C;j++){
    //     y[i]+= A[i][j]*x[j];
    // }

    for (i=0;i<NB_L;i++){
        pthread_create(&tid[i],NULL,product,(void*)&y[i]);
    }
    for(i=0;i<NB_L;i++)pthread_join(tid[i],NULL);
    print y;
}