package kz.bitlab.model;

public class Item {
    private int id;
    private String name;
    private Country country;
    private double price;
    private int amount;

    public Item(String name, Country country, double price, int amount) {
        this.name = name;
        this.country = country;
        this.price = price;
        this.amount = amount;
    }

    public Item(int id, String name, Country country, double price, int amount) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.price = price;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
