package Metodos;

import java.util.HashMap;

import Cargadores.*;
import Parametros.Constantes;
public class EscogerPreguntas extends DataBase {

    public int j, i=0, opcion, z;
    private int[] preguntas = new int[Constantes.FILAS];
    private int[] respuestas = new int[Constantes.FILAS];
    private HashMap<Integer,Integer> Switch;
    private DataBase db = new DataBase();
    private Datos[] datos = db.getDatos();

    public void setPreguntas(int opcion) {
        this.opcion = opcion;
        Switch = new HashMap<Integer,Integer>() {
            {
                put(0, 0);
                put(1, 20);
                put(2, 40);
                put(3, 60);
            }
        };
        z = Switch.get(opcion);
        System.out.println("Z: " + z + " Opcion: " + opcion);
        for(i = 0; i < preguntas.length; i++) {
            preguntas[i] = i+z;
            respuestas[i] = preguntas[i];
        }
    }
    public int getOpcion() {
        return opcion;
    }
    public String getPreguntas(int i) {
        return datos[preguntas[i]].pregunta;
    }
    public String getRespuestas(int i) {
        return datos[preguntas[i]].respuesta;
    }
}
