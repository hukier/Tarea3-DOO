package GUI;

import javax.swing.JFrame;
import java.awt.*;

/**
 * @author Martin Gonzalez
 *         Esta clase representa un inventario en una interfaz gráfica.
 *         Hereda de JFrame, lo que significa que es una ventana.
 */
public class Inventario extends JFrame {

    /**
     * PanelInventario es una clase que representa el panel de inventario.
     * Este es un miembro de la clase Inventario.
     */
    public PanelInventario panelInventario;

    /**
     * Este es el constructor de la clase Inventario.
     * Inicializa el panel de inventario y lo agrega a la ventana.
     * Luego llama a modificarInventario() en el panel de inventario.
     */
    public Inventario() {
        panelInventario = new PanelInventario(4000);
        this.add(panelInventario);
        panelInventario.modificarInventario();
    }

    /**
     * Este método muestra la ventana de inventario.
     * Configura varias propiedades de la ventana, como su visibilidad, título,
     * tamaño, etc.
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

    /**
     * Este método modifica el inventario basado en la selección del usuario.
     * La selección del usuario se pasa como un entero.
     * Dependiendo de la selección, se incrementa el inventario correspondiente.
     * Luego llama a modificarInventario() en el panel de inventario.
     *
     * @param seleccion La selección del usuario, representada como un entero.
     */
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