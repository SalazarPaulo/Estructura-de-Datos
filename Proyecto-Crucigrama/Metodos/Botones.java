package Metodos;

import Parametros.*;
public class Botones {
    EscogerPreguntas ep;
    public int i;
    LateralIzq datos;
    public Botones() {
        ep = new EscogerPreguntas();
    }

    public void cambiar () {
        ep.setPreguntas();
        datos = new LateralIzq();
        for (i = 0; i < Constantes.FILAS; i++) {
        }
        System.out.println("\n");
    }

    public void validar () {
        System.out.println("Boton validar Crucigrama");
    }
    public void reiniciar () {
        System.out.println("Boton reiniciar Crucigrama");
    }
    public void guardar () {
        System.out.println("Boton guardar Crucigrama");
    }

}