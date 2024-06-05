package GUI;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

import backend.*;
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
    // private JLabel label_borrado = null;

    // PANELES //
    // Panel de botones expendedor
    public JPanel panel_botones;
    // panel contenedor de monedas
    public JPanel contenedor_monedas;
    // panel contenedor de productos
    public JPanel contenedor_productos;
    public JPanel contenedor_vacio;
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

        // ................................................
    }

    public void label_precio_act(JLabel label, String texto) {
        label.setText(texto);
    }

}
