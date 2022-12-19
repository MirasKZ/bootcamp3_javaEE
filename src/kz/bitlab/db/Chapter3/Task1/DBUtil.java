package kz.bitlab.db.Chapter3.Task1;

import kz.bitlab.model.City;
import kz.bitlab.model.Country;
import kz.bitlab.model.Item;
import kz.bitlab.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

public class DBUtil {

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


    public static ArrayList<Student> getStudents(){
        ArrayList<Student> students= new ArrayList<>();

        try{

            PreparedStatement statement=connection.prepareStatement(""+
                    "SELECT st.id, st.name,st.surname,st.birthdate, st.city_id as cityid, ct.name as cityname, ct.code as citycode " +
                            "FROM studenty st " +
                            "INNER JOIN cities ct ON st.city_id = ct.id ORDER BY st.id" );
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Student student=new Student();
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setBirthdate(resultSet.getString("birthdate"));

                City city=new City();
                city.setId(resultSet.getInt("cityid"));
                city.setName(resultSet.getString("cityname"));
                city.setCode(resultSet.getString("citycode"));
                student.setCity(city);
                students.add(student);
            }
            statement.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }
    public static void addStudent(Student student){


        try{
            PreparedStatement statement=connection.prepareStatement(""+
                    "INSERT INTO studenty (name,surname,birthdate,city_id) "+
                    "VALUES (?,?,?,?)");
            statement.setString(1,student.getName());
            statement.setString(2,student.getSurname());
            statement.setString(3,student.getBirthdate());
            statement.setInt(4,student.getCity().getId());
            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
    public static void addCity(City city){


        try{
            PreparedStatement statement=connection.prepareStatement(""+
                    "INSERT INTO cities (name, code) "+
                    "VALUES (?,?)");
            statement.setString(1,city.getName());
            statement.setString(2,city.getCode());
            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }




    public static Student getStudent(int id){
        Student student=null;
        try{
            PreparedStatement statement=connection.prepareStatement(""+
                    " SELECT st.id, st.name,st.surname,st.birthdate, st.city_id AS cityid, ct.name AS cityname, ct.code " +
                    " FROM studenty st " +
                    " INNER JOIN cities ct ON st.city_id = ct.id "+
                    " WHERE st.id= ?");
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next()){
                student=new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setBirthdate(resultSet.getString("birthdate"));
                //student.setCity(resultSet.getString("city"));
                City city = new City();
                city.setId(resultSet.getInt("cityid"));
                city.setName(resultSet.getString("cityname"));
                city.setCode(resultSet.getString("code"));
                student.setCity(city);
            }
            statement.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }

    public static void updateStudent(Student student){

        try{
            PreparedStatement statement= connection.prepareStatement(""+
                    "UPDATE studenty SET name=?, surname=?, birthdate=?,city_id=? "+
                    "WHERE id=?");
            statement.setString(1,student.getName());
            statement.setString(2,student.getSurname());
            statement.setString(3,student.getBirthdate());
            statement.setInt(4,student.getCity().getId());
            statement.setLong(5, student.getId());
            statement.executeUpdate();
            statement.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void updateCity(City city){

        try{
            PreparedStatement statement= connection.prepareStatement(""+
                    "UPDATE cities SET name=?, code=? "+
                    "WHERE id=?");
            statement.setString(1,city.getName());
            statement.setString(2,city.getCode());
            statement.setInt(3, city.getId());
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
    public static void deleteCity(int id){
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                    "DELETE FROM cities WHERE id=?");
            statement.setInt(1,id);
            statement.executeUpdate();
            statement.close();
        }
        catch(Exception e){
            e.printStackTrace();

        }
    }
    public static ArrayList<City> getCities(){
        ArrayList<City> cities=new ArrayList<>();
        try {
            PreparedStatement statement=connection.prepareStatement("" +
                    "SELECT * FROM cities ORDER BY id ASC");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                City city=new City();
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                city.setCode(resultSet.getString("code"));
                cities.add(city);
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return cities;
    }

    public static City getCity(int id){
        City city=null;
        try {
            PreparedStatement statement=connection.prepareStatement("" +
                    "SELECT * FROM cities "+
                    "WHERE id=?");
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next()){
                city=new City();
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                city.setCode(resultSet.getString("code"));

            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return city;
    }
}
