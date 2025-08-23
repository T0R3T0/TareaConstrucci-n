package banco.modelo;

public class Cuenta {
    private Persona titular;
    private double cantidad;

    // Constructor vacío
    public Cuenta() {}

    // Constructor con titular y cantidad
    public Cuenta(Persona titular, double cantidad) {  
        this.titular = titular;
        this.cantidad = cantidad; 
    }

    // Constructor con solo titular (cantidad = 0)
    public Cuenta(Persona titular) {
        this.titular = titular;
        this.cantidad = 0.0;
    }

    // Getters
    public Persona getTitular() {
        return titular;
    }

    public double getCantidad() {
        return cantidad;
    }

    // Métodos lógicos
    public void mostrar() {
        System.out.println("Titular: " + titular.toString() + ", Cantidad: " + cantidad);
    }

    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            this.cantidad += cantidad;
        }
    }

    public void retirar(double cantidad) {
        this.cantidad -= cantidad; // Puede quedar en negativo como se indica en el enunciado
    }
}
