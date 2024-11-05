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
    int maxfd;
    fd_set master,temp;
    int sc = socket(AF_INET,SOCK_STREAM,0);
    FD_ZERO (&master);
    FD_SET(slis,&master);
    maxfd = slis;
    while (1){
        temp=master;
        select(maxfd+1,&temp,NULL,NULL,NULL);
        for (fr = 0;fd<=madfd;fd++){
            if(!FD_ISSET(fd,&temp))continue;
            if(fd == slis){
                sc=accept(fd,NULL,NULL);
                FD_SET(sc,&master);
                maxfd = (maxfd>sc) ? maxfd : sc;
                continue;
            }
            nb= read (fd,but,sizeof(buff));
            if(nb<=0){
                shutdown(fd,SHUT_RDWR);
                close(fd);
                FD_CLR(fd,&master);
                continue;
            }
            for(int i =0 ; i<nb;i++)buff[i]=toupper(buff[i]);
            write(fd,buff,nb);
        }
    }
}




















