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

/**
 *
 * @author mrloc
 */
public class QuestionDAO {

    private Connection conn;

    public QuestionDAO() {
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

    public Question getQuestion(int ID) {
        Question qt = null;
        String SqlQuery = "Select * from dbo.Question where Question_ID = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(SqlQuery);
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
}
