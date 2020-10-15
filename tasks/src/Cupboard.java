import java.util.Random;

public class Cupboard {
    private String name;
    private int price;
    private String color;
    private String size;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String toString() {
        return name + " " + color + " " + price;
    }
}