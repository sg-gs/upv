#include <stdio.h>
#include <stdlib.h>

// Added for C99 compatibility.
int getpid(void);
int getppid(void);
void sleep(int);
int fork(void);
int wait(int * status);

void createUniqueProcess(void);
void createMultipleProcess(int n);

int main(int argc, char *argv[])
{
    printf("Process %ld \n", (long)getpid());

    // createUniqueProcess();
    createMultipleProcess(4);
    
    return 0;
}

void createUniqueProcess(void)
{
    int val = fork();

    if(val > 0) 
    {
        printf("Soy el padre \n");
        printf("Process %ld, my parent %ld\n", (long)getpid(), (long)getppid());
    }

    if(val == 0)
    {
        printf("Soy el hijo \n");
        printf("Process %ld, my parent %ld\n", (long)getpid(), (long)getppid());
    }

    sleep(15);

}

void createMultipleProcess(int n) 
{

    printf("\n\n");

    int val = 1;
    int status;

    for(int i = 0; i < n; i++) 
    {
        if(val == 0)
        {
            printf("Hijo número %d | PID: %ld, PPID: %ld\n", i, (long)getpid(), (long)getppid());
            // Avoiding duplicated printfs
            break;
        }
        if(val > 0)
        {
            printf("Padre bro, en iteración número %d | PID: %ld, PPID: %ld\n", i, (long)getpid(), (long)getppid());
            // Avoiding replication of sons creating more sons
            val = fork();
        }
    }
    sleep(5);

    if(wait(&status) != -1)
    {
        printf("Mis hijos han finalizado ya \n");
    }

    exit(0);
}