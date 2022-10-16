
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NumerosSecretos {
    public static void main(String args[]) {
        JFrame Demo_Frame = new JFrame("Demo Frame");
        Demo_Frame.setLayout(new BorderLayout());
        Demo_Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Demo_Frame.setSize(250,100);

        final JLabel J_Label = new JLabel("Original Label");
        JButton J_Button = new JButton("Change Label");
        J_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                J_Label.setText("New Label");
            }
        });

        Demo_Frame.add(J_Label, BorderLayout.NORTH);
        Demo_Frame.add(J_Button, BorderLayout.CENTER);
        Demo_Frame.setVisible(true);
    }

}