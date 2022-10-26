package src.Cargadores;

public class DataBase extends Datos {

    public int i;
    private Datos datos[] = new Datos[80];

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
        datos[0].pregunta = "Pregunta no.1: Un proyecto requiere un(a)__________ de planificación.";
        datos[0].respuesta = "PROCESO";
        datos[1].pregunta = "Pregunta no.2: ¿Cuál es un elemento de un proyecto?";
        datos[1].respuesta = "ACTIVIDADES";
        datos[2].pregunta = "Pregunta no.3: ¿Ejemplo de costos indirectos en un proyecto?";
        datos[2].respuesta = "ALQUILER";
        datos[3].pregunta = "Pregunta no.4: Tipo de proyectos informáticos.";
        datos[3].respuesta = "REDES";
        datos[4].pregunta = "<html>Pregunta no.5: ¿Son todos aquellos que pueden ser identificados en el proyecto y están asociados a este?<html>";
        datos[4].respuesta = "COSTOSDIRECTOS";
        datos[5].pregunta = "<html>Pregunta no.6: ¿Qué normas se deben establecer para que un proyecto sea considerado exitoso?<html>";
        datos[5].respuesta = "ISO";
        datos[6].pregunta = "Pregunta no.7: ¿Qué requiere una inversión?";
        datos[6].respuesta = "ANALISIS";
        datos[7].pregunta = "Pregunta no.8: ¿Qué provoca el poco conocimiento de la industria TI y de los proveedores?";
        datos[7].respuesta = "FRACASO";
        datos[8].pregunta = "Pregunta no.9: ¿Ejemplo de costos directos de un proyecto?";
        datos[8].respuesta = "MATERIALES";
        datos[9].pregunta = "Pregunta no.10: ¿Qué área se encarga de planificar la contratación en un proyecto?";
        datos[9].respuesta = "ADQUISICIONES";
        datos[10].pregunta = "Pregunta no.11: ¿Qué área se encarga de cerrar el proyecto?";
        datos[10].respuesta = "INTEGRACION";
        datos[11].pregunta = "Pregunta no.12: ¿Qué área se encarga de crear EDT?";
        datos[11].respuesta = "ALCANCE";
        datos[12].pregunta = "Pregunta no.13: ¿Qué área se encarga de gestionar a los interesados?";
        datos[12].respuesta = "COMUNICACIONES";
        datos[13].pregunta = "Pregunta no.14: ¿Qué área se encarga de adquirir el equipo del proyecto?";
        datos[13].respuesta = "RECURSOSHUMANOS";
        datos[14].pregunta = "Pregunta no.15: ¿Qué área se encarga del desarrollo del cronograma?";
        datos[14].respuesta = "TIEMPO";
        datos[15].pregunta = "Pregunta no.16: ¿Qué área se encarga de preparación del presupuesto?";
        datos[15].respuesta = "COSTES";
        datos[16].pregunta = "Pregunta no.17: Mencione un tipo de proyecto informático de comunicaciones y redes.";
        datos[16].respuesta = "BUSES";
        datos[17].pregunta = "Pregunta no.18: ¿Qué tipo de lenguaje se debe usar en los proyectos informáticos?";
        datos[17].respuesta = "COMUN";
        datos[18].pregunta = "<html>Pregunta no.19: ¿Qué se debe establecer para el equipo para garantizar el éxito de los proyectos informáticos?<html>";
        datos[18].respuesta = "EXPECTATIVA";
        datos[19].pregunta = "<html>Pregunta no.20: Mencione un tipo de proyecto informático de instalaciones de hardware.<html>";
        datos[19].respuesta = "SERVICIOS";
        datos[20].pregunta = "Pregunta no.1: La búsqueda de una solución inteligente al planteamiento de un problema a resolver. ";
        datos[20].respuesta = "PROYECTO";
        datos[21].pregunta = "Pregunta no.2: En un proyecto existe un principio y un final esto quiere decir que es:";
        datos[21].respuesta = "TEMPORAL";
        datos[22].pregunta = "Pregunta no.3: Velocidad de proceso, (S.O.), Servicios ect.";
        datos[22].respuesta = "HARDWARE";
        datos[23].pregunta = "Pregunta no.4: Es aquel que presenta desvíos negativos en los plazos o en el presupuesto. ";
        datos[23].respuesta = "PROYECTOFALLIDO";
        datos[24].pregunta = "Pregunta no.5: Metodologías, ingeniería de software, interfaces, ect.. ";
        datos[24].respuesta = "INTERFACES";
        datos[25].pregunta = "Pregunta no.6: Sistemas, seguridad informática, reingenieria de proyectos, ect.";
        datos[25].respuesta = "AUDITORIAS";
        datos[26].pregunta = "Pregunta no.7: Para tener éxito, las organizaciones deben crear o adaptar un enfoque: ";
        datos[26].respuesta = "ESTANDAR";
        datos[27].pregunta = "Pregunta no.8: Siempre que exista una necesidad habrá un necesidad de:";
        datos[27].respuesta = "INVERTIR";
        datos[28].pregunta = "Pregunta no.9: ¿Quienes determinan que proyectos preceden a otros y cuales no? ";
        datos[28].respuesta = "ADMINISTRADOR";
        datos[29].pregunta = "Pregunta no.10: ¿Otro tipo de proyectos informáticos?";
        datos[29].respuesta = "CONSULTORIA";
        datos[30].pregunta = "Pregunta no.11: Son aquellos costos que están involucrados en el proyecto ";
        datos[30].respuesta = "INDIRECTOS";
        datos[31].pregunta = "Pregunta no.12: Requiere la intervención de personas y especialista en funcion de las : ";
        datos[31].respuesta = "NECESIDADES";
        datos[32].pregunta = "Pregunta no.13: Falta de habilidades de gestión de proyectos y administración del riesgo ";
        datos[32].respuesta = "CONFLICTOS";
        datos[33].pregunta = "<html>Pregunta no.14: ¿Para que un proyecto sea considerado exitoso debe estar dentro de un determinado?<html>";
        datos[33].respuesta = "PRESUPUESTO";
        datos[34].pregunta = "Pregunta no.15: ¿En que contexto se puede aplicar un proyecto de tecnología de la informacion?";
        datos[34].respuesta = "TECNOLOGICO";
        datos[35].pregunta = "Pregunta no.16: ¿Qué es esencial en un proyecto? ";
        datos[35].respuesta = "FECHA";
        datos[36].pregunta = "Pregunta no.17: ¿Qué tipo de sucesión se debe presentar en un proyecto?";
        datos[36].respuesta = "LOGICA";
        datos[37].pregunta = "<html>Pregunta no.18: ¿Que elementos son utilizados para poder realizar la ejecución de cada una de las tareas?<html>";
        datos[37].respuesta = "RECURSOS";
        datos[38].pregunta = "Pregunta no.19: En las áreas de aplicación un tipo de disciplina de respaldo es:";
        datos[38].respuesta = "LOGISTICA";
        datos[39].pregunta = "Pregunta no.20: Un área de aplicación de proyecto.";
        datos[39].respuesta = "INDUSTRIA";
        datos[40].pregunta = "Pregunta no.1: Diagrama que se parece a las vías de un tren. ";
        datos[40].respuesta = "ISHIKAWA";
        datos[41].pregunta = "Pregunta no.2: Forma parte del resumen narrativo de objetos";
        datos[41].respuesta = "FIN";
        datos[42].pregunta = "Pregunta no.3: Son los factores que consideramos ciertos, pero no son controlables";
        datos[42].respuesta = "SUPUESTOS";
        datos[43].pregunta = "<html>Pregunta no.4: Qué representa tendencias, crisis, ciclos, politicas de innovacion en el analisis PESTEL.<html>";
        datos[43].respuesta = "ECONOMICO";
        datos[44].pregunta = "Pregunta no.5: El diagrama de Ishikawa identifica problemas de:";
        datos[44].respuesta = "CALIDAD";
        datos[45].pregunta = "Pregunta no.6: Stakeholder matrix está formado por:";
        datos[45].respuesta = "TIEMPOVSDISPONIBILIDAD";
        datos[46].pregunta = "Pregunta no.7: Actividad realizada para obtener todas las visiones y llegar a un criterio común.";
        datos[46].respuesta = "BRAINSTORMING";
        datos[47].pregunta = "Pregunta no.8: Dentro del análisis PESTEL, en la sección social podemos encontrar…";
        datos[47].respuesta = "ACTITUDES";
        datos[48].pregunta = "Pregunta no.9: ¿Cantidad de capas que tiene el árbol de problemas?";
        datos[48].respuesta = "TRES";
        datos[49].pregunta = "Pregunta no.10: Variable que se toma en cuenta en los análisis de alternativas";
        datos[49].respuesta = "BENEFICIOS";
        datos[50].pregunta = "Pregunta no.11: Dimension que necesitan los indicadores de fin y propósito";
        datos[50].respuesta = "CANTIDAD"; // <--- REPETIDO
        datos[51].pregunta = "Pregunta no.12: Los skateholder map pueden ser agrupados por sus: ";
        datos[51].respuesta = "INTERESES";
        datos[52].pregunta = "Pregunta no.13: ¿En qué se enfoca la P en el análisis PESTEL?";
        datos[52].respuesta = "GOBIERNO";
        datos[53].pregunta = "Pregunta no.14: ¿skaterholder matrix está formado por nivel de poder vs nivel de?";
        datos[53].respuesta = "INTERES";
        datos[54].pregunta = "Pregunta no.15: Aspecto importante del proyecto";
        datos[54].respuesta = "COMPONENTES";
        datos[55].pregunta = "<html>Pregunta no.16: Ejemplo de stakeholders externo.<html>";
        datos[55].respuesta = "DISTRIBUIDOR";
        datos[56].pregunta = "Pregunta no.17: En el arbol de problemas las causas van en la  ____________";
        datos[56].respuesta = "RAIZ";
        datos[57].pregunta = "Pregunta no.18: ¿En que técnica se utiliza el análisis de problema?";
        datos[57].respuesta = "PORQUE";
        datos[58].pregunta = "Pregunta no.19: Dentro del análisis PESTEL, en la sección tecnologica podemos encontrar_____";
        datos[58].respuesta = "INVESTIGACION";
        datos[59].pregunta = "Pregunta no.20: Ejemplo de stakeholders internos.";
        datos[59].respuesta = "FINANCIERO";
        datos[60].pregunta = "Pregunta no.1: Cuántas etapas principales tiene el marco lógico.";
        datos[60].respuesta = "SIETE";
        datos[61].pregunta = "Pregunta no.2: ¿Qué análisis considera al público, usuario y a stakeholder?";
        datos[61].respuesta = "INVOLUCRADOS";
        datos[62].pregunta = "Pregunta no.3: ¿Qué analiza el analisis de involucrados?";
        datos[62].respuesta = "OBJETIVOS";
        datos[63].pregunta = "Pregunta no.4: Qué significa la L del ANALISIS PESTEL";
        datos[63].respuesta = "LEGAL";
        datos[64].pregunta = "<html>Pregunta no.5: ¿Qué significa demografia, estilo de vida, actitudes, aspectos eticos, nivel de educacion ect.. en el analisis PESTEL?<html>";
        datos[64].respuesta = "SOCIAL";
        datos[65].pregunta = "<html>Pregunta no.6: Debes tener en cuenta la funcionalidad, la fiabilidad, la usabilidad y el diseño que resuelva las necesidades del: <html>";
        datos[65].respuesta = "CLIENTE";
        datos[66].pregunta = "Pregunta no.7:La matriz de marco logico se considera un ____";
        datos[66].respuesta = "RESUMEN";
        datos[67].pregunta = "Pregunta no.8: Sus fundadores son  Brian Chesky y Joe Gebbia";
        datos[67].respuesta = "AIRBNB";
        datos[68].pregunta = "<html>Pregunta no.9: Qué analisis trata la tecnica de los cinco porqués, arbol de problemas y diagrama de Ishikawa<html>";
        datos[68].respuesta = "CAUSASYEFECTOS";
        datos[69].pregunta = "Pregunta no.10: ¿Qué metodo se usa para identificar las causas y efectos de un problema?";
        datos[69].respuesta = "ARBOLDEPROBLEMA";
        datos[70].pregunta = "Pregunta no.11: Stakeholder que atribuye criterios de poder a los grupos de interés";
        datos[70].respuesta = "MATRIX";
        datos[71].pregunta = "Pregunta no.12: Analisis que describe el entorno del proyecto";
        datos[71].respuesta = "PESTEL";
        datos[72].pregunta = "Pregunta no.13: Stakeholder matrix está formado por Nivel de interés vs Nivel de______";
        datos[72].respuesta = "PODER";
        datos[73].pregunta = "<html>Pregunta no.14: ¿En qué etapa se identifican los problemas de raíz que se desea intervenir del análisis de problemas de causas y efectos?<html>";
        datos[73].respuesta = "SEGUNDA";
        datos[74].pregunta = "Pregunta no.15: ¿En qué parte del Árbol de Problemas se encuentra el cuello de botella?";
        datos[74].respuesta = "PROBLEMA EFECTOS";
        datos[75].pregunta = "Pregunta no.16: ¿En qué parte del Árbol de Problemas se encuentra la falta de personal?";
        datos[75].respuesta = "PROBLEMA CAUSA";
        datos[76].pregunta = "<html>Pregunta no.17: Qué representa el gobierno, clima político, conflictos, iniciativas y ayudas en el Análisis PESTEL<html>";
        datos[76].respuesta = "POLITICO";
        datos[77].pregunta = "<html>Pregunta no.18: ¿.Qué representa problemas, medio ambiente, procesos, produccion, consumo, politicas ect en  el Análisis PESTEL?<html>";
        datos[77].respuesta = "ECOLOGICO";
        datos[78].pregunta = "<html>Pregunta no.19: ¿Quiénes pueden ser agrupados por sus intereses comunes?<html>";
        datos[78].respuesta = "STAKEHOLDERS";
        datos[79].pregunta = "Pregunta no.20: Empresa ejemplo de análisis del producto mínimo viable";
        datos[79].respuesta = "UBER";
    }
}