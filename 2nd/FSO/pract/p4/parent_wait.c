/***code of parent_wait.c***/
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
    printf("Process %ld \n", (long)getpid());
    int pid;
    int status;
    for(int i = 0; i < 5; i++) 
    {
        pid = fork();
        if(pid > 0) { continue; }
        else {
            printf("Soy el hijo creado en iteración=%d, PID: %d \n", i, (long)getpid());
            sleep(20);
            exit(i);
        }
    }
    /* Status recibe el estado de los hijos, devolviendo wait un numero de estado concreto, si este valor es -1, es que los hijos ya han finalizado */
    if(wait(&status) != -1)
    {
        printf("Mis hijos han finalizado ya.");
    }
    sleep(10);
    exit(0);
    return 0;
}
