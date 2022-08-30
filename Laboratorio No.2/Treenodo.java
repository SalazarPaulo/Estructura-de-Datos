public class Treenodo {

    protected Object Izqptr; // puntero al nodo izquierdo
    protected int dato; // dato del nodo (Elemento a guardar)
    protected Object Derptr; // puntero al nodo derecho

    public Treenodo(int dato, Treenodo Izqptr, Treenodo Derptr) {
        this.dato = dato;
        this.Izqptr = Izqptr;
        this.Derptr = Derptr;
    }
    public Treenodo () {
        this.dato = 0;
        this.Izqptr = null;
        this.Derptr = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    // public Treenodo getIzqptr() {
    //     return Izqptr;
    // }

    public void setIzqptr(Treenodo Izqptr) {
        this.Izqptr = Izqptr;
    }

    // public Treenodo getDerptr() {
    //     return Derptr;
    // }

    public void setDerptr(Treenodo Derptr) {
        this.Derptr = Derptr;
    }
}
