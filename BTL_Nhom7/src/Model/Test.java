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
public class Test {
    private int Test_ID;
    private String Test_Code;
    private int Number_Of_Question;
    private int Time;
    private int Level;
    private boolean Status;

    public Test() {
    }

    public Test(int Test_ID, String Test_Code, int Number_Of_Question, int Time, int Level, boolean Status) {
        this.Test_ID = Test_ID;
        this.Test_Code = Test_Code;
        this.Number_Of_Question = Number_Of_Question;
        this.Time = Time;
        this.Level = Level;
        this.Status = Status;
    }

    public int getTest_ID() {
        return Test_ID;
    }

    public void setTest_ID(int Test_ID) {
        this.Test_ID = Test_ID;
    }

    public String getTest_Code() {
        return Test_Code;
    }

    public void setTest_Code(String Test_Code) {
        this.Test_Code = Test_Code;
    }

    public int getNumber_Of_Question() {
        return Number_Of_Question;
    }

    public void setNumber_Of_Question(int Number_Of_Question) {
        this.Number_Of_Question = Number_Of_Question;
    }

    public int getTime() {
        return Time;
    }

    public void setTime(int Time) {
        this.Time = Time;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int Level) {
        this.Level = Level;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }   
}
