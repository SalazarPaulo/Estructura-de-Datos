// Proyecto No.1 (Arboles)

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct treenodo {
    struct treenodo *izqptr;     // puntero al nodo izquierdo
    int edad;                   // dato de edad
    char nombre [20];          // dato de nombre
    char nacionaliad[20];     // dato de nacionalidad
    struct treenodo *derptr; // puntero al nodo derecho
};

Menu () {
    printf ("\t1. Hoja de Presentación\n\t2. Crear Árbol Genealógico\n\t3. Insertar en Árbol ascendentes\n\t4.  Imprimir el Árbol (Gráficamente)*\n\t5. Generar Reportes\n\t6. Salir");
}
Presentation () {

    printf("\tUNIVERSIDAD TECNOLOGICA DE PANAMA\n\t\tFACULTAD DE INGENIERIA DE SISTEMAS COMPUTACIONALES\n\tDEPARTAMENTO DE COMPUTACION Y SIMULACION DE SISTEMAS\n\n\n\tLICENCIATURA EN INGENIERIA DE SISTEMAS Y COMPUTACION\n\t\tESTRUCTURA DE DATOS II");
    printf("\t\t\tPROYECTO NO.1\n\tPROF.: CUETO, DORIS\n\t\t\tINTEGRANTES: \n\t\t\t\tARQUINEZ, LIANETH 8-974-1567\n\t\t\t\tGONZALES, JOHANA 8-1004-1648\n\t\t\t\tLORENZO, KAREN 8-987-1549\n\t\t\t\tSALAZAR, PEDR 8-937-444\n\t\tGRUPO: 1IL122\n\n\t\t\tFECHA: 26 DE SEPTIEMBRE DE 2022")
}
Reports () {

}
// Metodo para obtener todas las madres del usuario
preorden (struct treenodo *nodo){
    if (nodo != NULL) {
            if (nodo->derptr != NULL)
            continue;
        printf("%d", nodo->dato);
        preorden(nodo->izqptr);
        preorden(nodo->derptr);
    }
    return 0;
}

int main () {

    struct treenodo *nodo;
    nodo = (struct treenodo*) malloc (sizeof(nodo));

    ////////-------- STATEMENTS & DECLARATIVES --------////////

    int optionMenu = 0;
    bool leido = true;

    Menu ();
    scanf("%i", &optionMenu);

    do {

        switch (optionMenu) {

            case 1: Presentation(); leido = false; break; // LISTO
            case 2: crear(nodo);   leido = false; break; // LISTO
            case 3: break;
            case 4: break;
            case 5: break;
            case 6: leido = true; break;
            default: printf("\tOpcion no encontrada"); leido = false; break;
            leido = true;

        } while (!leido);

    }
}

Crear (struct treenodo *nodo) {

    char option[1] = "S";

    ////---- DATOS DEL CAMPO INFORMACION DEL NODO ----////

    printf("\tIngresar el familiar: ");
    scanf("%s", &nodo->nombre);
    printf("\tIngrese su edad: ");
    scanf("%i", &nodo->edad);
    printf("\tIngrese su nacionalidad: ");
    scanf("%s", &nodo->nacionalidad);

    printf("\tTiene madre: ");
    scanf("%s", &option);

    if (strcmp (resp,"S") == 0) {
         nodo->izqptr = malloc (sizeof(struct treenodo));
         crear(nodo->izqptr);
    } else
         nodo->izqptr = NULL;

    printf("\tTiene padre: ");
    scanf("%s", &option);

    if (strcmp (resp,"S") == 0) {
         nodo->izqptr = malloc (sizeof(struct treenodo));
         crear(nodo->izqptr);
    } else
         nodo->izqptr = NULL;
}
