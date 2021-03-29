/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseIO;

import Model.Lesson;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author BINHBILL
 */
public class LessonDAO {

    public LessonDAO() {
    }
    public ArrayList<Lesson> getFullListLessonByChapter(int chapter){
        ArrayList<Lesson> list = new ArrayList<Lesson>();
        try{
            String query = "SELECT * FROM Lesson WHERE Chapter = ?";
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(query);
            ps.setInt(1, chapter);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Lesson ch = new Lesson(rs.getInt("Lesson_ID"), rs.getInt("Lesson"), rs.getString("Lesson_Name"),chapter);
                list.add(ch);
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
