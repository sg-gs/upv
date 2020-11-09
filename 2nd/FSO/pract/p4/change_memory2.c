#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <string.h>

int main (int argc, char *argv[])
{
    pid_t childpid;
    int status, x;
    
    childpid = fork();
    
    char* path;
    char* pathStart = "/bin/";
    path = malloc(strlen(pathStart) + strlen(argv[1]) + 1);
    strcpy(path, pathStart);
    strcat(path, argv[1]);
    
    if(childpid == -1)
    {
        printf("fork failed \n");
        exit(1);
    }
    else if(childpid == 0) 
    {
        if(execvp(path, argv) < 0)
        {
            printf("Could not execute: ls \n");
            exit(1);
        }
    }
    
    x = wait(&status);
    
    if(x != childpid) 
    {
        printf("Child has been interrupted by a signal \n");
    }
    
    exit(0);
}
