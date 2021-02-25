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
public class Test_Question {
    private int T_QT_ID;
    private int Test;
    private int Question;

    public Test_Question() {
    }

    public Test_Question(int T_QT_ID, int Test, int Question) {
        this.T_QT_ID = T_QT_ID;
        this.Test = Test;
        this.Question = Question;
    }

    public int getT_QT_ID() {
        return T_QT_ID;
    }

    public void setT_QT_ID(int T_QT_ID) {
        this.T_QT_ID = T_QT_ID;
    }

    public int getTest() {
        return Test;
    }

    public void setTest(int Test) {
        this.Test = Test;
    }

    public int getQuestion() {
        return Question;
    }

    public void setQuestion(int Question) {
        this.Question = Question;
    }
    
    
}
