package GUI;

import javax.swing.*;

public class PanelPrincipal extends JPanel {
    public PanelPrincipal(){
        JLabel label= new JLabel();

        //Crear el fondo
        ImageIcon image = new ImageIcon("src/main/java/resources/Fondo.png");
        label.setIcon(image);
        this.add(label);

    }
}
