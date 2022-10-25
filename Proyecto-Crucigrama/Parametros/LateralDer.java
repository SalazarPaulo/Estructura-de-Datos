package Parametros;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

import java.util.HashMap;

import Metodos.BordeRedondeado;
import Metodos.EscogerPreguntas;

public class LateralDer extends JPanel implements ActionListener {

    public int j, i, z = 0, cruci, count = 1;
    private JPanel  oeste, este;
    private JPanel contentpane, jp, south;
    private JButton[] enviar;
    private JButton borrar, cargar, validar;
    private JTextField [] respuestas;
    private JTextField [][] textField;
    private Border border;
    private Color color;
    private EscogerPreguntas ep;
    private HashMap<String, String> posiciones;
    private String[] palabras = {
        Constantes.J_Respuesta01.getText(),
        Constantes.J_Respuesta02.getText(),
        Constantes.J_Respuesta03.getText(),
        Constantes.J_Respuesta04.getText(),
        Constantes.J_Respuesta05.getText(),
        Constantes.J_Respuesta06.getText(),
        Constantes.J_Respuesta07.getText(),
        Constantes.J_Respuesta08.getText(),
        Constantes.J_Respuesta09.getText(),
        Constantes.J_Respuesta10.getText(),
        Constantes.J_Respuesta11.getText(),
        Constantes.J_Respuesta12.getText(),
        Constantes.J_Respuesta13.getText(),
        Constantes.J_Respuesta14.getText(),
        Constantes.J_Respuesta15.getText(),
        Constantes.J_Respuesta16.getText(),
        Constantes.J_Respuesta17.getText(),
        Constantes.J_Respuesta18.getText(),
        Constantes.J_Respuesta19.getText(),
        Constantes.J_Respuesta20.getText()
    };
    private Color color1;

    public LateralDer(int cruci) {

        color1 = new Color(247, 191, 190);

        this.setBackground(color1);
        this.setLayout(new BorderLayout(8, 6));
        this.setBorder(BorderFactory.createMatteBorder(4,4,4,4, color1));

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
        oeste.setMinimumSize(new Dimension((int) (Constantes.WIDTH/3), 50));
        oeste.setPreferredSize(new Dimension((int) (Constantes.WIDTH/3), 50));

        this.add(oeste, BorderLayout.WEST);
        this.add(este, BorderLayout.CENTER);

        // LLenando lado izquiedo, lado oeste
        borrar = new JButton("Limpiar");
        borrar.setFont(new Font("Times New Roman", Font.BOLD, 15));
        borrar.setBorder(new BordeRedondeado(6));
        borrar.addActionListener(this);

        validar = new JButton("Validar");
        validar.setFont(new Font("Times New Roman", Font.BOLD, 15));
        validar.setBorder(new BordeRedondeado(6));
        validar.addActionListener(this);

        cargar = new JButton("Cargar");
        cargar.setFont(new Font("Times New Roman", Font.BOLD, 15));
        cargar.setBorder(new BordeRedondeado(6));
        cargar.addActionListener(this);

        enviar = new JButton[20];

        jp = new JPanel();
        jp.setLayout(new GridLayout(20,1, 3,0));
        jp.setBackground(Color.GRAY);
        contentpane = new JPanel();
        contentpane.add(new JLabel(""));
        contentpane.setBackground(Color.CYAN);
        south = new JPanel();
        south.setLayout(new GridLayout(1,3, 3,0));
        south.setBackground(Color.DARK_GRAY);

        contentpane.setMinimumSize(new Dimension((int) (Constantes.WIDTH/4), 10));
        contentpane.setPreferredSize(new Dimension((int) (Constantes.WIDTH/4), 10));
        jp.setMinimumSize(new Dimension((int) (Constantes.WIDTH/5), 406)); //543
        jp.setPreferredSize(new Dimension((int) (Constantes.WIDTH/5), 406));
        south.setMinimumSize(new Dimension((int) (Constantes.WIDTH/4), 20));
        south.setPreferredSize(new Dimension((int) (Constantes.WIDTH/4), 20));
        south.add(borrar);
        south.add(cargar);
        south.add(validar);

        oeste.add(contentpane, BorderLayout.NORTH);
        oeste.add(jp, BorderLayout.CENTER);
        oeste.add(south, BorderLayout.SOUTH);
        respuestas = new JTextField [Constantes.FILAS];

        for (i = 0; i < 20; i++) {
            respuestas[i] = new JTextField(10);
            // Boton Enviar
            enviar[i] = new JButton("Validar");
            enviar[i].setHorizontalAlignment(SwingConstants.CENTER);
            enviar[i].setBounds(10, 10, 50, 50);
            enviar[i].setMinimumSize(new Dimension((int) (Constantes.WIDTH/5), 5));
            enviar[i].setPreferredSize(new java.awt.Dimension(10, 10));
            enviar[i].setFont(new Font("Times New Roman", Font.BOLD, 15));
            enviar[i].setBorder(new BordeRedondeado(6));
            enviar[i].addActionListener(this);
            jp.add(respuestas[i]);
            jp.add(enviar[i]);
        }

        // LLenando lado derecho, lado centro
        textField = new JTextField [Constantes.FILAS][Constantes.COLUMNAS];
        for (int i=0;i<Constantes.FILAS;i++)
            for (int j=0;j<Constantes.COLUMNAS;j++) {
                textField[i][j] = new JTextField(1);
                textField[i][j].setFont(new Font("Times New Roman", Font.BOLD, 15));
                textField[i][j].setHorizontalAlignment(SwingConstants.LEFT);
                textField[i][j].setBackground(new Color(192, 255, 247));
                textField[i][j].setEditable(false);
                textField[i][j].setBorder(BorderFactory.createLineBorder(new Color(106, 194, 217), 1));
                este.add(textField[i][j]);
            }
        this.cruci = cruci;
        cargar(cruci);
    }

