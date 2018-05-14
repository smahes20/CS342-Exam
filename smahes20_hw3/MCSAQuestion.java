/*Name: Sakshi Maheshwari
NetID: smahes20*/
import java.io.PrintWriter;
import java.util.*;

public class MCSAQuestion extends MCQuestion {

    public MCSAQuestion(String text, double maxValue){

        super(text, maxValue);
    }
    public MCSAQuestion (Scanner sc) {
        super(sc);
        maxValue = sc.nextDouble();
        //System.out.println("maxvalue: " + maxValue);
        sc.nextLine();

        text = sc.nextLine();
        //System.out.println("text: " + text);

    }
    public Answer getNewAnswer(){
        //ask user for input or send null string and
        MCSAAnswer value = new MCSAAnswer(null, 0.0);
        return value;
    }

    public Answer getNewAnswer(String text, double creditIfSelected){
        MCSAAnswer value = new MCSAAnswer(text, creditIfSelected);
        return value;
    }

    public void getAnswerFromStudent(){

        // Declare the object and initialize with
        Scanner scan =  ScannerFactory.getKeyboardScanner();

        // String input
        String ans = scan.nextLine();

        MCSAAnswer newAnswer = new MCSAAnswer(" ", 0);
        //or can be " "
        int i =0;
        //get the Answer from the array list at a particular position
        if (ans.equals("a")){

            i = 0;
        }
        else if (ans.equals("b")){

            i = 1;
        }
        else if (ans.equals("c")){

            i = 2;
        }
        else if (ans.equals("d")){

            i = 3;
        }
        else if (ans.equals("e")){
            i = 4;
        }
        newAnswer.text = (answers.get(i)).text;
        newAnswer.creditIfSelected = (answers.get(i)).creditIfSelected;

        studentAnswer = newAnswer;

    }
    public double getValue(){
       // return studentAnswer.getCredit(rightAnswer);
        return super.getValue((MCAnswer)studentAnswer);
    }
    public void save(PrintWriter p){
//        super(p);
        p.println();
        p.println("MCSAQuestion");
        p.println(maxValue);
        p.println(text);
        p.println(answers.size());
        for(int i =0; i < answers.size(); i++){
            answers.get(i).save(p);
        }
    }
    public void saveStudentAnswers(PrintWriter p){
        p.println();
        p.println("MCSAAnswer");
        getAnswerFromStudent();
        p.println((((MCAnswer)(studentAnswer)).text).trim());
    }
    public void restoreStudentAnswers(Scanner sc){
        String file = sc.nextLine();
        String ques;

        for(int i = 0; i < answers.size(); i++) {
            ques = ((MCAnswer)(answers.get(i))).text;
            //System.out.println("ques: " + ques);
            if ((ques.trim()).equals(file)) {
                //System.out.println("MATCH");
                studentAnswer = (MCAnswer)(answers.get(i));
                //System.out.println("ques: " + ((MCAnswer)(studentAnswer)).text);
            }
        }

    }
}
