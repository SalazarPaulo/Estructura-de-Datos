import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;
import javax.swing.WindowConstants;
import javax.swing.ImageIcon;

import Parametros.LateralDer;
import Parametros.LateralIzq;
import Parametros.FondoArriba;
import Parametros.Constantes;

public class Crucigrama extends JFrame {

    private FondoArriba arriba;
    private LateralIzq izq;
    private LateralDer der;
    private JFrame frame;
    private JPanel jp1, jp2, jp3;
    private ImageIcon icono;
    private Toolkit t = Toolkit.getDefaultToolkit();

    public void start() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("Tu resolución es de " + screenSize.width + "x" + screenSize.height);
        frame = new JFrame();
        arriba = new FondoArriba();
        izq = new LateralIzq();
        der = new LateralDer(0);

        frame.getContentPane().setLayout(new BorderLayout(8, 6));
        frame.setBackground(Color.YELLOW);
        frame.setTitle("Crucigrama");
        frame.setBounds(-10,0, t.getScreenSize().width, t.getScreenSize().height);
        frame.setResizable(true);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.GREEN));

        jp1 = new JPanel();
        jp1.setBorder(new LineBorder(Color.BLACK, 3));
        jp1.setBackground(Color.ORANGE);
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
        jp3.setMinimumSize(new Dimension((int)(Constantes.WIDTH),(int)(Constantes.HEIGHT*0.10)));
        jp3.setPreferredSize(new Dimension((int)(Constantes.WIDTH), (int)(Constantes.HEIGHT*0.10)));
        jp3.setLayout(new GridLayout(1, 1));
        jp3.add(arriba);

        frame.add(jp1, BorderLayout.WEST);
        frame.add(jp2, BorderLayout.CENTER);
        frame.add(jp3, BorderLayout.NORTH);

        ////////-------- ADD FRAME --------//////////
        icono= new ImageIcon(this.getClass().getResource("Assets/logoutp.png"));
        frame.setIconImage(icono.getImage());

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
