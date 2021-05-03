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
    private String Test_Name;
    private int Time;
    private int Level;

    private boolean Status;

    public Test() {
    }

    public Test(String Test_Name, int Time, int Level, boolean Status) {
        this.Test_Name = Test_Name;
        this.Time = Time;
        this.Level = Level;
        this.Status = Status;
    }

    public Test(int Test_ID, String Test_Name, int Time, int Level, boolean Status) {
        this.Test_ID = Test_ID;
        this.Test_Name = Test_Name;
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

    public String getTest_Name() {
        return Test_Name;
    }

    public void setTest_Name(String Test_Name) {
        this.Test_Name = Test_Name;
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
