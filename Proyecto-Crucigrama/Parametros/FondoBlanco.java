package Parametros;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Metodos.*;

public class FondoBlanco extends JPanel {

    private Botones botones;
    String[] respuesta;
    public int i;
    
    // public FondoBlanco(Botones b) {
        //     this.botones = b;
        //     mostrar();
        // }
        
        public FondoBlanco() {
        JTextField [][] textField = new JTextField [Constantes.FILAS][Constantes.COLUMNAS];

        this.setBackground(Color.RED);
        this.setLayout(new GridLayout(Constantes.FILAS,Constantes.COLUMNAS));
         // JLabel[][] label = new JLabel[filas][columnas];
        for (int i=0;i<Constantes.FILAS;i++)
            for (int j=0;j<Constantes.COLUMNAS;j++) {
                textField[i][j] = new JTextField(1);
                textField[i][j].setFont(new Font("Times New Roman", Font.BOLD, 15));
                textField[i][j].setHorizontalAlignment(SwingConstants.CENTER);

                textField[i][j] .setText(i+""+j);
                this.add(textField[i][j]);
            }

            textField[1][0] .setText("2");
    }
    public void dividirResp (String resp) {
        respuesta = new String[resp.length()];
        for (i = 0; i < resp.length(); i++) {
            respuesta[i] = resp.substring(i, i+1);
            // textField[i][i].setText(respuesta[i]);
        }
        // imprimir();
    }
    public void imprimir () {
        for (i = 0; i < respuesta.length; i++) {
            System.out.println(respuesta[i]);
            // textFieYld[i][i].setText(respuesta[i]);
        }
    // textField[0][i].setText(respuesta[i]);
    }
    public void mostrar () {
        System.out.println(botones.getRespuesta());
        // textField[5][6].setText(botones.getRespuesta());
    }
}
