package GUI;

import java.awt.*;
import javax.swing.*;

public class PanelPrincipal extends JPanel {

    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal() {
        setLayout(new BorderLayout()); // Usar BorderLayout para organización

        // Inicializar los paneles
        exp = new PanelExpendedor(5);
        com = new PanelComprador();

        // Añadir los paneles al PanelPrincipal

        add(com, BorderLayout.SOUTH);
        add(exp, BorderLayout.CENTER);
        // Ejemplo de adición, ajusta según sea necesario
    }
}