import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {
    public static void main(String x[]) throws IOException {

        ////////-------- STATEMENTS --------////////
        boolean leido, salir, terminaCiclo, terminaDer;
        int dato;
        String resp;
        
        ////////-------- INITIALIZE STATEMENTS --------////////
        leido = true;
        salir = true;
        terminaCiclo = true;
        terminaDer = true;
        dato = 0;
        resp = "S";
        
        ////////-------- INSTANCES OF THE CLASSES --------////////
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arbol nodo = new Arbol(); // <- Esta extiende de la clase Treenodo
        Treenodo treenodo = new Treenodo(dato); //puntero al nodo

        ////////-------- BODY --------////////
        do {
            do {
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
                    // con treenodo los asigno a las derecha o izqierda mientras que con nodo lo asigno a la raiz
                    if(resp.equals("S")) {
                        nodo.crear(dato, 1);
                        terminaCiclo = false;
                    } else {
                        nodo.crear(dato, 2);
                        terminaCiclo = true;
                    }
                    System.out.println("nodo ptr: " + nodo );
                    System.out.println("izquierda:" + treenodo.getIzqptr());
                    System.out.println("RAIZ: " + nodo.getRaiz());
                    System.out.println("derecha:" + treenodo.getDerptr());;
                } while (!terminaCiclo);
    
                // Llenar el lado derecho
                do {
                    try {
                        leido = true;
                        System.out.print("\nHay nodos a la derecha de " + dato + " entre S/N: " );
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
                    // terminaDer = false;
                } else {
                    nodo.crear(dato, 4);
                    nodo.recorrer();
                    // salir = true;
                }
                System.out.println("izquierda:" + treenodo.getIzqptr());
                System.out.println("RAIZ: " + nodo.getRaiz());
                System.out.println("derecha:" + treenodo.getDerptr());
            } while (!terminaDer);
        } while (!salir);
    }
}