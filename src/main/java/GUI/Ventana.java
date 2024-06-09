package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * @author Roberto Cruz
 *         Esta clase representa la ventana principal de la interfaz gráfica de
 *         usuario para la máquina expendedora.
 *         Extiende de JFrame, por lo que hereda todas las funcionalidades de
 *         una ventana de Swing.
 *         Contiene un PanelPrincipal que se añade al centro de la ventana.
 */
public class Ventana extends JFrame {

    /**
     * Constructor para la Ventana.
     * Inicializa la ventana con un título, un icono, un tamaño y una operación de
     * cierre por defecto.
     * También crea un PanelPrincipal y lo añade al centro de la ventana.
     */
    public Ventana() {
        // Establecer el título de la ventana
        this.setTitle("Expendedor");

        // Establecer el layout de la ventana como BorderLayout
        this.setLayout(new BorderLayout());

        // Crear un icono a partir de la imagen en la ruta especificada y establecerlo
        // como el icono de la ventana
        ImageIcon icon = new ImageIcon(SacarImagenes.ICONO.getDireccion());
        this.setIconImage(icon.getImage());

        // Establecer la operación de cierre por defecto (cerrar la ventana cuando se
        // pulsa el botón de cierre)
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Establecer el tamaño de la ventana
        this.setSize(1366, 768);

        // Hacer que la ventana no sea redimensionable
        this.setResizable(false);

        // Crear un PanelPrincipal y añadirlo al centro de la ventana
        PanelPrincipal panel = new PanelPrincipal();
        this.add(panel);

        // Hacer que la ventana sea visible
        this.setVisible(true);
    }
}