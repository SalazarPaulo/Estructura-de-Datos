#include <stdio.h>
#include <string.h>
#include <stdlib.h>
////---- Librerias para las vocales ----////
#include <wchar.h>
#include <locale.h>
////////-------- Para imprimir el arbol graficamente --------////////
//#include <graphics.h>
////////-------- INT_MIN & INT_MAX --------////////
#include <limits.h>
#include<stdbool.h>// Booleanos
////////-------- GLOBAL STATEMENTS --------////////
#define COUNT  10
#define Is_Woman  1
#define Is_Man 2
    char persona[20];
    int ronda = 1;

////////-------- NODE --------////////
struct treenodo {
    struct treenodo *izqptr;       // puntero al nodo izquierdo
    int edad;                     // dato de edad
    char nombre [20];            // dato de nombre
    char nacionalidad[20];      // dato de nacionalidad
    int Key_Gender;            // Clave para saber si es hombre o mujer
    int check;                // ID para numerar cada nodo
    struct treenodo *derptr; // puntero al nodo derecho
};

////////-------- NODE --------////////
void insertar(struct treenodo *nodo, char persona[]) {
    char resp[1] = "S";
    if(nodo != NULL) {
        if (strcmp(nodo->nombre, persona) == 0) {
            //if (((nodo->Key_Gender == Is_Woman)) && nodo->izqptr != NULL) {

            printf("\n\t %s tiene madre (S/N): ", nodo->nombre);
            scanf("%s", &resp);
            if (((strcmp(resp, "S") == 0) || (strcmp(resp, "s") == 0)) && nodo->izqptr == NULL) {
                    nodo->izqptr = malloc (sizeof(struct treenodo));
                    crear(nodo->izqptr);
            }else if (((strcmp(resp, "S") == 0) || (strcmp(resp, "s") == 0)) && nodo->izqptr != NULL)
                printf("\n\tYa posee una madre\n");

            printf("\t%s tiene padre (S/N): ", nodo->nombre);
            scanf("%s", &resp);
             if (((strcmp(resp, "S") == 0) || (strcmp(resp, "s") == 0)) && nodo->derptr == NULL) {
                nodo->derptr = malloc (sizeof(struct treenodo));
                crear(nodo->derptr);
            } else if (((strcmp(resp, "S") == 0) || (strcmp(resp, "s") == 0)) && nodo->derptr != NULL) {
                printf("\n\tYa posee un padre\n");
            }
        } else {
            //printf("estabamos en %s\n", nodo->nombre);
            insertar(nodo->izqptr, persona);
            insertar(nodo->derptr, persona);
        }
    }
    return;
}

////////-------- MENU --------////////
void Menu () {
    printf ("\n\t\t\tMENU\n\t1. Hoja de Presentación\n\t2. Crear Árbol Genealógico\n\t3. Insertar en Árbol ascendentes");
    printf("\n\t4. Imprimir el Árbol (Gráficamente)*\n\t5. Generar Reportes\n\t6. Salir\n\n\tRespuesta: ");
}
void SubMenu(){
    printf ("\n\t\t\tMENU\n\t1. Nombre de todos los progenitores femeninos \n\t2. Nombre de todos los progenitores masculinos \n\t3. Todos los Padres con sus hijos");
    printf("\n\t4. Nacionalidad de mis descendientes \n\t5. Progenitor de mayor edad\n\t6. Progenitor de menor edad\n\t7. Volver al menú\n\n\tRespuesta: ");
}

////////-------- PRESENTATION --------////////
void Presentation () {
    printf("\n\n\t\tUNIVERSIDAD TECNOLOGICA DE PANAMA\n\t FACULTAD DE INGENIERIA DE SISTEMAS COMPUTACIONALES");
    printf("\n\tDEPARTAMENTO DE COMPUTACION Y SIMULACION DE SISTEMAS\n\n\n\tLICENCIATURA EN INGENIERIA DE SISTEMAS Y COMPUTACION\n\t\t\tESTRUCTURA DE DATOS II");
    printf("\n\t\t\t   PROYECTO NO.1\n\n\n\tPROF.: CUETO, DORIS\n\n\t\t\t\t    INTEGRANTES: \n\t\t\t\t\tARQUINEZ, LIANETH 8-974-1567\n\t\t\t\t\tGONZALES, JOHANA 8-1004-1648");
    printf("\n\t\t\t\t\tLORENZO, KAREN 8-987-1549\n\t\t\t\t\tSALAZAR, PEDR0 8-937-444\n\n\t\t\t\tGRUPO: 1IL122\n\n\t\t\tFECHA: 26 DE SEPTIEMBRE DE 2022\n");
}

