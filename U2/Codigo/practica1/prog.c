#include <stdio.h>

int main() {
    int numero, i;
    char repetir;

    do {
        printf("Ingrese un numero entero positivo: ");
        scanf("%d", &numero);

        // Condicional if-else
        if (numero % 2 == 0) {
            printf("El numero es par.\n");
        } else {
            printf("El numero es impar.\n");
        }

        // Ciclo for
        printf("Contando del 1 al %d:\n", numero);
        for (i = 1; i <= numero; i++) {
            printf("%d ", i);
        }
        printf("\n");

        // Ciclo while
        printf("Cuenta regresiva desde %d:\n", numero);
        i = numero;
        while (i > 0) {
            printf("%d ", i);
            i--;
        }
        printf("\n");

        // Repetir con do-while
        printf("¿Desea ingresar otro numero? (s/n): ");
        scanf(" %c", &repetir);

    } while (repetir == 's' || repetir == 'S');

    return 0;
}
