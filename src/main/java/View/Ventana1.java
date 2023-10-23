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
    private JButton analizarButton;
    private JTable table1;
    private JTable table2;
    private JTextArea textArea1;
    private JButton borrarSeleccionadoButton;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton añadirDatosButton;
    private JButton actualizarSeleccionadoButton;
    private JButton exportarAFicheroJSONButton;
    private JButton exportarAFicheroXMLButton1;
    private JButton exportarAFicheroXMLButton;
    private JButton importarDeFicheroJSONButton;
    private JButton convertirXMLAJSONButton;

    public static void main(String[] args) {
        new Ventana1();
    }
}
