/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import config.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;

/**
 *
 * @author rpv15
 */
public class AccountDAO {
    Connection connection;

    public AccountDAO() throws SQLException {
        DBConnection conn = new DBConnection();
        connection = conn.getConnection("bd_app", "root", "RoPV_1840151087");
    }
     
     public List<Account> getAccounts(int userId) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
        List<Account> accountDB = new ArrayList<>();
            
        ps = connection.prepareStatement("SELECT * FROM account WHERE iduser = ?");
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                accountDB.add(new Account(rs.getInt("accountnumber"), rs.getString("type"), rs.getString("currency"), rs.getDouble("balance"), rs.getInt("iduser")));
            }
            
            rs.close();
            ps.close();
            connection.close();
        
        return accountDB;
    }
}
