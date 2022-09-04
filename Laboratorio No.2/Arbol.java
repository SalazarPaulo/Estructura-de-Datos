public class Arbol {
    private Treenodo raiz;

    public Arbol () {
        this.raiz = null;
    }
    public Treenodo getRaiz() {
        return raiz;
    } 
    public void crear (int dato, int option) {
        if (this.raiz == null) {
            this.raiz = new Treenodo(dato);
        } else {
            this.raiz.crear(dato, option);
        }
    }
    public void recorrer () {
        this.retornar(this.raiz);
    }
    public void retornar (Treenodo nodo) {
        if (nodo == null) {
            return; //<-- Paro la recursividad
        }
        // } else {
        //     retornar(nodo.getIzqptr());
        // }
    }
}