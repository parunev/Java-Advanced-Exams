package E02Exam19february2022.parrots;

public class Parrot {
    public String name;
    public String species;
    public boolean available = true;

    public Parrot(String name, String species){
        this.name = name;
        this.species = species;
    }

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    public void setSpecies(String species) {this.species = species;}
    public String getSpecies() {return species;}

    public void setAvailable(boolean available) {this.available = available;}
    public boolean isAvailable() {return available;}

    @Override
    public String toString(){
        return String.format("Parrot %s: %s%n",this.species,this.name);
    }
}
