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
public class Question {
    private int Question_ID;
    private String Question;
    private int Level;
    private int Lesson;

    public Question() {
    }

    public Question(int Question_ID, String Question, int Level, int Lesson) {
        this.Question_ID = Question_ID;
        this.Question = Question;
        this.Level = Level;
        this.Lesson = Lesson;
    }

    public int getQuestion_ID() {
        return Question_ID;
    }

    public void setQuestion_ID(int Question_ID) {
        this.Question_ID = Question_ID;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int Level) {
        this.Level = Level;
    }

    public int getLesson() {
        return Lesson;
    }

    public void setLesson(int Lesson) {
        this.Lesson = Lesson;
    }
    
}
