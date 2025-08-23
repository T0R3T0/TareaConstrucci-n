package animales;

public class Main {
    public static void main(String[] args) {
        Mamiferos ballena = new Ballena("Ballena", "Océano", true);
        Mamiferos elefante = new Elefante("Elefante", "Sabana Africana", true);

        // Polimorfismo con la interfaz
        AccionesMamiferos a1 = (AccionesMamiferos) ballena;
        AccionesMamiferos a2 = (AccionesMamiferos) elefante;

        System.out.println("=== Ballena ===");
        ballena.imprimirInfo();
        a1.moverMamifero();
        a1.alimentarMamifero();

        System.out.println("\n=== Elefante ===");
        elefante.imprimirInfo();
        a2.moverMamifero();
        a2.alimentarMamifero();
    }
}
