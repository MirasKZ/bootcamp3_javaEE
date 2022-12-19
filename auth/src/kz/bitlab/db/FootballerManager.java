package kz.bitlab.db;

import kz.bitlab.model.Footballer;

import java.util.ArrayList;

public class FootballerManager {

    private static ArrayList<Footballer> footballers = new ArrayList<>();
    private static int id = 4;

    static{

        footballers.add(new Footballer(1, "Vinicius", "Junior", "Real Madrid CF", 6000000, 120000000));
        footballers.add(new Footballer(2, "Ruslan", "Malinovskiy", "Atalanta", 3000000, 30000000));
        footballers.add(new Footballer(3, "Sergio", "Alvarez", "Real Sociedad", 2000000, 10000000));

    }

    public static void addFootballer(Footballer footballer){
        footballer.setId(id);
        footballers.add(footballer);
        id++;
    }

    public static ArrayList<Footballer> getFootballers(){
        return footballers;
    }

}
