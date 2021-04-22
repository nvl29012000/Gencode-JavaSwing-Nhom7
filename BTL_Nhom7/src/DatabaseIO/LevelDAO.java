/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseIO;

import Model.Level;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BINHBILL
 */
public class LevelDAO {

    public LevelDAO() {
    }
    public ArrayList<Level> getListLevel(){
        ArrayList<Level> list = new ArrayList<Level>();
        try{
            String query = "SELECT * FROM Level";
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(query);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Level lv = new Level(rs.getInt("Level_ID"),rs.getString("Level_Name"));
                list.add(lv);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    public Level getLevelByLevel_Name(String levelName){
        Level lv = new Level();
        try {
            String sql = "SELECT * FROM dbo.Level WHERE Level_Name = ?";
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sql);
            ps.setString(1, levelName);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                lv.setLevel_ID(rs.getInt("Level_ID"));
                lv.setLevel_Name(rs.getString("Level_Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lv;
    }
    public Level getLevelByLevel_ID(int levelID){
        Level lv = new Level();
        try {
            String sql = "SELECT * FROM dbo.Level WHERE Level_ID = ?";
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sql);
            ps.setInt(1, levelID);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                lv.setLevel_ID(rs.getInt("Level_ID"));
                lv.setLevel_Name(rs.getString("Level_Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lv;
    }
}
