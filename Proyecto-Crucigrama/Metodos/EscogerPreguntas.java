package Metodos;

import Cargadores.*;
public class EscogerPreguntas extends DataBase {

    public int[] indice = new int[10];
    public int[] indice2 = new int[10];
    public int j;
    DataBase db = new DataBase();
    Datos[] datos = db.getDatos();

    ////////-------- Rellenando el arreglo sin repetir  --------////////
    public void setPreguntas() {
        int i = 0;
        int num = (int)(Math.random() * 60);
        indice[i] = num;
        for(i = 1; i < indice.length; i++) {
            int num2 = (int)(Math.random() * 60);
            indice[i] = num2;
            for(j = 0; j < 1; j++) {
                if(indice[i] == indice[j])
                    i--;
            }
        }
    }
    public String getPreguntas(int i) {
        return datos[indice[i]].pregunta;
    }
    public void imprimir () {
        for (int i = 0; i < 10; i++) {
            System.out.println(indice[i]);
        }
    }

}
