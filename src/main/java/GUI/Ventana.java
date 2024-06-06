package GUI;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public Ventana(){


        this.setTitle("Expendedor");
        this.setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon(SacarImagenes.ICONO.getDireccion());
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setSize(1366,768);
        this.setResizable(false);

        PanelPrincipal panel = new PanelPrincipal();
        this.add(panel);


        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }

}
