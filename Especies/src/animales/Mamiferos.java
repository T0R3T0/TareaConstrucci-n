package animales;

public class Mamiferos {
    protected String tipoAnimal;
    protected String habitat;
    protected boolean peligroExt;

    public Mamiferos(String tipoAnimal, String habitat, boolean peligroExt) {
        this.tipoAnimal = tipoAnimal;
        this.habitat = habitat;
        this.peligroExt = peligroExt;
    }
    // Getters and Setters
    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public String getHabitat() {
        return habitat;
    }

    public boolean isPeligroExt() {
        return peligroExt;
    }

    // Implementación correcta
    public void imprimirInfo() {
        System.out.println("Tipo de animal: " + tipoAnimal);
        System.out.println("Hábitat: " + habitat);
        System.out.println("En peligro de extinción: " + (peligroExt ? "Sí" : "No"));
    }
}
