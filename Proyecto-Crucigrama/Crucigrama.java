import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Parametros.*;

public class Crucigrama extends JFrame {

    FondoBlanco blanco = new FondoBlanco();
    FondoNegro negro = new FondoNegro();
    // Container c = getContentPane();

    public Crucigrama(boolean state) {
        JFrame frame = new JFrame();

        frame.getContentPane().setLayout(new GridLayout(1, 2)); // Filas y Columnas
        frame.setTitle("Crucigrama");
        frame.setBounds(0,500, 400, 400);
        frame.setResizable(true);

        frame.getContentPane().add(negro);
        // frame.setLocation(100, 100);
        frame.getContentPane().add(blanco);

        frame.pack();
        frame.setVisible(state);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
