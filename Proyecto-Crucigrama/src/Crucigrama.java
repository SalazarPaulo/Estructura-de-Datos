package src;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;

import src.Parametros.Constantes;
import src.Parametros.FondoArriba;
import src.Parametros.LateralDer;
import src.Parametros.LateralIzq;

import javax.swing.WindowConstants;
import javax.swing.ImageIcon;

public class Crucigrama extends JFrame {

    private FondoArriba arriba;
    private LateralIzq izq;
    private LateralDer der;
    private JFrame frame;
    private JPanel jp1, jp2, jp3, fondo;
    private ImageIcon icono;
    private Toolkit t = Toolkit.getDefaultToolkit();
    private Color color;

    public void start() {

        color = new Color(255, 240, 201);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("Tu resolución es de " + screenSize.width + "x" + screenSize.height);
        frame = new JFrame();
        arriba = new FondoArriba();
        izq = new LateralIzq();
        der = new LateralDer(0);
        fondo = new JPanel();

        frame.getContentPane().setLayout(new BorderLayout(8, 6));
        frame.setBackground(color);
        frame.setTitle("Crucigrama");
        frame.setBounds(-10,0, t.getScreenSize().width, t.getScreenSize().height);
        frame.setResizable(true);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4, color));
        
        fondo.setLayout(new BorderLayout(8, 6));
        fondo.setBackground(color); // <--------- FONDO ROSADO
        frame.add(fondo);

        jp1 = new JPanel();
        jp1.setBorder(new LineBorder(Color.BLACK, 3));
        jp1.setBackground(color);
        jp1.setLayout(new BorderLayout());
        jp1.setMinimumSize(new Dimension((int) (Constantes.WIDTH/1.2), Constantes.HEIGHT));
        jp1.setPreferredSize(new Dimension((int) (Constantes.WIDTH/1.2), Constantes.HEIGHT));
        jp1.add(izq);

        jp2 = new JPanel();
        jp2.setBorder(new LineBorder(Color.BLACK, 3));
        jp2.setBackground(color);
        jp2.setMinimumSize(new Dimension((int) (Constantes.WIDTH), Constantes.HEIGHT));
        jp2.setPreferredSize(new Dimension((int) (Constantes.WIDTH), Constantes.HEIGHT));
        jp2.setLayout(new GridLayout(1, 1));
        jp2.add(der);

        jp3 = new JPanel();
        jp3.setBorder(new LineBorder(Color.BLACK, 3));
        jp3.setBackground(color);
        jp3.setMinimumSize(new Dimension((int)(Constantes.WIDTH),(int)(Constantes.HEIGHT*0.10)));
        jp3.setPreferredSize(new Dimension((int)(Constantes.WIDTH), (int)(Constantes.HEIGHT*0.10)));
        jp3.setLayout(new GridLayout(1, 1));
        jp3.add(arriba);

        fondo.add(jp1, BorderLayout.WEST);
        fondo.add(jp2, BorderLayout.CENTER);
        fondo.add(jp3, BorderLayout.NORTH);

        ////////-------- ADD FRAME --------//////////
        icono= new ImageIcon(this.getClass().getResource("/Assets/logoutp.png"));
        frame.setIconImage(icono.getImage());
        
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
