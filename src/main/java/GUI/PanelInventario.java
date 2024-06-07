package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInventario extends JPanel implements ActionListener {

    public int inv_cocacola = 0;
    public int inv_fanta = 0;
    public int inv_sprite = 0;
    public int inv_snickers = 0;
    public int inv_super8 = 0;
    public int billeteraCompra = 0;

    private JButton consumirCocacola;
    private JButton consumirFanta;
    private JButton consumirSprite;
    private JButton consumirSnickers;
    private JButton consumirSuper8;

    private Image cocacola;
    private Image fanta;
    private Image sprite;
    private Image snickers;
    private Image super8;

    JLabel dinero;
    JLabel labelCocacola;
    JLabel labelFanta;
    JLabel labelSprite;
    JLabel labelSnickers;
    JLabel labelSuper8;
    JLabel cuantaFanta;
    JLabel cuantaCocacola;
    JLabel cuantaSprite;
    JLabel cuantaSnickers;
    JLabel cuantaSuper8;

    /**
     * @param billetera
     */
    public PanelInventario(int billetera) {
        this.setLayout(null);

        billeteraCompra = billetera;

        // Imagenes
        fanta = new ImageIcon("src/main/java/GUI/Imagenes/fanta.png").getImage();
        cocacola = new ImageIcon("src/main/java/GUI/Imagenes/cocacola.png").getImage();
        sprite = new ImageIcon("src/main/java/GUI/Imagenes/sprite.png").getImage();
        snickers = new ImageIcon("src/main/java/GUI/Imagenes/snickers.png").getImage();
        super8 = new ImageIcon("src/main/java/GUI/Imagenes/super8.png").getImage();

        // escalado de imagenes
        fanta = escalarImagen(fanta, 50, 50);
        cocacola = escalarImagen(cocacola, 50, 50);
        sprite = escalarImagen(sprite, 50, 50);
        snickers = escalarImagen(snickers, 50, 50);
        super8 = escalarImagen(super8, 50, 50);

        // Label Img
        dinero = new JLabel();

        labelFanta = new JLabel(new ImageIcon(fanta));
        labelCocacola = new JLabel(new ImageIcon(cocacola));
        labelSprite = new JLabel(new ImageIcon(sprite));
        labelSnickers = new JLabel(new ImageIcon(snickers));
        labelSuper8 = new JLabel(new ImageIcon(super8));

        // Fuente
        Font fuente = new Font("Arial", Font.BOLD, 15);
        Font fuenteBoton = new Font("Arial", Font.BOLD, 10);

        // personalizar label
        dinero.setOpaque(true);
        dinero.setFont(fuente);
        dinero.setBackground(new Color(0x0000));
        dinero.setForeground(Color.white);
        dinero.setPreferredSize(new Dimension(200, 60));

        // agregar label al panel
        this.add(dinero);
        this.add(labelCocacola);
        this.add(labelFanta);
        this.add(labelSprite);
        this.add(labelSnickers);
        this.add(labelSuper8);

        dinero.setBounds(10, 10, 200, 60);
        labelCocacola.setBounds(10, 80, 50, 50);
        labelFanta.setBounds(10, 140, 50, 50);
        labelSprite.setBounds(10, 200, 50, 50);
        labelSnickers.setBounds(10, 260, 50, 50);
        labelSuper8.setBounds(10, 320, 50, 50);

        // Botones
        consumirCocacola = new JButton("Consumir");
        consumirFanta = new JButton("Consumir");
        consumirSprite = new JButton("Consumir");
        consumirSnickers = new JButton("Consumir");
        consumirSuper8 = new JButton("Consumir");

        consumirCocacola.setFont(fuenteBoton);
        consumirFanta.setFont(fuenteBoton);
        consumirSprite.setFont(fuenteBoton);
        consumirSnickers.setFont(fuenteBoton);
        consumirSuper8.setFont(fuenteBoton);

        // agregar botones al panel
        this.add(consumirCocacola);
        this.add(consumirFanta);
        this.add(consumirSprite);
        this.add(consumirSnickers);
        this.add(consumirSuper8);

        consumirCocacola.setBounds(100, 80, 100, 50);
        consumirFanta.setBounds(100, 140, 100, 50);
        consumirSprite.setBounds(100, 200, 100, 50);
        consumirSnickers.setBounds(100, 260, 100, 50);
        consumirSuper8.setBounds(100, 320, 100, 50);

        // Labels de cauntos productos hay
        cuantaCocacola = new JLabel();
        cuantaFanta = new JLabel();
        cuantaSprite = new JLabel();
        cuantaSnickers = new JLabel();
        cuantaSuper8 = new JLabel();

        // añadir label de productos en panel
        this.add(cuantaCocacola);
        this.add(cuantaFanta);
        this.add(cuantaSprite);
        this.add(cuantaSnickers);
        this.add(cuantaSuper8);

        cuantaCocacola.setBounds(220, 80, 50, 50);
        cuantaFanta.setBounds(220, 140, 50, 50);
        cuantaSprite.setBounds(220, 200, 50, 50);
        cuantaSnickers.setBounds(220, 260, 50, 50);
        cuantaSuper8.setBounds(220, 320, 50, 50);

        // Action Listener
        consumirCocacola.addActionListener(this);
        consumirFanta.addActionListener(this);
        consumirSprite.addActionListener(this);
        consumirSnickers.addActionListener(this);
        consumirSuper8.addActionListener(this);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private Image escalarImagen(Image image, int ancho, int alto) {
        return image.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
    }

    public void cambiarTexto(JLabel label, String texto) {
        label.setText(texto);
    }

    public void modificarInventario() {
        cambiarTexto(dinero, "Dinero: " + billeteraCompra);
        cambiarTexto(cuantaCocacola, "Cantidad: " + inv_cocacola);
        cambiarTexto(cuantaFanta, "Cantidad: " + inv_fanta);
        cambiarTexto(cuantaSprite, "Cantidad: " + inv_sprite);
        cambiarTexto(cuantaSnickers, "Cantidad: " + inv_snickers);
        cambiarTexto(cuantaSuper8, "Cantidad: " + inv_super8);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == consumirCocacola) {
            inv_cocacola--;
            modificarInventario();
        }
        if (e.getSource() == consumirFanta) {
            inv_fanta--;
            modificarInventario();
        }
        if (e.getSource() == consumirSprite) {
            inv_sprite--;
            modificarInventario();
        }
        if (e.getSource() == consumirSnickers) {
            inv_snickers--;
            modificarInventario();
        }
        if (e.getSource() == consumirSuper8) {
            inv_super8--;
            modificarInventario();
        }
        repaint();
    }

}
