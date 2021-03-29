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
 * @author BINHBILL
 */
public class ChapterDAO {

    public ChapterDAO() {
    }
    public ArrayList<Chapter> getFullListChapter(){
        ArrayList<Chapter> list = new ArrayList<Chapter>();
        try{
            String query = "SELECT * FROM Chapter";
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(query);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Chapter ch = new Chapter(rs.getInt("Chapter_ID"), rs.getInt("Chapter"), rs.getString("Chapter_Name"));
                list.add(ch);
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
