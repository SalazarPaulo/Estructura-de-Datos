package Parametros;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


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

import Metodos.*;

public class FondoBlanco extends JPanel {

    // private Botones botones;
    // String[] respuesta;
    // public int i;
    // JTextField [][] textField;
    // JPanel jp;

    private String palabra;
    JTextField [][] respuestas;
    JButton[] enviar, cambiarP;
    public int i;
    Botones botones;
    JPanel contentpane, jp, south;
    JLabel time;
    FondoBlanco fondoBlanco;

    public FondoBlanco(Botones b) {
        this.botones = b;
        // mostrar();
    }

    public void mostrar() {
        respuestas[0][0].setText("prueba");
    }
    public FondoBlanco() {

        this.setBackground(Color.gray);
        // ------------------ //
        jp = new JPanel();
        jp.setLayout(new GridLayout(Constantes.FILAS,Constantes.COLUMNAS, 5,0));
        jp.setBackground(Color.GRAY);
        // contentpane = new JPanel();
        // contentpane.add(new JLabel(""));
        // contentpane.setBackground(Color.CYAN);
        // south = new JPanel();
        // south.setLayout(null);
        // south.setBackground(Color.DARK_GRAY);
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
        // this.setLayout(new BorderLayout());
        // contentpane.setMinimumSize(new Dimension((int) (Constantes.WIDTH/4), 50));
        // contentpane.setPreferredSize(new Dimension((int) (Constantes.WIDTH/4), 50));
        jp.setMinimumSize(new Dimension((int) (Constantes.WIDTH/4), 300)); //543
        jp.setPreferredSize(new Dimension((int) (Constantes.WIDTH/4), 300));
        // south.setMinimumSize(new Dimension((int) (Constantes.WIDTH/4), 50));
        // south.setPreferredSize(new Dimension((int) (Constantes.WIDTH/4), 50));

        // this.add(contentpane, BorderLayout.NORTH);
        this.add(jp, BorderLayout.CENTER);
        // this.add(south, BorderLayout.SOUTH);
        respuestas = new JTextField [Constantes.FILAS][10];
        for (int j = 0; j < Constantes.FILAS; j++)

        for (i = 0; i < Constantes.FILAS; i++) {

            respuestas[i][j] = new JTextField(10);
            // Boton Enviar
            // enviar[i] = new JButton("Enviar Respuestas");
            // enviar[i].setHorizontalAlignment(SwingConstants.LEFT);
            // enviar[i].setBounds(10, 10, 50, 50);
            // enviar[i].setPreferredSize(new java.awt.Dimension(10, 10));
            // enviar[i].setFont(new Font("Times New Roman", Font.BOLD, 15));
            // enviar[i].addActionListener(this);

            // this.add(new JLabel(ep.getPreguntas(i)));// colocar un contador y la pregunta
            jp.add(respuestas[i][j]);
            // jp.add(new JButton("Cambiar Pregunta"));
            // jp.add(enviar[i]);

        }
        // south.add(new JLabel("Score: "));
        // south.add(new JLabel(""));
        // south.add(new JLabel("Time: "));
        // south.add(new JLabel(""));

    }
}

    //     public FondoBlanco() {
    //     textField = new JTextField [Constantes.FILAS][Constantes.COLUMNAS];
    //     this.setBackground(Color.RED);
    //     this.setLayout(new GridLayout(Constantes.FILAS,Constantes.COLUMNAS));
    //      // JLabel[][] label = new JLabel[filas][columnas];
    //     for (int i=0;i<Constantes.FILAS;i++)
    //         for (int j=0;j<Constantes.COLUMNAS;j++) {
    //             textField[i][j] = new JTextField(1);
    //             textField[i][j].setFont(new Font("Times New Roman", Font.BOLD, 15));
    //             textField[i][j].setHorizontalAlignment(SwingConstants.CENTER);

    //             // textField[i][j] .setText(i+""+j);
    //             this.add(textField[i][j]);
    //         }
    //         textField[1][0] .setText("2");
    // }
    
    
//     public void dividirResp () {

//         botones = new Botones();
//         // respuesta = new String[Constantes.FILAS];

//         String respuestas = botones.getRespuesta();
//         respuesta = new String[botones.getRespuesta().length()];
//         for (i = 0; i < botones.getRespuesta().length(); i++) {
//             respuesta[i] = botones.getRespuesta().substring(i, i+1);
//             // textField[i][i].setText(respuesta[i]);
//         }
//         // imprimir();
//     }
//     public void imprimir () {
//         for (i = 0; i < respuesta.length; i++) {
//             System.out.println(respuesta[i]);
//             // textFieYld[i][i].setText(respuesta[i]);
//         }
//     // textField[0][i].setText(respuesta[i]);
//     }
//     public void mostrar () {


//         textField = new JTextField [Constantes.FILAS][Constantes.COLUMNAS];
//         this.setBackground(Color.RED);
//         this.setLayout(new GridLayout(Constantes.FILAS,Constantes.COLUMNAS));
//          // JLabel[][] label = new JLabel[filas][columnas];
//         for (int i=0;i<Constantes.FILAS;i++)
//             for (int j=0;j<Constantes.COLUMNAS;j++) {
//                 textField[i][j] = new JTextField(1);
//                 textField[i][j].setFont(new Font("Times New Roman", Font.BOLD, 15));
//                 textField[i][j].setHorizontalAlignment(SwingConstants.CENTER);

//                 // textField[i][j] .setText(i+""+j);
//                 this.add(textField[i][j]);
//             }
//             textField[1][0] .setText("XXX");

//         if (botones.getRespuesta() != null) {
//             String respuestas = botones.getRespuesta();
//             String[] palabraDiv = new String[respuestas.length()];
//             for(i = 0; i < respuestas.length(); i++) {
//                 palabraDiv[i] = respuestas.substring(i, i+1);
//                 // System.out.println(respuestas + "mostrar" + palabraDiv[i]);
//             }
//             for(i = 0; i < respuestas.length(); i++) {
//                 // palabraDiv[i] = respuestas.substring(i, i+1);
//                 System.out.println(palabraDiv[i]);
//             }
//             textField[0][0].setText("XXX"); // <---- Es el error
//         }
//     }
// }
