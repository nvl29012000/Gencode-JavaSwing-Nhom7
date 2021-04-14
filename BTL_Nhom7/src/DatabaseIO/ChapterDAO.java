
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
        }
        
        return listC;
    }  

}
