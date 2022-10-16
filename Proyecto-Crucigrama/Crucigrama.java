import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;
import javax.swing.WindowConstants;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Parametros.*;
public class Crucigrama extends JFrame {

    FondoBlanco blanco;
    FondoNegro negro;
    FondoAbajo abajo;
    LateralIzq izq;
    JFrame frame;
    JPanel jp1, jp2, jp3, jp4, jp5;
    JLabel top, bottom;
    // Container c = getContentPane();

    public Crucigrama(boolean state) {

        frame = new JFrame();
        blanco = new FondoBlanco();
        negro = new FondoNegro();
        abajo = new FondoAbajo();
        izq = new LateralIzq();
        top = new JLabel("Top");
        bottom = new JLabel("Bottom");

        frame.getContentPane().setLayout(new BorderLayout(8, 6));
        frame.setBackground(Color.YELLOW);
        frame.setTitle("Crucigrama");
        frame.setBounds(0,500, Constantes.WIDTH, Constantes.HEIGHT);
        frame.setResizable(true);
        frame.setLocation(800, 0);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.GREEN));

        jp1 = new JPanel();
        jp1.setBorder(new LineBorder(Color.BLACK, 3));
        jp1.setBackground(Color.ORANGE);
        // jp1.setLayout(new GridLayout(1, 1));
        jp1.setLayout(new BorderLayout());
        jp1.setMinimumSize(new Dimension((int) (Constantes.WIDTH/4), Constantes.HEIGHT));
        jp1.setPreferredSize(new Dimension((int) (Constantes.WIDTH/4), Constantes.HEIGHT));
        // final JLabel J_Label = new JLabel("Original Label");
        // JButton J_Button = new JButton("Change Label");
        // J_Button.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent arg0) {

        //         J_Label.setText("New Label");
        //     }
        // });
        // jp1.add(J_Label, BorderLayout.NORTH);
        // jp1.add(J_Button, BorderLayout.SOUTH);
        jp1.add(izq);

        jp2 = new JPanel();
        jp2.setBorder(new LineBorder(Color.BLACK, 3));
        jp2.setBackground(Color.ORANGE);
        jp2.setMinimumSize(new Dimension((int) (Constantes.WIDTH/2), Constantes.HEIGHT));
        jp2.setPreferredSize(new Dimension((int) (Constantes.WIDTH/2), Constantes.HEIGHT));;
        jp2.setLayout(new GridLayout(1, 1));
        jp2.add(blanco);

        jp3 = new JPanel();
        jp3.setBorder(new LineBorder(Color.BLACK, 3));
        jp3.setBackground(Color.ORANGE);
        jp3.setMinimumSize(new Dimension((int) (Constantes.WIDTH/4), Constantes.HEIGHT));
        jp3.setPreferredSize(new Dimension((int) (Constantes.WIDTH/4), Constantes.HEIGHT));
        jp3.setLayout(new GridLayout(1, 1));
        jp3.add(negro);

        jp4 = new JPanel();
        jp4.setBorder(new LineBorder(Color.BLACK, 3));
        jp4.setBackground(Color.ORANGE);
        // jp4.setMinimumSize(new Dimension((int) (Constantes.WIDTH/4), Constantes.HEIGHT));
        // jp4.setPreferredSize(new Dimension((int) (Constantes.WIDTH/4), Constantes.HEIGHT));
        jp4.setLayout(new GridLayout(1, 1));
        jp4.add(top);

        jp5 = new JPanel();
        jp5.setBorder(new LineBorder(Color.BLACK, 3));
        jp5.setBackground(Color.ORANGE);
        jp5.setMinimumSize(new Dimension((int) (Constantes.WIDTH),(int)(Constantes.HEIGHT*0.25)));
        jp5.setPreferredSize(new Dimension((int) (Constantes.WIDTH), (int)(Constantes.HEIGHT*0.1)));
        jp5.setLayout(new GridLayout(1, 1));
        jp5.add(abajo);

        frame.add(jp1, BorderLayout.WEST);
        frame.add(jp2, BorderLayout.EAST);
        frame.add(jp3, BorderLayout.CENTER);
        frame.add(jp4, BorderLayout.NORTH);
        frame.add(jp5, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(state);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
