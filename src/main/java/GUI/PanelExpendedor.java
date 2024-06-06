package GUI;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

import backend.*;
import backend.Excepciones.NoHayProductoException;
import backend.Excepciones.PagoIncorrectoException;
import backend.Excepciones.PagoInsuficienteException;
import backend.Monedas.Moneda;

public class PanelExpendedor extends JPanel implements ActionListener {

    // boton para comprar
    private JButton boton_comprar;
    // boton para recoger producto
    private JButton boton_recoger;

    // boton fanta
    private JButton boton_Fanta;
    // boton coca cola
    private JButton boton_Coca_Cola;
    // boton sprite
    private JButton boton_Sprite;

    // boton snickers
    private JButton boton_Snickers;
    // boton super8
    private JButton boton_Super8;

    // boton rellenar expendedor
    private JButton boton_rellenar;

    // LABELS //

    // Labels fanta
    private ArrayList<JLabel> labels_fanta;
    // Labels coca cola
    private ArrayList<JLabel> labels_coca_cola;
    // Labels sprite
    private ArrayList<JLabel> labels_sprite;
    // Labels snickers
    private ArrayList<JLabel> labels_snickers;
    // Labels super8
    private ArrayList<JLabel> labels_super8;

    // Labels precio
    private JLabel label_precio;

    // Labels para productos borrados
    private JLabel label_borrado = null;

    // PANELES //
    // Panel de botones expendedor
    public JPanel panel_botones;
    // panel contenedor de monedas
    public JPanel contenedor_monedas;
    // panel contenedor de productos
    public JPanel contenedor_productos;
    public JPanel PanelVacio1;
    // exendedor inicial
    private Expendedor expendedor;
    // Moneda
    private Moneda moneda;
    // Comprador que interactua con el expendedor
    private Comprador comprador;

    // //
    private int seleccion = 0;
    private int sumaCocacola = 0;
    private int sumaFanta = 0;
    private int sumaSprite = 0;
    private int sumaSnickers = 0;
    private int sumaSuper8 = 0;

    int vuelto = 0;

    int velocidadEjeX = 3; // Velocidad de movimiento en el eje X 3 pixeles
    int velocidadEjeY = 3; // Velocidad de movimiento en el eje Y 3 pixeles

    int pos_baseX;
    int pos_baseY;

    Image fanta;
    Image coca_cola;
    Image sprite;
    Image snickers;
    Image super8;

    BufferedImage background;
    Timer timerCompra;

    boolean productoBorrado = false;

    public Inventario inventario;

