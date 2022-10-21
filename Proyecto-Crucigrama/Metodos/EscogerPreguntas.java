package Metodos;

import Cargadores.*;
import Parametros.Constantes;
public class EscogerPreguntas extends DataBase {

    public int j;
    private int[] preguntas = new int[Constantes.FILAS];
    private int[] respuestas = new int[Constantes.FILAS];
    private DataBase db = new DataBase();
    private Datos[] datos = db.getDatos();

    ////////-------- Rellenando el arreglo sin repetir  --------////////
    public void setPreguntas() {
        int i = 0;
        int num = (int)(Math.random() * 60);
        preguntas[i] = num;
        respuestas[i] = preguntas[i];
        for(i = 1; i < preguntas.length; i++) {
            int num2 = (int)(Math.random() * 60);
            preguntas[i] = num2;
            respuestas[i] = preguntas[i];
            for(j = 0; j < 1; j++) {
                if(preguntas[i] == preguntas[j])
                    i--;
            }
        }
    }
    public void imprimir() {
        for(int z = 0; z < preguntas.length; z++) {
            System.out.print("\n<-" + preguntas[z] + "||");
            System.out.print(respuestas[z] + "-> ");
        }
    }
    public String getPreguntas(int i) {
        return datos[preguntas[i]].pregunta;
    }
    public String getRespuestas(int i) {
        return datos[preguntas[i]].respuesta;
    }
}
