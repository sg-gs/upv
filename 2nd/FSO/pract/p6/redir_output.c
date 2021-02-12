#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

int main(int argc, char *argv[])
{
    int fd;
    char *arch = "output.txt";
    mode_t fd_mode = S_IRWXU; // file permissions
    // read, or create if not exists
    // open returns file descriptor from "output.txt"
    fd = open(arch, O_RDWR | O_CREAT, fd_mode);
    // dup2 closes standard output and redirects
    // fd in the new output (fd is the input of 
    // output.txt)
    if (dup2(fd, STDOUT_FILENO) == -1)
    {
        printf("Error calling dup2\n");
        exit(-1);
    }

    // so if we print in the output (stdout), as the output
    // is redirected to output.txt input, content
    // will be printed in output.txt instead of in the
    // console
    fprintf(stdout, "out: Output redirected\n");
    // as we haven't connected stderr with other fd
    // we continue to print in console because it is
    // the standard output for stderr.
    fprintf(stderr, "error: not redirected\n");
    fprintf(stderr, "Check file %s\n", arch);
    close(fd);
    return (0);
}