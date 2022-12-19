package kz.bitlab.model;

import java.sql.Timestamp;

public class Comments {
    private long id;
    private User user;
    private ShopItem shopItem;
    private String comment;
    private Timestamp timestamp;

    public Comments(long id, User user, ShopItem shopItem, String comment, Timestamp timestamp) {
        this.id = id;
        this.user = user;
        this.shopItem = shopItem;
        this.comment = comment;
        this.timestamp = timestamp;
    }
    public Comments(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ShopItem getShopItem() {
        return shopItem;
    }

    public void setShopItem(ShopItem shopItem) {
        this.shopItem = shopItem;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
