package Cargadores;

import Parametros.LateralDer;
import Metodos.*;
public class DataBase extends Datos {

    private Datos[] datos = new Datos[60];
    // protected int[] indice = new int[10];
    public int i;
    protected String respText, resp;

    public DataBase() {
        // Se cargan datos de la Base de Datos
        for (i = 0; i < datos.length; i++) {
            datos[i] = new Datos();
            datos[i].pregunta = "Pregunta No." + i;
            datos[i].respuesta = "Respuesta No." + i;
            datos[i].ID_Pregunta = i;
            datos[i].ID_Respuesta = i;
        }
    }
    public Datos[] getDatos() {
        return datos;
    }
    public void setDatos(Datos[] datos) {
        this.datos = datos;
    }
}