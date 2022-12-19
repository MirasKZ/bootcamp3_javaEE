package kz.bitlab.servlets.Chapter7;

import kz.bitlab.model.Tovar;

import java.util.ArrayList;

public class DBTovarManager {
    private static ArrayList<Tovar> tovary=new ArrayList<>();
    private static int id=5;
    static {
        tovary.add(new Tovar(1,"Adidas F50",50));
        tovary.add(new Tovar(2,"Reebok R30",35));
        tovary.add(new Tovar(3,"Nike Total 90",45));
        tovary.add(new Tovar(4,"Puma P44",34));
    }
    public static ArrayList<Tovar> getTovary(){
        return tovary;
    }
    public static void addTovar(Tovar tovar){
        tovar.setId(id);
        tovary.add(tovar);
        id++;
    }
    public static Tovar getTovarById(int id){
        for(Tovar tov: tovary){
            if(tov.getId()==id){
                return tov;
            }
        }
        return null;
    }

}
