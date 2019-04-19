package cs2030.catsanddogs;

import java.util.LinkedList;

public class Cat extends Animal {
    private String color;
    private boolean lazy = false;

    public Cat(String name, int appetite, String color) {
        super(name, appetite);    
        this.color = color;
        System.out.println(name + "(" + color + ") was created");
    }

    public void eat(LinkedList<Food> foods) {
       int i = 0;
       while(i < foods.size() && getApp() > 0) {
            if(foods.get(i) instanceof Tuna || foods.get(i) instanceof Chocolate) {
                decApp();
                System.out.println(getName() + "(" + color + ") eats " + foods.get(i));
                foods.remove(i);
            } else {
                i++;
            }
       }
    }

    public void hello() {
        if(lazy) {
            lazy = false;
            System.out.println(getName() + "(" + color + ") is lazy");
        } else {
            lazy = true;
            System.out.println(getName() + "(" + color + ") says meow and gets lazy"); 
        }
    }
}
