package E05RetakeExam18august2021.cafe;

public class Employee {
    public String name;
    public int age;
    public String country;

    public Employee(String name, int age, String country){
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {return name;}
    public int getAge(){return age;}

    @Override
    public String toString(){
        return String.format("Employee: %s, %d from %s", name, age, country);
    }
}
