package animales;

public class Ballena extends Mamiferos implements AccionesMamiferos{

    public Ballena (String tipoAnimal, String habitat , boolean peligroExtinción){
        super(tipoAnimal, habitat, peligroExtinción);
    }

    @Override
    public void moverMamifero() {
        System.out.println("La ballena nada en el océano.");
    }

    @Override
    public void alimentarMamifero() {
        System.out.println("La ballena se alimenta de krill y pequeños peces.");
    }

}
