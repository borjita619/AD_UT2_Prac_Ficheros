package View;

import javax.swing.*;
import java.awt.*;

public class Ventana1 extends JFrame {
    public Ventana1() {
        setTitle("GESTOR GIMNASIO");
        setContentPane(panelPadre);
        setMaximumSize(new Dimension(1200,700));
        setLocationRelativeTo(getParent());
        setVisible(true);
    }

    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel panelPadre;
}
