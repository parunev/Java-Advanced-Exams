package E08Exam20february2021.dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Dealership {
    public List<Car> data;
    public String name;
    public int capacity;

    public Dealership(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add(Car car){
        if (capacity > data.size()){
            data.add(car);
        }
    }
    public boolean buy(String manufacturer, String model){
        for (Car car:data){
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar(){
        return data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }

    public Car getCar(String manufacturer, String model){
        return data.stream().filter(e-> e.getManufacturer().equals(manufacturer) && e.getModel().equals(model))
                .findFirst().orElse(null);
    }

    public int getCount() {return data.size();}

    public String getStatistics(){
        return "The cars in the E08Exam20february2021.dealership " + name + ":" + System.lineSeparator() +
                data.stream().map(Car::toString).collect(Collectors.joining(System.lineSeparator()));
    }
}
