/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseIO;

import Model.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mrloc
 */
public class TestDAO {

    private Connection conn;

    public TestDAO() {
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

    public List<Test> listTest() {
        List<Test> list = new ArrayList<>();
        String SqlQuery = "SELECT * FROM dbo.Test WHERE Status = 1";
        try {
            PreparedStatement ps = conn.prepareStatement(SqlQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Test test = new Test();
                test.setTest_ID(rs.getInt("Test_ID"));
                test.setTest_Code(rs.getString("Test_Code"));
                test.setNumber_Of_Question(rs.getInt("Number_Of_Question"));
                test.setTime(rs.getInt("Time"));
                test.setLevel(rs.getInt("Level"));
                test.setStatus(rs.getBoolean("Status"));
                list.add(test);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        List<Test> list = new ArrayList<>();
        TestDAO dao = new TestDAO();
        list = dao.listTest();
        System.out.println("List Test");
        for (Test item : list) {
            System.out.println("ID : " + item.getTest_ID());
            System.out.println("Code : " + item.getTest_Code());
            System.out.println("Number Of Question : " + item.getNumber_Of_Question());
            System.out.println("Time : " + item.getTime());
            System.out.println("Level : " + item.getLevel());
            System.out.println("Status : " + item.isStatus());
        }
    }
}
