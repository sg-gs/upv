#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

int main(int argc, char *argv[])
{
    char *men1 = "men1: Writing in descriptor 1 (std_output)\n";
    char *men2 = "men2: Writing in descriptor 2 (std_error)\n";
    char *men3 = "men3: Writing in descriptor 1 (std_output)\n";
    char *men4 = "men4: Writing in descriptor 2 (std_error)\n";
    char *men5 = "men5: Writing in descriptor 1 (std_output)\n";
    char *men6 = "men6: Writing in descriptor 2 (std_error)\n";

    // writes on file whose descriptor is 1
    write(1, men1, strlen(men1));
    // writes on file whose descriptor is 2
    write(2, men2, strlen(men2));
    // closes descriptor nº1
    close(1);
    // hence, men3 won't print because descriptor is closed.
    write(1, men3, strlen(men3));
    // hence, men4 will print because descriptor 2 is still open.
    write(2, men4, strlen(men4));
    // closes descriptor nº2
    close(2);
    write(1, men5, strlen(men5));
    write(2, men6, strlen(men6));
    return (0);
}