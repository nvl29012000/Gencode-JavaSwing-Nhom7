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


    public TestDAO() {
    }

    public List<Test> getFullListTest() {
        List<Test> list = new ArrayList<>();
        String SqlQuery = "SELECT * FROM dbo.Test WHERE Status = 1";
        try {
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareStatement(SqlQuery);
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
    
    public Test getTest(int Test_ID){
        Test test = null;
        String SqlQuery = "SELECT * FROM dbo.Test WHERE Test_ID = ?";
        try {
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareStatement(SqlQuery);
            ps.setInt(1, Test_ID);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    test = new Test();
                    test.setTest_ID(rs.getInt("Test_ID"));
                    test.setTest_Code(rs.getString("Test_Code"));
                    test.setNumber_Of_Question(rs.getInt("Number_Of_Question"));
                    test.setTime(rs.getInt("Time"));
                    test.setLevel(rs.getInt("Level"));
                    test.setStatus(rs.getBoolean("Status"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return test;
    }
    public int getMaxIdTest(){
        int max = 0;
        String sqlQuerry = "SELECT MAX(Test_ID) AS Max FROM Test WHERE Status = 1";
        try{
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sqlQuerry);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                max = rs.getInt("Max");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return max;
    }
    public boolean insertTest(Test t){
        boolean isInsert = false;
        String sqlQuerry = "Insert into Test values (?,?,?,?,?)";
        try{
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sqlQuerry);
            ps.setString(1, t.getTest_Code());
            ps.setInt(2, t.getNumber_Of_Question());
            ps.setInt(3, t.getTime());
            ps.setInt(4, t.getLevel());
            ps.setBoolean(6, t.isStatus());
            
            int rs = ps.executeUpdate();
            if(rs == 1){
                isInsert = true;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            isInsert = false;
        }
        return isInsert;
    }
}
