package kz.bitlab.db.Chapter5Part2;

import kz.bitlab.model.Brand;
import kz.bitlab.model.City;
import kz.bitlab.model.Electronics;
import kz.bitlab.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ElectronicsDBUtil {

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


    public static ArrayList<Electronics> getElectronics(){
        ArrayList<Electronics> electronics= new ArrayList<>();

        try{

            PreparedStatement statement=connection.prepareStatement(""+
                    "SELECT el.id, el.name, el.brand_id, el.description, br.name as brandname, br.country " +
                            "FROM electronikaTovarlary el " +
                            "INNER JOIN brands br ON el.brand_id = br.id ORDER BY el.id" );
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Electronics electronika=new Electronics();
                electronika.setId(resultSet.getInt("id"));
                electronika.setName(resultSet.getString("name"));
                electronika.setDescription(resultSet.getString("description"));

                Brand brand =new Brand();
                brand.setId(resultSet.getInt("brand_id"));
                brand.setName(resultSet.getString("brandname"));
                brand.setCountry(resultSet.getString("country"));

                electronika.setBrand(brand);
                electronics.add(electronika);
            }
            statement.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return electronics;
    }
    public static void addElectronika(Electronics electronika){


        try{
            PreparedStatement statement=connection.prepareStatement(""+
                    "INSERT INTO electronikaTovarlary (name,brand_id,description,city_id) "+
                    "VALUES (?,?,?,?)");
           // statement.setString(1,student.getName());
            //statement.setString(2,student.getSurname());
            //statement.setString(3,student.getBirthdate());
            //statement.setInt(4,student.getCity().getId());
            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }




    public static Electronics getElectronika(int id){
        Electronics electronika= null;

        try{

            PreparedStatement statement=connection.prepareStatement(""+
                    "SELECT el.id, el.name, el.brand_id, el.description, br.name as brandname, br.country " +
                    "FROM electronikaTovarlary el " +
                    "INNER JOIN brands br ON el.brand_id = br.id ORDER BY el.id "+
                    "WHERE el.id=?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                electronika=new Electronics();
                electronika.setId(resultSet.getInt("id"));
                electronika.setName(resultSet.getString("name"));
                electronika.setDescription(resultSet.getString("description"));

                Brand brand =new Brand();
                brand.setId(resultSet.getInt("brand_id"));
                brand.setName(resultSet.getString("brandname"));
                brand.setCountry(resultSet.getString("country"));

                electronika.setBrand(brand);
            }
            statement.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return electronika;
    }

    public static void updateElectronika(Electronics electronika){

        try{
            PreparedStatement statement= connection.prepareStatement(""+
                    "UPDATE electronikaTovarlary SET name=?, brand_id=?, description=? "+
                    "WHERE id=?");
            statement.setString(1,electronika.getName());
            statement.setInt(2,electronika.getBrand().getId());
            statement.setString(3,electronika.getDescription());
            statement.setLong(4, electronika.getId());
            statement.executeUpdate();
            statement.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void deleteStudent(int id){
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                    "DELETE FROM studenty WHERE id=?");
            statement.setInt(1,id);
            statement.executeUpdate();
            statement.close();
        }
        catch(Exception e){
            e.printStackTrace();

        }
    }


}
