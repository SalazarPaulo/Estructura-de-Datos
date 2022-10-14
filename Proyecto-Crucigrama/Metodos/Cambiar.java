package Metodos;

import java.awt.event.*;
import javax.swing.*;

import Parametros.*;
public class Cambiar implements ActionListener {

    Cambiar(JButton cambiar) {
        cambiar.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Hola");
    }
}
