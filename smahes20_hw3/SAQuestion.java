/*Name: Sakshi Maheshwari
NetID: smahes20*/

import java.io.PrintWriter;
import java.util.Scanner;

public class SAQuestion extends Question  {

    public SAQuestion(String text, double maxValue){

        super(text, maxValue);
    }
    public SAQuestion(Scanner sc){

        super(sc);
        maxValue = sc.nextDouble();
        sc.nextLine();
        text = sc.nextLine();
        //System.out.println("text: " + text);
    }

    public Answer getNewAnswer(){
        SAAnswer ans = new SAAnswer("");
        return ans;
    }
    public Answer getNewAnswer(String text){
        SAAnswer ans = new SAAnswer(text);
        return ans;
    }
    public void getAnswerFromStudent(){
// Declare the object and initialize with
        Scanner scan =  ScannerFactory.getKeyboardScanner();
//        Scanner scanans =  new Scanner(System.in);

        // String input
        String ans = scan.nextLine();
        //can be converted to lowercase as well

        studentAnswer = new SAAnswer(ans.toLowerCase());
    }
    public double getValue(){

        return studentAnswer.getCredit(rightAnswer);
    }
    public void save(PrintWriter p){
        p.println();
        p.println("SAQuestion");
        p.println(maxValue);
        p.println(text);
        rightAnswer.save(p);
    }
    public void saveStudentAnswers(PrintWriter p){
        p.println();
        p.println("SAAnswer");
        getAnswerFromStudent();
        p.println((((SAAnswer)(studentAnswer)).text).trim());
    }
    public void restoreStudentAnswers(Scanner sc){
        String ans = sc.nextLine();

        SAAnswer newans = new SAAnswer(ans);
        studentAnswer = newans;
    }
}
