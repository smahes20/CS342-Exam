/*Name: Sakshi Maheshwari
NetID: smahes20*/

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.*;

public class MCMAQuestion extends MCQuestion {

    protected ArrayList<Answer> studentAnswer;
    protected double baseCredit;

    public MCMAQuestion(String text, double maxValue, double baseCredit){

        super(text, maxValue);
        this.baseCredit = baseCredit;
        studentAnswer = new ArrayList<Answer>();

    }
    public MCMAQuestion(Scanner sc){
        super(sc);
        studentAnswer = new ArrayList<Answer>();
        maxValue = sc.nextDouble();
        //System.out.println("maxvalue: " + maxValue);
        sc.nextLine();

        text = sc.nextLine();
        //System.out.println("text: " + text);

        baseCredit = sc.nextDouble();
    }
    public Answer getNewAnswer(){
        //ask user for input or send null string and
        MCMAAnswer value = new MCMAAnswer(null, 0.0);
        return value;
    }

    public Answer getNewAnswer(String text, double creditIfSelected){
        MCMAAnswer value = new MCMAAnswer(text, creditIfSelected);
        return value;
    }

    public void getAnswerFromStudent(){

        // Declare the object and initialize with
        Scanner scan =  ScannerFactory.getKeyboardScanner();
        String ans = scan.nextLine();
        String[] parts = ans.split(" ");

        //MCMAAnswer newAnswer = new MCMAAnswer(" ", 0);
        for(int i = 0; i < parts.length; i++){

            //get the Answer from the array list at a particular position
            if (parts[i].equals("a")){
                studentAnswer.add(answers.get(0));
            }
            else if (parts[i].equals("b")){
                studentAnswer.add(answers.get(1));
            }
            else if (parts[i].equals("c")){
                studentAnswer.add(answers.get(2));
            }
            else if (parts[i].equals("d")){

                studentAnswer.add(answers.get(3));
            }
            else if (parts[i].equals("e")){

                studentAnswer.add(answers.get(4));
            }
        }
        //System.out.println("Enter Answer: " + ((MCAnswer)(studentAnswer.get(0))).text);
    }
    public double getValue(){
        int sum = 0;
        for( int i = 0; i< studentAnswer.size(); i++){
            sum += super.getValue((MCAnswer)answers.get(i));
        }
        return (sum + baseCredit);
    }
    public void save(PrintWriter p){
        p.println();
        p.println("MCMAQuestion");
        p.println(maxValue);
        p.println(text);
        p.println(baseCredit);
        p.println(answers.size());
        for(int i =0; i < answers.size(); i++){
            answers.get(i).save(p);
        }
    }
    public void saveStudentAnswers(PrintWriter p) {
        p.println();
        p.println("MCMAAnswer");
        getAnswerFromStudent();
        p.println(studentAnswer.size());

        for(int i = 0; i < studentAnswer.size(); i ++){
            p.println((((MCAnswer)(studentAnswer.get(i))).text).trim());
        }
    }
    public void restoreStudentAnswers(Scanner sc){
        int file = sc.nextInt();
        sc.nextLine();
        //System.out.println("in mcma");
        //System.out.println(fileans);
       String[] array = new String[file];

       int i = 0;
//       String ans = sc.nextLine();
       while(i < file){
           String ans = sc.nextLine();

           array[i] = ans;

           i++;
       }
           for (int k = 0; k < file; k++){

                //add
               //((MCAnswer)(studentAnswer.get(k))).text = array[k];
//               System.out.println("array:" + array[k]);
//               System.out.println("mcma:" + ((MCMAAnswer)(answers.get(k))).text);
               if (array[k].equals((((MCMAAnswer)(answers.get(k))).text).trim())){
                   studentAnswer.add(answers.get(k));
//                   System.out.println("ans added was:" +((MCMAAnswer)(answers.get(k))).text);
               }
//               System.out.println("in the for3 loop");
           }
    }
}
//compare



//        for(int i = 0; i < answers.size(); i++) {
//            //((MCAnswer)(answers.get(i))).text = (MCAnswer)(studentAnswer.get(i)).text
//           for(int j = 0; j < studentAnswer.size(); j++){
//               (MCAnswer)(answers.get(i)) = (studentAnswer).get(i);
//           }
//       }