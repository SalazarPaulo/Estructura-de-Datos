import java.io.*;

public class Main {
    public static void main(String x[]) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Treenodo nodo = new Treenodo();
        crear(nodo, br);

    }

    public static void crear(Treenodo nodo, BufferedReader br) {

        String resp = "S";
        int dato = 0;
        Treenodo Izqptr, Derptr;

        System.out.println();

        try {
            System.out.print("\tIngrese el dato: ");
            dato = Integer.parseInt(br.readLine());
        } catch (IOException ioe) {
        }

        System.out.println();

        try {
            System.out.print("\tHay dato a la izquierda de (" + dato + ") S/N: ");
            resp = br.readLine();
        } catch (IOException ioe) {
        }

        if (resp.equals("S")) {
            Izqptr = new Treenodo();
            crear(Izqptr, br);
        } else {
            Izqptr = null;
        }

        System.out.println();

        try {
            System.out.print("\tHay dato a la derecha de (" + dato + ") S/N: ");
            resp = br.readLine();
        } catch (IOException ioe) {
        }

        if (resp.equals("S")) {
            Derptr = new Treenodo();
            crear(Derptr, br);
        } else {
            Derptr = null;
        }
        return;
    }
}