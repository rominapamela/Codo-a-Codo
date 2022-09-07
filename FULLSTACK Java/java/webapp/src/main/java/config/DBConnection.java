/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rpv15
 */
public class DBConnection {
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String host = "jdbc:mysql://localhost:3306/";
    
    public Connection getConnection(String database, String userMysql, String passMysql ) throws SQLException {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(host + database, userMysql, passMysql);
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
