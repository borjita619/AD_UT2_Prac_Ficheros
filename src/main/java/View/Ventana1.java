package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class Ventana1 extends JFrame {
    final String rutaAAnalizar="C:\\_Pruebas_Programacion";
    public Ventana1() {
        setTitle("GESTOR GIMNASIO");
        setContentPane(panelPadre);
        setMinimumSize(new Dimension(1200,700));
        setLocationRelativeTo(getParent());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        textFieldRutaActual.setText(rutaAAnalizar);
        examinarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

                int result = fileChooser.showOpenDialog(null);

                if (result != JFileChooser.CANCEL_OPTION) {

                    File fileName = fileChooser.getSelectedFile();

                    if ((fileName == null) || (fileName.getName().equals(""))) {
                        textFieldRutaActual.setText("...");
                    } else {
                        textFieldRutaActual.setText(fileName.getAbsolutePath());
                    }
                }
            }
        });
    }

    private JTextField textFieldRutaActual;
    private JButton examinarButton;
    private JButton nuevoButton;
    private JButton renombrarSeleccionadoButton;
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
        new Ventana1().setVisible(true);


    }
}
