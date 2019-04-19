package cs2030.catsanddogs;

public class Cheese extends Food {

    public Cheese(String brandName) {
        super(brandName);
        System.out.println(brandName + " cheese was added");
    }

    public void add() {
    
    }

    public String toString() {
        return getBrandName() + " cheese";
    }

}
