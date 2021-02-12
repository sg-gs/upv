#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

int main(int argc, char *argv[])
{
    int fd;
    char *arch = "ls_salida.txt";
    mode_t fd_mode = S_IRWXU; // file permissions
    fd = open(arch, O_RDWR | O_CREAT, fd_mode);

    if (dup2(fd, STDOUT_FILENO) == -1)
    {
        printf("Error calling dup2\n");
        exit(-1);
    }

    // output of ls will be printed in ls_salida.txt
    execl("/bin/ls", "ls", "-la", NULL);
    close(fd);
    return (0);
}