/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseIO;

import Model.Question;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mrloc
 */
public class QuestionDAO {

    public QuestionDAO() {
        
    }

    public ArrayList<Question> getListQuestion(){
        ArrayList<Question> listQ = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Question";
        
        try {
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Question q = new Question();
                q.setQuestion_ID(rs.getInt("Question_ID"));
                q.setQuestion(rs.getString("Question"));
                q.setLevel(rs.getInt("Level"));
                q.setLesson(rs.getInt("Lesson"));
                
                listQ.add(q);
            }
        } catch (SQLException e) {
        }
        
        return listQ;
    }
    
    public boolean addQuestion(Question q){
        String sql = "INSERT INTO dbo.Question(Question, Level, Lesson)"
                + "VALUES(?, ?, ?)";
        try {
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sql);
            ps.setString(1, q.getQuestion());
            ps.setInt(2, q.getLevel());
            ps.setInt(3, q.getLesson());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
        }
           
        return false;
    }
    
    public boolean updateQuestion(Question q){
        String sql = "UPDATE dbo.Question SET Question = ?, Level = ?, Lesson = ?"
                + " WHERE Question_ID = ?";
        try {
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sql);
            ps.setString(1, q.getQuestion());
            ps.setInt(2, q.getLevel());
            ps.setInt(3, q.getLesson());
            ps.setInt(4, q.getQuestion_ID());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
        }
        
        return false;
    }
    
    public boolean deleteQuestion(int id){
        String sql = "DELETE FROM dbo.Question WHERE Question_ID = ?";
        try {
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sql);
            ps.setInt(1, id);
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
        }
        
        return false;
    }
    
    public int getLastQuestionID(){
        int id = 0;
        String sql = "SELECT TOP 1 Question_ID FROM dbo.Question ORDER BY Question_ID DESC";
        try {
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                id = rs.getInt("Question_ID");
            }
        } catch (SQLException e) {
        }
        
        return id;
    }
}
