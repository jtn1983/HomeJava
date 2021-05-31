package Lesson7_2;

public class Product {
    private String name;
    private int price;
    private String description;

    public Product(int price, String name, String description) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return  "{Name: " + name +
                ", Price: " + price +
                ", Description: " + description +
                "}";
    }

}
