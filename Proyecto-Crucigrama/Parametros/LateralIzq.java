package Parametros;

import java.awt.Container;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Metodos.*;
import Parametros.*;

public class LateralIzq extends JPanel {

    public int i = 0;
    EscogerPreguntas ep = new EscogerPreguntas();

    public LateralIzq() {

        ep.setPreguntas();
        this.setLayout(new GridLayout(12, 1));

        JButton J_Button = new JButton("Change Label");
        J_Button.setBounds(50, 105, 173, 50);
        J_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ep.setPreguntas();
                for (i = 0; i < Constantes.FILAS; i++) {
                    System.out.println(ep.getPreguntas(i));
                    // J_Label.setText(ep.getPreguntas(i));
                    Constantes.J_Label01.setText(ep.getPreguntas(0));
                    Constantes.J_Label02.setText(ep.getPreguntas(1));
                    Constantes.J_Label03.setText(ep.getPreguntas(2));
                    Constantes.J_Label04.setText(ep.getPreguntas(3));
                    Constantes.J_Label05.setText(ep.getPreguntas(4));
                    Constantes.J_Label06.setText(ep.getPreguntas(5));
                    Constantes.J_Label07.setText(ep.getPreguntas(6));
                    Constantes.J_Label08.setText(ep.getPreguntas(7));
                    Constantes.J_Label09.setText(ep.getPreguntas(8));
                    Constantes.J_Label10.setText(ep.getPreguntas(9));
                }
            }
        });
        Constantes.J_Label01.setBorder(BorderFactory.createLineBorder(Color.blue));

        this.add(Constantes.J_Label);
        this.add(Constantes.J_Label01);
        this.add(Constantes.J_Label02);
        this.add(Constantes.J_Label03);
        this.add(Constantes.J_Label04);
        this.add(Constantes.J_Label05);
        this.add(Constantes.J_Label06);
        this.add(Constantes.J_Label07);
        this.add(Constantes.J_Label08);
        this.add(Constantes.J_Label09);
        this.add(Constantes.J_Label10);
        this.add(J_Button);
    }
}
