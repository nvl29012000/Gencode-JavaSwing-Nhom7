
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
 * @author ADMIN
 */
public class LessonDAO {

    public LessonDAO() {
    }
    public ArrayList<Lesson> getListLesson(){
        ArrayList<Lesson> listL = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Lesson";
        
        try {
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Lesson l = new Lesson();
                l.setLesson_ID(rs.getInt("Lesson_ID"));
                l.setLesson(rs.getInt("Lesson"));
                l.setLesson_Name(rs.getString("Lesson_Name"));
                l.setChapter(rs.getInt("Chapter"));
                
                listL.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listL;
    }
    public ArrayList<Lesson> getListLessonByChapter(int chapter_ID){
        ArrayList<Lesson> listL = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Lesson WHERE Chapter = ?";
        
        try {
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sql);
            ps.setInt(1, chapter_ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Lesson l = new Lesson();
                l.setLesson_ID(rs.getInt("Lesson_ID"));
                l.setLesson(rs.getInt("Lesson"));
                l.setLesson_Name(rs.getString("Lesson_Name"));
                l.setChapter(rs.getInt("Chapter"));
                
                listL.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listL;
    }
    public Lesson getLessonByLessonAndChapter(int Lesson, int Chapter){
        String sql = "SELECT * FROM dbo.Lesson WHERE Lesson = ? AND Chapter = ?";
        Lesson l = new Lesson();
        try {
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sql);
            ps.setInt(1, Lesson);
            ps.setInt(2, Chapter);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                l.setLesson_ID(rs.getInt("Lesson_ID"));
                l.setLesson(rs.getInt("Lesson"));
                l.setLesson_Name(rs.getString("Lesson_Name"));
                l.setChapter(rs.getInt("Chapter"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }
    public Lesson getLessonByLesson_ID(int Lesson_ID){
        String sql = "SELECT * FROM dbo.Lesson WHERE Lesson_ID = ?";
        Lesson l = new Lesson();
        try {
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sql);
            ps.setInt(1, Lesson_ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                l.setLesson_ID(rs.getInt("Lesson_ID"));
                l.setLesson(rs.getInt("Lesson"));
                l.setLesson_Name(rs.getString("Lesson_Name"));
                l.setChapter(rs.getInt("Chapter"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }
}
