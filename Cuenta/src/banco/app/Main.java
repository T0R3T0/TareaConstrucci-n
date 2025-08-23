package banco.app;

import banco.modelo.Cuenta;
import banco.modelo.Persona;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ingreso de datos de la persona
        System.out.print("Ingrese el nombre del titular: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese la edad: ");
        int edad = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        System.out.print("Ingrese el documento: ");
        String documento = sc.nextLine();

        // Crear persona
        Persona titular = new Persona(nombre, documento, edad);

        // Crear cuenta (saldo inicial en 0)
        Cuenta cuenta = new Cuenta(titular);

        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Mostrar cuenta");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    cuenta.mostrar();
                    break;
                case 2:
                    System.out.print("Ingrese cantidad a depositar: ");
                    double ingreso = sc.nextDouble();
                    cuenta.ingresar(ingreso);
                    break;
                case 3:
                    System.out.print("Ingrese cantidad a retirar: ");
                    double retiro = sc.nextDouble();
                    cuenta.retirar(retiro);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);

        sc.close();
    }
}
