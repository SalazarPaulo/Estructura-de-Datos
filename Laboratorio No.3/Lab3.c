#include <stdio.h>
#include <string.h>
#include <stdlib.h>


struct treenodo {
   struct treenodo *izqptr;   //puntero al nodo izquierdo
   int dato;                 //dato del nodo
   struct treenodo *derptr; // puntero al nodo derecho
};
// Metodo para obtener el preorden en un arbol binario
preorden (struct treenodo *nodo){
    if (nodo != NULL) {
        printf("%d", nodo->dato);
        preorden(nodo->izqptr);
        preorden(nodo->derptr);
    }
    return 0;
}
// Metodo para obtener el inorden en un arbol binario
inorden (struct treenodo *nodo){
    if (nodo != NULL) {
        inorden(nodo->izqptr);
        printf("%d", nodo->dato);
        inorden(nodo->derptr);
    }
    return 0;
}
// Metodo para obtener el postorden en un arbol binario
postorden (struct treenodo *nodo){
    if (nodo != NULL) {
        postorden(nodo->izqptr);
        postorden(nodo->derptr);
        printf("%d", nodo->dato);
    }
    return 0;
}

// Método Principal

int main(){
    struct treenodo *nodo;
    nodo = (struct treenodo*) malloc (sizeof(nodo));
    crear (nodo);
    printf("\nPreorden: ");
    preorden(nodo);
    printf("\nInorden: ");
    inorden(nodo);
    printf("\nPostorden: ");
    postorden(nodo);
    printf("\n\n");
}

// Método que crea el árbol binario (Aplicando recursividad)

 int crear(struct treenodo *nodo){
    char resp[1] = "S";

    printf ("\nEntre el dato: ");
    scanf (" %d", &nodo->dato);
    printf ("Hay nodos a la Izquierda de %d", nodo -> dato);
    printf(" entre S/N: ");
    scanf("%s", &resp);

    if (strcmp (resp,"S")==0) {
         nodo->izqptr= malloc (sizeof(struct treenodo));
         crear(nodo->izqptr);
    } else
         nodo->izqptr= NULL;

    printf ("Hay nodos a la Derecha de %d", nodo -> dato);
    printf(" entre S/N: ");
    scanf("%s", &resp);

   if (strcmp (resp,"S")==0) {
       nodo->derptr = malloc (sizeof(struct treenodo));
       crear(nodo->derptr);
    } else
       nodo->derptr= NULL;

    return;
}
