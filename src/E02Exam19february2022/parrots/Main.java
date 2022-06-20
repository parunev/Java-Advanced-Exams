package E02Exam19february2022.parrots;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cage cage = new Cage("Wilderness", 20);

        Parrot parrot = new Parrot("Fluffy", "Loriinae");
        Parrot parrot1 = new Parrot("Pesho", "Loriinae");
        Parrot parrot2 = new Parrot("Tosho", "Loriinae");

        System.out.printf("%s%n%s%n%s%n",parrot,parrot1,parrot2);

        cage.add(parrot);
        cage.add(parrot1);
        cage.add(parrot2);

        System.out.println(cage.count());

        cage.remove("Pesho");

        System.out.println(cage.sellParrot("Tosho"));
        List<Parrot> soldSpecies = cage.sellParrotBySpecies("Lorrinae");

        soldSpecies.forEach(f-> System.out.println(f.getName()));

        System.out.println(cage.report());
    }
}
