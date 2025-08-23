public abstract class Figura {
    protected String color;

    public Figura(String color) {
        this.color = color;
    }

    // Método que imprime información de la figura
    public void imprimir() {
        System.out.println("Soy una figura de color: " + color);
    }

    public void cambiarColor(String nuevoColor) {
        this.color = nuevoColor;
    }

    // Métodos abstractos que deben implementar las subclases
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
}
