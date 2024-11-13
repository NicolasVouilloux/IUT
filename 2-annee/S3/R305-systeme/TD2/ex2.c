void handleTERM(int sig){
    exit(0);
}

int maint(){
    
    signal(SIGTERM,handleTERM);

    struct sockaddr_in sa ={0};// sa is the address and sockaddr_in is a special type of struct
    sa.sin_Family = AF_INET;
    sa.sin_port = htons(5015);
    sa.sin_addr.s_addr=htol(INADDR_ANY);

    int slis = socket(AF_INET,SOCK_STREAM,);
    if(bind(slis,(struct sockaddr*)& sa,sizeof(sa))==-1){
        perror("bind error");exit(1);
    }
    listen(slis,7);// slis = socket d'ecoute 7 = nb max de demande en attente d'acceptation
    while (1){
        int scon = accept(slis,NULL,NULL);//scon is a file shared between the father and the chidl
        if (fork()!=0){
            close(scon);//close the file only in the father to keep connection and win a bit of space
            continue;
        } 
        //child code
        char buff[1024]={0};
        while (1){
            int nb = read(scon,buff,sizeof(buff));
            if (nb==0)break;
            for(i=0;i<nb;i++){
                if(isLower(buff[i]))
                buff[i] = toupper(but[i]);
            }
            write(scon,buff,nb);
            shutdown(scon,SHUT_RDWR);
            close(scon);
            exit(0);
        }
    }
}

