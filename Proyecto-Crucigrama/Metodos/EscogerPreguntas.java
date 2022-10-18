package Metodos;

import Cargadores.*;
public class EscogerPreguntas extends DataBase {

    private int[] preguntas = new int[10];
    private int[] respuestas = new int[10];
    public int j;
    public boolean leido = true;
    DataBase db = new DataBase();
    Datos[] datos = db.getDatos();

    ////////-------- Rellenando el arreglo sin repetir  --------////////
    public void setPreguntas() {
        int i = 0;
        int num = (int)(Math.random() * 60);
        preguntas[i] = num;
        respuestas[i] = num;
        for(i = 1; i < preguntas.length; i++) {
            preguntas[i] = (int)(Math.random() * 60);
            for(j = 0; j < 1; j++) {
                if(preguntas[i] == preguntas[j])
                    i--;
            }
        }
    }
    public String getPreguntas(int i) {
        return datos[preguntas[i]].pregunta;
    }
    public String getRespuestas(int i) {
        return datos[respuestas[i]].respuesta;
    }
}
