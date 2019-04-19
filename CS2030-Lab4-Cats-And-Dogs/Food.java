package cs2030.catsanddogs;

public abstract class Food {
    private String brandName;

    public Food(String brandName) {
        this.brandName = brandName;
    }

    public abstract void add();

    public abstract String toString();

    public String getBrandName() {
        return brandName;
    }
}
