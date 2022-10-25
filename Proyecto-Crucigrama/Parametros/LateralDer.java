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

    public int j, i, z = 0;
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
                textField[i][j].setBorder(BorderFactory.createLineBorder(new Color(48, 48, 48), 1));
                este.add(textField[i][j]);
            }
    }

    // Ver donde colocar la palabra en el crucigrama
    public void colocarPalabra (int ref, String palabra) {
        int coordX, coordY, posicion, numCruci;
        posiciones = new HashMap<String, String>() {
            {   // MODULO 1 CRUCIGRAMA 1 // 0-19
                put("PROCESO", "");
                put("ACTIVIDADES", "");
                put("ALQUILER", "");
                put("REDES","");
                put("COSTOSDIRECTOS","");
                put("ISO","");
                put("ANALISIS", "");
                put("FRACASO","");
                put("MATERIALES", "");
                put("ADQUISICIONES","");
                put("INTEGRACION","");
                put("ALCANCE","");
                put("COMUNICACIONES","");
                put("RECURSOSHUMANOS","");
                put("TIEMPO","");
                put("COSTES","");
                put("BUSES","");
                put("COMUN","");
                put("EXPECTATIVA","");
                put("SERVICIOS",""); //< ----
                // MODULO 1 CRUCIGRAMA 2 // 20-39
                put("PROYECTO","");
                put("TEMPORAL", "");
                put("HARDWARE","");
                put("PROYECTOFALLIDO", "");
                put("INTERFACES","");
                put("AUDITORIAS", "");
                put("ESTANDAR","");
                put("INVERTIR", "");
                put("ADMINISTRADOR","");
                put("CONSULTORIA", "");
                put("INDIRECTOS","");
                put("NECESIDADES", "");
                put("CONFLICTOS","");
                put("PRESUPUESTO", "");
                put("TECNOLOGICO","");
                put("FECHA", "");
                put("LOGICA","");
                put("RECURSOS", "");
                put("LOGISTICA","");
                put("INDUSTRIA", "");
                // MODULO 2 CRUCIGRAMA 1 // 40- 59
                put("ISHIKAWA", "06 11 01 2");
                put("FIN", "15 03 01 2");
                put("SUPUESTOS", "20 00 01 2");
                put("ECONOMICO", "00 11 02 2");
                put("CANTIDAD", "");//¿?
                put("TIEMPOVSDISPONIBILIDAD", "11 00 01 2");
                put("BRAINSTORMING", "05 00 02 2");
                put("ACTITUDES", "00 04 01 2");
                put("TRES", "13 11 01 2");
                put("BENEFICIOS", "05 00 01 2");
                put("CANTIDAD", "");
                put("INTERESES", "");
                put("GOBIERNO", "");
                put("INTERES", "");
                put("COMPONENTES", "");
                put("ALQUILER", "");
                put("RAIZ", "");
                put("PORQUE", "00 01 02 2");
                put("INVESTIGACION", "");
                put("FINANCIERO", "");

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
;            }
        };

        coordX = Integer.parseInt(posiciones.get(palabra).substring(0,2));
        coordY = Integer.parseInt(posiciones.get(palabra).substring(3,5));
        posicion = Integer.parseInt(posiciones.get(palabra).substring(6,8));
        numCruci = (int) (posiciones.get(palabra).charAt(9));

        color = new Color(240, 240, 240);
        border = BorderFactory.createLineBorder(Color.BLACK, 1);
        // if (ref == 1 || ref == 2 || ref == 3 || ref == 4) {
        //     for (i = 0; i < palabra.length(); i++) {
        //         textField[0][i].setText(palabra.substring(i, i+1));
        //         textField[0][i].setBackground(color);
        //         textField[0][i].setBorder(border);
        //     }
        // }

        switch(palabra) {
            case "PROCESO": // datos[0]
                for (j=0;j<Constantes.COLUMNAS;j++) {
                    textField[15+j][18].setText(palabra.substring(j, j+1));
                    textField[0][j].setBackground(color);
                    textField[0][j].setBorder(border);
                    textField[i][j].setHorizontalAlignment(SwingConstants.LEFT);
                }
            break;
            case "ACTIVIDADES": // datos[1]
                for (j=0;j<Constantes.COLUMNAS;j++) {
                    textField[1][j].setBackground(color);
                    textField[1][j].setBorder(border);
                }
            break;
            // case "ALQUILER": // datos[2]
            //     for (int j=0;j<Constantes.COLUMNAS;j++) {
            //         textField[2][j].setBackground(color);
            //         textField[2][j].setBorder(border);
            //     }
            // break;
            case "REDES": // datos[3]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[3][j].setBackground(color);
                    textField[3][j].setBorder(border);
                }
            break;
            case "COSTOSDIRECTOS": // datos[4]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[4][j].setBackground(color);
                    textField[4][j].setBorder(border);
                }
            break;
            case "ISO": // datos[5]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[5][j].setBackground(color);
                    textField[5][j].setBorder(border);
                }
            break;
            case "ANALISIS": // datos[6]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[6][j].setBackground(color);
                    textField[6][j].setBorder(border);
                }
            break;
            case "FRACASO": // datos[7]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[7][j].setBackground(color);
                    textField[7][j].setBorder(border);
                }
            break;
            case "MATERIALES": // datos[8]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[8][j].setBackground(color);
                    textField[8][j].setBorder(border);
                }
            break;
            case "ADQUISICIONES": // datos[9]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[9][j].setBackground(color);
                    textField[9][j].setBorder(border);
                }
            break;
            case "INTEGRACION": // datos[10]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[10][j].setBackground(color);
                    textField[10][j].setBorder(border);
                }
            break;
            case "ALCANCE": // datos[11]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[11][j].setBackground(color);
                    textField[11][j].setBorder(border);
                }
            break;
            case "COMUNICACIONES": // datos[12]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[12][j].setBackground(color);
                    textField[12][j].setBorder(border);
                }
            break;
            case "RECURSOSHUMANOS": // datos[13]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[13][j].setBackground(color);
                    textField[13][j].setBorder(border);
                }
            break;
            case "TIEMPO": // datos[14]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[14][j].setBackground(color);
                    textField[14][j].setBorder(border);
                }
            break;
            case "COSTES": // datos[15]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[15][j].setBackground(color);
                    textField[15][j].setBorder(border);
                }
            break;
            case "BUSES": // datos[16]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[16][j].setBackground(color);
                    textField[16][j].setBorder(border);
                }
            break;
            case "COMUN": // datos[17]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[17][j].setBackground(color);
                    textField[17][j].setBorder(border);
                }
            break;
            case "EXPECTATIVA": // datos[18]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[18][j].setBackground(color);
                    textField[18][j].setBorder(border);
                }
            break;
            case "SERVICIOS": // datos[19]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[19][j].setBackground(color);
                    textField[19][j].setBorder(border);
                }
            break;
            // MODULO 1 CRUCIGRAMA 2 //
            case "PROYECTO": // datos[20]
                for (i = 0; i < palabra.length(); i++) {
                    textField[4][3+i].setText(palabra.substring(i, i+1));
                    textField[20][j].setBackground(color);
                    textField[20][j].setBorder(border);
                }
            break;
            case "TEMPORAL": // datos[21]
                for (i = 0; i < palabra.length(); i++) {
                    textField[21][j].setBackground(color);
                    textField[21][j].setBorder(border);
                }
            break;
            case "HARDWARE": // datos[22]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[22][j].setBackground(color);
                    textField[22][j].setBorder(border);
                }
            break;
            case "PROYECTOFALLIDO": // datos[23]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[23][j].setBackground(color);
                    textField[23][j].setBorder(border);
                }
            break;
            case "INTERFACES": // datos[24]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[24][j].setBackground(color);
                    textField[24][j].setBorder(border);
                }
            break;
            case "AUDITORIAS": // datos[25]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[25][j].setBackground(color);
                    textField[25][j].setBorder(border);
                }
            break;
            case "ESTANDAR": // datos[26]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[26][j].setBackground(color);
                    textField[26][j].setBorder(border);
                }
            break;
            case "INVERTIR": // datos[27]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[27][j].setBackground(color);
                    textField[27][j].setBorder(border);
                }
            break;
            case "ADMINISTRADOR": // datos[28]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[28][j].setBackground(color);
                    textField[28][j].setBorder(border);
                }
            break;
            case "CONSULTORIA": // datos[29]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[29][j].setBackground(color);
                    textField[29][j].setBorder(border);
                }
            break;
            case "INDIRECTOS": // datos[30]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[30][j].setBackground(color);
                    textField[30][j].setBorder(border);
                }
            break;
            case "NECESIDADES": // datos[31]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[31][j].setBackground(color);
                    textField[31][j].setBorder(border);
                }
            break;
            case "CONFLICTOS": // datos[32]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[32][j].setBackground(color);
                    textField[32][j].setBorder(border);
                }
            break;
            case "PRESUPUESTO": // datos[33]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[33][j].setBackground(color);
                    textField[33][j].setBorder(border);
                }
            break;
            case "TECNOLOGICO": // datos[34]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[34][j].setBackground(color);
                    textField[34][j].setBorder(border);
                }
            break;
            case "FECHA": // datos[35]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[35][j].setBackground(color);
                    textField[35][j].setBorder(border);
                }
            break;
            case "LOGICA": // datos[36]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[36][j].setBackground(color);
                    textField[36][j].setBorder(border);
                }
            break;
            case "RECURSOS": // datos[37]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[37][j].setBackground(color);
                    textField[37][j].setBorder(border);
                }
            break;
            case "LOGISTICA": // datos[38]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[38][j].setBackground(color);
                    textField[38][j].setBorder(border);
                }
            break;
            case "INDUSTRIA": // datos[39]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[39][j].setBackground(color);
                    textField[39][j].setBorder(border);
                }
            break;
            // MODULO 2 CRUCIGRAMA 1 //
            case "ISHIKAWA": // datos[40]
                for (i = 0; i < palabra.length(); i++) {
                    textField[6][11+i].setText(palabra.substring(i, i+1));
                    textField[6][11].setBackground(color);
                    textField[6][11].setBorder(border);
                }
            break;
            case "FIN": // datos[41]
                for (i = 0; i < palabra.length(); i++) {
                    textField[15][3+i].setText(palabra.substring(i, i+1));
                    textField[15][3+i].setBackground(color);
                    textField[15][3+i].setBorder(border);
                }
            break;
            case "SUPUESTOS": // datos[42]
                for (i = 0; i < palabra.length(); i++) {
                    textField[20][0+i].setText(palabra.substring(i, i+1));
                    textField[20][0+i].setBackground(color);
                    textField[20][0+i].setBorder(border);
                }
            break;
            case "ECONOMICO": // datos[43]
                for (i = 0; i < palabra.length(); i++) {
                    textField[0][11+i].setText(palabra.substring(i, i+1));
                    textField[0][11+i].setBackground(color);
                    textField[0][11+i].setBorder(border);
                }
            break;
            case "CALIDAD": // datos[44]
                for (i = 0; i < palabra.length(); i++) {
                    textField[3][13+i].setText(palabra.substring(i, i+1));
                    textField[3][13+i].setBackground(color);
                    textField[3][13+i].setBorder(border);
                }
            break;
            case "TIEMPOVSDISPONIBILIDAD": // datos[45]
                for (i = 0; i < palabra.length(); i++) {
                    textField[11][0+i].setText(palabra.substring(i, i+1));
                    textField[11][0+i].setBackground(color);
                    textField[11][0+i].setBorder(border);
                }
            break;
            case "BRAINSTORMING": // datos[46]
                for (i = 0; i < palabra.length(); i++) {
                    textField[5+i][0].setText(palabra.substring(i, i+1));
                    textField[5+i][0].setBackground(color);
                    textField[5+i][0].setBorder(border);
                }
            break;
            case "ACTITUDES": // datos[47]
                for (i = 0; i < palabra.length(); i++) {
                    textField[0][4+i].setText(palabra.substring(i, i+1));
                    textField[0][4+i].setBackground(color);
                    textField[0][4+i].setBorder(border);
                }
            break;
            case "TRES": // datos[48]
                for (i = 0; i < palabra.length(); i++) {
                    textField[14][11+i].setText(palabra.substring(i, i+1));
                    textField[14][11+i].setBackground(color);
                    textField[14][11+i].setBorder(border);
                }
            break;
            /// <-.-.-.-.-.-.-.-.-.-.-.-.-.
            case "BENEFICIOS": // datos[49]
            for (i = 0; i < palabra.length(); i++) {
                textField[14][11+i].setText(palabra.substring(i, i+1));
                    textField[49][j].setBackground(color);
                    textField[49][j].setBorder(border);
                }
            break;
            case "CANTIDAD": // datos[50]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[50][j].setBackground(color);
                    textField[50][j].setBorder(border);
                }
            break;
            case "INTERESES": // datos[51]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[51][j].setBackground(color);
                    textField[51][j].setBorder(border);
                }
            break;
            case "GOBIERNO": // datos[52]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[52][j].setBackground(color);
                    textField[52][j].setBorder(border);
                }
            break;
            case "INTERES": // datos[53]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[53][j].setBackground(color);
                    textField[53][j].setBorder(border);
                }
            break;
            case "COMPONENTES": // datos[54]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[54][j].setBackground(color);
                    textField[54][j].setBorder(border);
                }
            break;
            case "ALQUILER": // datos[55]
                for (int j=0;j<Constantes.COLUMNAS;j++) {
                    textField[55][j].setBackground(color);
                    textField[55][j].setBorder(border);
                }
            break;
            case "RAIZ": // datos[56]
                for (j=0;j<Constantes.COLUMNAS;j++) {
                    textField[56][j].setBackground(color);
                    textField[56][j].setBorder(border);
                }
            break;
            case "PORQUE": // datos[57]
                for (j=0;j<Constantes.COLUMNAS;j++) {
                    textField[57][j].setBackground(color);
                    textField[57][j].setBorder(border);
                }
            break;
            case "INVESTIGACION": // datos[58]
                for (j=0;j<Constantes.COLUMNAS;j++) {
                    textField[58][j].setBackground(color);
                    textField[58][j].setBorder(border);
                }
            break;
            case "FINANCIERO": // datos[59]
                for (j=0;j<Constantes.COLUMNAS;j++) {
                    textField[59][j].setBackground(color);
                    textField[59][j].setBorder(border);
                }
            break;
            case "SIETE": // datos[60]
                for (i = 0; i < palabra.length(); i++) {
                    textField[15+i][18].setText(palabra.substring(i, i+1));
                    textField[60][j].setBackground(color);
                    textField[60][j].setBorder(border);
                }
            break;
            case "INVOLUCRADOS": // datos[61]
                for (i = 0; i < palabra.length(); i++) {
                    textField[15+i][18].setText(palabra.substring(i, i+1));
                    textField[61][j].setBackground(color);
                    textField[61][j].setBorder(border);
                }
            break;
            case "OBJETIVOS": // datos[62]
                for (i = 0; i < palabra.length(); i++) {
                    textField[15+i][18].setText(palabra.substring(i, i+1));
                    textField[15+i][18].setBorder(border);
                    textField[15+i][18].setBackground(color);
                }
            break; 
            case "LEGAL": // datos[63]
                for (i = 0; i < palabra.length(); i++) {
                    textField[15+i][18].setText(palabra.substring(i, i+1));
                    textField[15+i][18].setBorder(border);
                    textField[15+i][18].setBackground(color);
                }
            break;
            case "SOCIAL": // datos[64]
                for (i = 0; i < palabra.length(); i++) {
                    textField[15+i][18].setText(palabra.substring(i, i+1));
                    textField[15+i][18].setBorder(border);
                    textField[15+i][18].setBackground(color);
                }
            break;
            case "CLIENTE": // datos[65]
                for (i = 0; i < palabra.length(); i++) {
                    textField[18+i][18].setText(palabra.substring(i, i+1));
                    textField[18+i][18].setBorder(border);
                    textField[18+i][18].setBackground(color);
                }
            break;
            case "RESUMEN": // datos[66]
                for (i = 0; i < palabra.length(); i++) {
                    textField[12+i][13].setText(palabra.substring(i, i+1));
                    textField[12+i][13].setBorder(border);
                    textField[12+i][13].setBackground(color);
                }
            break;
            case "AIRBNB": // datos[67]
                for (i = 0; i < palabra.length(); i++) {
                    textField[8][1+i].setText(palabra.substring(i, i+1));
                    textField[8][1+i].setBorder(border);
                    textField[8][18+i].setBackground(color);
                }
            break;
            case "CAUSASYEFECTOS": // datos[68]
                for (i = 0; i < palabra.length(); i++) {
                    textField[4][3+i].setText(palabra.substring(i, i+1));
                    textField[4][3+i].setBorder(border);
                    textField[4][3+i].setBackground(color);
                }
            break;
            case "ARBOLDEPROBLEMA": // datos[69]
                for (i = 0; i < palabra.length(); i++) {
                    textField[6+i][3].setText(palabra.substring(i, i+1));
                    textField[6+i][3].setBorder(border);
                    textField[6+i][3].setBackground(color);
                }
            break;
            case "MATRIX": // datos[70]
                for (i = 0; i < palabra.length(); i++) {
                    textField[7+i][1].setText(palabra.substring(i, i+1));
                    textField[7+i][1].setBorder(border);
                    textField[7+i][1].setBackground(color);
                }
            break;
            case "PESTEL": // datos[71]
                for (i = 0; i < palabra.length(); i++) {
                    textField[0][5+i].setText(palabra.substring(i, i+1));
                    textField[0][5+i].setBorder(border);
                    textField[0][5+i].setBackground(color);
                }
            break;
            case "PODER": // datos[72]
                for (i = 0; i < palabra.length(); i++) {
                    textField[16+i][2].setText(palabra.substring(i, i+1));
                    textField[16+i][2].setBorder(border);
                    textField[16+i][2].setBackground(color);
                }
            break;
            case "SEGUNDA": // datos[73]
                for (i = 0; i < palabra.length(); i++) {
                    textField[15+i][18].setText(palabra.substring(i, i+1));
                    textField[15+i][18].setBorder(border);
                    textField[15+i][18].setBackground(color);
                }
            break;
            case "PROBLEMA EFECTOS": // datos[74]
                for (i = 0; i < palabra.length(); i++) {
                    textField[13][4+i].setText(palabra.substring(i, i+1));
                    textField[13][4+i].setBorder(border);
                    textField[13][4+i].setBackground(color);
                }
            break;
            case "PROBLEMA CAUSA": // datos[75]
                for (i = 0; i < palabra.length(); i++) {
                    textField[10+i][7].setText(palabra.substring(i, i+1));
                    textField[10+i][7].setBorder(border);
                    textField[10+i][7].setBackground(color);
                }
            break;
            case "POLITICO": // datos[76]
                for (i = 0; i < palabra.length(); i++) {
                    textField[15+i][11].setText(palabra.substring(i, i+1));
                    textField[15+i][11].setBorder(border);
                    textField[15+i][11].setBackground(color);
                }
            break;
            case "ECOLOGICO": // datos[77]
                for (i = 0; i < palabra.length(); i++) {
                    textField[9][11+i].setText(palabra.substring(i, i+1));
                    textField[9][11+i].setBorder(border);
                    textField[9][11+i].setBackground(color);
                }
            break;
            case "STAKEHOLDERS": // datos[78]
                for (i = 0; i < palabra.length(); i++) {
                    textField[24][4+i].setText(palabra.substring(i, i+1));
                    textField[24][4+i].setBorder(border);
                    textField[24][4+i].setBackground(color);
                }
            break;
            case "UBER": // datos[79]
                for (i = 0; i < palabra.length(); i++) {
                    textField[14][1+i].setText(palabra.substring(i, i+1));
                    textField[14][1+i].setBorder(border);
                    textField[14][1+i].setBackground(color);
                }
            break;

        }
    }
    public void borrar () {

        color = new Color(240, 240, 240);

        for (int i = 0; i < Constantes.FILAS; i++) {
            for (int j = 0; j < Constantes.COLUMNAS; j++) {
                textField[i][j].setText("");
                textField[i][j].setBorder(BorderFactory.createLineBorder(new Color(48, 48, 48), 1));
                textField[i][j].setBackground(new Color(192, 255, 247));
            }
        }
        for (int i = 0; i < 20; i++) {
            respuestas[i].setText("");
            respuestas[i].setBackground(Color.WHITE);
        }
    }
    public void validar () {
        String[] palabras = {
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
    public void cargar() {
        
    }

    @Override
    public synchronized void actionPerformed (ActionEvent e) {
        ep = new EscogerPreguntas();
        if (e.getSource() == enviar[0]) {
            // if (respuestas[0].getText().equals("Constantes.J_Respuesta01.getText()"))
                colocarPalabra(ep.getOpcion(), respuestas[0].getText().toUpperCase());
            notify();
            setVisible(true);

        } else if (e.getSource() == enviar[1]) {
            // if (respuestas[1].getText().equals("Constantes.J_Respuesta02.getText()"))
            colocarPalabra(ep.getOpcion(), respuestas[1].getText());
            notify();
            setVisible(true);
        } else if (e.getSource() == enviar[2]) {
            // if (respuestas[2].getText().equals("Constantes.J_Respuesta03.getText()"))
            colocarPalabra(ep.getOpcion(), respuestas[2].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[3]) {
            // if (respuestas[3].getText().equals("Constantes.J_Respuesta04.getText()"))
            colocarPalabra(ep.getOpcion(), respuestas[3].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[4]) {
            // if (respuestas[4].getText().equals("Constantes.J_Respuesta05.getText()"))
            colocarPalabra(ep.getOpcion(), respuestas[4].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[5]) {
            // if (respuestas[5].getText().equals("Constantes.J_Respuesta06.getText()"))
            colocarPalabra(ep.getOpcion(), respuestas[5].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[6]) {
            // if (respuestas[6].getText().equals("Constantes.J_Respuesta07.getText()"))
            colocarPalabra(ep.getOpcion(), respuestas[6].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[7]) {
            // if (respuestas[7].getText().equals("Constantes.J_Respuesta08.getText()"))
            colocarPalabra(ep.getOpcion(), respuestas[7].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[8]) {
            // if (respuestas[8].getText().equals("Constantes.J_Respuesta09.getText()"))
            colocarPalabra(ep.getOpcion(), respuestas[8].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[9]) {
            // if (respuestas[9].getText().equals("Constantes.J_Respuesta10.getText()"))
            colocarPalabra(ep.getOpcion(), respuestas[9].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[10]) {
            // if (respuestas[10].getText().equals("Constantes.J_Respuesta11.getText()"))
            colocarPalabra(ep.getOpcion(), respuestas[10].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[11]) {
            // if (respuestas[11].getText().equals("Constantes.J_Respuesta12.getText()"))
            colocarPalabra(ep.getOpcion(), respuestas[11].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[12]) {
            // if (respuestas[12].getText().equals("Constantes.J_Respuesta13.getText()"))
            colocarPalabra(ep.getOpcion(), respuestas[12].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[13]) {
            // if (respuestas[13].getText().equals("Constantes.J_Respuesta14.getText()"))
            colocarPalabra(ep.getOpcion(), respuestas[13].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[14]) {
            // if (respuestas[14].getText().equals("Constantes.J_Respuesta15.getText()"))
            colocarPalabra(ep.getOpcion(), respuestas[14].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[15]) {
            // if (respuestas[15].getText().equals("Constantes.J_Respuesta16.getText()"))
            colocarPalabra(ep.getOpcion(), respuestas[15].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[16]) {
            // if (respuestas[16].getText().equals("Constantes.J_Respuesta17.getText()"))
            colocarPalabra(ep.getOpcion(), respuestas[16].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[17]) {
            // if (respuestas[17].getText().equals("Constantes.J_Respuesta18.getText()"))
            colocarPalabra(ep.getOpcion(), respuestas[17].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[18]) {
            // if (respuestas[18].getText().equals("Constantes.J_Respuesta19.getText()"))
            colocarPalabra(ep.getOpcion(), respuestas[18].getText());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[19]) {
            // if (respuestas[19].getText().equals("Constantes.J_Respuesta20.getText()"))
            colocarPalabra(ep.getOpcion(), respuestas[19].getText());
            notify();
            setVisible(true);
        } else if (e.getSource() == borrar) {
            borrar();
            notify();
            setVisible(true);
        } else if (e.getSource() == validar) {
            cargar();
            notify();
            setVisible(true);
        } else if (e.getSource() == cargar) {
            validar();
            notify();
            setVisible(true);
        }
    }
}