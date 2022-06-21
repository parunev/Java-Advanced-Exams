package E06Exam26june2021.groomingSalon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroomingSalon {
    public List<Pet> data;
    public int capacity;

    public GroomingSalon(int capacity){
        data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet){
        if (data.size() < capacity){
            data.add(pet);
        }
    }
    public boolean remove(String name){
        for (Pet pet: data){
            if (pet.getName().equals(name)){
                data.remove(pet);
                return true;
            }
        }
        return false;
    }
    public Pet getPet(String name, String owner){
        return data.stream().filter(e -> e.getName().equals(name) && e.getOwner().equals(owner)).findFirst().orElse(null);
    }
    public int getCount(){
        return data.size();
    }
    public String getStatistics(){
        return "The grooming salon has the following clients:" + System.lineSeparator() + data.stream().map(pet -> pet.getName() + " "
        + pet.getOwner()).collect(Collectors.joining(System.lineSeparator()));
    }
}
