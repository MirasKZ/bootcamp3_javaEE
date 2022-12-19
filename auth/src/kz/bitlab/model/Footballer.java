package kz.bitlab.model;

public class Footballer {

    private int id;
    private String name;
    private String surname;
    private String club;
    private long price;
    private long salary;

    public Footballer(){

    }

    public Footballer(int id, String name, String surname, String club, long price, long salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.club = club;
        this.price = price;
        this.salary = salary;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
