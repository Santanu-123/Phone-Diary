package Database;

import Model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HandleDatabase {
    private static final String databaseURL = "jdbc:mysql://localhost:3306/phone";
    private static final String userName = "root";
    private static final String password = "Arijit@123";

    public HandleDatabase(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(databaseURL, userName, password);
            String createTable = "CREATE TABLE IF NOT EXISTS User_Details(" +
                    "id int AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(255) NOT NULL, " +
                    "email VARCHAR(255) NOT NULL, " +
                    "phoneNumber VARCHAR(20) NOT NULL)";

            conn.createStatement().execute(createTable);
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void addUser(String name, String email, String phoneNumber) {
        try (Connection conn = DriverManager.getConnection(databaseURL, userName, password);
                PreparedStatement pst = conn.prepareStatement("INSERT INTO User_Details " +
                        "(name, email, phoneNumber) VALUES (?, ?, ?)")) {
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, phoneNumber);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(int id, String name, String email, String phoneNumber) {
        try (Connection conn = DriverManager.getConnection(databaseURL, userName, password);
                PreparedStatement pst = conn.prepareStatement("UPDATE User_Details SET name = ?, " +
                        "email = ?, phoneNumber = ? WHERE id = ?")) {
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, phoneNumber);
            pst.setInt(4, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try (Connection conn = DriverManager.getConnection(databaseURL, userName, password);
                PreparedStatement pst = conn.prepareStatement("DELETE FROM User_Details WHERE id = ?")) {
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User searchById(int id) {
        User user = null;
        try (Connection conn = DriverManager.getConnection(databaseURL, userName, password);
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM User_Details WHERE id = ?")) {
            pst.setInt(1, id);
            try(ResultSet rs = pst.executeQuery()){
                if (rs.next()){
                    user = new User(rs.getInt("id"), rs.getString("name"),
                            rs.getString("email"), rs.getString("phoneNumber"));
                }
            }
//            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(databaseURL, userName, password);
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM User_Details");
            ResultSet rs = pst.executeQuery()){

            while(rs.next()){
                users.add(new User(rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getString("phoneNumber")));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return users;
    }
    public static void main(String[] args){
        HandleDatabase hd = new HandleDatabase();
        hd.addUser("Jana nei", "ki kore bolbo", "992345");
    }
}
