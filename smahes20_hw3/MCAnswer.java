/*Name: Sakshi Maheshwari
NetID: smahes20*/

import java.io.PrintWriter;
import java.util.*;

public abstract class MCAnswer extends Answer{

    protected String text;
    //protected boolean selected;
    protected double creditIfSelected;

    protected MCAnswer(){}

    protected MCAnswer(String text, double creditIfSelected){
        this.text = text;
        //selected = false;
        this.creditIfSelected = creditIfSelected;
    }
    public MCAnswer(Scanner sc){
       super(sc);
    }
    public void print(){

        System.out.println(text);
    }

//    public void setSelected(boolean selected){ //selects the given answer
//        //if some answer is selected
//        if (selected == true){
//            creditIfSelected = 1;
//        }
//        else {
//            creditIfSelected = 0;
//        }
//        //this.selected = selected
//    }
    public double getCredit(Answer rightAnswer){

        String correctAnswer = ((MCAnswer)rightAnswer).text;
//        System.out.println("text " + text);
//        System.out.println("answer " + correctAnswer);

        if (text.equals(correctAnswer)){ // as we compare references to object class
            return creditIfSelected;//or can return creditIf selected
        }
        else{
            return creditIfSelected;//0
        }

    }
    public void save(PrintWriter p){

    }
}