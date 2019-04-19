import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import cs2030.catsanddogs.Animal;
import cs2030.catsanddogs.Dog;
import cs2030.catsanddogs.Cat;
import cs2030.catsanddogs.Food;
import cs2030.catsanddogs.Chocolate;
import cs2030.catsanddogs.Tuna;
import cs2030.catsanddogs.Cheese;
import cs2030.catsanddogs.IllegalInstructionException;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            BufferedReader scroll = new BufferedReader(new FileReader(args[0]));
            String line = scroll.readLine();
            LinkedList<Animal> animals = new LinkedList<>();
            LinkedList<Food> foods = new LinkedList<>();
            while(line != null) {
                try {
                    String[] command = line.split(" ");

                    if(command[0].equals("new")) {
                        if(command.length == 5) {
                            if(command[1].equals("dog")) {
                                animals.add(new Dog(command[2], Integer.parseInt(command[3]), command[4]));
                            } else if(command[1].equals("cat")) {
                                animals.add(new Cat(command[2], Integer.parseInt(command[3]), command[4]));
                            } else {
                                throw new IllegalInstructionException(command[1] + " is not a valid species");
                            }

                        } else {
                            if(!command[1].equals("cat") && !command[1].equals("dog")) {
                                throw new IllegalInstructionException(command[1] + " is not a valid species");
                            } else {
                                throw new IllegalInstructionException("Too few arguments");
                            }
                        }
                    }

                    else if(command[0].equals("add")) {
                        if(command[1].equals("cheese")) {
                            if(command.length == 3) {
                                foods.add(new Cheese(command[2]));
                            } else {
                                throw new IllegalInstructionException("Too few arguments");
                            }
                        } else if(command[1].equals("chocolate")) {
                            if(command.length == 4) {
                                foods.add(new Chocolate(command[2], command[3]));
                            } else {
                                throw new IllegalInstructionException("Too few arguments");
                            }
                        } else if(command[1].equals("tuna")){
                            if(command.length == 3) {
                                foods.add(new Tuna(command[2]));
                            } else {
                                throw new IllegalInstructionException("Too few arguments");
                            }
                        } else {
                            throw new IllegalInstructionException(command[1] + " is not a valid food type");
                        }
                    } else if(command[0].equals("eat")) {
                        Collections.sort(animals, (Animal a, Animal b) -> 
                                a.getName().compareTo(b.getName()));

                        int i = 0;
                        int size = animals.size();

                        while(i < size) {
                            animals.get(i).eat(foods);
                            i++;
                        }
                    } else if(command[0].equals("hello")) {
                        Collections.sort(animals, (Animal a, Animal b) -> 
                                a.getName().compareTo(b.getName()));

                        int i = 0;
                        int size = animals.size();

                        while(i < size) {
                            animals.get(i).hello();
                            i++;
                        }
                    } else {
                        throw new IllegalInstructionException(command[0] + " is not a valid instruction");
                    }

                }
                catch (IllegalInstructionException err) {
                    System.err.println(err);
                }
                line = scroll.readLine(); 
            } 
        } catch (IOException ioEx) {

        }
    }
}
