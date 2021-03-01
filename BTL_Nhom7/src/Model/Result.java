/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author mrloc
 */
public class Result {
    private int Result_ID;
    private int Account;
    private int Test;
    private int Time;
    private int Correct_QT;
    private Date date;

    public Result() {
    }
    
    public Result(int Account, int Test, int Time, int Correct_QT, Date date){
        this.Account = Account;
        this.Test = Test;
        this.Time = Time;
        this.Correct_QT = Correct_QT;
        this.date = date;
    }
    
    public Result(int Result_ID, int Account, int Test, int Time, int Correct_QT, Date date) {
        this.Result_ID = Result_ID;
        this.Account = Account;
        this.Test = Test;
        this.Time = Time;
        this.Correct_QT = Correct_QT;
        this.date = date;
    }

    public int getResult_ID() {
        return Result_ID;
    }

    public void setResult_ID(int Result_ID) {
        this.Result_ID = Result_ID;
    }

    public int getAccount() {
        return Account;
    }

    public void setAccount(int Account) {
        this.Account = Account;
    }

    public int getTest() {
        return Test;
    }

    public void setTest(int Test) {
        this.Test = Test;
    }

    public int getTime() {
        return Time;
    }

    public void setTime(int Time) {
        this.Time = Time;
    }

    public int getCorrect_QT() {
        return Correct_QT;
    }

    public void setCorrect_QT(int Correct_QT) {
        this.Correct_QT = Correct_QT;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
