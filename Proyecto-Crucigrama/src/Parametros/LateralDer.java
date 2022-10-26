package src.Parametros;

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

import src.Metodos.BordeRedondeado;

import javax.swing.BorderFactory;

import java.util.HashMap;
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
    private Color color1, color3;

    public LateralDer(int cruci) {

        color1 = new Color(247, 191, 190);
        color3 = new Color(165, 109, 93); // Botones Color

        this.setBackground(color1);
        this.setLayout(new BorderLayout(8, 6));
        this.setBorder(BorderFactory.createMatteBorder(4,4,4,4, color1));

        este = new JPanel();
        este.setLayout(new GridLayout(Constantes.FILAS,Constantes.COLUMNAS));
        este.setBackground(Color.DARK_GRAY);
        este.setBorder(BorderFactory.createMatteBorder(2,1,2,1, Color.BLACK));
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
        borrar.setBackground(color3);
        borrar.setForeground(Color.BLACK);
        borrar.addActionListener(this);

        validar = new JButton("Validar");
        validar.setFont(new Font("Times New Roman", Font.BOLD, 15));
        validar.setBorder(new BordeRedondeado(6));
        validar.setForeground(Color.BLACK);
        validar.setBackground(color3);
        validar.addActionListener(this);

        cargar = new JButton("Cargar");
        cargar.setFont(new Font("Times New Roman", Font.BOLD, 15));
        cargar.setBorder(new BordeRedondeado(6));
        cargar.setForeground(Color.BLACK);
        cargar.setBackground(color3);
        cargar.addActionListener(this);

        enviar = new JButton[20];

        jp = new JPanel();
        jp.setLayout(new GridLayout(20,1, 3,0));
        jp.setBackground(Color.GRAY);
        contentpane = new JPanel();
        contentpane.add(new JLabel(""));
        contentpane.setBackground(new Color(192, 255, 247));
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
            enviar[i] = new JButton("Validar["+(i+1)+"]");
            enviar[i].setHorizontalAlignment(SwingConstants.CENTER);
            enviar[i].setFont(new Font("Times New Roman", Font.BOLD, 15));
            enviar[i].setBorder(new BordeRedondeado(6));
            enviar[i].setBackground(color3);
            enviar[i].setForeground(Color.BLACK);
            enviar[i].addActionListener(this);
            jp.add(respuestas[i]);
            jp.add(enviar[i]);
        }

        // LLenando lado derecho, lado centro
        textField = new JTextField [Constantes.FILAS][Constantes.COLUMNAS];
        for (i = 0; i < Constantes.FILAS; i++)
            for (j = 0; j < Constantes.COLUMNAS; j++) {
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
        int coordX, coordY, posicion;
        int numCruci;
        posiciones = new HashMap<String, String>() {
            {   // MODULO 1 CRUCIGRAMA 1 // 0-19
                put("PROCESO", "14 13 02 01"); // LISTO
                put("ACTIVIDADES", "05 05 01 02"); // LISTO
                put("ALQUILER", "06 15 01 03"); // LISTO
                put("REDES","18 12 01 04"); // LISTO
                put("COSTOSDIRECTOS","01 04 01 05"); // LISTO
                put("ISO","00 06 02 06"); // LISTO
                put("ANALISIS", "16 02 02 07"); // LISTO
                put("FRACASO","18 04 01 08"); // LISTO
                put("MATERIALES", "04 05 02 09"); // LISTO
                put("ADQUISICIONES","09 10 02 10"); // LISTO
                put("INTEGRACION","04 02 02 11"); // LISTO
                put("ALCANCE","09 18 02 12"); // LISTO
                put("COMUNICACIONES","00 08 02 13"); // LISTO
                put("RECURSOSHUMANOS","12 07 01 14"); // LISTO
                put("TIEMPO","03 14 02 15"); // LISTO
                put("COSTES","20 12 01 16"); // LISTO
                put("BUSES","11 16 02 17"); // LISTO
                put("COMUN","08 13 01 18"); // LISTO
                put("EXPECTATIVA","07 02 01 19"); // LISTO
                put("SERVICIOS","21 02 01 20"); // LISTO
                // MODULO 1 CRUCIGRAMA 2 // 20-39
                put("PROYECTO","10 15 01 01"); // LISTO
                put("TEMPORAL", "02 10 02 02"); // LISTO
                put("HARDWARE","06 13 01 03"); // LISTO
                put("PROYECTOFALLIDO", "12 07 01 04"); // LISTO
                put("INTERFACES","00 02 01 05"); // LISTO
                put("AUDITORIAS", "08 13 02 06"); // LISTO
                put("ESTANDAR","14 07 02 07"); // LISTO
                put("INVERTIR", "19 11 01 08"); // LISTO
                put("ADMINISTRADOR","00 08 02 09"); // LISTO
                put("CONSULTORIA", "07 02 01 10"); // LISTO
                put("INDIRECTOS","21 03 01 11"); // LISTO
                put("NECESIDADES", "05 02 02 12"); // LISTO
                put("CONFLICTOS","15 09 02 13"); //LISTO
                put("PRESUPUESTO", "04 05 02 14"); // LISTO
                put("TECNOLOGICO","11 11 02 15"); // LISTO
                put("FECHA", "02 14 02 16"); // LISTO
                put("LOGICA","17 02 01 17"); // LISTO
                put("RECURSOS", "15 15 02 18"); // LISTO
                put("LOGISTICA","24 05 01 19"); // LISTO
                put("INDUSTRIA", "04 16 02 20"); // LISTO
                // MODULO 2 CRUCIGRAMA 1 // 40- 59
                put("ISHIKAWA", "22 09 01 01"); // LISTO
                put("FIN", "09 14 01 02"); // LISTO
                put("SUPUESTOS", "03 03 01 03"); // LISTO
                put("ECONOMICO", "12 04 02 04"); // LISTO
                put("CALIDAD", "22 00 01 05"); // LISTO
                put("TIEMPOVSDISPONIBILIDAD", "12 02 01 06"); // LISTO
                put("BRAINSTORMING", "06 02 02 07"); // LISTO
                put("ACTITUDES", "19 03 01 08"); // LISTO
                put("TRES", "08 05 01 09"); // LISTO
                put("BENEFICIOS", "06 02 01 10"); // LISTO
                put("CANTIDAD", "15 06 02 11"); // LISTO
                put("INTERESES", "14 10 02 12"); // LISTO
                put("GOBIERNO", "01 04 01 13"); // LISTO
                put("INTERES", "12 20 02 14"); // LISTO
                put("COMPONENTES", "00 05 02 15"); // LISTO
                put("ALQUILER", "15 06 01 16"); // LISTO
                put("RAIZ", "20 12 02 17"); // LISTO
                put("PORQUE", "15 08 02 18"); // LISTO
                put("INVESTIGACION", "10 01 01 19"); // LISTO
                put("FINANCIERO", "08 15 02 20"); // LISTO

                // MODULO 2 CRUCIGRAMA 2 // 60- 79
                put("SIETE", "02 10 02 01");
                put("INVOLUCRADOS", "01 18 02 02" );
                put("OBJETIVOS", "08 09 02 03"); // Casillas de arr-aba, der-izq, x-y,cruc
                put("LEGAL", "18 01 01 04");
                put("SOCIAL", "00 07 02 05");
                put("CLIENTE", "19 09 01 06");
                put("RESUMEN", "10 13 02 07");
                put("AIRBNB", "06 01 01 08");
                put("CAUSASYEFECTOS", "04 03 01 09");
                put("ARBOLDEPROBLEMA", "04 04 02 10");
                put("MATRIX", "05 01 02 11");
                put("PESTEL", "00 05 01 12");
                put("PODER", "15 02 02 13");
                put("SEGUNDA", "02 14 01 14");
                put("PROBLEMA EFECTOS", "11 04 01 15");
                put("PROBLEMA CAUSA", "08 07 02 16");
                put("POLITICO", "14 11 02 17");
                put("ECOLOGICO", "07 11 01 18");
                put("STAKEHOLDERS", "21 05 01 19");
                put("UBER", "12 01 01 20");
            }
        };

        coordX = Integer.parseInt(posiciones.get(palabra).substring(0,2));
        coordY = Integer.parseInt(posiciones.get(palabra).substring(3,5));
        posicion = Integer.parseInt(posiciones.get(palabra).substring(6,8));
        numCruci = Integer.parseInt(posiciones.get(palabra).substring(9,11));

        color = new Color(240, 240, 240);

        border = BorderFactory.createLineBorder(Color.BLACK, 1);
        if (posicion == 01 && ref == 0)
            for (i = 0; i < palabra.length(); i++) {
                textField[coordX][coordY+i].setForeground(Color.BLACK);
                textField[coordX][coordY+i].setFont(new Font("Times New Roman", Font.BOLD, 15));
                textField[coordX][coordY+i].setText(palabra.substring(i, i+1));
                textField[coordX][coordY+i].setBorder(border);
                textField[coordX][coordY+i].setBackground(color);
                textField[coordX][coordY+i].setHorizontalAlignment(SwingConstants.CENTER);
            }
        else if (posicion == 02 && ref == 0)
            for (i = 0; i < palabra.length(); i++) {
                textField[coordX+i][coordY].setForeground(Color.BLACK);
                textField[coordX+i][coordY].setFont(new Font("Times New Roman", Font.BOLD, 15));
                textField[coordX+i][coordY].setText(palabra.substring(i, i+1));
                textField[coordX+i][coordY].setBorder(border);
                textField[coordX+i][coordY].setBackground(color);
                textField[coordX+i][coordY].setHorizontalAlignment(SwingConstants.LEFT);
            }
        else if (posicion == 01 && ref == 1)
            for (i = 0; i < palabra.length(); i++) {
                if(i == 0) {
                    textField[coordX][coordY+i].setText(String.valueOf(numCruci));
                    textField[coordX][coordY+i].setFont(new Font("Verdana", Font.BOLD, 8));
                    textField[coordX][coordY+i].setForeground(Color.RED);
                }
                textField[coordX][coordY+i].setBorder(border);
            }
        else if (posicion == 02 && ref == 1)
            for (i = 0; i < palabra.length(); i++) {
                if(i == 0) {
                    textField[coordX+i][coordY].setText(String.valueOf(numCruci));
                    textField[coordX+i][coordY].setFont(new Font("Verdana", Font.BOLD, 8));
                    textField[coordX+i][coordY].setForeground(Color.RED);
                }
                textField[coordX+i][coordY].setBorder(border);
            }
    }
    public void borrar () {

        color = new Color(240, 240, 240);

        for (i = 0; i < Constantes.FILAS; i++) {
            for (j = 0; j < Constantes.COLUMNAS; j++) {
                textField[i][j].setText("");
                textField[i][j].setBorder(BorderFactory.createLineBorder(new Color(106, 194, 217), 1));
                textField[i][j].setBackground(new Color(192, 255, 247));
                textField[i][j].setForeground(Color.BLACK);
            }
        }
        for (i = 0; i < 20; i++) {
            respuestas[i].setText("");
            respuestas[i].setBackground(new Color(255, 247, 255));
            respuestas[i].setForeground(Color.BLACK);
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
        if (e.getSource() == enviar[0]) {
            if (respuestas[0].getText().toUpperCase().equals(Constantes.J_Respuesta01.getText()))
                colocarPalabra(0, respuestas[0].getText().toUpperCase());
            notify();
            setVisible(true);
        } else if (e.getSource() == enviar[1]) {
            if (respuestas[1].getText().toUpperCase().equals(Constantes.J_Respuesta02.getText()))
                colocarPalabra(0, respuestas[1].getText().toUpperCase());
            notify();
            setVisible(true);
        } else if (e.getSource() == enviar[2]) {
            if (respuestas[2].getText().toUpperCase().equals(Constantes.J_Respuesta03.getText()))
                colocarPalabra(0, respuestas[2].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[3]) {
            if (respuestas[3].getText().toUpperCase().equals(Constantes.J_Respuesta04.getText()))
                colocarPalabra(0, respuestas[3].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[4]) {
            if (respuestas[4].getText().toUpperCase().equals(Constantes.J_Respuesta05.getText()))
                colocarPalabra(0, respuestas[4].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[5]) {
            if (respuestas[5].getText().toUpperCase().equals(Constantes.J_Respuesta06.getText()))
                colocarPalabra(0, respuestas[5].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[6]) {
            if (respuestas[6].getText().toUpperCase().equals(Constantes.J_Respuesta07.getText()))
                colocarPalabra(0, respuestas[6].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[7]) {
            if (respuestas[7].getText().toUpperCase().equals(Constantes.J_Respuesta08.getText()))
                colocarPalabra(0, respuestas[7].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[8]) {
            if (respuestas[8].getText().toUpperCase().equals(Constantes.J_Respuesta09.getText()))
                colocarPalabra(0, respuestas[8].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[9]) {
            if (respuestas[9].getText().toUpperCase().equals(Constantes.J_Respuesta10.getText()))
                colocarPalabra(0, respuestas[9].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[10]) {
            if (respuestas[10].getText().toUpperCase().equals(Constantes.J_Respuesta11.getText()))
                colocarPalabra(0, respuestas[10].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[11]) {
            if (respuestas[11].getText().toUpperCase().equals(Constantes.J_Respuesta12.getText()))
                colocarPalabra(0, respuestas[11].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[12]) {
            if (respuestas[12].getText().toUpperCase().equals(Constantes.J_Respuesta13.getText()))
                colocarPalabra(0, respuestas[12].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[13]) {
            if (respuestas[13].getText().toUpperCase().equals(Constantes.J_Respuesta14.getText()))
                colocarPalabra(0, respuestas[13].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[14]) {
            if (respuestas[14].getText().toUpperCase().equals(Constantes.J_Respuesta15.getText()))
                colocarPalabra(0, respuestas[14].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[15]) {
            if (respuestas[15].getText().toUpperCase().equals(Constantes.J_Respuesta16.getText()))
                colocarPalabra(0, respuestas[15].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[16]) {
            if (respuestas[16].getText().toUpperCase().equals(Constantes.J_Respuesta17.getText()))
                colocarPalabra(0, respuestas[16].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[17]) {
            if (respuestas[17].getText().toUpperCase().equals(Constantes.J_Respuesta18.getText()))
                colocarPalabra(0, respuestas[17].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[18]) {
            if (respuestas[18].getText().toUpperCase().equals(Constantes.J_Respuesta19.getText()))
                colocarPalabra(0, respuestas[18].getText().toUpperCase());
            notify();
            setVisible(true);
        }  else if (e.getSource() == enviar[19]) {
            if (respuestas[19].getText().toUpperCase().equals(Constantes.J_Respuesta20.getText()))
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