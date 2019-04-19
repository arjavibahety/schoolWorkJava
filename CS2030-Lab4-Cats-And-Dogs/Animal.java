package cs2030.catsanddogs;

import java.util.LinkedList;
import cs2030.catsanddogs.Food;

public abstract class Animal {
    private String name;
    private int appetite;

    public Animal(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public abstract void eat(LinkedList<Food> foods);
    
    public abstract void hello();

    public String getName() {
        return name;
    }

    public int getApp() {
        return appetite;
    }

    public void decApp() {
        appetite--;
    }


}
