package Parametros;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Metodos.*;

public class LateralIzq extends JPanel {

    public int i = 0;
    private EscogerPreguntas ep = new EscogerPreguntas();

    public LateralIzq() {

        // ep.setPreguntas();
        this.setLayout(new GridLayout(22, 1));

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
                    Constantes.J_Label10.setText(ep.getPreguntas(9));
                    Constantes.J_Label11.setText(ep.getPreguntas(10));
                    Constantes.J_Label12.setText(ep.getPreguntas(11));
                    Constantes.J_Label13.setText(ep.getPreguntas(12));
                    Constantes.J_Label14.setText(ep.getPreguntas(13));
                    Constantes.J_Label15.setText(ep.getPreguntas(14));
                    Constantes.J_Label16.setText(ep.getPreguntas(15));
                    Constantes.J_Label17.setText(ep.getPreguntas(16));
                    Constantes.J_Label18.setText(ep.getPreguntas(17));
                    Constantes.J_Label19.setText(ep.getPreguntas(18));
                    Constantes.J_Label20.setText(ep.getPreguntas(19));

                    // Constantes.J_Respuesta[i].setText(ep.getRespuestas(i));
                    Constantes.J_Respuesta01.setText(ep.getRespuestas(0));
                    Constantes.J_Respuesta02.setText(ep.getRespuestas(1));
                    Constantes.J_Respuesta03.setText(ep.getRespuestas(2));
                    Constantes.J_Respuesta04.setText(ep.getRespuestas(3));
                    Constantes.J_Respuesta05.setText(ep.getRespuestas(4));
                    Constantes.J_Respuesta06.setText(ep.getRespuestas(5));
                    Constantes.J_Respuesta07.setText(ep.getRespuestas(6));
                    Constantes.J_Respuesta08.setText(ep.getRespuestas(7));
                    Constantes.J_Respuesta09.setText(ep.getRespuestas(8));
                    Constantes.J_Respuesta10.setText(ep.getRespuestas(9));
                    Constantes.J_Respuesta11.setText(ep.getRespuestas(10));
                    Constantes.J_Respuesta12.setText(ep.getRespuestas(11));
                    Constantes.J_Respuesta13.setText(ep.getRespuestas(12));
                    Constantes.J_Respuesta14.setText(ep.getRespuestas(13));
                    Constantes.J_Respuesta15.setText(ep.getRespuestas(14));
                    Constantes.J_Respuesta16.setText(ep.getRespuestas(15));
                    Constantes.J_Respuesta17.setText(ep.getRespuestas(16));
                    Constantes.J_Respuesta18.setText(ep.getRespuestas(17));
                    Constantes.J_Respuesta19.setText(ep.getRespuestas(18));
                    Constantes.J_Respuesta20.setText(ep.getRespuestas(19));

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
        this.add(Constantes.J_Label11);
        this.add(Constantes.J_Label12);
        this.add(Constantes.J_Label13);
        this.add(Constantes.J_Label14);
        this.add(Constantes.J_Label15);
        this.add(Constantes.J_Label16);
        this.add(Constantes.J_Label17);
        this.add(Constantes.J_Label18);
        this.add(Constantes.J_Label19);
        this.add(Constantes.J_Label20);
        this.add(J_Button);
    }
}
