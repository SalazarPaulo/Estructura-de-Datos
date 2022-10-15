package Metodos;

import Parametros.*;
public class Botones  {
    EscogerPreguntas ep;
    public int i;
    public Botones() {
        ep = new EscogerPreguntas();
    }

    public void cambiar () {
        ep.setPreguntas();
        for (i = 0; i < Constantes.FILAS; i++) {
            System.out.println(ep.getPreguntas(i));
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