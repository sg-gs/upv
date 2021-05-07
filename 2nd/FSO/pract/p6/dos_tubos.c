#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
int main(int argc, char *argv[])
{
    int i;
    char *arguments1[] = {"ls", "-la", 0};
    char *arguments2[] = {"wc", "-l", 0};
    char *arguments3[] = {"grep", "ejemplo", 0};
    int fildes[2];
    int fildes_other[2];
    pid_t pid;
    //Parent process creates a pipe
    if ((pipe(fildes) == -1))
    {
        fprintf(stderr, " Pipe failure \n");
        exit(-1);
    }

    if ((pipe(fildes_other) == -1))
    {
        fprintf(stderr, " Pipe failure \n");
        exit(-1);
    }

    for (i = 0; i < 3; i++)
    {
        pid = fork(); //Creates a child process
        if ((pid == 0) && (i == 0))
        {
            // Child process redirects its output to the pipe
            // fildes[1] --> Write in pipe
            dup2(fildes[1], STDOUT_FILENO);
            // Child process closes pipe descriptors
            close(fildes[0]);
            close(fildes[1]);
            close(fildes_other[0]);
            close(fildes_other[1]);
            // When we execute ls, output is write in pipe
            // Child process changes its memory image
            if (execvp("ls", arguments1) < 0)
            {
                fprintf(stderr, "ls not found \n");
                exit(-1);
            }
        }
        else if ((pid == 0) && (i == 1))
        {
            // Child process redirects its input to the pipe
            // fildes[0] --> Read from pipe
            dup2(fildes[0], STDIN_FILENO);
            dup2(fildes_other[1], STDOUT_FILENO);

            // Child process closes pipe descriptors
            close(fildes[0]);
            close(fildes[1]);
            close(fildes_other[0]);
            close(fildes_other[1]);
            // When we execute wc, input received by wc comes
            // from pipe's fd instead from standard in
            // Child process changes its memory image
            if (execvp("grep", arguments3) < 0)
            {
                fprintf(stderr, "grep not found \n");
                exit(-1);
            }
        }
        else if ((pid == 0) && (i == 2))
        {
            // Child process redirects its input to the pipe
            // fildes[0] --> Read from pipe
            dup2(fildes_other[0], STDIN_FILENO);

            char *arch = "result.txt";
            mode_t fd_mode = S_IRWXU; // file permissions
            int fd_result_txt = open(arch, O_RDWR | O_CREAT, fd_mode);

            if (dup2(fd_result_txt, STDOUT_FILENO) == -1)
            {
                printf(" Error when calling to result.txt \n");
                exit(-1);
            }

            // Child process closes pipe descriptors
            close(fildes[0]);
            close(fildes[1]);
            close(fildes_other[0]);
            close(fildes_other[1]);
            // When we execute wc, input received by wc comes
            // from pipe's fd instead from standard in
            // Child process changes its memory image
            if (execvp("wc", arguments2) < 0)
            {
                fprintf(stderr, "wc not found \n");
                exit(-1);
            }
        }
    }
    // Parent process closes pipe descriptors
    close(fildes[0]);
    close(fildes[1]);
    for (i = 0; i < 2; i++)
        wait(NULL);
    return (0);
}