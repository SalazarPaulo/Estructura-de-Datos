public class Treenodo {

    protected Treenodo Izqptr; // puntero al nodo izquierdo
    protected int dato; // dato del nodo (Elemento a guardar)
    protected Treenodo Derptr; // puntero al nodo derecho

    public Treenodo (int dato) {
        this.dato = dato;
        this.Izqptr = null;
        this.Derptr = null;
    }
    public Treenodo () {
        this.dato = 0;
        this.Izqptr = null;
        this.Derptr = null;
    }

    public int getDato() {
        return dato;
    }

    public void getDato(int dato) {
        this.dato = dato;
    }

    public Treenodo getIzqptr() {
        return Izqptr;
    }

    public Treenodo getDerptr() {
        return Derptr;
    }
    public void crear (int dato, int option) {
        // Treenodo nodo = new Treenodo(dato);
        // Lado Izquierdo
        if (option  == 1) {
            this.Izqptr = new Treenodo(dato);
        } else if (option == 2) {
            this.Izqptr = null;
            // this.Izqptr.crear(dato, option);
        // Lado Derecho
        } else if (option == 3) {
            this.Derptr  = new Treenodo(dato);;
        } else {
            // this.Derptr.crear(dato, option);
            this.Derptr = null;
        }
    }
    
}
