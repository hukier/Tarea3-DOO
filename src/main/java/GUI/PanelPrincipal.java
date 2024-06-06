package GUI;

import javax.swing.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador panelComprador;
    private PanelExpendedor panelExpendedor;

    public PanelPrincipal(){
        setLayout(null);

        panelComprador = new PanelComprador();
        //panelExpendedor = new PanelExpendedor();



        //Crear el fondo
        ImageIcon imagenFondo = new ImageIcon("src/main/java/resources/Fondo.png");
        JLabel labelFondo = new JLabel();
        labelFondo.setIcon(imagenFondo);
        labelFondo.setBounds(0, 0, imagenFondo.getIconWidth(), imagenFondo.getIconHeight());
        this.add(labelFondo);

        //Crear imagen de Moneda100
        ImageIcon imagenMoneda100 = new ImageIcon("src/main/java/resources/Moneda100.png");
        JLabel labelMoneda100 = new JLabel();
        labelMoneda100.setIcon(imagenMoneda100);
        labelMoneda100.setBounds(150, 100, imagenMoneda100.getIconWidth(), imagenMoneda100.getIconHeight());
        this.add(labelMoneda100);

        //Crear imagen de Moneda500
        ImageIcon imagenMoneda500 = new ImageIcon("src/main/java/resources/Moneda500.png");
        JLabel labelMoneda500 = new JLabel();
        labelMoneda500.setIcon(imagenMoneda500);
        labelMoneda500.setBounds(150+120, 100, imagenMoneda500.getIconWidth(), imagenMoneda500.getIconHeight());
        this.add(labelMoneda500);

        //Crear imagen de Moneda1000
        ImageIcon imagenMoneda1000 = new ImageIcon("src/main/java/resources/Moneda1000.png");
        JLabel labelMoneda1000 = new JLabel();
        labelMoneda1000.setIcon(imagenMoneda1000);
        labelMoneda1000.setBounds(210, 100+120, imagenMoneda500.getIconWidth(), imagenMoneda500.getIconHeight());
        this.add(labelMoneda1000);

        /*
        // Crear el botón invisible
        JButton botonMoneda = new JButton();
        botonMoneda.setBounds(150, 100, imagenMoneda100.getIconWidth(), imagenMoneda100.getIconHeight());
        botonMoneda.setOpaque(false);
        botonMoneda.setContentAreaFilled(false);
        botonMoneda.setBorderPainted(false);
        botonMoneda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción al hacer clic en el botón
                System.out.println("¡Botón presionado!");
            }
        });
        this.add(botonMoneda);
        */
        this.setComponentZOrder(labelFondo, this.getComponentCount() - 1);

    }
}
