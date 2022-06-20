package E01RetakeExam13april2022.easterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    public List<Egg> data;
    public String material;
    public int capacity;

    public Basket(String material, int capacity){
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getMaterial() {
        return material;
    }

    public void addEgg(Egg egg){
        if (data.size()<capacity){
            data.add(egg);
        }
    }

    public boolean removeEgg(String color){
        for (Egg egg: data){
            if (egg.getColor().equals(color)){
                data.remove(egg);
                return true;
            }
        }
        return false;
    }

    public Egg getStrongestEgg() {
        int maxStrength = Integer.MIN_VALUE;
        Egg searchedEgg = null;
        for (Egg egg : data) {
            int currentStrength = egg.getStrength();
            if (currentStrength > maxStrength) {
                maxStrength = currentStrength;
                searchedEgg = egg;
            }
        }
        return searchedEgg;
    }

    public Egg getEgg(String color) {
        Egg searchedEgg = null;
        for (Egg egg : data) {
            String currentColour = egg.getColor();
            if (currentColour.equals(color)) {
                searchedEgg = egg;
            }
        }
        return searchedEgg;
    }

    public int getCount() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s basket contains:", material));
        sb.append("\n");
        for (Egg egg : data) {
            sb.append(String.format("%s", egg.toString()));
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}
