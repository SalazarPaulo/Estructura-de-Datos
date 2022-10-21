package Cargadores;

public class DataBase extends Datos {

    public int i;
    private Datos datos[] = new Datos[60];

    public DataBase() {
        // Se cargan datos de la Base de Datos
        for (i = 0; i < datos.length; i++) {
            datos[i] = new Datos();
            datos[i].pregunta = "Pregunta No." + i;
            datos[i].respuesta = "Resp" + i;
            datos[i].ID_Pregunta = i;
            datos[i].ID_Respuesta = i;
        }
        rellenar();
    }
    public Datos[] getDatos() {
        return datos;
    }
    public void setDatos(Datos[] datos) {
        this.datos = datos;
    }
    public String getRespuesta(int i) {
        return datos[i].respuesta;
    }
    public void rellenar() {
        datos[1].pregunta = "Pregunta no.1: Un proyecto requiere un(a)__________ de planificación.";
        datos[1].respuesta = "proceso";
        datos[2].pregunta = "Pregunta no.2: ¿Cuál es un elemento de un proyecto?";
        datos[2].respuesta = "actividades";
        datos[3].pregunta = "Pregunta no.3: ¿Ejemplo de costos indirectos en un proyecto?";
        datos[3].respuesta = "alquiler";
        datos[4].pregunta = "Pregunta no.4: Tipo de proyectos informáticos.";
        datos[4].respuesta = "redes";
        datos[5].pregunta = "Pregunta no.5: ¿Son todos aquellos que pueden ser identificados en el proyecto y están asociados a este?";
        datos[5].respuesta = "costosdirectos";
        datos[6].pregunta = "Pregunta no.6: ¿Qué normas se deben establecer para que un proyecto sea considerado exitoso?";
        datos[6].respuesta = "iso";
        datos[7].pregunta = "Pregunta no.7: ¿Qué requiere una inversión?";
        datos[7].respuesta = "analisis";
        datos[8].pregunta = "Pregunta no.8: ¿Qué provoca el poco conocimiento de la industria TI y de los proveedores?";
        datos[8].respuesta = "fracaso";
        datos[9].pregunta = "Pregunta no.9: ¿Ejemplo de costos directos de un proyecto?";
        datos[9].respuesta = "materiales";
        datos[10].pregunta = "Pregunta no.10: ¿Qué área se encarga de planificar la contratación en un proyecto?";
        datos[10].respuesta = "adquisiciones";
        datos[11].pregunta = "Pregunta no.11: ¿Qué área se encarga de cerrar el proyecto?";
        datos[11].respuesta = "integracion";
        datos[12].pregunta = "Pregunta no.12: ¿Qué área se encarga de crear EDT?";
        datos[12].respuesta = "alcance";
        datos[13].pregunta = "Pregunta no.13: ¿Qué área se encarga de gestionar a los interesados?";
        datos[13].respuesta = "comunicaciones";
        datos[14].pregunta = "Pregunta no.14: ¿Qué área se encarga de adquirir el equipo del proyecto?";
        datos[14].respuesta = "recursoshumanos";
        datos[15].pregunta = "Pregunta no.15: ¿Qué área se encarga del desarrollo del cronograma?";
        datos[15].respuesta = "tiempo";
        datos[16].pregunta = "Pregunta no.16: ¿Qué área se encarga de preparación del presupuesto?";
        datos[16].respuesta = "costes";
        datos[17].pregunta = "Pregunta no.17: Mencione un tipo de proyecto informático de comunicaciones y redes.";
        datos[17].respuesta = "buses";
        datos[18].pregunta = "Pregunta no.18: ¿Qué tipo de lenguaje se debe usar en los proyectos informáticos?";
        datos[18].respuesta = "comun";
        datos[19].pregunta = "Pregunta no.19: ¿Qué se debe establecer para el equipo para garantizar el éxito de los proyectos informáticos?";
        datos[19].respuesta = "expectativa";
        datos[20].pregunta = "Pregunta no.20: Mencione un tipo de proyecto informático de instalaciones de hardware.";
        datos[20].respuesta = "calidad";
    }
}