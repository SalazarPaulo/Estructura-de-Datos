package Metodos;

import java.io.*;
import Cargadores.*;

public class EscogerPreguntas extends DataBase {

    private int[] preguntas = new int[10];
    public int j;
    public boolean leido = true;

    ////////-------- Rellenando el arreglo sin repetir  --------////////
    private void escogerPreguntas() {
        int i = 0;
        preguntas[i] = (int)(Math.random() * 60);
        for(i = 1; i < preguntas.length; i++) {
            preguntas[i] = (int)(Math.random() * 60);
            for(j = 0; j < 1; j++) {
                if(preguntas[i] == preguntas[j])
                    i--;
            }
        }
    }

    private void imprimirPreguntas() {
        int i = 0;
        DataBase db = new DataBase();
        Datos[] datos = db.getDatos();
        for (i = 0; i < preguntas.length; i++) {
            System.out.println(datos[preguntas[i]].pregunta);
        }
    }
    public static void main(String x[]) {
        EscogerPreguntas ep = new EscogerPreguntas();
        ep.escogerPreguntas();
        ep.imprimirPreguntas();
    }
}
