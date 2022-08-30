import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {
    public static void main(String x[]) throws IOException {

        ////////-------- INSTANCES OF THE CLASSES --------////////
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Metodos nodo = new Metodos(); // <- Esta extiende de la clase Treenodo
        // Treenodo nodo = new Treenodo(); //puntero al nodo

        ////////-------- STATEMENTS --------////////
        boolean leido, salir;
        int dato;
        String resp;

        ////////-------- INITIALIZE STATEMENTS --------////////
        leido = true;
        salir = true;
        dato = 0;
        resp = "S";

        ////////-------- BODY --------////////
        do {
            ////---- Leer el dato ----////
            do {
                try {
                    leido = true;
                    System.out.print("\nEntre del dato: ");
                    dato = Integer.parseInt(br.readLine());
                } catch (NumberFormatException nfe) {
                    leido = false;
                    System.out.print("\tDato no numerico, reingrese\n");
                } catch (Exception e) {
                    leido = false;
                    System.out.print("\t" + e);
                }
            } while (!leido);

            // nodo.setDato(dato); // Enviando el dato al campo info del nodo
            
            //Llenar el lado izquierdo
            do {
                try {
                    leido = true;
                    System.out.print("Hay nodos a la izquierda de " + dato + " entre S/N: ");
                    resp = br.readLine();
                    if (!(resp.equals("S") || resp.equals("N"))) {
                        leido = false;
                        System.out.println("Ingrese S o N");
                    }
                } catch (Exception e) {
                    leido = false;
                    System.out.print("\t" + e + "\n");
                }
            } while (!leido);

            if(resp.equals("S")) {
                nodo.crear(dato, 1);
                // nodo.setIzqptr(new Treenodo());
            } else {
                nodo.crear(dato, 2);
            }

            // Llenar el lado derecho
            do {
                try {
                    leido = true;
                    System.out.print("Hay nodos a la derecha de " + dato + " entre S/N: ");
                    resp = br.readLine();
                    if (!(resp.equals("S") || resp.equals("N"))) {
                        leido = false;
                        System.out.println("Ingrese S o N");
                    }
                } catch (Exception e) {
                    leido = false;
                    System.out.print("\t" + e);
                }
            } while (!leido);

            if(resp.equals("S")) {
                nodo.crear(dato, 3);
                // nodo.setDerptr(new Treenodo());
            } else {
                nodo.crear(dato, 4);
            }

        } while (salir);
    }
}