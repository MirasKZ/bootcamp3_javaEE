package kz.bitlab.model;

public class ShopItem {
    private int id;
    private String name;
    private String description;
    private Type type;
    private double newprice;
    private double oldprice;

    private int amount;
    private boolean onSale;
    private boolean isPopular;
    private String url;

    public ShopItem(int id, String name, String description, Type type, double newprice, double oldprice, int amount, boolean onSale, boolean isPopular,String url) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.newprice = newprice;
        this.oldprice = oldprice;
        this.onSale = onSale;
        this.isPopular = isPopular;
        this.url=url;
        this.amount=amount;
    }

    public ShopItem(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getNewprice() {
        return newprice;
    }

    public void setNewprice(double newprice) {
        this.newprice = newprice;
    }

    public double getOldprice() {
        return oldprice;
    }

    public void setOldprice(double oldprice) {
        this.oldprice = oldprice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public boolean isPopular() {
        return isPopular;
    }

    public void setPopular(boolean popular) {
        isPopular = popular;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
