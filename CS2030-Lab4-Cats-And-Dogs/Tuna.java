package cs2030.catsanddogs;

public class Tuna extends Food {
    
    public Tuna(String brandName) {
        super(brandName);
        System.out.println(brandName + " tuna was added");
    }

    public void add() {
    
    }

    public String toString() {
        return getBrandName() + " tuna";
    }
}
