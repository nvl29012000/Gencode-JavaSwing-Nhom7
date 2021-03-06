/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseIO;

import Model.Question;
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
public class QuestionDAO {

    public QuestionDAO() {
        
    }

    public Question getQuestionById(int ID) {
        Question qt = null;
        String SqlQuery = "Select * from dbo.Question where Question_ID = ? ";
        try {
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareStatement(SqlQuery);
            ps.setInt(1, ID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                qt = new Question();
                qt.setQuestion_ID(rs.getInt("Question_ID"));
                qt.setQuestion(rs.getString("Question"));
                qt.setLevel(rs.getInt("Level"));
                qt.setLesson(rs.getInt("Lesson"));
            }
        } catch (SQLException e) {
        }
        return qt;
    }
    public List<Question> getQuestionByIdTest(int idTest){
        List<Question> listQuest = new ArrayList<Question>();
        String sqlQuery = "EXEC STP_GetQuestionByIdTest ? ";
        try{
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sqlQuery);
            ps.setInt(1, idTest);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Question qt = new Question();
                qt.setQuestion_ID(rs.getInt("Question_ID"));
                qt.setQuestion(rs.getString("Question"));
                qt.setLevel(rs.getInt("Level"));
                qt.setLesson(rs.getInt("Lesson"));
                listQuest.add(qt);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return listQuest;
    }
    public List<Question> getQuestionByLevel(int level){
        List<Question> listQuest = new ArrayList<Question>();
        String sqlQuery = "EXEC STP_GetQuestionByLevel ? ";
        try{
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sqlQuery);
            ps.setInt(1, level);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Question qt = new Question();
                qt.setQuestion_ID(rs.getInt("Question_ID"));
                listQuest.add(qt);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return listQuest;
    }
    public int getMinIdQuestion(int level){
        int min = 0;
        String sqlQuerry = "EXEC STP_GetMinIdOfQuestionByLevel ?";
        try{
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sqlQuerry);
            ps.setInt(1, level);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                min = rs.getInt("Min");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return min;
    }
    public int getMaxIdQuestion(int level){
        int max = 0;
        String sqlQuerry = "EXEC STP_GetMaxIdOfQuestionByLevel ?";
        try{
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sqlQuerry);
            ps.setInt(1, level);
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
}
