package E01RetakeExam13april2022.easterBasket;

public class Egg {
    public String color;
    public int strength;
    public String shape;

    public Egg(String color, int strength, String shape){
        this.color = color;
        this.strength = strength;
        this.shape = shape;
    }

    public String getColor(){
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getShape() {
        return shape;
    }
    public void setShape(String shape) {
        this.shape = shape;
    }

    @Override
    public String toString(){
        return String.format("%s egg, with %d strength and %s shape.", this.color, this.strength, this.shape);
    }
}
