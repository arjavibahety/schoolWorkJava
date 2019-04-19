package cs2030.catsanddogs;

public class Chocolate extends Food {
    private String flavour;

    public Chocolate(String brandName, String flavour) {
        super(brandName);
        this.flavour = flavour;
        System.out.println(brandName + " " + flavour + " chocolate was added");
    }

    public void add() {
    
    }

    public String toString() {
        return getBrandName() + " " + flavour + " chocolate";
    }
}
