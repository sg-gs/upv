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
            sleep(20);
            exit(i);
        }
    }
    sleep(10);
    exit(0);
    return 0;
}
