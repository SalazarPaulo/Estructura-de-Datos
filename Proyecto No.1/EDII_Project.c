#include <stdio.h>
#include <string.h>
#include <stdlib.h>
////---- Librerias para las vocales ----////
#include <wchar.h>
#include <locale.h>
////////-------- Para imprimir el arbol graficamente --------////////
//#include <graphics.h>

////////-------- GLOBAL STATEMENTS --------////////
#define Is_Woman  1
#define Is_Man 2
    int max = 0;
    int min = 1000;
    char Family [1000];

struct treenodo {
    struct treenodo *izqptr;     // puntero al nodo izquierdo
    int edad;                   // dato de edad
    char nombre [20];          // dato de nombre
    char nacionalidad[20];    // dato de nacionalidad
    int Key_Gender;
    struct treenodo *derptr; // puntero al nodo derecho
};
Menu () {
    printf ("\n\t\t\tMENU\n\t1. Hoja de Presentación\n\t2. Crear Árbol Genealógico\n\t3. Insertar en Árbol ascendentes");
    printf("\n\t4. Imprimir el Árbol (Gráficamente)*\n\t5. Generar Reportes\n\t6. Salir\n\n\tRespuesta: ");
}
Presentation () {
    printf("\n\n\t\tUNIVERSIDAD TECNOLOGICA DE PANAMA\n\t FACULTAD DE INGENIERIA DE SISTEMAS COMPUTACIONALES");
    printf("\n\tDEPARTAMENTO DE COMPUTACION Y SIMULACION DE SISTEMAS\n\n\n\tLICENCIATURA EN INGENIERIA DE SISTEMAS Y COMPUTACION\n\t\t\tESTRUCTURA DE DATOS II");
    printf("\n\t\t\t   PROYECTO NO.1\n\n\n\tPROF.: CUETO, DORIS\n\n\t\t\t\t    INTEGRANTES: \n\t\t\t\t\tARQUINEZ, LIANETH 8-974-1567\n\t\t\t\t\tGONZALES, JOHANA 8-1004-1648");
    printf("\n\t\t\t\t\tLORENZO, KAREN 8-987-1549\n\t\t\t\t\tSALAZAR, PEDR0 8-937-444\n\n\t\t\t\tGRUPO: 1IL122\n\n\t\t\tFECHA: 26 DE SEPTIEMBRE DE 2022\n");
}
Reports (struct treenodo *nodo) {
    printf("\tNombre de todos los Progenitores Femeninos:\n");
    GetMothers(nodo);
    printf("\n\tNombre de todos los Progenitores Masculinos: \n");
    GetFathers(nodo);
    printf("\n\tTodos los padres con sus hijos: ");

    printf("\n\tEl progenitor de mayor edad: ");
    GetMaxAge(nodo);
    printf("\n\tEl progenitor de menor edad: ");
    GetMinAge(nodo);
    printf("\n\n\tPress Enter to continue...\n\t");
}
// Metodo para obtener todas las madres del usuario
GetMothers (struct treenodo *nodo){
    if (nodo != NULL) {

        GetMothers(nodo->izqptr);
        GetMothers(nodo->derptr);
        if((nodo->Key_Gender) == Is_Woman)
            printf("\t| %s |", nodo->nombre);
    }
    return;
}
// Metodo para obtener todas los padres del usuario
GetFathers (struct treenodo *nodo){
    if (nodo != NULL) {

        GetFathers(nodo->izqptr);
        GetFathers(nodo->derptr);
        if((nodo->Key_Gender) == Is_Man)
            printf("\t| %s |", nodo->nombre);
    }
    return;
}
// Father & Mother with Son
GetFamily (struct treenodo *nodo) {

    GetFamily(nodo->izqptr);
    GetFamily(nodo->derptr);
    //strcmp() // <-- Ir concatenando las cadenas

}
// Me retorna todo menos la raiz
GetMinAge (struct treenodo *nodo) {
    if (nodo != NULL) {
        GetMinAge(nodo->izqptr);
        GetMinAge(nodo->derptr);
        if (nodo->edad < min)
            min = nodo->edad;
    }
    printf("\n\t%i", min);
    return;
}
// Me retorna todo menos la raiz
GetMaxAge (struct treenodo *nodo) {
    if (nodo != NULL) {
        if (nodo->edad > max) {
            max = nodo->edad;
        }
        GetMinAge(nodo->izqptr);
        GetMinAge(nodo->derptr);
    }
    return max;
}
// Método Principal
int main(){

    ////////-------- NODE --------////////
    struct treenodo *nodo;
    nodo = (struct treenodo*) malloc (sizeof(nodo));
    ////////-------- Para poder colocar las tildes --------////////
    setlocale(LC_ALL, "");

    ////////-------- STATEMENTS & DECLARATIVES --------////////
    int optionMenu, pass;

    do {
        system("cls");
        Menu ();
        do {
            fflush(stdin);
            scanf("%i", &optionMenu);
        } while (optionMenu < 1 || optionMenu > 6);

        switch (optionMenu) {
            case 1:
                system("cls");
                Presentation();
                getchar();
                getchar();
            break;
            case 2:
                crear (nodo);

            break;
            case 3:
            break;
            case 4:
            break;
            case 5:
                system("cls");
                Reports(nodo);
                getchar();
                getchar();
            break;
            case 6:
                pass = 0;
            break;
            default:
            break;
        }
        system("cls");
    } while (pass != 0);

    printf("\n\n");
}

// Método que crea el árbol binario (Aplicando recursividad)

 int crear(struct treenodo *nodo){ // Implementar fflush (stdin);
    char resp[1] = "S";
    char gender[1];

    system ("cls");
    ////---- DATOS DEL CAMPO INFORMACION DEL NODO ----////

    ////---- NAME ----////
    printf("\n\tIngresar el familiar: ");
    scanf("%s", &nodo->nombre);

    ////---- GENDER ----//// <-------------- DONE
    printf("\n\tGenero: ");
    scanf ("%i", &nodo->Key_Gender);

   /* if (gender == "W" || gender == "w")
        nodo->Key_Gender = Is_Woman;
    else if (gender == "M" || gender == "m")
        nodo->Key_Gender = Is_MAN;*/ // <----------------- To automatize the gender process, CHECK
    printf("\tIngrese su edad: ");
    scanf("%i", &nodo->edad);
    printf("\tIngrese su nacionalidad: ");
    scanf("%s", &nodo->nacionalidad);

    printf("\t%s tiene madre(S/N): ", nodo -> nombre);
    scanf("%s", &resp);

    if (strcmp (resp,"S")==0) {
        nodo->izqptr= malloc (sizeof(struct treenodo));
        crear(nodo->izqptr);
    } else
        nodo->izqptr= NULL;

    printf("\t%s tiene padre (S/N): ", nodo -> nombre);
    scanf("%s", &resp);

   if (strcmp (resp,"S")==0) {
        nodo->derptr = malloc (sizeof(struct treenodo));
        crear(nodo->derptr);
    } else
        nodo->derptr= NULL;

    return;
}