////////-------- NATIONALITIES --------////////
void GetNationality (struct treenodo *nodo) { // <------- DONE
    if (nodo != NULL) {
        printf("\n\tLa nacionalidad de: %s", nodo->nombre);
        printf(" es: %s", nodo->nacionalidad);
        GetNationality(nodo->izqptr);
        GetNationality(nodo->derptr);
    }
    return;
}

////////-------- FATHERS & MOTHERS --------////////
// Metodo para obtener todas las madres del usuario
void GetMothers (struct treenodo *nodo){ // <--------- REVISAR/DONE
    if (nodo != NULL) {
            if (nodo->check != 2)
                if((nodo->Key_Gender) == Is_Woman)
                    printf("\t| %s |", nodo->nombre);
        GetMothers(nodo->izqptr);
        GetMothers(nodo->derptr);
    }
    return;
}
// Metodo para obtener todas los padres del usuario
void GetFathers (struct treenodo *nodo){ // <--------- REVISAR/DONE
    if (nodo != NULL) {
        if (nodo->check != 2)
            if((nodo->Key_Gender) == Is_Man)
                printf("\t| %s |", nodo->nombre);
        GetFathers(nodo->izqptr);
        GetFathers(nodo->derptr);
    }
    return;
}

////////-------- FAMILY --------////////
// Father & Mother with Son // <--- PostOrden
GetFamily (struct treenodo *nodo){
    if (nodo != NULL && (nodo->derptr != NULL && nodo->izqptr != NULL)) {
        printf(" La madre: %s y ", nodo->izqptr ->nombre);
        printf(" el padre: %s tienen un", nodo->derptr->nombre);
        printf(" hijo: %s\n", nodo->nombre);
        GetFamily(nodo->izqptr);
        GetFamily(nodo->derptr);
    }
    return 0;
}

////////-------- MAX & MIN --------////////
// Obtener el valor minimo
int GetMinAge (struct treenodo *nodo) {

    int res;
    if (nodo == NULL)
        return INT_MAX;

    if(nodo->check == 2)
        res = 1000;
    else
        res = nodo->edad;

    int lres = GetMinAge(nodo->izqptr);
    int rres = GetMinAge(nodo->derptr);

    if (lres < rres)
        res = lres;
    if (rres < res)
        res = rres;

    return res;
}
// Obtener el valor maximo
int GetMaxAge (struct treenodo *nodo) {

    if (nodo == NULL)
        return INT_MIN;

    int res = nodo->edad;
    int lres = GetMaxAge(nodo->izqptr);
    int rres = GetMaxAge(nodo->derptr);

    if (lres > rres)
        res = lres;
    if (rres > res)
        res = rres;

    return res;
}
// Obtener los nombres de max edad
void nombreEdadMax(struct treenodo *nodo, int edad) {
    if(nodo != NULL && nodo->check >= 2) {
        if (nodo->check !=2 && nodo->edad == edad)
            printf(" |%s| ", nodo->nombre);
        nombreEdadMax(nodo->izqptr, edad);
        nombreEdadMax(nodo->derptr, edad);
    }
}
// Obtener los nombres de min edad
void nombreEdadMin(struct treenodo *nodo, int edad) {
    if(nodo != NULL && nodo->check >= 2) {
        if (nodo->check !=2 && nodo->edad == edad)
            printf(" |%s| ", nodo->nombre);
        nombreEdadMin(nodo->izqptr, edad);
        nombreEdadMin(nodo->derptr, edad);
    }
}

////////-------- GRAPHICS --------////////
void impresion2DUtil(struct treenodo *nodo, int espacio) {

    if (nodo == NULL)
        return;

    espacio += COUNT;
    impresion2DUtil(nodo->derptr, espacio);
    printf("\n");

    for (int i = COUNT; i < espacio; i++)
        printf(" ");
    printf("%s\n", nodo-> nombre);

    impresion2DUtil(nodo->izqptr, espacio);
}
void impresion2D(struct treenodo *nodo){
   impresion2DUtil(nodo, 0);
}

