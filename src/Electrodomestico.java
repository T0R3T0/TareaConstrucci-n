package electrodomesticos;

public class Electrodomestico {

    // Constantes por defecto
    private static final double PRECIO_BASE_DEF = 100;
    private static final String COLOR_DEF = "blanco";
    private static final char CONSUMO_DEF = 'F';
    private static final double PESO_DEF = 5;

    // Colores disponibles
    private static final String[] COLORES_DISPONIBLES = {"blanco", "negro", "rojo", "azul", "gris"};

    // Atributos
    private double precioBase;
    private String color;
    private char consumoEnergetico;
    private double peso;

    // Constructor por defecto
    public Electrodomestico() {
        this.precioBase = PRECIO_BASE_DEF;
        this.color = COLOR_DEF;
        this.consumoEnergetico = CONSUMO_DEF;
        this.peso = PESO_DEF;
    }

    // Constructor con precio y peso
    public Electrodomestico(double precioBase, double peso) {
        this.precioBase = precioBase;
        this.color = COLOR_DEF;
        this.consumoEnergetico = CONSUMO_DEF;
        this.peso = peso;
    }

    // Constructor con todos los atributos
    public Electrodomestico(double precioBase, String color, char consumoEnergetico, double peso) {
        this.precioBase = precioBase;
        this.color = comprobarColor(color);
        this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
        this.peso = peso;
    }

    // Getters
    public double getPrecioBase() { return precioBase; }
    public String getColor() { return color; }
    public char getConsumoEnergetico() { return consumoEnergetico; }
    public double getPeso() { return peso; }

    // Métodos privados de comprobación
    private char comprobarConsumoEnergetico(char letra) {
        letra = Character.toUpperCase(letra);
        if (letra >= 'A' && letra <= 'F') {
            return letra;
        }
        return CONSUMO_DEF;
    }

    private String comprobarColor(String color) {
        color = color.toLowerCase();
        for (String c : COLORES_DISPONIBLES) {
            if (c.equals(color)) {
                return color;
            }
        }
        return COLOR_DEF;
    }

    // Método para calcular el precio final
    public double precioFinal() {
        double precioFinal = this.precioBase;

        // Según consumo energético
        switch (this.consumoEnergetico) {
            case 'A': precioFinal += 100; break;
            case 'B': precioFinal += 80; break;
            case 'C': precioFinal += 60; break;
            case 'D': precioFinal += 50; break;
            case 'E': precioFinal += 30; break;
            case 'F': precioFinal += 10; break;
        }

        // Según peso
        if (this.peso >= 0 && this.peso <= 19) {
            precioFinal += 10;
        } else if (this.peso >= 20 && this.peso <= 49) {
            precioFinal += 50;
        } else if (this.peso >= 50 && this.peso <= 79) {
            precioFinal += 80;
        } else if (this.peso >= 80) {
            precioFinal += 100;
        }

        return precioFinal;
    }
}
