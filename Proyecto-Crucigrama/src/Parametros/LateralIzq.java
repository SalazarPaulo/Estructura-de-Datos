package src.Parametros;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import javax.swing.JPanel;

import src.Metodos.*;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.*;

public class LateralIzq extends JPanel implements ItemListener {

    public int i = 0, z = 0;
    private EscogerPreguntas ep = new EscogerPreguntas();
    private JPanel top, bot, norte;
    private JComboBox<String> lista;
    private String[] opc  =  {
        "MODULO #1: CRUCIGRAMA NO.1",
        "MODULO #1: CRUCIGRAMA NO.2",
        "MODULO #2: CRUCIGRAMA NO.1",
        "MODULO #2: CRUCIGRAMA NO.2"};
    private boolean leido = true;
    private HashMap<Integer, String> opciones;
    private Color color, color1, color2;

    public LateralIzq() {

        color = new Color(247, 191, 190);
        color1 = new Color(255, 247, 255);
        color2 = new Color(165, 109, 93); // Botones Color

        this.setLayout(new BorderLayout());
        top = new JPanel();
        top.setLayout(new GridLayout(20, 1));
        top.setBackground(color1);

        bot = new JPanel();
        bot.setLayout(new GridLayout(1, 2));

        norte = new JPanel();
        norte.setBackground(color);
        norte.setBorder(new BordeRedondeado(10));
        norte.setBorder(BorderFactory.createLineBorder(color));

        this.add(top, BorderLayout.CENTER);
        this.add(bot, BorderLayout.SOUTH);
        this.add(norte, BorderLayout.NORTH);

        JButton J_Button = new JButton("Generar");
        J_Button.setFont(new Font("Times New Roman", Font.BOLD, 15));
        J_Button.setForeground(Color.BLACK);
        J_Button.setBackground(color2);
        J_Button.setBounds(50, 105, 173, 50);
        J_Button.setBorder(new BordeRedondeado(6));
        J_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                do {
                    leido = true;
                    z = (int)((Math.random() * 3)+1);
                    if ( z == ep.getOpcion()) {
                        leido = false;
                    }
                } while (!leido);
                cambiar(z);
            }
        });
        lista = new JComboBox<String>(opc);
        lista.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lista.setForeground(Color.BLACK);
        lista.setBackground(Color.WHITE);
        lista.addItemListener(this);

        Constantes.J_Label.setVerticalTextPosition(SwingConstants.TOP);
        Constantes.J_Label.setFont(new Font("Times New Roman", Font.BOLD, 15));

        Constantes.J_Label01.setForeground(Color.BLACK);
        Constantes.J_Label01.setVerticalTextPosition(SwingConstants.TOP);
        Constantes.J_Label01.setFont(new Font("Verdana", Font.BOLD, 11));

        Constantes.J_Label02.setForeground(Color.BLACK);
        Constantes.J_Label02.setVerticalTextPosition(SwingConstants.TOP);
        Constantes.J_Label02.setFont(new Font("Verdana", Font.BOLD, 11));

        Constantes.J_Label03.setForeground(Color.BLACK);
        Constantes.J_Label03.setVerticalTextPosition(SwingConstants.TOP);
        Constantes.J_Label03.setFont(new Font("Verdana", Font.BOLD, 11));

        Constantes.J_Label04.setForeground(Color.BLACK);
        Constantes.J_Label04.setVerticalTextPosition(SwingConstants.TOP);
        Constantes.J_Label04.setFont(new Font("Verdana", Font.BOLD, 11));

        Constantes.J_Label05.setForeground(Color.BLACK);
        Constantes.J_Label05.setVerticalTextPosition(SwingConstants.TOP);
        Constantes.J_Label05.setFont(new Font("Verdana", Font.BOLD, 11));

        Constantes.J_Label06.setForeground(Color.BLACK);
        Constantes.J_Label06.setVerticalTextPosition(SwingConstants.TOP);
        Constantes.J_Label06.setFont(new Font("Verdana", Font.BOLD, 11));

        Constantes.J_Label07.setForeground(Color.BLACK);
        Constantes.J_Label07.setVerticalTextPosition(SwingConstants.TOP);
        Constantes.J_Label07.setFont(new Font("Verdana", Font.BOLD, 11));

        Constantes.J_Label08.setForeground(Color.BLACK);
        Constantes.J_Label08.setVerticalTextPosition(SwingConstants.TOP);
        Constantes.J_Label08.setFont(new Font("Verdana", Font.BOLD, 11));

        Constantes.J_Label09.setForeground(Color.BLACK);
        Constantes.J_Label09.setVerticalTextPosition(SwingConstants.TOP);
        Constantes.J_Label09.setFont(new Font("Verdana", Font.BOLD, 11));

        Constantes.J_Label10.setForeground(Color.BLACK);
        Constantes.J_Label10.setVerticalTextPosition(SwingConstants.TOP);
        Constantes.J_Label10.setFont(new Font("Verdana", Font.BOLD, 11));

        Constantes.J_Label11.setForeground(Color.BLACK);
        Constantes.J_Label11.setVerticalTextPosition(SwingConstants.TOP);
        Constantes.J_Label11.setFont(new Font("Verdana", Font.BOLD, 11));

        Constantes.J_Label12.setForeground(Color.BLACK);
        Constantes.J_Label12.setVerticalTextPosition(SwingConstants.TOP);
        Constantes.J_Label12.setFont(new Font("Verdana", Font.BOLD, 11));

        Constantes.J_Label13.setForeground(Color.BLACK);
        Constantes.J_Label13.setVerticalTextPosition(SwingConstants.TOP);
        Constantes.J_Label13.setFont(new Font("Verdana", Font.BOLD, 11));

        Constantes.J_Label14.setForeground(Color.BLACK);
        Constantes.J_Label14.setVerticalTextPosition(SwingConstants.TOP);
        Constantes.J_Label14.setFont(new Font("Verdana", Font.BOLD, 11));

        Constantes.J_Label15.setForeground(Color.BLACK);
        Constantes.J_Label15.setVerticalTextPosition(SwingConstants.TOP);
        Constantes.J_Label15.setFont(new Font("Verdana", Font.BOLD, 11));

        Constantes.J_Label16.setForeground(Color.BLACK);
        Constantes.J_Label16.setVerticalTextPosition(SwingConstants.TOP);
        Constantes.J_Label16.setFont(new Font("Verdana", Font.BOLD, 11));

        Constantes.J_Label17.setForeground(Color.BLACK);
        Constantes.J_Label17.setVerticalTextPosition(SwingConstants.TOP);
        Constantes.J_Label17.setFont(new Font("Verdana", Font.BOLD, 11));

        Constantes.J_Label18.setForeground(Color.BLACK);
        Constantes.J_Label18.setVerticalTextPosition(SwingConstants.TOP);
        Constantes.J_Label18.setFont(new Font("Verdana", Font.BOLD, 11));

        Constantes.J_Label19.setForeground(Color.BLACK);
        Constantes.J_Label19.setVerticalTextPosition(SwingConstants.TOP);
        Constantes.J_Label19.setFont(new Font("Verdana", Font.BOLD, 11));

        Constantes.J_Label20.setForeground(Color.BLACK);
        Constantes.J_Label20.setVerticalTextPosition(SwingConstants.TOP);
        Constantes.J_Label20.setFont(new Font("Verdana", Font.BOLD, 11));

        norte.add(Constantes.J_Label);
        top.add(Constantes.J_Label01);
        top.add(Constantes.J_Label02);
        top.add(Constantes.J_Label03);
        top.add(Constantes.J_Label04);
        top.add(Constantes.J_Label05);
        top.add(Constantes.J_Label06);
        top.add(Constantes.J_Label07);
        top.add(Constantes.J_Label08);
        top.add(Constantes.J_Label09);
        top.add(Constantes.J_Label10);
        top.add(Constantes.J_Label11);
        top.add(Constantes.J_Label12);
        top.add(Constantes.J_Label13);
        top.add(Constantes.J_Label14);
        top.add(Constantes.J_Label15);
        top.add(Constantes.J_Label16);
        top.add(Constantes.J_Label17);
        top.add(Constantes.J_Label18);
        top.add(Constantes.J_Label19);
        top.add(Constantes.J_Label20);
        bot.add(J_Button);
        bot.add(lista);
    }
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == lista) {
            String seleccionado=(String)lista.getSelectedItem();
            if(seleccionado.equals("MODULO #1: CRUCIGRAMA NO.1"))
                cambiar(0);
            if(seleccionado.equals("MODULO #1: CRUCIGRAMA NO.2"))
                cambiar(1);
            if(seleccionado.equals("MODULO #2: CRUCIGRAMA NO.1"))
                cambiar(2);
            if(seleccionado.equals("MODULO #2: CRUCIGRAMA NO.2"))
                cambiar(3);

        }
    }
    public void cambiar(int opc) {

        String text = "";
        ep.setPreguntas(opc);
        opciones = new HashMap<Integer, String>() {
            {
                put(0, "MODULO #1: CRUCIGRAMA NO.1");
                put(1, "MODULO #1: CRUCIGRAMA NO.2");
                put(2, "MODULO #2: CRUCIGRAMA NO.1");
                put(3, "MODULO #2: CRUCIGRAMA NO.2");
            }
        };
        text = opciones.get(opc);

        Constantes.J_Label.setText(text);
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