    public PanelExpendedor() {
        this.setLayout(new BorderLayout());

        fanta = new ImageIcon("fotofanta").getImage();
        coca_cola = new ImageIcon("fotococa_cola").getImage();
        sprite = new ImageIcon("fotosprite").getImage();
        snickers = new ImageIcon("fotosnickers").getImage();
        super8 = new ImageIcon("fotosuper8").getImage();

        // inventario = new Inventario(sumaCocacola, sumaFanta, sumaSprite,
        // sumaSnickers, sumaSuper8);

        expendedor = new Expendedor(5);
        this.setPreferredSize(new Dimension(777, 1000)); // numeros al azar xd

        panel_botones = new JPanel();

        this.add(panel_botones, BorderLayout.EAST);
        panel_botones.setLayout(new BoxLayout(panel_botones, BoxLayout.Y_AXIS));
        panel_botones.setOpaque(false);
        panel_botones.setPreferredSize(new Dimension(200, 0));

        // TABLERO //

        panel_botones.add(Box.createVerticalStrut(30));
        Font fuente = new Font("Arial", Font.BOLD, 20);
        label_precio = new JLabel("");
        label_precio.setOpaque(true);
        label_precio.setFont(fuente);
        label_precio.setBackground(Color.BLACK);
        label_precio.setForeground(Color.WHITE);
        label_precio.setPreferredSize(new Dimension(200, 50));
        label_precio_act(label_precio, "Precio:  ");
        panel_botones.add(label_precio);
        panel_botones.add(Box.createVerticalStrut(30));

        boton_Fanta = new JButton("Fanta");
        boton_Fanta.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boton_Fanta.setFocusable(false);
        boton_Fanta.setForeground(Color.WHITE);
        boton_Fanta.setBackground(Color.ORANGE);
        boton_Fanta.add(boton_Fanta, 1);
        panel_botones.add(Box.createVerticalStrut(10));

        boton_Sprite = new JButton("Sprite");
        boton_Sprite.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boton_Sprite.setFocusable(false);
        boton_Sprite.setForeground(Color.WHITE);
        boton_Sprite.setBackground(Color.GREEN);
        boton_Sprite.add(boton_Sprite, 2);
        panel_botones.add(Box.createVerticalStrut(10));

        boton_Coca_Cola = new JButton("Coca Cola");
        boton_Coca_Cola.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boton_Coca_Cola.setFocusable(false);
        boton_Coca_Cola.setForeground(Color.WHITE);
        boton_Coca_Cola.setBackground(Color.RED);
        boton_Coca_Cola.add(boton_Coca_Cola, 3);
        panel_botones.add(Box.createVerticalStrut(10));

        boton_Snickers = new JButton("Snickers");
        boton_Snickers.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boton_Snickers.setFocusable(false);
        boton_Snickers.setForeground(Color.WHITE);
        boton_Snickers.setBackground(new Color(80, 60, 50));
        boton_Snickers.add(boton_Snickers, 4);
        panel_botones.add(Box.createVerticalStrut(10));

        boton_Super8 = new JButton("Super8");
        boton_Super8.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boton_Super8.setFocusable(false);
        boton_Super8.setForeground(Color.WHITE);
        boton_Super8.setBackground(Color.YELLOW);
        boton_Super8.add(boton_Super8, 5);
        panel_botones.add(Box.createVerticalStrut(10)); // revisar, puede ser mas

        boton_comprar = new JButton("Comprar");
        boton_comprar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boton_comprar.setFocusable(false);
        boton_comprar.setForeground(Color.WHITE);
        boton_comprar.setBackground(Color.BLUE);
        boton_comprar.setEnabled(false);
        boton_comprar.add(boton_comprar);
        panel_botones.add(Box.createVerticalStrut(20));

        boton_recoger = new JButton("Recoger");
        boton_recoger.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boton_recoger.setFocusable(false);
        boton_recoger.setForeground(Color.WHITE);
        boton_recoger.setBackground(new Color(40, 39, 53));
        boton_recoger.setEnabled(false);
        this.add(boton_recoger);

        boton_rellenar = new JButton("Rellenar");
        boton_rellenar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boton_rellenar.setFocusable(false);
        boton_rellenar.setBackground(Color.BLACK);
        boton_rellenar.setForeground(Color.WHITE);
        boton_rellenar.setToolTipText("Rellenar el expendedor");
        boton_rellenar.add(boton_rellenar);
        panel_botones.add(Box.createVerticalStrut(10));

        contenedor_monedas = new JPanel();
        this.add(contenedor_monedas);
        contenedor_monedas.setLayout(new FlowLayout());
        contenedor_monedas.setOpaque(false);
        contenedor_monedas.setBounds(552, 520, 200, 200);

        // CODIGO DE LOS PRODUCTOS //

        JPanel PanelVacio = new JPanel();
        PanelVacio.setOpaque(false);
        this.add(PanelVacio, BorderLayout.NORTH);

        PanelVacio1 = new JPanel();
        PanelVacio1.setOpaque(false);
        PanelVacio1.setLayout(null);
        this.add(PanelVacio1, BorderLayout.SOUTH);
        PanelVacio1.setPreferredSize(new Dimension(0, 250));

        contenedor_productos = new JPanel();
        this.add(contenedor_productos, BorderLayout.CENTER);
        contenedor_productos.setOpaque(false);
        contenedor_productos.setLayout(null);

        // Label de las imagenes //

        labels_fanta = new ArrayList<JLabel>();
        labels_coca_cola = new ArrayList<JLabel>();
        labels_sprite = new ArrayList<JLabel>();
        labels_snickers = new ArrayList<JLabel>();
        labels_super8 = new ArrayList<JLabel>();

        ProductosImagen(fanta, labels_fanta, expendedor.fanta);
        ProductosImagen(coca_cola, labels_coca_cola, expendedor.coca);
        ProductosImagen(sprite, labels_sprite, expendedor.sprite);
        ProductosImagen(snickers, labels_snickers, expendedor.snickers);
        ProductosImagen(super8, labels_super8, expendedor.super8);

        timerCompra = new Timer(30, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton_Fanta) {
            label_precio_act(label_precio, "Precio:  " + Precios.Fanta.getPrecio()); // precio de la fanta
            seleccion = Expendedor.FANTA; // seleccion de la fanta
            boton_comprar.setEnabled(true);
            repaint();
        }

        else if (e.getSource() == boton_Sprite) {
            label_precio_act(label_precio, "Precio:  " + Precios.Sprite.getPrecio()); // precio de la sprite
            seleccion = Expendedor.SPRITE; // seleccion de la sprite
            boton_comprar.setEnabled(true);
            repaint();
        }

        else if (e.getSource() == boton_Coca_Cola) {
            label_precio_act(label_precio, "Precio:  " + Precios.CocaCola.getPrecio()); // precio de la coca cola
            seleccion = Expendedor.COCACOLA; // seleccion de la coca cola
            boton_comprar.setEnabled(true);
            repaint();
        }

        else if (e.getSource() == boton_Snickers) {
            label_precio_act(label_precio, "Precio:  " + Precios.Snickers.getPrecio()); // precio de la snickers
            seleccion = Expendedor.SNICKERS; // seleccion de la snickers
            boton_comprar.setEnabled(true);
            repaint();
        }

        else if (e.getSource() == boton_Super8) {
            label_precio_act(label_precio, "Precio:  " + Precios.Super8.getPrecio()); // precio de la super8
            seleccion = Expendedor.SUPER8; // seleccion de la super8
            boton_comprar.setEnabled(true);
            repaint();
        }

        else if (e.getSource() == boton_recoger) {
            productoBorrado = false;
            boton_comprar.setEnabled(false);
            if (!Expendedor.coca.checkSize()) {
                boton_Coca_Cola.setEnabled(true);
            }
            if (!Expendedor.fanta.checkSize()) {
                boton_Fanta.setEnabled(true);
            }
            if (!Expendedor.sprite.checkSize()) {
                boton_Sprite.setEnabled(true);
            }
            if (!Expendedor.snickers.checkSize()) {
                boton_Snickers.setEnabled(true);
            }
            if (!Expendedor.super8.checkSize()) {
                boton_Super8.setEnabled(true);
            }
            boton_recoger.setEnabled(false);
            seleccion = 0;
        }

        else if (e.getSource() == boton_comprar) {
            label_precio_act(label_precio, "Precio:  ");
            boton_recoger.setEnabled(true);
            comprasComprador(seleccion);
            boton_comprar.setEnabled(false);
            boton_Coca_Cola.setEnabled(false);
            boton_Fanta.setEnabled(false);
            boton_Sprite.setEnabled(false);
            boton_Snickers.setEnabled(false);
            boton_Super8.setEnabled(false);
            repaint();
        }

        else if (e.getSource() == boton_rellenar) {
            expendedor = new Expendedor(5);
            ProductosImagen(fanta, labels_fanta, Expendedor.fanta);
            ProductosImagen(coca_cola, labels_coca_cola, Expendedor.coca);
            ProductosImagen(sprite, labels_sprite, Expendedor.sprite);
            ProductosImagen(snickers, labels_snickers, Expendedor.snickers);
            ProductosImagen(super8, labels_super8, Expendedor.super8);
            boton_Fanta.setEnabled(true);
            boton_Sprite.setEnabled(true);
            boton_Coca_Cola.setEnabled(true);
            boton_Snickers.setEnabled(true);
            boton_Super8.setEnabled(true);
            repaint();
        }

        else if (e.getSource() == timerCompra) {
            if (seleccion == Expendedor.FANTA) {
                if (pos_baseX <= 150) {
                    pos_baseX += velocidadEjeX;
                } else {
                    if (pos_baseY < 500) {
                        pos_baseY += velocidadEjeY;
                    } else {
                        timerCompra.stop();
                        productoBorrado = false;
                    }
                }
            }

            if (seleccion == Expendedor.COCACOLA) {
                if (pos_baseX <= 150) {
                    pos_baseX += velocidadEjeX;
                } else {
                    if (pos_baseY >= 500) {
                        pos_baseY += velocidadEjeY;
                    } else {
                        timerCompra.stop();
                        productoBorrado = false;
                    }
                }
            }

            if (seleccion == Expendedor.SPRITE) {
                if (pos_baseX <= 150) {
                    pos_baseX += velocidadEjeX;
                } else {
                    if (pos_baseY < 500) {
                        pos_baseY += velocidadEjeY;
                    } else {
                        timerCompra.stop();
                        productoBorrado = false;
                    }
                }
            }

            if (seleccion == Expendedor.SNICKERS) {
                if (pos_baseX <= 150) {
                    pos_baseX += velocidadEjeX;
                } else {
                    if (pos_baseY >= 500) {
                        pos_baseY += velocidadEjeY;
                    } else {
                        timerCompra.stop();
                        productoBorrado = false;
                    }
                }
            }

            if (seleccion == Expendedor.SUPER8) {
                if (pos_baseX <= 150) {
                    pos_baseX += velocidadEjeX;
                } else {
                    if (pos_baseY < 500) {
                        pos_baseY += velocidadEjeY;
                    } else {
                        timerCompra.stop();
                        productoBorrado = false;
                    }
                }
            }
        }

        repaint();
    }

