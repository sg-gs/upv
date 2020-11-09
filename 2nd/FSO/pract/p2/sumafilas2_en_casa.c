#include <stdio.h>
#define TAM_FILA 100
#define NUM_FILAS 10

struct FILA {
    float datos[TAM_FILA];
    float suma;
};

void suma_fila(struct FILA *pf) {
    for(int i = 0; i < sizeof(pf->datos); i++)
    {
        pf->suma += pf->datos[i];
    }
}

void inicia_fila(struct FILA *pf, int i) 
{
    int j;
    for(j = 0; j < sizeof(pf->datos); j++)
    {
        pf->datos[j] = (float)i*j;
    }
}

void main() {
    struct FILA filas[NUM_FILAS];
    int i;
    float suma_total;
    // C) Complete bucle
    suma_total = 0;
    for (i = 0; i < NUM_FILAS; i++) {
        // Llamar a suma_fila
        inicia_fila(&filas[i], i);
        suma_fila(&filas[i]);
        printf("La suma de la fila %u es %f\n", i, filas[i].suma);
        suma_total += filas[i].suma;
        // sumar la fila a suma_total
    }
    printf("La suma final es %f\n", suma_total);
}