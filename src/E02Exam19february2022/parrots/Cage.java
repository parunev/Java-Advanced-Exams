package E02Exam19february2022.parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    public String name;
    public int capacity;
    public List<Parrot> data;

    public Cage(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public String getName() {return name;}
    public int getCapacity() {return capacity;}

    //we remove the parrot if there is a one with the same name
    public boolean remove(String name){
        for (int i = 0; i <data.size() ; i++) {
            if (data.get(i).getName().equals(name)){
                data.remove(i);
                return true;
            }
        }
        return false;
      }

    //if there is available space in the cage we put the current parrot inside
    public void add(Parrot parrot){
        if(data.size() < capacity){
            data.add(parrot);
        }
    }

    //if there is a parrot with this name we sell it, otherwise we don't
    public Parrot sellParrot(String name){
        for (Parrot datum : data) {
            if (datum.getName().equals(name) && datum.isAvailable()) {
                datum.setAvailable(false);
                return datum;
            }
        }
        return null;
    }

    //sells and returns all parrots from that species as a List
    public List<Parrot> sellParrotBySpecies(String species){
        List<Parrot> forSale = new ArrayList<>();
        for (Parrot datum : data) {
            if (datum.getSpecies().equals(species) && datum.isAvailable()) {
                forSale.add(datum);
            }
        }
        return forSale;
    }

    //we found the parrots number
    public int count(){return data.size();}

    // we print what parrots are available
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Parrots available at ").append(name).append(":").append(System.lineSeparator());
        for (int i = 0; i < data.size(); i++) {
            Parrot parrot = data.get(i);
            if (parrot.isAvailable()) {
                sb.append(parrot);
            }
            if (i < data.size() - 1) {
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

}
