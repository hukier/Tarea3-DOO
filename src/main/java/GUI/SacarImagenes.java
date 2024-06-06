package GUI;

public enum SacarImagenes {

    ICONO("src/main/java/resources/IconoTarea3.PNG"),
    FONDO("src/main/java/resources/Fondo.png"),
    MONEDA100("src/main/java/resources/Moneda100.png"),
    MONEDA500("src/main/java/resources/Moneda500.png"),
    MONEDA1000("src/main/java/resources/Moneda1000.png"),
    COCACOLA("src/main/java/resources/cocacola.png"),
    FANTA("src/main/java/resources/Fanta.png"),
    SPRITE("src/main/java/resources/Sprite.png"),
    SNICKERS("Snickers"),
    SUPER8("Super8");


    private final String direccion;
    SacarImagenes(String direccion){
        this.direccion =direccion;
    }

    public String getDireccion() {
        return direccion;
    }
}
