package kz.bitlab.db;

import kz.bitlab.model.Country;
import kz.bitlab.model.Item;
import kz.bitlab.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBMyUtil {

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/bootcamp3db", "root", "root");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Item> getItems(){

        ArrayList<Item> items = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT it.id, it.name, it.amount, it.price, it.country_id, co.name AS countryname, co.code, co.code_simple " +
                    "FROM items it " +
                    "INNER JOIN countries co ON it.country_id = co.id");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Item item = new Item();
                item.setId(resultSet.getInt("id"));
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getDouble("price"));
                item.setAmount(resultSet.getInt("amount"));

                Country country = new Country();
                country.setId(resultSet.getInt("country_id"));
                country.setName(resultSet.getString("countryname"));
                country.setCode(resultSet.getString("code"));
                country.setCodeSimple(resultSet.getString("code_simple"));

                item.setCountry(country);

                items.add(item);
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }

    public static void addItem(Item item){

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO items (name, country_id, price, amount) " +
                    "VALUES (?,?,?,?)");

            statement.setString(1, item.getName());
            statement.setInt(2, item.getCountry().getId());
            statement.setDouble(3, item.getPrice());
            statement.setInt(4, item.getAmount());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static Item getItem(int id){

        Item item = null;

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT it.id, it.name, it.amount, it.price, it.country_id, co.name AS countryname, co.code, co.code_simple " +
                    "FROM items it " +
                    "INNER JOIN countries co ON it.country_id = co.id " +
                    "WHERE it.id = ?");

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                item = new Item();
                item.setId(resultSet.getInt("id"));
                item.setName(resultSet.getString("name"));
                item.setAmount(resultSet.getInt("amount"));
                item.setPrice(resultSet.getDouble("price"));

                Country country = new Country();
                country.setId(resultSet.getInt("country_id"));
                country.setName(resultSet.getString("countryname"));
                country.setCode(resultSet.getString("code"));
                country.setCodeSimple(resultSet.getString("code_simple"));

                item.setCountry(country);
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return item;

    }

    public static void updateItem(Item item){

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE items SET name = ?, price = ?, amount = ?, country_id = ? " +
                    "WHERE id = ?");

            statement.setString(1, item.getName());
            statement.setDouble(2, item.getPrice());
            statement.setInt(3, item.getAmount());
            statement.setInt(4, item.getCountry().getId());
            statement.setInt(5, item.getId());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteItem(int id){
        try{

            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM items WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Country> getCountries(){
        ArrayList<Country> countries = new ArrayList<>();
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM countries ORDER BY name ASC");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Country country = new Country();
                country.setId(resultSet.getInt("id"));
                country.setName(resultSet.getString("name"));
                country.setCode(resultSet.getString("code"));
                country.setCodeSimple(resultSet.getString("code_simple"));
                countries.add(country);
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return countries;
    }

    public static Country getCountry(int id){
        Country country = null;
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM countries WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                country = new Country();
                country.setId(resultSet.getInt("id"));
                country.setName(resultSet.getString("name"));
                country.setCode(resultSet.getString("code"));
                country.setCodeSimple(resultSet.getString("code_simple"));
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return country;
    }

    public static User getUserByEmail(String email){
        User found = null;
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM usery WHERE email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                found = new User();
                found.setEmail(email);
                found.setId(resultSet.getInt("id"));
                found.setPassword(resultSet.getString("password"));
                found.setFullName(resultSet.getString("full_name"));
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return found;
    }

}
