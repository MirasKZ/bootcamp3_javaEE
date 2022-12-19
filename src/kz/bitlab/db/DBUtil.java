package kz.bitlab.db;

import kz.bitlab.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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


    public static ArrayList<Item> getItems(){
        ArrayList<Item> items= new ArrayList<>();



        try{

            PreparedStatement statement=connection.prepareStatement(
                    "SELECT ph.id, ph.name, ph.price, ph.amount, ph.country_id, " +
                            " co.name AS countryname,co.code, co.code_simple" +
                            " FROM phones ph" +
                            " INNER JOIN countries co ON ph.country_id=co.id");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Item item=new Item();
                item.setId(resultSet.getInt("id"));
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getDouble("price"));
                item.setAmount(resultSet.getInt("amount"));

                Country country=new Country();
                country.setId(resultSet.getInt("country_id"));
                country.setName(resultSet.getString("countryname"));
                country.setCode(resultSet.getString("code"));
                country.setCodeSimple(resultSet.getString("code_simple"));

                item.setCountry(country);
                items.add(item);
            }
            statement.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }

    public static ArrayList<Type> getTypes(){
        ArrayList<Type> types = new ArrayList<>();
        try{
            PreparedStatement statement=connection.prepareStatement(""+
                    "SELECT * FROM item_tipy ORDER BY name ASC");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                Type type=new Type();
                type.setId(resultSet.getInt("id"));
                type.setName(resultSet.getString("name"));
                types.add(type);
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return types;
    }

    public static Type getTypeById(int id){
        Type type=null;
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                    "SELECT * FROM item_tipy "+
                    "WHERE id=?");
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next()){
                type=new Type();
                type.setId(id);
                type.setName(resultSet.getString("name"));
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return type;
    }
    public static ArrayList<Comments> getComments(int id){
        ArrayList<Comments> comments=new ArrayList<>();
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                    "SELECT co.comment, co.user_id, co.post_date,"+
                    " us.fullname, us.login "+
                    "FROM comments co "+
                    "INNER JOIN usery us ON co.user_id=us.id "+
                    "WHERE co.shopitem_id=?");
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                Comments comments1=new Comments();
                User user=new User();
                user.setFullname(resultSet.getString("fullname"));
                user.setLogin(resultSet.getString("login"));
                comments1.setUser(user);
                comments1.setComment(resultSet.getString("comment"));
                comments1.setTimestamp(resultSet.getTimestamp("post_date"));
                comments.add(comments1);
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return comments;
    }

    public static ArrayList<ShopItem> getShopItems(){
        ArrayList<ShopItem> shopitems= new ArrayList<>();

        try{
            PreparedStatement statement=connection.prepareStatement(""+
                    "SELECT sh.id, sh.name, sh.description, sh.type_id, itp.name as typename, sh.newprice, sh.oldprice,sh.onsale, sh.ispopular, " +
                            " sh.photo_url " +
                            " FROM shopitemy sh " +
                            " INNER JOIN item_tipy itp ON sh.type_id=itp.id ORDER BY sh.id ASC");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                ShopItem shopitem=new ShopItem();
                shopitem.setId(resultSet.getInt("id"));
                shopitem.setName(resultSet.getString("name"));
                shopitem.setDescription(resultSet.getString("description"));
                shopitem.setNewprice(resultSet.getDouble("newprice"));
                shopitem.setOldprice(resultSet.getDouble("oldprice"));
                shopitem.setOnSale(resultSet.getBoolean("onsale"));
                shopitem.setPopular(resultSet.getBoolean("ispopular"));
                shopitem.setUrl(resultSet.getString("photo_url"));

                Type type=new Type();
                type.setId(resultSet.getInt("type_id"));
                type.setName(resultSet.getString("typename"));

                shopitem.setType(type);
                shopitems.add(shopitem);
            }
            statement.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return shopitems;
    }
    public static ArrayList<ShopItem> getShopItemsByCategory(String type_id){
        ArrayList<ShopItem> shopitems= new ArrayList<>();

        try{
            PreparedStatement statement=connection.prepareStatement(""+
                    "SELECT sh.id, sh.name, sh.description, sh.type_id, itp.name as typename, sh.newprice, sh.oldprice,sh.onsale, sh.ispopular, " +
                    " sh.photo_url " +
                    " FROM shopitemy sh " +
                    " INNER JOIN item_tipy itp ON sh.type_id=itp.id WHERE sh.type_id=?");
            statement.setInt(1,Integer.parseInt(type_id));
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                ShopItem shopitem=new ShopItem();
                shopitem.setId(resultSet.getInt("id"));
                shopitem.setName(resultSet.getString("name"));
                shopitem.setDescription(resultSet.getString("description"));
                shopitem.setNewprice(resultSet.getDouble("newprice"));
                shopitem.setOldprice(resultSet.getDouble("oldprice"));
                shopitem.setOnSale(resultSet.getBoolean("onsale"));
                shopitem.setPopular(resultSet.getBoolean("ispopular"));
                shopitem.setUrl(resultSet.getString("photo_url"));

                Type type=new Type();
                type.setId(resultSet.getInt("type_id"));
                type.setName(resultSet.getString("typename"));

                shopitem.setType(type);
                shopitems.add(shopitem);
            }
            statement.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return shopitems;
    }

    public static ShopItem getShopItem(int id){
        ShopItem shopitem = null;
        try{

            PreparedStatement statement=connection.prepareStatement(""+
                    "SELECT sh.id, sh.name, sh.description, sh.type_id, itp.name as typename, sh.newprice, sh.oldprice,sh.onsale, sh.ispopular, " +
                    " sh.amount, sh.photo_url " +
                    " FROM shopitemy sh " +
                    " INNER JOIN item_tipy itp ON sh.type_id=itp.id "+
                    "WHERE sh.id=?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                shopitem=new ShopItem();
                shopitem.setId(resultSet.getInt("id"));
                shopitem.setName(resultSet.getString("name"));
                shopitem.setDescription(resultSet.getString("description"));
                shopitem.setNewprice(resultSet.getDouble("newprice"));
                shopitem.setOldprice(resultSet.getDouble("oldprice"));
                shopitem.setOnSale(resultSet.getBoolean("onsale"));
                shopitem.setPopular(resultSet.getBoolean("ispopular"));
                shopitem.setUrl(resultSet.getString("photo_url"));
                shopitem.setAmount(resultSet.getInt("amount"));
                Type type=new Type();
                type.setId(resultSet.getInt("type_id"));
                type.setName(resultSet.getString("typename"));

                shopitem.setType(type);
            }
            statement.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return shopitem;
    }


    public static void addComment(Comments comments){
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                    "INSERT INTO comments (comment,user_id,shopitem_id,post_date)"+
                    " VALUES (?,?,?, NOW())");
            statement.setString(1,comments.getComment());
            statement.setInt(2,comments.getUser().getId());
            statement.setInt(3,comments.getShopItem().getId());
            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addType(Type type){
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                    "INSERT INTO item_tipy (name) VALUES (?)");
            statement.setString(1,type.getName());
            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addShopItem(ShopItem shopItem){
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                   "INSERT INTO shopitemy (name,description, type_id,newprice,oldprice,onsale,ispopular,photo_url,amount) " +
                    "VALUES(?,?,?,?,?,?,?,?,?)");
                    statement.setString(1,shopItem.getName());
                    statement.setString(2,shopItem.getDescription());
                    statement.setInt(3,shopItem.getType().getId());
                    statement.setDouble(4,shopItem.getNewprice());
                    statement.setDouble(5,shopItem.getOldprice());
                    statement.setBoolean(6,shopItem.isOnSale());
                    statement.setBoolean(7,shopItem.isPopular());
                    statement.setString(8,shopItem.getUrl());
                    statement.setInt(9,shopItem.getAmount());
                    statement.executeUpdate();
                    statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addItem(Item item){

        try{
            PreparedStatement statement=connection.prepareStatement(""+
                    "INSERT INTO phones (name,country_id,price,amount) "+
                    "VALUES (?,?,?,?)");
            statement.setString(1,item.getName());
           statement.setInt(2,item.getCountry().getId());
            statement.setDouble(3,item.getPrice());
            statement.setInt(4,item.getAmount());
            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public static Item getItem(int id){
        Item item=null;
        try{
            PreparedStatement statement=connection.prepareStatement(""+
                    "SELECT ph.id, ph.name, ph.price, ph.amount, ph.country_id," +
                    " co.name AS countryname,co.code, co.code_simple " +
                    " FROM phones ph " +
                    " INNER JOIN countries co ON ph.country_id=co.id "+
                    " WHERE ph.id= ? " );
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next()){
                item=new Item();
                item.setId(resultSet.getInt("id"));
                item.setName(resultSet.getString("name"));
                //item.setCountry(resultSet.getString("country"));
                item.setPrice(resultSet.getDouble("price"));
                item.setAmount(resultSet.getInt("amount"));
                Country country=new Country();
                country.setId(resultSet.getInt("country_id"));
                country.setName(resultSet.getString("countryname"));
                country.setCode(resultSet.getString("code"));
                country.setCodeSimple(resultSet.getString("code_simple"));

                item.setCountry(country);
            }
            statement.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return item;
    }
    public static void updateShopItem(ShopItem shopItem){
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                    "UPDATE shopitemy SET name = ?, description = ?, type_id = ?, newprice = ? , " +
                    "oldprice = ?, onsale = ?, ispopular = ?, photo_url = ?, amount = ? "+
                    "WHERE id = ?");
            statement.setString(1,shopItem.getName());
            statement.setString(2,shopItem.getDescription());
            statement.setInt(3,shopItem.getType().getId());
            statement.setDouble(4,shopItem.getNewprice());
            statement.setDouble(5,shopItem.getOldprice());
            statement.setBoolean(6,shopItem.isOnSale());
            statement.setBoolean(7,shopItem.isPopular());
            statement.setString(8,shopItem.getUrl());
            statement.setInt(9,shopItem.getAmount());
            statement.setInt(10,shopItem.getId());
            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e){

        }
    }

    public static void updateType(Type type){
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                    "UPDATE item_tipy SET name=? WHERE id=?");
            statement.setString(1,type.getName());
            statement.setInt(2,type.getId());
            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void updateItem(Item item){
        try{
            PreparedStatement statement= connection.prepareStatement(""+
                    "UPDATE phones SET name=?, price=?,amount=?,country_id=? "+
                    "WHERE id=?");
            statement.setString(1,item.getName());
            statement.setDouble(2,item.getPrice());
            statement.setInt(3,item.getAmount());
            statement.setInt(4,item.getCountry().getId());
            statement.setInt(5,item.getId());
            statement.executeUpdate();
            statement.close();

        }
        catch (Exception e){

        }
    }

    public static void deleteShopItem(int id){
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                    "DELETE FROM shopitemy WHERE id=?");
            statement.setInt(1,id);
            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e){

        }
    }
    public static void deleteType(int id){
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                    "DELETE FROM item_tipy WHERE id=?");
            statement.setInt(1,id);
            statement.executeUpdate();
            statement.close();
        }
        catch(Exception e){
            e.printStackTrace();

        }
    }
    public static void deleteItem(int id){
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                    "DELETE FROM phones WHERE id=?");
            statement.setInt(1,id);
            statement.executeUpdate();
            statement.close();
        }
        catch(Exception e){
            e.printStackTrace();

        }
    }
    public static ArrayList<Country> getCountries(){
        ArrayList<Country> countries=new ArrayList<>();
       try {
            PreparedStatement statement=connection.prepareStatement("" +
                    "SELECT * FROM countries ORDER BY name ASC");
              ResultSet resultSet=statement.executeQuery();
              while (resultSet.next()){
                  Country country=new Country();
                  country.setId(resultSet.getInt("id"));
                  country.setName(resultSet.getString("name"));
                  country.setCode(resultSet.getString("code"));
                  country.setCodeSimple(resultSet.getString("code_simple"));
                  countries.add(country);
              }
              statement.close();
       }
       catch (Exception e){
           e.printStackTrace();
       }
       return countries;
    }

    public static Country getCountry(int id){
        Country country=null;
        try {
            PreparedStatement statement=connection.prepareStatement("" +
                    "SELECT * FROM countries "+
                      "WHERE id=?");
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next()){
                country=new Country();
                country.setId(resultSet.getInt("id"));
                country.setName(resultSet.getString("name"));
                country.setCode(resultSet.getString("code"));
                country.setCodeSimple(resultSet.getString("code_simple"));

            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return country;
    }

    public static void addUser(User user){
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                    "INSERT INTO usery (login, password,fullname) "+
                    "VALUES (?,?,?)");
            statement.setString(1,user.getLogin());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getFullname());
            statement.executeUpdate();
            statement.close();
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }


    public static User getUserByEmail(String login){
        User found = null;
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM usery WHERE login = ?");
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                found = new User();
                found.setLogin(login);
                found.setId(resultSet.getInt("id"));
                found.setPassword(resultSet.getString("password"));
                found.setFullname(resultSet.getString("fullname"));
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return found;
    }
    public static void updatePassword(User user){
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                    "UPDATE usery SET password= ? WHERE id=?");
            statement.setString(1, user.getPassword());
            statement.setInt(2,user.getId());
            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
