
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseIO;

import Model.Chapter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class ChapterDAO {

    public ChapterDAO() {
    }
    
    public ArrayList<Chapter> getListChapter(){
        ArrayList<Chapter> listC = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Chapter";
        
        try {
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Chapter c = new Chapter();
                c.setChapter_ID(rs.getInt("Chapter_ID"));
                c.setChapter(rs.getInt("Chapter"));
                c.setChapter_Name(rs.getString("Chapter_Name"));
                
                listC.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listC;
    }  
    
    public Chapter getChapterByChapter_ID(int Chapter_ID){
        String sql = "SELECT * FROM dbo.Chapter WHERE Chapter_ID = ?";
        Chapter c = new Chapter();
        try {
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sql);
            ps.setInt(1, Chapter_ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c.setChapter_ID(rs.getInt("Chapter_ID"));
                c.setChapter(rs.getInt("Chapter"));
                c.setChapter_Name(rs.getString("Chapter_Name"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
    
    public Chapter getChapterByChapter(int Chapter){
        String sql = "SELECT * FROM dbo.Chapter WHERE Chapter = ?";
        Chapter c = new Chapter();
        try {
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sql);
            ps.setInt(1, Chapter);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c.setChapter_ID(rs.getInt("Chapter_ID"));
                c.setChapter(rs.getInt("Chapter"));
                c.setChapter_Name(rs.getString("Chapter_Name"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
}
