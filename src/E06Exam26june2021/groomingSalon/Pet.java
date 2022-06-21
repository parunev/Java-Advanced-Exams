package E06Exam26june2021.groomingSalon;

public class Pet {
    public String name;
    public int age;
    public String owner;

    public Pet(String name, int age, String owner){
        this.name = name;
        this.age = age;
        this.owner = owner;
    }

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    public void setAge(int age) {this.age = age;}
    public int getAge(){return  age;}

    public void setOwner(String owner) {this.owner = owner;}
    public String getOwner() {return owner;}

    @Override
    public String toString(){
        return String.format("%s %d - (%s)",name, age, owner);
    }
}
