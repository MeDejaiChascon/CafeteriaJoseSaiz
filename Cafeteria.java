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
                        // Crear el botón correspondiente a cada línea del archivo
                        JButton botonCafe = new JButton(linea);
                        // Agregar el ActionListener correspondiente al botón
                        String finalLinea = linea;
                        botonCafe.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                // Aquí se podría implementar la funcionalidad de agregar el café al pedido
                                JFrame ventanaCafe = new JFrame("Seleccionar café");
                                ventanaCafe.setSize(400, 400);
                                ventanaCafe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                ventanaCafe.setLocationRelativeTo(null);

                                JPanel panelCafe = new JPanel();
                                panelCafe.setLayout(new BoxLayout(panelCafe, BoxLayout.Y_AXIS));

// Agregar botones de opción para seleccionar el tamaño del café
                                JLabel labelTamaño = new JLabel("Tamaño:");
                                JRadioButton pequeño = new JRadioButton("Pequeño");
                                JRadioButton mediano = new JRadioButton("Mediano");
                                JRadioButton grande = new JRadioButton("Grande");
                                ButtonGroup grupoTamaño = new ButtonGroup();
                                grupoTamaño.add(pequeño);
                                grupoTamaño.add(mediano);
                                grupoTamaño.add(grande);

// Agregar casillas de verificación para seleccionar los ingredientes adicionales
                                JLabel labelIngredientes = new JLabel("Ingredientes adicionales:");
                                JCheckBox crema = new JCheckBox("Crema");
                                JCheckBox leche = new JCheckBox("Leche");
                                JCheckBox chocolate = new JCheckBox("Chocolate");

                                panelCafe.add(labelTamaño);
                                panelCafe.add(pequeño);
                                panelCafe.add(mediano);
                                panelCafe.add(grande);
                                panelCafe.add(labelIngredientes);
                                panelCafe.add(crema);
                                panelCafe.add(leche);
                                panelCafe.add(chocolate);

// Agregar botón de confirmar pedido
                                JButton confirmar = new JButton("Confirmar pedido");
                                confirmar.addActionListener(a -> {
                                    // Obtener los valores seleccionados por el usuario
                                    String tamaño = "";
                                    if (pequeño.isSelected()) {
                                        tamaño = "Pequeño";
                                    } else if (mediano.isSelected()) {
                                        tamaño = "Mediano";
                                    } else if (grande.isSelected()) {
                                        tamaño = "Grande";
                                    }
                                    boolean agregarCrema = crema.isSelected();
                                    boolean agregarLeche = leche.isSelected();
                                    boolean agregarChocolate = chocolate.isSelected();

                                    // Aquí puedes agregar el código para procesar el pedido del usuario
                                    // utilizando los valores seleccionados

                                    ventanaCafe.dispose(); // Cerrar la ventana de selección de café
                                });

                                panelCafe.add(confirmar);

                                ventanaCafe.add(panelCafe);
                                ventanaCafe.setVisible(true);

                            }
                        });
                        // Agregar el botón al panel correspondiente
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
