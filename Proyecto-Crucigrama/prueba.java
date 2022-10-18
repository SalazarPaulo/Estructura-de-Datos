import Cargadores.*;
public class prueba extends DataBase {

    private int[] preguntas = new int[10];
    private int[] respuestas = new int[10];
    public int j;
    public boolean leido = true;
    DataBase db = new DataBase();
    Datos[] datos = db.getDatos();
    public prueba() {
        setPreguntas();
    }
    ////////-------- Rellenando el arreglo sin repetir  --------////////
    public void setPreguntas() {
        int i = 0;
        int num = (int)(Math.random() * 60);
        preguntas[i] = num;
        respuestas[i] = 1;
        for(i = 1; i < preguntas.length; i++) {
            int num2 = (int)(Math.random() * 60);
            preguntas[i] = num2;
            respuestas[i] = num2;
            for(j = 0; j < 1; j++) {
                if(preguntas[i] == preguntas[j])
                    i--;
                }
                // System.out.print(respuestas[i-1] + " ");
        }
    }
    public void imprimir() {
        for(int z = 0; z < preguntas.length; z++) {
            // System.out.print(preguntas[z] + " ");
            System.out.print(respuestas[z] + " ");
        }
    }
    public String getPreguntas(int i) {
        return datos[preguntas[i]].pregunta;
    }
    public String getRespuestas(int i) {
        int indice = respuestas[i];
        imprimir();
        return datos[indice].respuesta;
    }
    public static void main(String [] args) {
        prueba c = new prueba();
        c.imprimir();
        // c.setVisible(true);
        
    }
}