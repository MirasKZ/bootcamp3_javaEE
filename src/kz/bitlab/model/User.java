package kz.bitlab.model;

public class User {
    private int id;
    private String login;
    private String password;
    private String fullname;
    private int age;

    public User(int id, String login, String password, String fullname, int age) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.fullname = fullname;
        this.age = age;
    }
    public User(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
