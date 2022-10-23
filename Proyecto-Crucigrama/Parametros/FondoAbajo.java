package Parametros;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import Metodos.*;
public class FondoAbajo extends JPanel implements ActionListener {

    public int i;
    private LateralIzq datos = new LateralIzq();
    private JButton reiniciar, guardar, cambiar, validar;
    private JPanel contentpane;

    public FondoAbajo() {

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
        guardar = new JButton("Guardar Crucigrama");
        guardar.setHorizontalAlignment(SwingConstants.LEFT);
        guardar.setBounds(50, 105, 173, 50);
        // guardar.setPreferredSize(new java.awt.Dimension(10, 10));
        guardar.setFont(new Font("Times New Roman", Font.BOLD, 15));
        guardar.addActionListener(this);

        EscogerPreguntas ep = new EscogerPreguntas();
        ep.setPreguntas();

        this.setBackground(Color.gray);

        FlowLayout layout = new FlowLayout();
        layout.setVgap(20);
        layout.setHgap(100);

        this.setLayout(layout);

        this.setLayout(new GridLayout(1,1));

        this.add(cambiar);
        this.add(validar);
        this.add(reiniciar);
        this.add(guardar);

    }
    @Override
    public synchronized void actionPerformed (ActionEvent e) {
        if (e.getSource() == cambiar) {
            notify();
            setVisible(true);

        } else if (e.getSource() == validar) {
            notify();
            setVisible(true);
        }  else if (e.getSource() == reiniciar) {
            notify();
            setVisible(true);
        }  else if (e.getSource() == guardar) {
            notify();
            setVisible(true);
        }
    }
}