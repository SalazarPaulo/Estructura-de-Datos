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
#define Is_Woman  1
#define Is_Man 2
    int max;
    int min;
    char Family [1000];
    char persona[20];
    int count, countF;
    int cambio;
    int ronda, ronda2;
    int otro;

////////-------- NODE --------////////
struct treenodo {
    struct treenodo *izqptr;      // puntero al nodo izquierdo
    int edad;                    // dato de edad
    char nombre [20];           // dato de nombre
    char nacionalidad[20];     // dato de nacionalidad
    int Key_Gender;           // Clave para saber si es hombre o mujer
    int check;
    struct treenodo *derptr; // puntero al nodo derecho
};

insertar(struct treenodo *nodo, char persona[]) {
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
preorden (struct treenodo *nodo){
    if (nodo != NULL) {
        printf(" |%s| ", nodo->nombre);
        preorden(nodo->izqptr);
        preorden(nodo->derptr);
    }
    return 0;
}


////////-------- MENU --------////////
Menu () {
    printf ("\n\t\t\tMENU\n\t1. Hoja de Presentación\n\t2. Crear Árbol Genealógico\n\t3. Insertar en Árbol ascendentes");
    printf("\n\t4. Imprimir el Árbol (Gráficamente)*\n\t5. Generar Reportes\n\t6. Salir\n\n\tRespuesta: ");
}

////////-------- PRESENTATION --------////////
Presentation () {
    printf("\n\n\t\tUNIVERSIDAD TECNOLOGICA DE PANAMA\n\t FACULTAD DE INGENIERIA DE SISTEMAS COMPUTACIONALES");
    printf("\n\tDEPARTAMENTO DE COMPUTACION Y SIMULACION DE SISTEMAS\n\n\n\tLICENCIATURA EN INGENIERIA DE SISTEMAS Y COMPUTACION\n\t\t\tESTRUCTURA DE DATOS II");
    printf("\n\t\t\t   PROYECTO NO.1\n\n\n\tPROF.: CUETO, DORIS\n\n\t\t\t\t    INTEGRANTES: \n\t\t\t\t\tARQUINEZ, LIANETH 8-974-1567\n\t\t\t\t\tGONZALES, JOHANA 8-1004-1648");
    printf("\n\t\t\t\t\tLORENZO, KAREN 8-987-1549\n\t\t\t\t\tSALAZAR, PEDR0 8-937-444\n\n\t\t\t\tGRUPO: 1IL122\n\n\t\t\tFECHA: 26 DE SEPTIEMBRE DE 2022\n");
}
SubMenu(){
    printf ("\n\t\t\tMENU\n\t1. Nombre de todos los progenitores femeninos \n\t2. Nombre de todos los progenitores masculinos \n\t3. Todos los Padres con sus hijos");
    printf("\n\t4. Nacionalidad de mis descendientes \n\t5. Progenitor de mayor edad\n\t6. Progenitor de menor edad\n\t7. Volver al menú\n\n\tRespuesta: ");
}

////////-------- REPORTS --------////////
Reports (struct treenodo *nodo) {
    system("cls");
    //printf("\tNombre de todos los Progenitores Femeninos:\n");
    //GetMothers(nodo);
    //printf("\n\tNombre de todos los Progenitores Masculinos: \n");
    //GetFathers(nodo);
    printf("\n\tTodos los padres con sus hijos: ");
    GetFamily(nodo);
    //printf("\n\tNacionalidad de todos mis descendientes: ");
    //GetNationality(nodo);
    //printf("\n\tEl progenitor de mayor edad: %d", GetMaxAge(nodo));
    //printf("\n\tEl progenitor de menor edad: %d", GetMinAge(nodo));
    printf("\n\n\tPress Enter to continue...\n\t");
}
////////-------- NATIONALITIES --------////////
GetNationality (struct treenodo *nodo) { // <------- DONE
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
GetMothers (struct treenodo *nodo){ // <--------- REVISAR/DONE
    if (nodo != NULL) {
        //if (countF != 0)
            if((nodo->Key_Gender) == Is_Woman)
                printf("\t| %s |", nodo->nombre);
        GetMothers(nodo->izqptr);
        GetMothers(nodo->derptr);
        countF++;
    }
    return;
}
// Metodo para obtener todas los padres del usuario
GetFathers (struct treenodo *nodo){ // <--------- REVISAR/DONE
    if (nodo != NULL) {
        if (count != 0)
            if((nodo->Key_Gender) == Is_Man)
                printf("\t| %s |", nodo->nombre);
        GetFathers(nodo->izqptr);
        GetFathers(nodo->derptr);
        count++;
    }
    return;
}

////////-------- FAMILY --------////////
// Father & Mother with Son // <--- PostOrden
GetFamily (struct treenodo *nodo) {
    if (nodo != NULL) {
        if (ronda2 != ronda) {

            GetFamily(nodo->izqptr);
            GetFamily(nodo->derptr);

            if (cambio == 0) {
                    if(otro==0)
                        printf("\n\tLa Mamá: %s ", nodo->nombre);
                cambio++;
                otro++;
                //printf("\n %i", cambio);
            }
            else if(cambio == 1) {
                printf(" y el Papá: %s", nodo->nombre);
                cambio++;
            }
            else if (cambio == 2) {
                printf(" tienen un hijo llamado: %s", nodo->nombre);
                printf("\n\tLa Mamá: %s ", nodo->nombre);
                cambio++;
            }
            nodo->check = 1;
        }
        cambio = (cambio == 3)? cambio = 0: cambio;
        ronda2++;
    }
    return;
}

////////-------- MAX & MIN --------////////
// Obtener el valor minimo
int GetMinAge (struct treenodo *nodo) { // <---------- REVISAR/DONE

    int res;

    if (nodo == NULL)
        return INT_MAX;

    if (nodo != NULL) {
        int res1 = nodo->edad;
        int lres = GetMinAge(nodo->izqptr);
        int rres = GetMinAge(nodo->derptr);

        if (lres < rres)
            res = lres;
        if (rres < res1)
            res = rres;
    }
    return res;
}
// Obtener el valor maximo
int GetMaxAge (struct treenodo *nodo) { // <---------- REVISAR/DONE

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

        switch (optionMenu) {
            case 1:
                system("cls");
                Presentation();
                getchar();
                getchar();
            break;
            case 2:
                system("cls");
                crear (nodo);
            break;
            case 3:
                system("cls");
                printf("\n\tIngrese el nodo padre: ");
                scanf("%s", &persona);
                insertar(nodo, persona);
            break;
            case 4:
                system("cls");
                printf("\tNombre de todos los Progenitores:\n");
                preorden(nodo);
                printf("\n\n\tPress Enter to continue...\n\t");
                getchar();
                getchar();
            break;
            case 5:
                do{
                    system("cls");
                    //Reports(nodo);
                    SubMenu();
                    /*getchar();
                    getchar();*/
                     do {
                        fflush(stdin);
                        scanf("%i", &optSub);
                    } while (optSub < 1 || optSub > 7);
                    switch(optSub){
                        case 1:
                            system("cls");
                            printf("\tNombre de todos los Progenitores Femeninos:\n");
                            preorden(nodo);
                            printf("\n\n\tPress Enter to continue...\n\t");
                            getchar();
                            getchar();
                            break;
                        case 2:
                            system("cls");
                            printf("\tNombre de todos los Progenitores Masculinos:\n");
                            GetFathers(nodo);
                            printf("\n\n\tPress Enter to continue...\n\t");
                            getchar();
                            getchar();
                            break;
                        case 3:
                            system("cls");
                            printf("\n\tTodos los padres con sus hijos: \n");
                            GetFamily(nodo);
                            printf("\n\n\tPress Enter to continue...\n\t");
                            getchar();
                            getchar();
                            break;
                        case 4:
                            system("cls");
                            //printf("\n\tNacionalidad de todos mis descendientes: ");
                            //GetNationality(nodo);
                            printf("\n\n\tPress Enter to continue...\n\t");
                            getchar();
                            getchar();
                            break;
                        case 5:
                            system("cls");
                            //printf("\n\tEl progenitor de mayor edad: %d", GetMaxAge(nodo));
                            printf("\n\n\tPress Enter to continue...\n\t");
                            getchar();
                            getchar();
                            break;
                        case 6:
                            system("cls");
                            //printf("\n\tEl progenitor de menor edad: %d", GetMinAge(nodo));
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
 int crear(struct treenodo *nodo){ // Implementar fflush (stdin);
    char resp[1] = "S";
    char gender[1];

    //system ("cls");
    ////---- DATOS DEL CAMPO INFORMACION DEL NODO ----////

    ////---- NAME ----////
    printf("\n\tIngresar el familiar: ");
    scanf("%s", &nodo->nombre);
    nodo->check = 0;
    ronda++;

    ////---- GENDER ----//// <-------------- DONE
   // printf("\n\tGenero([1]Mujer/[2]Hombre: ");
    //scanf ("%i", &nodo->Key_Gender);

   /* if (gender == "W" || gender == "w")
        nodo->Key_Gender = Is_Woman;
    else if (gender == "M" || gender == "m")
        nodo->Key_Gender = Is_MAN;*/ // <----------------- To automatize the gender process, CHECK

    /*printf("\tIngrese su edad: ");
    scanf("%i", &nodo->edad);
    printf("\tIngrese su nacionalidad: ");
    scanf("%s", &nodo->nacionalidad);*/

    printf("\t%s tiene madre(S/N): ", nodo -> nombre);
    scanf("%s", &resp);

    if (strcmp (resp,"S") == 0) {
        nodo->izqptr = malloc (sizeof(struct treenodo));
        crear(nodo->izqptr);
    } else
        nodo->izqptr = NULL;

    printf("\t%s tiene padre (S/N): ", nodo -> nombre);
    scanf("%s", &resp);

   if (strcmp (resp,"S") == 0) {
        nodo->derptr = malloc (sizeof(struct treenodo));
        crear(nodo->derptr);
    } else
        nodo->derptr = NULL;

    return;
}