    // Ver donde colocar la palabra en el crucigrama
    public void colocarPalabra (int ref, String palabra) {
        int coordX, coordY, posicion, numCruci;
        posiciones = new HashMap<String, String>() {
            {   // MODULO 1 CRUCIGRAMA 1 // 0-19
                put("PROCESO", "15 01 02 0"); // LISTO
                put("ACTIVIDADES", "06 0    6 01 0"); // LISTO
                put("ALQUILER", "02 04 02 0"); // ¿?
                put("REDES","00 11 02 0"); // LSITO
                put("COSTOSDIRECTOS","04 16 02 0"); // LISTO
                put("ISO","15 05 02 0"); // LISTO
                put("ANALISIS", "03 01 01 0"); // LISTO
                put("FRACASO","16 00 01 0"); // LISTO
                put("MATERIALES", "12 14 02 0"); // LISTO
                put("ADQUISICIONES","08 18 02 0"); // LISTO
                put("INTEGRACION","11 09 02 0"); // LISTO
                put("ALCANCE","21 05 01 0"); // LISTO
                put("COMUNICACIONES","11 00 01 0"); // LISTO
                put("RECURSOSHUMANOS","09 00 01 0"); // LISTO
                put("TIEMPO","19 16 01 0"); //LISTO
                put("COSTES","02 19 02 0"); // LISTO
                put("BUSES","01 08 01 0"); // LISTO
                put("COMUN","05 01 01 0"); // LISTO
                put("EXPECTATIVA","19 01 01 0"); // 
                put("SERVICIOS","04 11 01 0"); //< ----
                // MODULO 1 CRUCIGRAMA 2 // 20-39
                put("PROYECTO","10 15 01 1"); // LISTO
                put("TEMPORAL", "02 10 02 1"); // LISTO
                put("HARDWARE","06 13 01 1"); // LISTO
                put("PROYECTOFALLIDO", "12 07 01 1"); // LISTO
                put("INTERFACES","00 02 01 1"); // LISTO
                put("AUDITORIAS", "08 13 02 1"); // LISTO
                put("ESTANDAR","14 07 02 1"); // LISTO
                put("INVERTIR", "19 11 01 1"); // LISTO
                put("ADMINISTRADOR","00 08 02 1"); // LISTO
                put("CONSULTORIA", "07 02 01 1"); // LISTO
                put("INDIRECTOS","21 03 01 1"); // LISTO
                put("NECESIDADES", "05 02 02 1"); // LISTO
                put("CONFLICTOS","15 09 02 1"); //LISTO
                put("PRESUPUESTO", "04 05 02 1"); // LISTO
                put("TECNOLOGICO","11 11 02 1"); // ¿?
                put("FECHA", "02 14 02 1"); //
                put("LOGICA","17 02 01 1");
                put("RECURSOS", "15 15 02 1");
                put("LOGISTICA","24 05 01 1");
                put("INDUSTRIA", "04 16 02 1");
                // MODULO 2 CRUCIGRAMA 1 // 40- 59
                put("ISHIKAWA", "06 11 01 2");
                put("FIN", "15 03 01 2");
                put("SUPUESTOS", "20 00 01 2");
                put("ECONOMICO", "00 11 02 2");
                put("CANTIDAD", "02 14 01 2");//¿? <---
                put("TIEMPOVSDISPONIBILIDAD", "11 00 01 2");
                put("BRAINSTORMING", "05 00 02 2");
                put("ACTITUDES", "00 04 01 2");
                put("TRES", "13 11 01 2");
                put("BENEFICIOS", "05 00 01 2");
                put("CANTIDAD", "02 14 02 2");
                put("INTERESES", "10 13 02 2");
                put("GOBIERNO", "02 04 01 2");
                put("INTERES", "17 04 01 2");
                put("COMPONENTES", "10 05 02 2");
                put("ALQUILER", "10 17 02 2");
                put("RAIZ", "01 16 02 2");
                put("PORQUE", "00 01 02 2");
                put("INVESTIGACION", "08 00 01 2");
                put("FINANCIERO", "10 09 02 2");

                // MODULO 2 CRUCIGRAMA 2 // 60- 79
                put("SIETE", "10 02 02 3");
                put("INVOLUCRADOS", "01 18 02 3" );
                put("OBJETIVOS", "08 09 02 3"); // Casillas de arr-aba, der-izq, x-y,cruc
                put("LEGAL", "18 01 01 3");
                put("SOCIAL", "00 07 02 3");
                put("CLIENTE", "19 09 01 3");
                put("RESUMEN", "10 13 02 3");
                put("AIRBNB", "06 01 01 3");
                put("CAUSASYEFECTOS", "04 03 01 3");
                put("ARBOLDEPROBLEMA", "04 04 02 3");
                put("MATRIX", "05 01 02 3");
                put("PESTEL", "00 05 01 3");
                put("PODER", "15 02 02 3");
                put("SEGUNDA", "02 14 01 3");
                put("PROBLEMA EFECTOS", "11 04 01 3");
                put("PROBLEMA CAUSA", "08 07 02 3");
                put("POLITICO", "14 11 02 3");
                put("ECOLOGICO", "07 11 01 3");
                put("STAKEHOLDERS", "21 05 01 3");
                put("UBER", "12 01 01 3");
            }
        };

        coordX = Integer.parseInt(posiciones.get(palabra).substring(0,2));
        coordY = Integer.parseInt(posiciones.get(palabra).substring(3,5));
        posicion = Integer.parseInt(posiciones.get(palabra).substring(6,8));
        numCruci = (int) (posiciones.get(palabra).charAt(9));

        color = new Color(240, 240, 240);
        border = BorderFactory.createLineBorder(Color.BLACK, 1);
        if (posicion == 01 && ref == 0)
            for (i = 0; i < palabra.length(); i++) {
                textField[coordX][coordY+i].setText(palabra.substring(i, i+1));
                textField[coordX][coordY+i].setBorder(border);
                textField[coordX][coordY+i].setBackground(color);
            }
        else if (posicion == 02 && ref == 0)
            for (i = 0; i < palabra.length(); i++) {
                textField[coordX+i][coordY].setText(palabra.substring(i, i+1));
                textField[coordX+i][coordY].setBorder(border);
                textField[coordX+i][coordY].setBackground(color);
            }
        else if (posicion == 01 && ref == 1)
            for (i = 0; i < palabra.length(); i++) {
                if(i == 0)
                    textField[coordX][coordY+i].setText(String.valueOf(count));
                textField[coordX][coordY+i].setBorder(border);
            }
        else if (posicion == 02 && ref == 1)
            for (i = 0; i < palabra.length(); i++) {
                if(i == 0)
                    textField[coordX+i][coordY].setText(String.valueOf(count));
                textField[coordX+i][coordY].setBorder(border);
            }
        count++;
        count = (count == 21) ? 1 : count;
    }
    public void borrar () {

        color = new Color(240, 240, 240);

        for (int i = 0; i < Constantes.FILAS; i++) {
            for (int j = 0; j < Constantes.COLUMNAS; j++) {
                textField[i][j].setText("");
                textField[i][j].setBorder(BorderFactory.createLineBorder(new Color(106, 194, 217), 1));
                textField[i][j].setBackground(new Color(192, 255, 247));
            }
        }
        for (int i = 0; i < 20; i++) {
            respuestas[i].setText("");
            respuestas[i].setBackground(Color.WHITE);
        }
    }
    public void validar () {
        for (i = 0; i < 20; i++) {
            if (respuestas[i].getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Faltan respuestas por completar");
                break;
            }
            else {
                if (respuestas[i].getText().equals(palabras[i])) {
                    respuestas[i].setBackground(new Color(0, 255, 0));
                }
                else {
                    respuestas[i].setBackground(new Color(255, 0, 0));
                }
            }
        }
    }
    public void cargar(int cruci) {
        borrar();
        colocarPalabra(0,Constantes.J_Respuesta01.getText());
        colocarPalabra(0,Constantes.J_Respuesta02.getText());
        colocarPalabra(0,Constantes.J_Respuesta03.getText());
        colocarPalabra(0,Constantes.J_Respuesta04.getText());
        colocarPalabra(0,Constantes.J_Respuesta05.getText());
        colocarPalabra(0,Constantes.J_Respuesta06.getText());
        colocarPalabra(0,Constantes.J_Respuesta07.getText());
        colocarPalabra(0,Constantes.J_Respuesta08.getText());
        colocarPalabra(0,Constantes.J_Respuesta09.getText());
        colocarPalabra(0,Constantes.J_Respuesta10.getText());
        colocarPalabra(0,Constantes.J_Respuesta11.getText());
        colocarPalabra(0,Constantes.J_Respuesta12.getText());
        colocarPalabra(0,Constantes.J_Respuesta13.getText());
        colocarPalabra(0,Constantes.J_Respuesta14.getText());
        colocarPalabra(0,Constantes.J_Respuesta15.getText());
        colocarPalabra(0,Constantes.J_Respuesta16.getText());
        colocarPalabra(0,Constantes.J_Respuesta17.getText());
        colocarPalabra(0,Constantes.J_Respuesta18.getText());
        colocarPalabra(0,Constantes.J_Respuesta19.getText());
        colocarPalabra(0,Constantes.J_Respuesta20.getText());
    }

