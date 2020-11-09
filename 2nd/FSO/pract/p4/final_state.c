/***code of final_state.c***/
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
    printf("Process %ld \n", (long)getpid());
    int pid;
    int status;
    for(int i = 0; i < 4; i++) 
    {
        pid = fork();
        if(pid == 0) 
        { 
            printf("Soy el hijo creado en iteración=%d, PID: %d \n", i, (long)getpid());
            pid = fork();
            sleep(10);
        }
        else { break; } /* el padre no hace nada */
        
        while(wait(&status) > 0)
        {
            printf("Mis hijos han finalizado ya.");
        }
            
        exit(i);
            
    }
    
    exit(0);
    return 0;
}
