/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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

    public Result() {
    }

    public Result(int Result_ID, int Account, int Test, int Time, int Correct_QT) {
        this.Result_ID = Result_ID;
        this.Account = Account;
        this.Test = Test;
        this.Time = Time;
        this.Correct_QT = Correct_QT;
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
    
    
}
