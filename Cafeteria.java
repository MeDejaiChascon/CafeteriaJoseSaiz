//Vistas creadas con ChatGPT

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Cafeteria extends JFrame {
    public Cafeteria() {
        // Configurar la ventana principal
        setTitle("Cafetería");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el panel principal y agregarlo a la ventana
        JPanel panelPrincipal = new JPanel(new GridLayout(2, 1, 10, 10));
        add(panelPrincipal);

        // Crear los botones y agregarlos al panel principal
        JButton botonSeleccionar = new JButton("Seleccionar café");
        JButton botonCancelar = new JButton("Cancelar pedido");
        panelPrincipal.add(botonSeleccionar);
        panelPrincipal.add(botonCancelar);

        // Centrar los botones en el panel principal
        botonSeleccionar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonCancelar.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Agregar el listener al botón "Seleccionar café"
        botonSeleccionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crear la ventana de selección de café
                JFrame ventanaCafes = new JFrame("Seleccionar café");
                ventanaCafes.setSize(300, 200);
                ventanaCafes.setLocationRelativeTo(null);

                // Crear el panel de botones de café y agregarlo a la ventana
                JPanel panelCafes = new JPanel(new GridLayout(0, 1, 10, 10));
                ventanaCafes.add(panelCafes);

                // Leer el archivo de tipos de café y crear los botones correspondientes
                try {
                    File archivo = new File("tipos_cafe.txt");
                    BufferedReader br = new BufferedReader(new FileReader(archivo));
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        JButton botonCafe = new JButton(linea);
                        String finalLinea = linea;
                        botonCafe.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                // Aquí se podría implementar la funcionalidad de agregar el café al pedido
                                JOptionPane.showMessageDialog(null, "Ha seleccionado " + finalLinea);
                            }
                        });
                        panelCafes.add(botonCafe);
                    }
                    br.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "No se pudo leer el archivo de tipos de café.");
                }

                // Mostrar la ventana de selección de café
                ventanaCafes.setVisible(true);
            }
        });

        // Mostrar la ventana principal
        setVisible(true);
    }

    public static void main(String[] args) {
        new Cafeteria();
    }
}
