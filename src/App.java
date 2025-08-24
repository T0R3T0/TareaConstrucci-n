package electrodomesticos;

public class App {
    public static void main(String[] args) {
        Electrodomestico e1 = new Electrodomestico();
        Electrodomestico e2 = new Electrodomestico(200, 30);
        Electrodomestico e3 = new Electrodomestico(300, "Rojo", 'B', 60);

        System.out.println("Electrodomestico 1 -> Precio Final: $" + e1.precioFinal());
        System.out.println("Electrodomestico 2 -> Precio Final: $" + e2.precioFinal());
        System.out.println("Electrodomestico 3 -> Precio Final: $" + e3.precioFinal());
    }
}
