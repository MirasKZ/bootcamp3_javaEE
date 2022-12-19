package kz.bitlab.db;

import kz.bitlab.model.User;

import java.util.ArrayList;

public class DBUser {
    private static ArrayList<User> users=new ArrayList<>();
    private static int id=6;
    static {
        users.add(new User(1,"miras_yerikov","asdf","Miras Yerikov Bekseituly", 24));
        users.add(new User(2,"john07","qwer","John Kennedy Henry",44));
        users.add(new User(3,"mike22","qwer","Mike Mike Mike",26));
        users.add(new User(4,"roy22","qwer","Roy Roy Roy",33));
        users.add(new User(5,"Kevin22","qwer","Kevin Kevin Kevin",38));
    }
    public static ArrayList<User> getUsers(){
        return users;
    }
    public static void addUser(User user){
        user.setId(id);
        users.add(user);
        id++;
    }

}