    private void comprasComprador(int producto) {
        try {
            comprador = new Comprador(moneda, Precios.values()[producto], expendedor);
            actualizarInventario(seleccion);
            productoBorrado = true;

            if (seleccion == Expendedor.FANTA) {
                ProductosImagen(fanta, labels_fanta, Expendedor.fanta);
                int dep_size = Expendedor.fanta.getSize();
                pos_baseX = 63 + (dep_size * 10) + 10;
                pos_baseY = 180;
                repaint();
            } else if (seleccion == Expendedor.COCACOLA) {
                ProductosImagen(coca_cola, labels_coca_cola, Expendedor.coca);
                int dep_size = Expendedor.coca.getSize();
                pos_baseX = 255 + (dep_size * 10) + 10;
                pos_baseY = 380;
                repaint();
            } else if (seleccion == Expendedor.SPRITE) {
                ProductosImagen(sprite, labels_sprite, Expendedor.sprite);
                int dep_size = Expendedor.sprite.getSize();
                pos_baseX = 63 + (dep_size * 10) + 10;
                pos_baseY = 180;
                repaint();
            } else if (seleccion == Expendedor.SNICKERS) {
                ProductosImagen(snickers, labels_snickers, Expendedor.snickers);
                int dep_size = Expendedor.snickers.getSize();
                pos_baseX = 45 + (dep_size * 10) + 10;
                pos_baseY = 17;
                repaint();
            } else if (seleccion == Expendedor.SUPER8) {
                ProductosImagen(super8, labels_super8, Expendedor.super8);
                int dep_size = Expendedor.super8.getSize();
                pos_baseX = 63 + (dep_size * 10) + 10;
                pos_baseY = 30;
                repaint();
            }
        } catch (PagoIncorrectoException e) {
            JOptionPane.showMessageDialog(null, "Pago incorrecto");
        } catch (PagoInsuficienteException e) {
            JOptionPane.showMessageDialog(null, "Pago insuficiente");
        } catch (NoHayProductoException e) {
            JOptionPane.showMessageDialog(null, "No hay producto");
        }
    }

