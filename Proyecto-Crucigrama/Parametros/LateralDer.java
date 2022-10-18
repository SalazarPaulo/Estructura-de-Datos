package Parametros;

import java.awt.Color;
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
import javax.xml.crypto.Data;
import javax.swing.*;

import Metodos.EscogerPreguntas;
import Cargadores.DataBase;

public class LateralDer extends JPanel implements ActionListener {

    // Panel principal
    private JPanel  oeste, este;
    // Lado Negro
    private EscogerPreguntas ep;
    private String palabra;
    private JTextField [] respuestas;
    private JButton[] enviar;
    public int i;
    private JPanel contentpane, jp, south;
    private JLabel time;
    // private EscogerPreguntas ep;
    // Lado Blanco
    private String[] respuesta;
    // public int i;
    private JTextField [][] textField;
    int z;
    // Metodos
    private DataBase datos;

    public LateralDer() {

        this.setBackground(Color.RED);
        this.setLayout(new BorderLayout(8, 6));
        this.setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.CYAN));

        este = new JPanel();
        este.setLayout(new GridLayout(Constantes.FILAS,Constantes.COLUMNAS));
        este.setBackground(Color.GREEN);
        este.setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.BLACK));
        este.setMinimumSize(new Dimension((int) (Constantes.WIDTH/2), 50));
        este.setPreferredSize(new Dimension((int) (Constantes.WIDTH/2), 50));

        oeste = new JPanel();
        oeste.setLayout(new BorderLayout(2, 6));
        oeste.setBackground(Color.DARK_GRAY);
        oeste.setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.BLACK));
        oeste.setMinimumSize(new Dimension((int) (Constantes.WIDTH/2), 50));
        oeste.setPreferredSize(new Dimension((int) (Constantes.WIDTH/2), 50));

        this.add(oeste, BorderLayout.WEST);
        this.add(este, BorderLayout.CENTER);

        // LLenando lado izquiedo, lado oeste
        enviar = new JButton[Constantes.FILAS];

        ep = new EscogerPreguntas(); // <-- Ya cargo las preguntas
        ep.setPreguntas();
        time = new JLabel("Time: 0");

        jp = new JPanel();
        jp.setLayout(new GridLayout(Constantes.FILAS,1, 3,0));
        jp.setBackground(Color.GRAY);
        contentpane = new JPanel();
        contentpane.add(new JLabel(""));
        contentpane.setBackground(Color.CYAN);
        south = new JPanel();
        south.setLayout(null);
        south.setBackground(Color.DARK_GRAY);

        contentpane.setMinimumSize(new Dimension((int) (Constantes.WIDTH/4), 38));
        contentpane.setPreferredSize(new Dimension((int) (Constantes.WIDTH/4), 38));
        jp.setMinimumSize(new Dimension((int) (Constantes.WIDTH/4), 348)); //543
        jp.setPreferredSize(new Dimension((int) (Constantes.WIDTH/4), 348));
        south.setMinimumSize(new Dimension((int) (Constantes.WIDTH/4), 30));
        south.setPreferredSize(new Dimension((int) (Constantes.WIDTH/4), 30));

        oeste.add(contentpane, BorderLayout.NORTH);
        oeste.add(jp, BorderLayout.CENTER);
        oeste.add(south, BorderLayout.SOUTH);

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
            jp.add(respuestas[i]);
            jp.add(new JButton("Cambiar Pregunta"));
            jp.add(enviar[i]);
        }

        south.add(new JLabel("Score: "));
        south.add(new JLabel(""));
        south.add(new JLabel("Time: "));
        south.add(new JLabel(""));

        // LLenando lado derecho, lado centro
        textField = new JTextField [Constantes.FILAS][Constantes.COLUMNAS];
        for (int i=0;i<Constantes.FILAS;i++)
            for (int j=0;j<Constantes.COLUMNAS;j++) {
                textField[i][j] = new JTextField(1);
                textField[i][j].setFont(new Font("Times New Roman", Font.BOLD, 15));
                textField[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                este.add(textField[i][j]);
            }
    }
    // Se encarga de dividir la palabra
    public void dividirResp () {

        respuesta = new String[Constantes.FILAS];
        // respuesta = new String[palabra.length()];
        try {
            for (i = 0; i < respuesta.length; i++) {
                respuesta[i] = palabra.substring(i, i+1);
                // System.out.println(respuesta[i]);
                textField[i][i].setText(respuesta[i]);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    // imprimir la palabra en el crucigrama
    // Ver donde colocar la palabra en el crucigrama
    // Ver si la palabra esta bien escrita

    // Comparar la palabra clave con la palabra que se tiene(escrita por el usuario)
    public void compararPalabras(int i) {

        ep = new EscogerPreguntas();

        String palabraClave = ep.getRespuestas(i);
        String palabraUsuario = respuestas[i].getText();

        if (palabraClave.equals(palabraUsuario)) {
            System.out.println("Son iguales");
        } else {
            System.out.println("No son iguales");
        }
    }

    @Override
    public synchronized void actionPerformed (ActionEvent e) {
        if (e.getSource() == enviar[0]) {
            palabra = respuestas[0].getText(); // <-- Esto setea la palabra
            textField[0][0].setText(respuestas[0].getText());
            // dividirResp();
            compararPalabras(0);
            notify();
            setVisible(true);
        } else if (e.getSource() == enviar[1]) {
            // respuestas[2].setText(respuestas[1].getText());
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
}