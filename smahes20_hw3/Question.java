/*Name: Sakshi Maheshwari
NetID: smahes20*/

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public abstract class Question {

    protected String text;
    protected double maxValue;
    protected Answer rightAnswer;
    protected Answer studentAnswer;


    public Question(String text, double maxValue) {
        this.text = text;
        this.maxValue = maxValue;

    }
    public Question(Scanner sc){

        //Scanner File = new Scanner(file);
//        rightAnswer = null;
//        studentAnswer = null;
    }
    public void print() {

        System.out.println(text);
    }

    public void setRightAnswer(Answer ans) {

        rightAnswer = ans;
    }

    public abstract Answer getNewAnswer();

    public abstract void getAnswerFromStudent();

    public abstract double getValue();
    public abstract void save(PrintWriter p);
    public void saveStudentAnswers(PrintWriter p){
    }
    public void restoreStudentAnswers(Scanner sc){
    }


}