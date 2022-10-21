import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;
import javax.swing.WindowConstants;

import Parametros.LateralDer;
import Parametros.LateralIzq;
import Parametros.FondoAbajo;
import Parametros.FondoArriba;
import Parametros.Constantes;

public class Crucigrama extends JFrame {

    private FondoAbajo abajo;
    private LateralIzq izq;
    private LateralDer der;
    private JFrame frame;
    private JPanel jp1, jp2, jp3, jp4;
    private JLabel top;

    public Crucigrama(boolean state) {

        frame = new JFrame();
        abajo = new FondoAbajo();
        izq = new LateralIzq();
        der = new LateralDer();
        top = new JLabel("Top");

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
        jp1.setMinimumSize(new Dimension((int) (Constantes.WIDTH/1.2), Constantes.HEIGHT));
        jp1.setPreferredSize(new Dimension((int) (Constantes.WIDTH/1.2), Constantes.HEIGHT));
        jp1.add(izq);

        jp2 = new JPanel();
        jp2.setBorder(new LineBorder(Color.BLACK, 3));
        jp2.setBackground(Color.ORANGE);
        jp2.setMinimumSize(new Dimension((int) (Constantes.WIDTH), Constantes.HEIGHT));
        jp2.setPreferredSize(new Dimension((int) (Constantes.WIDTH), Constantes.HEIGHT));
        jp2.setLayout(new GridLayout(1, 1));
        jp2.add(der);

        jp3 = new JPanel();
        jp3.setBorder(new LineBorder(Color.BLACK, 3));
        jp3.setBackground(Color.ORANGE);
        // jp4.setMinimumSize(new Dimension((int) (Constantes.WIDTH/4), Constantes.HEIGHT));
        // jp4.setPreferredSize(new Dimension((int) (Constantes.WIDTH/4), Constantes.HEIGHT));
        jp3.setLayout(new GridLayout(1, 1));
        jp3.add(top);

        jp4 = new JPanel();
        jp4.setBorder(new LineBorder(Color.BLACK, 3));
        jp4.setBackground(Color.ORANGE);
        jp4.setMinimumSize(new Dimension((int) (Constantes.WIDTH),(int)(Constantes.HEIGHT*0.25)));
        jp4.setPreferredSize(new Dimension((int) (Constantes.WIDTH), (int)(Constantes.HEIGHT*0.1)));
        jp4.setLayout(new GridLayout(1, 1));
        jp4.add(abajo);

        frame.add(jp1, BorderLayout.WEST);
        frame.add(jp2, BorderLayout.CENTER);
        frame.add(jp3, BorderLayout.NORTH);
        // frame.add(jp4, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(state);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
