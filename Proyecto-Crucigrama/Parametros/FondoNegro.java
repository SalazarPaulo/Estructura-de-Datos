package Parametros;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
public class FondoNegro extends JPanel {

    private String palabra;
    JTextField [] respuestas;
    JButton reiniciar, guardar, cambiar, validar;
    JButton[] enviar, cambiarP;
    public int i;

    public FondoNegro() {

        this.setBackground(Color.gray);

        FlowLayout layout = new FlowLayout();
        layout.setVgap(20);
        layout.setHgap(100);

        this.setLayout(layout);

        this.setLayout(new GridLayout(Constantes.FILAS+2,1));
        respuestas = new JTextField [Constantes.FILAS];
        for (i = 0; i < Constantes.FILAS; i++) {
            respuestas[i] = new JTextField(10);
            this.add(new JLabel("Pregunta No.%i %s: "));// colocar un contador y la pregunta
            this.add(respuestas[i]);
            this.add(new JButton("Cambiar Pregunta"));
            this.add(new JButton("Enviar"));
        }
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));

        this.add(new JButton("Cambiar Crucigrama"));
        this.add(new JButton("Validar"));
        this.add(new JButton("Reiniciar"));
        this.add(new JButton("Guardar"));
    }
    private String getPalabra() {

        for(i = 0; i < Constantes.FILAS; i++) {
            if (respuestas[i].getText().equals("SI")) {
                palabra = "SI"; // ESCRIBIR EN EL CRUCIGRAMA
            } else {
                palabra = "NO"; // Tambien se puede hacer por recursividad
            }
        }
        return palabra;
    }
}