    @Override
    public synchronized void actionPerformed (ActionEvent e) {
        ep = new EscogerPreguntas();
        if (e.getSource() == enviar[0]) {
            // if (respuestas[0].getText().equals("Constantes.J_Respuesta01.getText()"))
                colocarPalabra(0, respuestas[0].getText().toUpperCase());
            notify();
            setVisible(true);
        } else if (e.getSource() == enviar[1]) {
            // if (respuestas[1].getText().equals("Constantes.J_Respuesta02.getText()"))
                colocarPalabra(0, respuestas[1].getText().toUpperCase());
            notify();
            setVisible(true);
        } else if (e.getSource() == enviar[2]) {
            // if (respuestas[2].getText().equals("Constantes.J_Respuesta03.getText()"))
                colocarPalabra(0, respuestas[2].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[3]) {
            // if (respuestas[3].getText().equals("Constantes.J_Respuesta04.getText()"))
                colocarPalabra(0, respuestas[3].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[4]) {
            // if (respuestas[4].getText().equals("Constantes.J_Respuesta05.getText()"))
                colocarPalabra(0, respuestas[4].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[5]) {
            // if (respuestas[5].getText().equals("Constantes.J_Respuesta06.getText()"))
                colocarPalabra(0, respuestas[5].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[6]) {
            // if (respuestas[6].getText().equals("Constantes.J_Respuesta07.getText()"))
                colocarPalabra(0, respuestas[6].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[7]) {
            // if (respuestas[7].getText().equals("Constantes.J_Respuesta08.getText()"))
                colocarPalabra(0, respuestas[7].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[8]) {
            // if (respuestas[8].getText().equals("Constantes.J_Respuesta09.getText()"))
                colocarPalabra(0, respuestas[8].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[9]) {
            // if (respuestas[9].getText().equals("Constantes.J_Respuesta10.getText()"))
                colocarPalabra(0, respuestas[9].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[10]) {
            // if (respuestas[10].getText().equals("Constantes.J_Respuesta11.getText()"))
                colocarPalabra(0, respuestas[10].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[11]) {
            // if (respuestas[11].getText().equals("Constantes.J_Respuesta12.getText()"))
                colocarPalabra(0, respuestas[11].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[12]) {
            // if (respuestas[12].getText().equals("Constantes.J_Respuesta13.getText()"))
                colocarPalabra(0, respuestas[12].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[13]) {
            // if (respuestas[13].getText().equals("Constantes.J_Respuesta14.getText()"))
                colocarPalabra(0, respuestas[13].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[14]) {
            // if (respuestas[14].getText().equals("Constantes.J_Respuesta15.getText()"))
                colocarPalabra(0, respuestas[14].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[15]) {
            // if (respuestas[15].getText().equals("Constantes.J_Respuesta16.getText()"))
                colocarPalabra(0, respuestas[15].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[16]) {
            // if (respuestas[16].getText().equals("Constantes.J_Respuesta17.getText()"))
                colocarPalabra(0, respuestas[16].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[17]) {
            // if (respuestas[17].getText().equals("Constantes.J_Respuesta18.getText()"))
                colocarPalabra(0, respuestas[17].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[18]) {
            // if (respuestas[18].getText().equals("Constantes.J_Respuesta19.getText()"))
                colocarPalabra(0, respuestas[18].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[19]) {
            // if (respuestas[19].getText().equals("Constantes.J_Respuesta20.getText()"))
                colocarPalabra(0, respuestas[19].getText().toUpperCase());
            notify();
            setVisible(true);
        } else if (e.getSource() == borrar) {
            borrar();
            notify();
            setVisible(true);
        } else if (e.getSource() == validar) {
            validar();
            notify();
            setVisible(true);
        } else if (e.getSource() == cargar) {
            cargar(cruci);
            notify();
            setVisible(true);
        }
    }
}