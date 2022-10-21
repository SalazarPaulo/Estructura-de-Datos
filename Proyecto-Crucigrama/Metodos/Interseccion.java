package Metodos;

public class Interseccion {
    String [][] matriz = new String[10][10];
    public void interseccion() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matriz[i][j] = "* ";
                System.out.print( matriz[i][j]);
            }
            System.out.println( );
        }
    }
    public void sobreescribir(int i, int j) {
        matriz[i][j] = "X ";
        System.out.print( matriz[i][j]);
    }
    public static void main(String[] args) {
        Interseccion inter = new Interseccion();
        inter.interseccion();
        inter.sobreescribir(2, 2);
    }
}
