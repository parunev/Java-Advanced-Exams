package E01RetakeExam13april2022.easterBasket;

public class Main {
    public static void main(String[] args) {

        Basket basket = new Basket("Wood", 20);
        Egg egg = new Egg("Yellow", 10, "oval");
        Egg egg1 = new Egg("Red", 11, "oval");
        Egg egg2 = new Egg("Green", 12, "oval");
        Egg egg3 = new Egg("Orange", 13, "oval");

        basket.addEgg(egg);
        basket.addEgg(egg1);
        basket.addEgg(egg2);
        basket.addEgg(egg3);

        Egg strongestEgg = basket.getStrongestEgg();

        System.out.println(basket.report());
    }
}
