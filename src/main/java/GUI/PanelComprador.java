package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Roberto Cruz
 *         Esta clase representa un panel de comprador en una interfaz gráfica.
 *         Hereda de JPanel, lo que significa que es un panel que puede contener
 *         otros componentes de Swing.
 */
public class PanelComprador extends JPanel {

    /**
     * Este es el constructor de la clase PanelComprador.
     * Configura el layout del panel como null, lo que significa que los componentes
     * se pueden posicionar absolutamente.
     */
    public PanelComprador() {
        setLayout(null);
    }
}