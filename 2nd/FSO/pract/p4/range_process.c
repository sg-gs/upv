/***code of range_process.c***/
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
    printf("Process %ld \n", (long)getpid());
    int pid;
    for(int i = 0; i < 5; i++) 
    {
        pid = fork();
        if(pid > 0) { continue; }
        else {
            printf("Hijo creado en iteración=%d \n", i);
            /* da igual exit i que exit 0, 1 etc, es sólo un coódigo de respuesta */
            exit(i);
        }
    }
    /* sólo el padre llega hasta aquí, los hijos salen en el bucle, al no hacer el padre un wait, los hijos se quedan en estado de zombies. */
    sleep(10);
    exit(0);
    return 0;
}
