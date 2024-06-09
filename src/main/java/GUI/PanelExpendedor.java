package GUI;

import backend.*;
import backend.Excepciones.*;
import backend.Monedas.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PanelExpendedor extends JPanel {

    private Expendedor expendedor;
    private JLabel labelCocaCola, labelSprite, labelFanta, labelSnickers, labelSuper8;
    private JLabel labelMoneda100, labelMoneda500, labelMoneda1000;
    private JLabel monedaSeleccionada;
    private JLabel labelFondo, labelExpendedor;
    private Moneda monedaInsertada;

    public PanelExpendedor(int numEspacios) {
        setLayout(null);

        // Inicializar el expendedor
        expendedor = new Expendedor(numEspacios);

        // Crear el fondo
        ImageIcon imagenFondo = new ImageIcon("src/main/java/resources/Fondo.png");
        labelFondo = new JLabel();
        labelFondo.setIcon(imagenFondo);
        labelFondo.setBounds(0, 0, imagenFondo.getIconWidth(), imagenFondo.getIconHeight());
        this.add(labelFondo);

        // Crear y agregar etiquetas para los productos
        labelCocaCola = crearProductoLabel("src/main/java/resources/CocaCola.png", 450, 23);
        labelSprite = crearProductoLabel("src/main/java/resources/Sprite.png", 450, 150);
        labelFanta = crearProductoLabel("src/main/java/resources/Fanta.png", 450, 285);
        labelSnickers = crearProductoLabel("src/main/java/resources/Snickers.png", 450, 420);
        labelSuper8 = crearProductoLabel("src/main/java/resources/Super8.png", 450, 550);

        // Crear etiquetas para las monedas
        labelMoneda100 = crearMonedaLabel("src/main/java/resources/Moneda100.png", 100, 50);
        labelMoneda500 = crearMonedaLabel("src/main/java/resources/Moneda500.png", 200, 50);
        labelMoneda1000 = crearMonedaLabel("src/main/java/resources/Moneda1000.png", 300, 50);

        // Variable para rastrear la moneda seleccionada
        monedaSeleccionada = null;

        // Crear botones invisibles para las monedas
        crearBotonMoneda(labelMoneda100, new Moneda100());
        crearBotonMoneda(labelMoneda500, new Moneda500());
        crearBotonMoneda(labelMoneda1000, new Moneda1000());

        // Crear botones invisibles para los productos
        crearBotonProducto(labelCocaCola, Precios.CocaCola);
        crearBotonProducto(labelSprite, Precios.Sprite);
        crearBotonProducto(labelFanta, Precios.Fanta);
        crearBotonProducto(labelSnickers, Precios.Snickers);
        crearBotonProducto(labelSuper8, Precios.Super8);

        // Crear y agregar la imagen del expendedor
        ImageIcon imageExpendedor = new ImageIcon("src/main/java/resources/Expendedor.png");
        labelExpendedor = new JLabel();
        labelExpendedor.setIcon(imageExpendedor);
        labelExpendedor.setBounds(0, -35, imageExpendedor.getIconWidth(), imageExpendedor.getIconHeight());
        this.add(labelExpendedor);

        // Asegura que labelFondo esté en la capa más baja
        this.setComponentZOrder(labelFondo, this.getComponentCount() - 1);
    }

    // Método para crear etiquetas de productos
    private JLabel crearProductoLabel(String rutaImagen, int x, int y) {
        ImageIcon imagen = new ImageIcon(rutaImagen);
        JLabel label = new JLabel(imagen);
        label.setBounds(x, y, imagen.getIconWidth(), imagen.getIconHeight());
        this.add(label);
        return label;
    }

    // Método para crear etiquetas de monedas
    private JLabel crearMonedaLabel(String rutaImagen, int x, int y) {
        ImageIcon imagen = new ImageIcon(rutaImagen);
        JLabel label = new JLabel(imagen);
        label.setBounds(x, y, imagen.getIconWidth(), imagen.getIconHeight());
        this.add(label);
        return label;
    }

    // Método para crear botones invisibles para monedas
    private void crearBotonMoneda(JLabel label, Moneda moneda) {
        JButton boton = new JButton();
        boton.setBounds(label.getBounds());
        boton.setOpaque(false);
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarMoneda(label, moneda);
            }
        });
        this.add(boton);
    }

    // Método para crear botones invisibles para productos
    private void crearBotonProducto(JLabel label, Precios producto) {
        JButton boton = new JButton();
        boton.setBounds(label.getBounds());
        boton.setOpaque(false);
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(true);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprarProducto(producto);
            }
        });
        this.add(boton);
    }

    // Método para manejar la selección de monedas
    private void seleccionarMoneda(JLabel label, Moneda moneda) {
        if (monedaSeleccionada != null) {
            monedaSeleccionada.setBorder(null); // Restablecer la selección previa
        }
        monedaSeleccionada = label;
        monedaInsertada = moneda;
        monedaSeleccionada.setBorder(BorderFactory.createLineBorder(Color.RED, 2)); // Marcar la nueva selección
    }

    // Método para manejar la compra de productos
    private void comprarProducto(Precios producto) {
        if (monedaInsertada != null) {
            try {
                Producto prodComprado = expendedor.comprarBebida(producto, monedaInsertada);
                if (prodComprado != null) {
                    JOptionPane.showMessageDialog(this, "Compraste: " + prodComprado.getClass().getSimpleName());
                    switch (producto) {
                        case CocaCola:
                            eliminarProductoSeleccionado(labelCocaCola);
                            break;
                        case Sprite:
                            eliminarProductoSeleccionado(labelSprite);
                            break;
                        case Fanta:
                            eliminarProductoSeleccionado(labelFanta);
                            break;
                        case Snickers:
                            eliminarProductoSeleccionado(labelSnickers);
                            break;
                        case Super8:
                            eliminarProductoSeleccionado(labelSuper8);
                            break;
                    }
                    //eliminarMonedaSeleccionada(); // Eliminar la moneda utilizada
                }
                monedaInsertada = null;
            } catch (PagoIncorrectoException | PagoInsuficienteException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage()+"a");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Inserta una moneda primero.");
        }
    }

    private void eliminarMonedaSeleccionada() {
        if (monedaSeleccionada != null) {
            this.remove(monedaSeleccionada);
            monedaSeleccionada = null;
            this.repaint(); // Actualizar el panel después de eliminar la moneda
        }
    }
    private void eliminarProductoSeleccionado(JLabel labelProducto) {
        if (labelProducto != null) {
            this.remove(labelProducto);
            this.repaint(); // Actualizar el panel después de eliminar el producto
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Custom painting if needed
    }
}
