package kz.bitlab.db.Chapter5Part2;

import kz.bitlab.model.Brand;
import kz.bitlab.model.City;
import kz.bitlab.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BrandsDBUtil {

    private static Connection connection;

    static {
        try{
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/bootcamp3_db","postgres","postgres");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



    public static ArrayList<Brand> getBrands(){
        ArrayList<Brand> brands=new ArrayList<>();
        try {
            PreparedStatement statement=connection.prepareStatement("" +
                    "SELECT * FROM brands ORDER BY id ASC");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                Brand brand=new Brand();
                brand.setId(resultSet.getInt("id"));
                brand.setName(resultSet.getString("name"));
                brand.setCountry(resultSet.getString("country"));
                brands.add(brand);
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return brands;
    }

    public static Brand getBrand(int id){
        Brand brand=null;
        try {
            PreparedStatement statement=connection.prepareStatement("" +
                    "SELECT * FROM brands "+
                    "WHERE id=?");
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next()){
                brand=new Brand();
                brand.setId(resultSet.getInt("id"));
                brand.setName(resultSet.getString("name"));
                brand.setCountry(resultSet.getString("code"));

            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return brand;
    }
    public static void addBrand(Brand brand){


        try{
            PreparedStatement statement=connection.prepareStatement(""+
                    "INSERT INTO brands (name, country) "+
                    "VALUES (?,?)");
            statement.setString(1,brand.getName());
            statement.setString(2,brand.getCountry());
            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



    public static void updateBrand(Brand brand){

        try{
            PreparedStatement statement= connection.prepareStatement(""+
                    "UPDATE brands SET name=?, country=? "+
                    "WHERE id=?");
            statement.setString(1,brand.getName());
            statement.setString(2,brand.getCountry());
            statement.setInt(3, brand.getId());
            statement.executeUpdate();
            statement.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteBrand(int id){
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                    "DELETE FROM brands WHERE id=?");
            statement.setInt(1,id);
            statement.executeUpdate();
            statement.close();
        }
        catch(Exception e){
            e.printStackTrace();

        }
    }

}
