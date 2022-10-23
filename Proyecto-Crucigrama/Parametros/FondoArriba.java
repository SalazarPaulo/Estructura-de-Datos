package Parametros;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class FondoArriba extends JPanel {

    private JLabel img, logo_utp;
    private ImageIcon image;

    public FondoArriba() {

        this.setLayout(new BorderLayout());

        image = new ImageIcon(getClass().getResource("/Assets/logofisc.png"));
        img = new JLabel();
        img.setBounds(0,0, 50, 50);
        img.setIcon(new ImageIcon(image.getImage().getScaledInstance(img.getWidth(), img.getHeight(), 200)));
        this.add(img, BorderLayout.WEST);

        logo_utp = new JLabel();
        logo_utp.setBounds(0,0, 50, 50);
        logo_utp.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Assets/logoutp.png")).getImage().getScaledInstance(logo_utp.getWidth(), logo_utp.getHeight(), 200)));
        this.add(logo_utp, BorderLayout.EAST);
    }
}
