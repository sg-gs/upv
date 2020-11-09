#include <stdio.h>
int main(int argc, char *argv[])
{
    printf("Numero de argumentos = %d\n", argc);
    for(int i = 0; i < argc; i++) 
    {
        printf("Argumento %d es %s\n", i + 1, argv[i]);
    }
}
