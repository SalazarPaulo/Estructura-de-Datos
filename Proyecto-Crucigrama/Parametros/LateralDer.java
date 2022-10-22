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
import javax.swing.border.Border;
import javax.xml.crypto.Data;
import javax.swing.*;

import Cargadores.*;

public class LateralDer extends JPanel implements ActionListener {


    public int i, z = 0;
    private String[] respuesta;
    private JPanel  oeste, este;
    private JPanel contentpane, jp, south;
    private JLabel time;
    private JButton[] enviar;
    private JTextField [] respuestas;
    private JTextField [][] textField;
    private int[] posicion;
    private Border border;
    private Color color;

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
        oeste.setMinimumSize(new Dimension((int) (Constantes.WIDTH/4), 50));
        oeste.setPreferredSize(new Dimension((int) (Constantes.WIDTH/4), 50));

        this.add(oeste, BorderLayout.WEST);
        this.add(este, BorderLayout.CENTER);

        // LLenando lado izquiedo, lado oeste
        enviar = new JButton[Constantes.FILAS];

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

        contentpane.setMinimumSize(new Dimension((int) (Constantes.WIDTH/4), 10));
        contentpane.setPreferredSize(new Dimension((int) (Constantes.WIDTH/4), 10));
        jp.setMinimumSize(new Dimension((int) (Constantes.WIDTH/5), 406)); //543
        jp.setPreferredSize(new Dimension((int) (Constantes.WIDTH/5), 406));
        south.setMinimumSize(new Dimension((int) (Constantes.WIDTH/4), 10));
        south.setPreferredSize(new Dimension((int) (Constantes.WIDTH/4), 10));

        oeste.add(contentpane, BorderLayout.NORTH);
        oeste.add(jp, BorderLayout.CENTER);
        oeste.add(south, BorderLayout.SOUTH);
        respuestas = new JTextField [Constantes.FILAS];

