package Parametros;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Metodos.*;
public class FondoNegro extends JPanel implements ActionListener {

    private String palabra;
    private byte val;
    JTextField [] respuestas;
    JButton reiniciar, guardar, cambiar, validar;
    JButton[] enviar, cambiarP;
    public int i;
    Botones botones = new Botones();

    public FondoNegro() {

        // Boton Cambiar Crucigrama
        cambiar = new JButton("Cambiar Crucigrama");
        cambiar.setHorizontalAlignment(SwingConstants.LEFT);
        cambiar.setBounds(50, 105, 173, 50);
        cambiar.setPreferredSize(new java.awt.Dimension(10, 10));
        cambiar.setFont(new Font("Times New Roman", Font.BOLD, 15));
        cambiar.addActionListener(this);

        // Boton validar Crucigrama
        validar = new JButton("Validar Crucigrama");
        validar.setHorizontalAlignment(SwingConstants.LEFT);
        validar.setBounds(50, 105, 173, 50);
        validar.setPreferredSize(new java.awt.Dimension(10, 10));
        validar.setFont(new Font("Times New Roman", Font.BOLD, 15));
        validar.addActionListener(this);

        // Boton reiniciar Crucigrama
        reiniciar = new JButton("Reiniciar Crucigrama");
        reiniciar.setHorizontalAlignment(SwingConstants.LEFT);
        reiniciar.setBounds(50, 105, 173, 50);
        reiniciar.setPreferredSize(new java.awt.Dimension(10, 10));
        reiniciar.setFont(new Font("Times New Roman", Font.BOLD, 15));
        reiniciar.addActionListener(this);

        // Boton guardar Crucigrama
        guardar = new JButton("Validar Crucigrama");
        guardar.setHorizontalAlignment(SwingConstants.LEFT);
        guardar.setBounds(50, 105, 173, 50);
        guardar.setPreferredSize(new java.awt.Dimension(10, 10));
        guardar.setFont(new Font("Times New Roman", Font.BOLD, 15));
        guardar.addActionListener(this);

        // Botones Enviar Respuestas
        enviar = new JButton[Constantes.FILAS];

        EscogerPreguntas ep = new EscogerPreguntas();
        ep.setPreguntas();

        this.setBackground(Color.gray);

        FlowLayout layout = new FlowLayout();
        layout.setVgap(20);
        layout.setHgap(100);

        this.setLayout(layout);
        this.setLayout(new GridLayout(Constantes.FILAS+2,1));
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

            this.add(new JLabel(ep.getPreguntas(i)));// colocar un contador y la pregunta
            this.add(respuestas[i]);

            this.add(new JButton("Cambiar Pregunta"));
            this.add(enviar[i]);
        }

        this.add(new JLabel("Score: "));
        this.add(new JLabel(""));
        this.add(new JLabel("Time: "));
        this.add(new JLabel(""));

        this.add(cambiar);
        this.add(validar);
        this.add(new JButton("Reiniciar"));
        this.add(new JButton("Guardar"));

    }
    public String getRespuestas(int i) {
        return (respuestas[i].getText());
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
        if (e.getSource() == cambiar) {
            botones.cambiar();
            notify();
            setVisible(true);

        } else if (e.getSource() == validar) {
            System.out.println("Boton validar Crucigrama " + getRespuestas(0));
            notify();
            setVisible(true);
        }  else if (e.getSource() == reiniciar) {
            val = 3;
            notify();
            setVisible(true);
        }  else if (e.getSource() == guardar) {
            val = 4;
            notify();
            setVisible(true);
        }
    }
    // public byte getVal () {
    //     return val;
    // }
}