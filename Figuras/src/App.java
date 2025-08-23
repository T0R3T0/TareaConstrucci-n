import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Menú para que el usuario elija la figura
        System.out.println("Elige una figura:");
        System.out.println("1. Círculo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Rectángulo");
        System.out.println("4. Triángulo");
        int opcion = sc.nextInt();

        Figura figura = null;

        switch (opcion) {
            case 1:
                System.out.print("Color: ");
                String colorC = sc.next();
                System.out.print("Radio: ");
                double radio = sc.nextDouble();
                figura = new Circulo(colorC, radio);
                break;

            case 2:
                System.out.print("Color: ");
                String colorQ = sc.next();
                System.out.print("Lado: ");
                double lado = sc.nextDouble();
                figura = new Cuadrado(colorQ, lado);
                break;

            case 3:
                System.out.print("Color: ");
                String colorR = sc.next();
                System.out.print("Ancho: ");
                double ancho = sc.nextDouble();
                System.out.print("Alto: ");
                double alto = sc.nextDouble();
                figura = new Rectangulo(colorR, ancho, alto);
                break;

            case 4:
                System.out.print("Color: ");
                String colorT = sc.next();
                System.out.print("Base: ");
                double base = sc.nextDouble();
                System.out.print("Altura: ");
                double altura = sc.nextDouble();
                System.out.print("Lado 1: ");
                double lado1 = sc.nextDouble();
                System.out.print("Lado 2: ");
                double lado2 = sc.nextDouble();
                System.out.print("Lado 3: ");
                double lado3 = sc.nextDouble();
                figura = new Triangulo(colorT, base, altura, lado1, lado2, lado3);
                break;

            default:
                System.out.println("Opción inválida.");
                break;
        }

        // Si se creó la figura, mostramos sus datos
        if (figura != null) {
            mostrarFigura(figura);
        }

        sc.close();
    }

    // Función polimórfica
    public static void mostrarFigura(Figura figura) {
        figura.imprimir();
        System.out.println("Área: " + figura.calcularArea());
        System.out.println("Perímetro: " + figura.calcularPerimetro());
        System.out.println("--------------------------------");
    }
}
