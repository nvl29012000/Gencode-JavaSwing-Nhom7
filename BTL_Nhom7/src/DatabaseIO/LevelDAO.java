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
}