    /**
     * 
     * @param seleccion numero del producto que se compra
     */
    public void actualizarInventario(int seleccion) {
        switch (seleccion) {
            case 1:
                inventario.modificar(1);
                break;
            case 2:
                inventario.modificar(2);
                break;
            case 3:
                inventario.modificar(3);
                break;
            case 4:
                inventario.modificar(4);
                break;
            case 5:
                inventario.modificar(5);
                break;
        }
    }

    public void label_precio_act(JLabel label, String texto) {
        label.setText(texto);
    }

    /**
     * 
     * @param imagen   para imagen de los productos
     * @param labels   arraylist con las imagenes
     * @param deposito deposito de productos en stock
     */
    public void ProductosImagen(Image imagen, ArrayList<JLabel> labels,
            @SuppressWarnings("rawtypes") Deposito deposito) {
        labels.clear();
        for (int i = 0; i < deposito.getSize(); i++) {
            JLabel label = new JLabel(new ImageIcon(imagen));
            labels.add(label);
            contenedor_productos.add(label);
        }
        contenedor_productos.revalidate();
        contenedor_productos.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        contenedor_productos.removeAll();

        int i = 0;
        for (JLabel label : labels_fanta) {
            i += 10;
            g2.drawImage(fanta, 63 + i, 205, null);
            contenedor_productos.add(label);
        }

        i = 0;
        for (JLabel label : labels_coca_cola) {
            i += 10;
            g2.drawImage(coca_cola, 255 + i, 405, null);
            contenedor_productos.add(label);
        }

        i = 0;
        for (JLabel label : labels_sprite) {
            i += 10;
            g2.drawImage(sprite, 63 + i, 205, null);
            contenedor_productos.add(label);
        }

        i = 0;
        for (JLabel label : labels_snickers) {
            i += 10;
            g2.drawImage(snickers, 45 + i, 42, null);
            contenedor_productos.add(label);
        }

        i = 0;
        for (JLabel label : labels_super8) {
            i += 10;
            g2.drawImage(super8, 63 + i, 55, null);
            contenedor_productos.add(label);
        }

        if (productoBorrado && seleccion == Expendedor.FANTA) {
            label_borrado = new JLabel(new ImageIcon(fanta));
            label_borrado.setBounds(pos_baseX, pos_baseY, 160, 120);
            contenedor_productos.add(label_borrado);
            timerCompra.start();
        } else if (productoBorrado && seleccion == Expendedor.COCACOLA) {
            label_borrado = new JLabel(new ImageIcon(coca_cola));
            label_borrado.setBounds(pos_baseX, pos_baseY, 160, 120);
            contenedor_productos.add(label_borrado);
            timerCompra.start();
        } else if (productoBorrado && seleccion == Expendedor.SPRITE) {
            label_borrado = new JLabel(new ImageIcon(sprite));
            label_borrado.setBounds(pos_baseX, pos_baseY, 160, 120);
            contenedor_productos.add(label_borrado);
            timerCompra.start();
        } else if (productoBorrado && seleccion == Expendedor.SNICKERS) {
            label_borrado = new JLabel(new ImageIcon(snickers));
            label_borrado.setBounds(pos_baseX, pos_baseY, 160, 120);
            contenedor_productos.add(label_borrado);
            timerCompra.start();
        } else if (productoBorrado && seleccion == Expendedor.SUPER8) {
            label_borrado = new JLabel(new ImageIcon(super8));
            label_borrado.setBounds(pos_baseX, pos_baseY, 160, 120);
            contenedor_productos.add(label_borrado);
            timerCompra.start();

        }

        PanelVacio1.repaint();
        contenedor_productos.repaint();

    }

}
