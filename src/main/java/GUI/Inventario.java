package GUI;

import javax.swing.JFrame;
import java.awt.*;

public class Inventario extends JFrame {

    public PanelInventario panelInventario;

    /**
     * Constructor de la clase Inventario.
     */
    public Inventario() {
        panelInventario = new PanelInventario(4000);
        this.add(panelInventario);
        panelInventario.modificarInventario();
    }

    /**
     * Metodo para mostrar la ventana de inventario.
     */
    public void mostrarPanel() {
        this.setVisible(true);
        this.setTitle("Inventario");
        this.setResizable(false);
        this.setSize(320, 350); // valores al azar
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void modificar(int seleccion) { // Base de modificacion de los valores del inventario
        switch (seleccion) {
            case 1:
                panelInventario.inv_cocacola++;
                break;
            case 2:
                panelInventario.inv_fanta++;
                break;
            case 3:
                panelInventario.inv_sprite++;
                break;
            case 4:
                panelInventario.inv_snickers++;
                break;
            case 5:
                panelInventario.inv_super8++;
                break;
        }
        panelInventario.modificarInventario();

    }

}
