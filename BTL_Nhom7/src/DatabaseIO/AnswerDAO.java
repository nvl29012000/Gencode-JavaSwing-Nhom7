/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseIO;

import Model.Answer;
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
public class AnswerDAO {

    public AnswerDAO() {
        
    }

    public List<Answer> list(int Question_ID) {
        List<Answer> list = new ArrayList<>();
        try {
            String SqlQuery = "SELECT * FROM dbo.Answer Where Question = ?";

            PreparedStatement ps = DataProvider.Connection().prepareStatement(SqlQuery);
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
    
}
