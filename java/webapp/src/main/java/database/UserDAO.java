/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import config.DBConnection;
import static java.lang.Math.log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author rpv15
 */
public class UserDAO {
    Connection connection; 
    
    public UserDAO() throws SQLException {
        DBConnection conn = new DBConnection();
        connection = conn.getConnection("bd_app", "root", "RoPV_1840151087");
    }
    
    public List<User> getUsers(int limit)throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
        List<User> usersDB = new ArrayList<>();
            
        ps = connection.prepareStatement("SELECT * FROM user LIMIT ?");
        ps.setInt(1, limit);
        rs = ps.executeQuery();

        while(rs.next()) {
            usersDB.add(new User(rs.getString("username"), rs.getString("password")));
        }

        rs.close();
        ps.close();
        connection.close();
        
        return usersDB;
    }

    public User getUserByID(int id) throws SQLException {
        PreparedStatement preparedSt;
        ResultSet resultSt;
        User user = null;
        
        preparedSt = connection.prepareStatement("SELECT * FROM user WHERE iduser = ?");
        preparedSt.setInt(1, id);
        resultSt = preparedSt.executeQuery();

        if(resultSt.next()) {
            String username = resultSt.getString("username");
            String password = resultSt.getString("password");
            String name = resultSt.getString("name");
            String lastname = resultSt.getString("lastname");
            String email = resultSt.getString("email");

            user = new User(username, password, name, lastname, email);
        }

        resultSt.close();
        preparedSt.close();
        connection.close();
        return user;
    }
    
    public User getUserByUserName(String username) throws SQLException {
        PreparedStatement preparedSt;
        ResultSet resultSt;
        User user = null;
        
        preparedSt = connection.prepareStatement("SELECT * FROM user WHERE username = ?");
        preparedSt.setString(1, username);
        resultSt = preparedSt.executeQuery();

        if(resultSt.next()) {
            String userName = resultSt.getString("username");
            String password = resultSt.getString("password");
            String name = resultSt.getString("name");
            String lastName = resultSt.getString("lastname");
            String email = resultSt.getString("email");

            user = new User(userName, password, name, lastName, email);
        }

        return user;
    }
    
    public boolean login(String username, String password) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;

        ps = connection.prepareStatement("SELECT username, password FROM user WHERE username = ? AND password = ?");
        ps.setString(1, username);
        ps.setString(2, password);
        rs = ps.executeQuery();
        
        return rs.next();

    }
    
    public boolean createUser(String username, String password, String name, String lastname, String email, String repass) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
        
        if (password.equals(repass)) {
            try{
                ps = connection.prepareStatement("INSERT INTO user (username, password, name, lastname, email) "
                + "VALUES(?, ?, ?, ?, ?)");
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, name);
                ps.setString(4, lastname);
                ps.setString(5, email);
                ps.executeUpdate();
                return true;
            }catch(SQLException e){
                return false;
            }                 
            //ps = connection.prepareStatement("SELECT * FROM user WHERE username = ?");
            //ps.setString(1, username);
            //rs = ps.executeQuery();          
            //return rs.next();  
        }   
        else
        {
            return false; 
        }           
    }    
}
