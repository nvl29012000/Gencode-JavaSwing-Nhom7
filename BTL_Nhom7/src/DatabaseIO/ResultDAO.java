/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseIO;

import Model.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mrloc
 */
public class ResultDAO {
    private Connection conn;

    public ResultDAO() {
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
    
    public boolean insertResult(Result a){
        boolean isInserted = false;
        String SqlQuery = "Insert into dbo.Result values(?,?,?,?,?)";
        try{
            PreparedStatement ps = conn.prepareStatement(SqlQuery);
            ps.setInt(1, a.getAccount());
            ps.setInt(2, a.getTest());
            ps.setInt(3, a.getTime());
            ps.setInt(4, a.getCorrect_QT());
            ps.setDate(5, a.getDate());
            
            int rs = ps.executeUpdate();
            if(rs == 1){
                isInserted = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
            isInserted = false;
        }
        return isInserted;
    }
}
