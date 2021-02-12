/*** Programa de ejemplo "Hola mundo" con pthreads.* Para compilar teclea:  gcc hola.c -lpthread -o hola**/
#include <stdio.h>
#include <pthread.h>
#include <string.h>
#include <unistd.h>

void*Imprime( void *ptr )
{
        char*men;
        men=(char*)ptr;
        //EJERCICIO1.b
        //Retraso de 2 segundos, en microsegundos
        usleep(2000000);
        write(1,men,strlen(men));
}

int main(){
    pthread_attr_t atrib;
    pthread_t hilo1, hilo2;
    // Si no se crean los atributos, el hilo no se puede crear
    pthread_attr_init(&atrib);
    pthread_create(&hilo1, &atrib, Imprime, "Hola \n");
    pthread_create(&hilo2, &atrib, Imprime, "mundo \n");
    
    //EJERCICIO1.a
    //pthread_join(hilo1, NULL);
    //pthread_join(hilo2, NULL);
    
    // Solo finaliza el hilo que ejecuta main(), no termina el proceso, luego los hilos restantes siguen ejecutándose.
    // pthread_exit(0);
    
    // Si usamos exit, si que finalizaria el proceso, y con ello, todos los hilos que dependen de él
    // exit(0)
    
    // Retraso de un segundo, en microsegundos
    // Si añadimos 1s aquí y dos a los hilos, el main() termina antes que los hilos y finaliza
    // el proceso, no dando tiempo a los hilos para hacer el 'write'
    usleep(1000000);
    
    
}  
