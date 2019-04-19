package cs2030.catsanddogs;

import java.util.LinkedList;
import cs2030.catsanddogs.Food;

public class Dog extends Animal {
    private String sound;
    String woof;

    public Dog(String name, int appetite, String sound) {
        super(name, appetite);
        this.sound = sound;
        woof = sound;
        System.out.println(name + " was created");
    }

    public void eat(LinkedList<Food> foods) {
        int i = 0;
        while(i < foods.size() && getApp() > 0) {
            if(foods.get(i) instanceof Tuna || foods.get(i) instanceof Cheese) {
                decApp();
                System.out.println(getName() + " eats " + foods.get(i));
                foods.remove(i);
            } else
                i++;
        }
    }

    public void hello() {
        System.out.println(getName() + " says " + woof);
        woof += sound;
    }
}

