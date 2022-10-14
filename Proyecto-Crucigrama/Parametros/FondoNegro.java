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
    JTextField respuesta;

    public FondoNegro() {

        this.setBackground(Color.gray);
        respuesta = new JTextField(10);

        FlowLayout layout = new FlowLayout();
        layout.setVgap(20);
        layout.setHgap(70);

        this.setLayout(layout);

        this.setLayout(new GridLayout(Constantes.FILAS+2,1));
        JTextField [] textField = new JTextField [Constantes.FILAS];
        for (int i=0;i<Constantes.FILAS;i++) {
            textField[i] = new JTextField(1);
            this.add(new JLabel("Pregunta No.%i %s: "));// colocar un contador y la pregunta
            this.add(textField[i]);
            this.add(new JButton("Cambiar Pregunta"));
            this.add(new JButton("Enviar"));
        }
        this.add(new JButton("Cambiar Crucigrama"));
        this.add(new JButton("Reiniciar"));
    }
    private String GetPalabra() {
        return palabra;
    }
}