/*Name: Sakshi Maheshwari
NetID: smahes20*/


import java.io.PrintWriter;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public abstract class MCQuestion extends Question {

    protected List<MCAnswer> answers;

    protected MCQuestion(String text, double maxValue){
        super(text, maxValue);
        answers = new ArrayList<MCAnswer>();

    }
    protected MCQuestion(Scanner sc){

        super(sc);
        answers = new ArrayList<MCAnswer>();
    }
    public void print() {

        System.out.println(text);
        //System.out.println();
        for (int i = 0; i < 5; i++){
            System.out.print("  "+(char)(i+97) + ".");
            answers.get(i).print();
        }
        System.out.println("");
    }

    public void AddAnswer(MCAnswer answer) {

        this.answers.add(answer);
    }

    public void reorderAnswers(){

        Collections.shuffle(answers, new Random());

    }
    public double getValue(MCAnswer answer){
        //int credit = 0;
        for (int i = 0; i < answers.size(); i++){

//            if ((((MCAnswer)answers.get(i)).text).equals(answer.text)){
//                return ((answers.get(i).creditIfSelected)*maxValue);
//            }
            //System.out.println("in get value");
            return (maxValue *(answer.getCredit(answers.get(i))));
//            if (answer.getCredit(answers.get(i))){
//                return maxValue *(answer.getCredit(answers.get(i)));
//            }
        }
        return 0;
    }
    public void save(PrintWriter p){

    }
}
