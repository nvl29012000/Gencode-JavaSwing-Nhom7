/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseIO;

import Model.Answer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mrloc
 */
public class AnswerDAO {

    public AnswerDAO() {
        
    }

    public List<Answer> list(int Question_ID) {
        List<Answer> list = new ArrayList<>();
        try {
            String SqlQuery = "SELECT * FROM dbo.Answer Where Question = ?";

            PreparedStatement ps = DataProvider.getInstance().Connection().prepareStatement(SqlQuery);
            ps.setInt(1, Question_ID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Answer as = new Answer();
                as.setAnswer_ID(rs.getInt("Answer_ID"));
                as.setAnswer(rs.getString("Answer"));
                as.setCorrect(rs.getBoolean("Correct"));
                as.setQuestion(rs.getInt("Question"));
                list.add(as);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean addAnswer(Answer asw){
        String sql = "INSERT INTO dbo.Answer(Answer, Correct, Question)"
                + "VALUES(?, ?, ?)";
        try {
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sql);
            ps.setString(1, asw.getAnswer());
            ps.setBoolean(2, asw.isCorrect());
            ps.setInt(3, asw.getQuestion());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
           
        return false;
    }
    
    public boolean updateAnswer(Answer asw){
        String sql = "UPDATE dbo.Answer SET Answer = ?, Correct = ?"
                + " WHERE Answer_ID = ?";
        try {
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sql);
            ps.setString(1, asw.getAnswer());
            ps.setBoolean(2, asw.isCorrect());
            ps.setInt(3, asw.getAnswer_ID());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
}
