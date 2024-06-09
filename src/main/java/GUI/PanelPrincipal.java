package GUI;

import java.awt.*;
import javax.swing.*;

/**
 * @author Roberto Cruz
 *         Esta clase representa el panel principal de la interfaz gráfica de
 *         usuario
 *         para la máquina expendedora.
 *         Contiene un PanelComprador y un PanelExpendedor, que se colocan en la
 *         parte
 *         sur y central del panel, respectivamente.
 */
public class PanelPrincipal extends JPanel {

    // Panel para el comprador
    private PanelComprador com;
    // Panel para el expendedor
    private PanelExpendedor exp;

    /**
     * Constructor para el PanelPrincipal.
     * Inicializa los paneles y los añade al PanelPrincipal.
     */

    public PanelPrincipal() {
        // Establecer el layout del panel como BorderLayout
        setLayout(new BorderLayout());

        // Inicializar el panel del expendedor con 5 espacios
        exp = new PanelExpendedor(5);
        // Inicializar el panel del comprador
        com = new PanelComprador();

        // Añadir el panel del comprador a la parte sur del PanelPrincipal
        add(com, BorderLayout.SOUTH);
        // Añadir el panel del expendedor a la parte central del PanelPrincipal
        add(exp, BorderLayout.CENTER);
    }
}