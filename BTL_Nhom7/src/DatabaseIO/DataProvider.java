/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseIO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataProvider {
    
    private static Connection conn;

    public DataProvider() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;database=TracNghiemCNPM;";
            String username = "sa";
            String password = "vietloc123";
            conn = DriverManager.getConnection(connectionUrl, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Failed");
        }
    }
    
    public static Connection Connection()
    {
        return conn;
    }
}
