package Parametros;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class FondoBlanco extends JPanel {

    public FondoBlanco() {

        this.setBackground(Color.white);
        this.setLayout(new GridLayout(Constantes.FILAS,Constantes.COLUMNAS));
        JTextField [][] textField = new JTextField [Constantes.FILAS][Constantes.COLUMNAS];
        for (int i=0;i<Constantes.FILAS;i++)
            for (int j=0;j<Constantes.COLUMNAS;j++) {
                textField[i][j] = new JTextField(1);
                this.add(textField[i][j]);
            }
    }
}
