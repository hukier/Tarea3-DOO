package GUI;

/**
 * @author Roberto Cruz
 *         Enumeración para manejar las rutas de las imágenes utilizadas en la
 *         interfaz
 *         gráfica de usuario.
 *         Cada constante de la enumeración representa una imagen y tiene
 *         asociada una
 *         ruta a la imagen.
 */
public enum SacarImagenes {

    // Ruta a la imagen del icono
    ICONO("src/main/java/resources/IconoTarea3.PNG"),
    // Ruta a la imagen del fondo
    FONDO("src/main/java/resources/Fondo.png"),
    // Ruta a la imagen de la moneda de 100
    MONEDA100("src/main/java/resources/Moneda100.png"),
    // Ruta a la imagen de la moneda de 500
    MONEDA500("src/main/java/resources/Moneda500.png"),
    // Ruta a la imagen de la moneda de 1000
    MONEDA1000("src/main/java/resources/Moneda1000.png"),
    // Ruta a la imagen de la Coca-Cola
    COCACOLA("src/main/java/resources/cocacola.png"),
    // Ruta a la imagen de la Fanta
    FANTA("src/main/java/resources/Fanta.png"),
    // Ruta a la imagen del Sprite
    SPRITE("src/main/java/resources/Sprite.png"),
    // Ruta a la imagen del Snickers
    SNICKERS("Snickers"),
    // Ruta a la imagen del Super8
    SUPER8("Super8");

    // Variable para almacenar la ruta de la imagen
    private final String direccion;

    /**
     * Constructor de la enumeración.
     * 
     * @param direccion la ruta a la imagen.
     */
    SacarImagenes(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método para obtener la ruta de la imagen.
     * 
     * @return la ruta de la imagen.
     */
    public String getDireccion() {
        return direccion;
    }
}