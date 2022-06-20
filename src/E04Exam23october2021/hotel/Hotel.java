package E04Exam23october2021.hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
    public List<Person> roster;
    public String name;
    public int capacity;

    public Hotel(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        roster = new ArrayList<>();
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public List<Person> getRoster() {return roster;}
    public void setRoster(List<Person> roster) {this.roster = roster;}

    public int getCapacity(){return capacity;}
    public void setCapacity(int capacity) {this.capacity = capacity;}

    public void add(Person person){
        if (roster.size()<capacity){
            roster.add(person);
        }
    }

    public boolean remove(String name){
        for (Person person: roster){
            if (person.getName().equals(name)){
                roster.remove(person);
                return true;
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown){
        Person personToFind = roster.stream().filter(s->s.getName().equals(name)).findFirst().orElse(null);
        if (personToFind != null){
            if (personToFind.getHometown().equals(hometown)){
                return personToFind;
            }
        }
        return null;
    }

    public int getCount(){
        return roster.size();
    }


    public String getStatistics(){
        return "The people in the E04Exam23october2021.hotel " + name + " are:" + System.lineSeparator() + roster.stream()
                .map(Person::toString).collect(Collectors.joining(System.lineSeparator()));
    }
}
