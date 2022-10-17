package Parametros;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.*;

import Metodos.*;
public class FondoNegro extends JPanel  implements ActionListener  {

    private String palabra;
    JTextField [] respuestas;
    JButton[] enviar, cambiarP;
    public int i;
    Botones botones;
    JPanel contentpane, jp, south;
    JLabel time;
    FondoBlanco fondoBlanco;

    public FondoNegro() {
        // Botones Enviar Respuestas
        enviar = new JButton[Constantes.FILAS];

        EscogerPreguntas ep = new EscogerPreguntas();
        ep.setPreguntas();
        time = new JLabel("Time: 0");

        this.setBackground(Color.gray);
        // ------------------ //
        jp = new JPanel();
        jp.setLayout(new GridLayout(Constantes.FILAS,1, 5,0));
        jp.setBackground(Color.GRAY);
        contentpane = new JPanel();
        contentpane.add(new JLabel(""));
        contentpane.setBackground(Color.CYAN);
        south = new JPanel();
        south.setLayout(null);
        south.setBackground(Color.DARK_GRAY);
        // jp.setSize(200, 200);
        // jp.setLocation(0,0);
        // content.removeAll();
        // jp.add(cambiar, BorderLayout.NORTH);
        // Content.revalidate();
        // content.repaint();
        // FlowLayout layout = new FlowLayout();
        // layout.setVgap(20);
        // layout.setHgap(100);

        // // this.setLayout(layout);
        
        // this.setLayout(new GridLayout(Constantes.FILAS+2,1));
        this.setLayout(new BorderLayout());
        contentpane.setMinimumSize(new Dimension((int) (Constantes.WIDTH/4), 50));
        contentpane.setPreferredSize(new Dimension((int) (Constantes.WIDTH/4), 50));
        jp.setMinimumSize(new Dimension((int) (Constantes.WIDTH/4), 300)); //543
        jp.setPreferredSize(new Dimension((int) (Constantes.WIDTH/4), 300));
        south.setMinimumSize(new Dimension((int) (Constantes.WIDTH/4), 50));
        south.setPreferredSize(new Dimension((int) (Constantes.WIDTH/4), 50));

        this.add(contentpane, BorderLayout.NORTH);
        this.add(jp, BorderLayout.CENTER);
        this.add(south, BorderLayout.SOUTH);

        respuestas = new JTextField [Constantes.FILAS];

        for (i = 0; i < Constantes.FILAS; i++) {

            respuestas[i] = new JTextField(10);
            // Boton Enviar
            enviar[i] = new JButton("Enviar Respuestas");
            enviar[i].setHorizontalAlignment(SwingConstants.LEFT);
            enviar[i].setBounds(10, 10, 50, 50);
            enviar[i].setPreferredSize(new java.awt.Dimension(10, 10));
            enviar[i].setFont(new Font("Times New Roman", Font.BOLD, 15));
            enviar[i].addActionListener(this);

            // this.add(new JLabel(ep.getPreguntas(i)));// colocar un contador y la pregunta
            jp.add(respuestas[i]);
            jp.add(new JButton("Cambiar Pregunta"));
            jp.add(enviar[i]);

        }
        south.add(new JLabel("Score: "));
        south.add(new JLabel(""));
        south.add(new JLabel("Time: "));
        south.add(new JLabel(""));

    }
    public String getRespuestas(int i) {
        return (respuestas[i].getText());
    }
    public void setRespuestas(int i, int j) {
        this.respuestas[j].setText(respuestas[i].getText());
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
    @Override
    public synchronized void actionPerformed (ActionEvent e) {
        // botones = new Botones(respuestas[i].getText());
        // fondoBlanco = new FondoBlanco(botones);
        if (e.getSource() == enviar[0]) {
            // respuestas[1].setText(respuestas[0].getText());
            botones.hacerAccionB(0, respuestas[0].getText());
            // System.out.println("boton" + resp);
            //     fn.setRespuestas(i, i+1);
            //     fb.dividirResp(resp)
            notify();
            setVisible(true);
        } else if (e.getSource() == enviar[1]) {
            // respuestas[2].setText(respuestas[1].getText());
            botones.hacerAccionB(1, respuestas[1].getText());
            notify();
            setVisible(true);
        } else if (e.getSource() == enviar[2]) {
            // botones.hacerAccionB(2);
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[3]) {
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[4]) {
            notify();
            setVisible(true);
        }
    }
    // implements KeyListener
    // @Override
    public void respuestasKeyReleased(KeyEvent e) {
        System.out.println("Funciono");
        respuestas[1].setText("hola");
    }
    // @Override
    // public void keyTyped(KeyEvent e) {
    //     // TODO Auto-generated method stub
        
    // }
    // @Override
    // public void keyPressed(KeyEvent e) {
    //     // TODO Auto-generated method stub
        
    // }
    // @Override
    // public void keyReleased(KeyEvent e) {
    //     respuestas[1].setText(respuestas[0].getText());
    // }
}