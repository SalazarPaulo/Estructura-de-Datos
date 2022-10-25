package Parametros;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class FondoArriba extends JPanel {

    private JLabel img, logo_utp;
    private ImageIcon image;
    private JTextArea textArea1, textArea2, textArea3;
    private JPanel center;

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

        textArea1 =new JTextArea();
        textArea1.setText("\tINTEGRANTES:\n\t\t-Arqui\u00f1ez, Lianeth(8-974-1567)\t-Castro, Aldrin(8-993-2253)\t-Consiglieri, Alberto(20-70-3971)\n\t\t-De los Santos, David(8-974-141)\t-Lorenzo, Karen(8-987-1549)\t-Vargas, Johana(8-1004-1648)");
        textArea1.setEditable(false);
        textArea1.setOpaque(false);
        textArea1.setBounds(0, 0, 50, 50);
        center.setLayout(new GridLayout(3,1));
        this.add(textArea1, BorderLayout.CENTER);
    }
}
