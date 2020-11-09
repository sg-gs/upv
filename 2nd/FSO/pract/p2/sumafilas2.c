#include <stdio.h>
#define TAM_FILA 100
#define NUM_FILAS 10
struct FILA {
    float datos[TAM_FILA];
    float suma;
};


float suma_fila(struct FILA *pf) {
    float resultado = 0;
    for(int i = 0; i < sizeof(pf->datos); i++) 
    {
        pf->suma += pf->datos[i];
    }
}
float inicia_fila(struct FILA *pf, int j) {
    // printf("Iniciar fila");
    for (int i = 0; i < TAM_FILA; i++) {
        pf->datos[i] = (float)i*j;
    }
}
void main() {
    
    int i;
    float suma_total = 0;
    // La variable filas sea local y definida en la función main
    struct FILA filas[NUM_FILAS];
    
    for (i = 0; i < NUM_FILAS; i++) {
        // Llamar a suma_fila
        inicia_fila(&filas[i], i);
        suma_fila(&filas[i]);
        printf("La suma de la fila %u es %f\n", i, filas[i].suma);
        // sumar la fila a suma_total
        suma_total += filas[i].suma;
    }
    printf("La suma final es %f\n", suma_total);
}
