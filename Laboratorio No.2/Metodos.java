import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JPanel;

public class Metodos extends Treenodo {

    private Treenodo nodoIzqptr, nodoDerptr;

    public Metodos () {
        nodoIzqptr = null;
        nodoDerptr = null;
    }
    public int getNodoIzqptr() {
        return nodoIzqptr.dato;
    }
    public void setNodoIzqptr(Treenodo nodo) {
        this.nodoIzqptr = nodo;
    }
    public int getNodoDerptr () {
        return nodoDerptr.dato;
    }
    public void setNodoDerptr (Treenodo nodo) {
        this.nodoDerptr = nodo;
    }
    // Insertamos el valor en el campo de informacion del nodo y definimos las direcciones de sus punteros
    public void crear (int element, int option) {

        Treenodo nodo = new Treenodo();

        nodo.dato = element;
        nodo.Derptr = null;
        nodo.Izqptr = null;

        // Lado Izquierdo
        if (option  == 1) {
            nodoIzqptr = nodo;
        } else if (option == 2) {
            nodoIzqptr = null;
        // Lado Derecho
        } else if (option == 3) {
            nodoDerptr = nodo;
        } else {
            nodoDerptr = null;
        }

    }

    // public boolean agregar(int dato) {
    //     Nodo nuevo = new Nodo(dato, null, null);
    //     insertar(nuevo, raiz);
    //     return true;
    // }

    // //Metodo para insertar un dato en el arbol...no acepta repetidos :)
    // public void insertar(Nodo nuevo, Nodo pivote) {
    //     if (this.raiz == null) {
    //         raiz = nuevo;
    //     } else {
    //         if (nuevo.getDato() <= pivote.getDato()) {
    //             if (pivote.getIzq() == null) {
    //                 pivote.setIzq(nuevo);
    //             } else {
    //                 insertar(nuevo, pivote.getIzq());
    //             }
    //         } else {
    //             if (pivote.getDer() == null) {
    //                 pivote.setDer(nuevo);
    //             } else {
    //                 insertar(nuevo, pivote.getDer());
    //             }
    //         }
    //     }
    // }
    // private void altura(Nodo aux, int nivel) {
    //     if (aux != null) {
    //         altura(aux.getIzq(), nivel + 1);
    //         alt = nivel;
    //         altura(aux.getDer(), nivel + 1);
    //     }
    // }

    // //Devuleve la altura del arbol
    // public int getAltura() {
    //     altura(raiz, 1);
    //     return alt;
    // }
    
    //Metodo para verificar si hay un nodo en el arbol
    // public boolean checkIfExist(int dato) {
    //     Treenodo aux = nodo;
    //     while (aux != null) {
    //         if (dato == aux.getDato()) {
    //             return true;
    //         } else if (dato > aux.getDato()) {
    //             aux = aux.getDerptr();
    //         } else {
    //             aux = aux.getIzqptr();
    //         }
    //     }
    //     return false;
    // }

    // public JPanel getdibujo() {
    //     return new ArbolExpresionGrafico(this);
    // }

}
