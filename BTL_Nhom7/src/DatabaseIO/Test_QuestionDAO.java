/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseIO;

import Model.Test_Question;
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
public class Test_QuestionDAO {


    public Test_QuestionDAO() {
    }
    
    public List<Test_Question> list(int Test_ID){
        List<Test_Question> list = new ArrayList<>();
        try{
            String SqlQuery = "SELECT * FROM dbo.Test_Question Where Test = ?";
            
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareStatement(SqlQuery);
            ps.setInt(1, Test_ID);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Test_Question tq = new Test_Question();
                tq.setT_QT_ID(rs.getInt("T_QT_ID"));
                tq.setTest(rs.getInt("Test"));
                tq.setQuestion(rs.getInt("Question"));
                list.add(tq);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean insertTestQuestion(int idTest, int idQuestion){
        boolean isInsert = false;
        String sqlQuerry = "Insert into  Test_Question values (?,?)";
        try{
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sqlQuerry);
            ps.setInt(1, idTest);
            ps.setInt(2, idQuestion);
            
            int rs = ps.executeUpdate();
            if(rs==1){
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
