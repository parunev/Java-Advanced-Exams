package E08Exam20february2021.dealership;

public class Car {
    public String manufacturer;
    public String model;
    public int year;

    public Car(String manufacturer,String model, int year){
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
    }

    public void setManufacturer(String manufacturer) {this.manufacturer = manufacturer;}
    public String getManufacturer() {return manufacturer;}

    public void setModel(String model) {this.model = model;}
    public String getModel() {return model;}

    public void setYear(int year) {this.year = year;}
    public int getYear() {return year;}

    @Override
    public String toString(){
        return String.format("%s %s (%d)",manufacturer,model,year);
    }
}