////////-------- MAIN --------////////
// Método Principal
int main(){

    ////////-------- NODE --------////////
    struct treenodo *nodo;
    nodo = (struct treenodo*) malloc (sizeof(nodo));
    ////////-------- Para poder colocar las tildes --------////////
    setlocale(LC_ALL, "");

    ////////-------- STATEMENTS & DECLARATIVES --------////////
    int optionMenu, pass, optSub,pass2;

    do {
        system("cls");
        Menu ();
        do {
            fflush(stdin);
            scanf("%i", &optionMenu);
        } while (optionMenu < 1 || optionMenu > 6);

        system("cls");

        switch (optionMenu) {
            case 1:
                Presentation();
                getchar();
                getchar();
            break;
            case 2:
                crear (nodo);
            break;
            case 3:
                printf("\n\tIngrese el nodo padre: ");
                scanf("%s", &persona);
                insertar(nodo, persona);
            break;
            case 4:
                impresion2D(nodo);
                printf("\n\n\tPress Enter to continue...\n\t");
                getchar();
                getchar();
            break;
            case 5:
                do{
                    system("cls");
                    SubMenu();
                     do {
                        fflush(stdin);
                        scanf("%i", &optSub);
                    } while (optSub < 1 || optSub > 7);

                    system("cls");

                    switch(optSub){
                        case 1:
                            printf("\tNombre de todos los Progenitores Femeninos:\n");
                            GetMothers(nodo);
                            printf("\n\n\tPress Enter to continue...\n\t");
                            getchar();
                            getchar();
                            break;
                        case 2:
                            printf("\tNombre de todos los Progenitores Masculinos:\n");
                            GetFathers(nodo);
                            printf("\n\n\tPress Enter to continue...\n\t");
                            getchar();
                            getchar();
                            break;
                        case 3:
                            printf("\n\tTodos los padres con sus hijos: \n");
                            GetFamily(nodo);
                            printf("\n\n\tPress Enter to continue...\n\t");
                            getchar();
                            getchar();
                            break;
                        case 4:
                            printf("\n\tNacionalidad de todos mis descendientes: ");
                            GetNationality(nodo);
                            printf("\n\n\tPress Enter to continue...\n\t");
                            getchar();
                            getchar();
                            break;
                        case 5:
                            printf("\n\tEl progenitor de mayor edad: %d", GetMaxAge(nodo));
                            int edad1 = GetMaxAge(nodo);
                            nombreEdadMax(nodo, edad1);
                            printf("\n\n\tPress Enter to continue...\n\t");
                            getchar();
                            getchar();
                            break;
                        case 6:
                            printf("\n\tEl progenitor de menor edad: %d", GetMinAge(nodo));
                            int edad = GetMinAge(nodo);
                            nombreEdadMin(nodo, edad);
                            printf("\n\n\tPress Enter to continue...\n\t");
                            getchar();
                            getchar();
                            break;
                        case 7:
                            pass2=0;
                            break;
                    }
                }while(pass2!=0);
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

////////-------- THREE --------////////
// Método que crea el árbol binario (Aplicando recursividad)
 int crear(struct treenodo *nodo){
    char resp[1] = "S";
 //system ("cls");
    ////---- DATOS DEL CAMPO INFORMACION DEL NODO ----////

    ////---- NAME ----////
    printf("\n\tIngresar el familiar: ");
    scanf("%s", &nodo->nombre);
    printf("\tIngrese su edad: ");
    scanf("%i", &nodo->edad);
    ronda++;
    nodo->check = ronda;

    ////---- GENDER ----//// <-------------- DONE
   // printf("\n\tGenero([1]Mujer/[2]Hombre: ");
    //scanf ("%i", &nodo->Key_Gender);

    //printf("\tIngrese su nacionalidad: ");
    //scanf("%s", &nodo->nacionalidad);

    printf ("\tTiene madre %s", nodo -> nombre);
    printf(" S/N: ");
    scanf("%s", &resp);

    if ((strcmp (resp,"S")==0) || (strcmp (resp,"s")==0)){
        nodo->izqptr = malloc (sizeof(struct treenodo));
        nodo->izqptr->Key_Gender = 1;
        crear(nodo->izqptr);
    } else
         nodo->izqptr= NULL;

    printf ("\tTiene padre %s", nodo -> nombre);
    printf(" S/N: ");
    scanf("%s", &resp);

   if ((strcmp (resp,"S")==0) || (strcmp (resp,"s")==0)) {
        nodo->derptr = malloc (sizeof(struct treenodo));
        nodo->derptr->Key_Gender = 2;
        crear(nodo->derptr);
    } else
       nodo->derptr= NULL;

    return;
}

