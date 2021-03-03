/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseIO;

import Model.Account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mrloc
 */
public class AccountDAO {


    public AccountDAO() {
        
    }

    public Account loginAccount(String username, String password) {
        Account account = null;
        String SqlQuery = "SELECT * FROM dbo.Account WHERE UserName = ? AND PassWord = ?";
        try {
            PreparedStatement ps = DataProvider.Connection().prepareStatement(SqlQuery);
            ps.setString(1, username.trim());
            ps.setString(2, password.trim());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                account = new Account();
                account.setAccount_ID(rs.getInt("Account_ID"));
                account.setUsername(rs.getString("UserName"));
                account.setPassword(rs.getString("PassWord"));
                account.setName(rs.getString("Name"));
                account.setRole(rs.getBoolean("Roles"));
                account.setStatus(rs.getBoolean("Status"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public Account getAccount(int Account_ID) {
        Account account = null;;
        String SqlQuery = "SELECT * FROM dbo.Account WHERE Account_ID = ? ";
        try {
            PreparedStatement ps = DataProvider.Connection().prepareStatement(SqlQuery);
            ps.setInt(1, Account_ID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                account = new Account();
                account.setAccount_ID(rs.getInt("Account_ID"));
                account.setUsername(rs.getString("UserName"));
                account.setPassword(rs.getString("PassWord"));
                account.setName(rs.getString("Name"));
                account.setRole(rs.getBoolean("Roles"));
                account.setStatus(rs.getBoolean("Status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

}