        for (i = 0; i < Constantes.FILAS; i++) {
            respuestas[i] = new JTextField(10);
            // Boton Enviar
            enviar[i] = new JButton("Validar");
            enviar[i].setHorizontalAlignment(SwingConstants.LEFT);
            enviar[i].setBounds(10, 10, 50, 50);
            enviar[i].setMinimumSize(new Dimension((int) (Constantes.WIDTH/5), 5));
            enviar[i].setPreferredSize(new java.awt.Dimension(10, 10));
            enviar[i].setFont(new Font("Times New Roman", Font.BOLD, 15));
            enviar[i].addActionListener(this);
            jp.add(respuestas[i]);
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

    // Ver donde colocar la palabra en el crucigrama
    public void colocarPalabra (String palabra) {
        color = new Color(240, 240, 240);
        border = BorderFactory.createLineBorder(Color.BLACK, 1);
        switch(palabra) {
            case "expectativa":
            for (i = 0; i < palabra.length(); i++) {
                textField[0][i].setText(palabra.substring(i, i+1));
                textField[0][i].setBorder(border);
                textField[0][i].setBackground(color);
            }
            break;
            case "fracaso":
            for (i = 0; i < palabra.length(); i++) {
                textField[i+13][0].setText(palabra.substring(i, i+1));
                textField[i+13][0].setBorder(border);
                textField[i+13][0].setBackground(color);
            }
            break;
            case "alcance":
            for (i = 0; i < palabra.length(); i++) {
                textField[15][i].setText(palabra.substring(i, i+1));
                textField[15][i].setBorder(border);
                textField[15][i].setBackground(color);
            }
            break;
            case "proceso":
            for (i = 0; i < palabra.length(); i++) {
                textField[i+4][1].setText(palabra.substring(i, i+1));
                textField[i+4][1].setBorder(border);
                textField[i+4][1].setBackground(color);
            }
            break;
            case "recursoshumanos":
            for (i = 0; i < palabra.length(); i++) {
                textField[8][0+i].setText(palabra.substring(i, i+1));
                textField[8][0+i].setBorder(border);
                textField[8][0+i].setBackground(color);
            }
            break;
            case "costosdirectos":
            for (i = 0; i < palabra.length(); i++) {
                textField[6][0+i].setText(palabra.substring(i, i+1));
                textField[6][0+i].setBorder(border);
                textField[6][0+i].setBackground(color);
            }
            break;
            case "buses":
            for (i = 0; i < palabra.length(); i++) {
                textField[2+i][5].setText(palabra.substring(i, i+1));
                textField[2+i][5].setBorder(border);
                textField[2+i][5].setBackground(color);
            }
            break;
            case "comun":
            for (i = 0; i < palabra.length(); i++){
                textField[3][2+i].setText(palabra.substring(i, i+1));
                textField[3][2+i].setBorder(border);
                textField[3][2+i].setBackground(color);
            }
            break;
            case "adquisiciones":
            for (i = 0; i < palabra.length(); i++){
                textField[17][0+i].setText(palabra.substring(i, i+1));
                textField[17][0+i].setBorder(border);
                textField[17][0+i].setBackground(color);
            }
            break;
            case "iso":
            for (i = 0; i < palabra.length(); i++) {
                textField[17+i][4].setText(palabra.substring(i, i+1));
                textField[17+i][4].setBorder(border);
                textField[17+i][4].setBackground(color);
            }
            break;
            case "integracion":
            for (i = 0; i < palabra.length(); i++) {
                textField[13][3+i].setText(palabra.substring(i, i+1));
                textField[13][3+i].setBorder(border);
                textField[13][3+i].setBackground(color);
            }
            break;
            case "costes":
            for (i = 0; i < palabra.length(); i++){
                textField[3][8+i].setText(palabra.substring(i, i+1));
                textField[3][8+i].setBorder(border);
                textField[3][8+i].setBackground(color);
            }
            break;
            case "analisis":
            for (i = 0; i < palabra.length(); i++) {
                textField[11][7+i].setText(palabra.substring(i, i+1));
                textField[11][7+i].setBorder(border);
                textField[11][7+i].setBackground(color);
            }
            break;
            case "actividades":
            for (i = 0; i < palabra.length(); i++) {
                textField[8+i][11].setText(palabra.substring(i, i+1));
                textField[8+i][11].setBorder(border);
                textField[8+i][11].setBackground(color);
            }
            break;
            case "materiales":
            for (i = 0; i < palabra.length(); i++) {
                textField[1][10+i].setText(palabra.substring(i, i+1));
                textField[1][10+i].setBorder(border);
                textField[1][10+i].setBackground(color);
            }
            break;
            case "tiempos":
            for (i = 0; i < palabra.length(); i++) {
                textField[1+i][12].setText(palabra.substring(i, i+1));
                textField[1+i][12].setBorder(border);
                textField[1+i][12].setBackground(color);
            }
            break;
            case "alquiler":
            for (i = 0; i < palabra.length(); i++) {
                textField[15][11+i].setText(palabra.substring(i, i+1));
                textField[15][11+i].setBorder(border);
                textField[15][11+i].setBackground(color);
            }
            break;
            case "canlidad":
            for (i = 0; i < palabra.length(); i++) {
                textField[12+i][15].setText(palabra.substring(i, i+1));
                textField[12+i][15].setBorder(border);
                textField[12+i][15].setBackground(color);
            }
            break;
            case "comunicaciones":
            for (i = 0; i < palabra.length(); i++) {
                textField[3+i][17].setText(palabra.substring(i, i+1));
                textField[3+i][17].setBorder(border);
                textField[3+i][17].setBackground(color);
            }
            break;
            case "redes":
            for (i = 0; i < palabra.length(); i++) {
                textField[15+i][18].setText(palabra.substring(i, i+1));
                textField[15+i][18].setBorder(border);
                textField[15+i][18].setBackground(color);
            }
            break;
        }
    }
    // Validacion final de todo el crucigrama

    @Override
    public synchronized void actionPerformed (ActionEvent e) {
        // String palabra;
        if (e.getSource() == enviar[0]) {
            // if (respuestas[0].getText().equals("Constantes.J_Respuesta01.getText()"))
                colocarPalabra(respuestas[0].getText());
            notify();
            setVisible(true);

        } else if (e.getSource() == enviar[1]) {
            // if (respuestas[1].getText().equals("Constantes.J_Respuesta02.getText()"))
            colocarPalabra(respuestas[1].getText());
            notify();
            setVisible(true);
        } else if (e.getSource() == enviar[2]) {
            // if (respuestas[2].getText().equals("Constantes.J_Respuesta03.getText()"))
            colocarPalabra(respuestas[2].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[3]) {
            // if (respuestas[3].getText().equals("Constantes.J_Respuesta04.getText()"))
            colocarPalabra(respuestas[3].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[4]) {
            // if (respuestas[4].getText().equals("Constantes.J_Respuesta05.getText()"))
            colocarPalabra(respuestas[4].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[5]) {
            // if (respuestas[5].getText().equals("Constantes.J_Respuesta06.getText()"))
            colocarPalabra(respuestas[5].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[6]) {
            // if (respuestas[6].getText().equals("Constantes.J_Respuesta07.getText()"))
            colocarPalabra(respuestas[6].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[7]) {
            // if (respuestas[7].getText().equals("Constantes.J_Respuesta08.getText()"))
            colocarPalabra(respuestas[7].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[8]) {
            // if (respuestas[8].getText().equals("Constantes.J_Respuesta09.getText()"))
            colocarPalabra(respuestas[8].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[9]) {
            // if (respuestas[9].getText().equals("Constantes.J_Respuesta10.getText()"))
            colocarPalabra(respuestas[9].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[10]) {
            // if (respuestas[10].getText().equals("Constantes.J_Respuesta11.getText()"))
            colocarPalabra(respuestas[10].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[11]) {
            // if (respuestas[11].getText().equals("Constantes.J_Respuesta12.getText()"))
            colocarPalabra(respuestas[11].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[12]) {
            // if (respuestas[12].getText().equals("Constantes.J_Respuesta13.getText()"))
            colocarPalabra(respuestas[12].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[13]) {
            // if (respuestas[13].getText().equals("Constantes.J_Respuesta14.getText()"))
            colocarPalabra(respuestas[13].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[14]) {
            // if (respuestas[14].getText().equals("Constantes.J_Respuesta15.getText()"))
            colocarPalabra(respuestas[14].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[15]) {
            // if (respuestas[15].getText().equals("Constantes.J_Respuesta16.getText()"))
            colocarPalabra(respuestas[15].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[16]) {
            // if (respuestas[16].getText().equals("Constantes.J_Respuesta17.getText()"))
            colocarPalabra(respuestas[16].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[17]) {
            // if (respuestas[17].getText().equals("Constantes.J_Respuesta18.getText()"))
            colocarPalabra(respuestas[17].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[18]) {
            // if (respuestas[18].getText().equals("Constantes.J_Respuesta19.getText()"))
            colocarPalabra(respuestas[18].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[19]) {
            // if (respuestas[19].getText().equals("Constantes.J_Respuesta20.getText()"))
            colocarPalabra(respuestas[19].getText());
            notify();
            setVisible(true);
        }
    }
}