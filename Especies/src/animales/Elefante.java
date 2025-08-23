package animales;

public class Elefante extends Mamiferos implements AccionesMamiferos{
    public Elefante (String tipoAnimal, String habitat, boolean peligroExtinción){
        super(tipoAnimal, habitat, peligroExtinción);
    }

    @Override
    public void moverMamifero() {
        System.out.println("El elefante camina por la sabana.");
    }

    @Override
    public void alimentarMamifero() {
        System.out.println("El elefante se alimenta de hierbas, frutas y corteza de árboles.");
    }

}
