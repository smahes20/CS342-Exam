/*Name: Sakshi Maheshwari
NetID: smahes20*/

import java.io.PrintWriter;
import java.util.*;

public class Exam {
    private List<Question> questions;
    private String text;

    public Exam(String text){
        this.text = text;
        questions = new ArrayList<Question>();
    }

    public Exam(Scanner sc){
        questions = new ArrayList<Question>();
        String name, exam;
        name = sc.nextLine();
        exam = name;
        text = exam;

        while(sc.hasNext()){
            //System.out.println("entered while loop");
            name = sc.nextLine();
            if (name.equals("MCSAQuestion")){
                MCSAQuestion mcq = new MCSAQuestion(sc);
                questions.add(mcq);
                //create the answer now
                //MCSAAnswer mcsa = new MCSAAnswer(sc);
                int numberans = sc.nextInt();
                sc.nextLine();
                for(int i = 0; i < numberans; i++){
                    MCSAAnswer ans = new MCSAAnswer(sc);
                    mcq.answers.add(ans);
                }
            }
            else if(name.equals("SAQuestion")){

                SAQuestion sa = new SAQuestion(sc);
                questions.add(sa);

                SAAnswer ans = new SAAnswer(sc);
                sa.rightAnswer = ans;
            }
            else if(name.equals("MCMAQuestion")){
                MCMAQuestion mcm = new MCMAQuestion(sc);
                questions.add(mcm);
                int numberans = sc.nextInt();
                sc.nextLine();
                for(int i = 0; i < numberans; i++){
                    MCMAAnswer ans = new MCMAAnswer(sc);
                    mcm.answers.add(ans);
                }
            }
        }
    }
    public void print(){
        System.out.println(text);
        for (int i = 0; i <questions.size(); i ++){
            System.out.print("Question " + (i+ 1) + ":  ");
            questions.get(i).print();
        }
    }
    public void AddQuestion(Question question){

        this.questions.add(question);
    }

    public void reorderQuestion(){
        Collections.shuffle(questions, new Random());

    }
    public void reorderMCAnswers(int position){
        //MCQuestion shuffle = new MCQuestion(" ", 1 );
        if (position < 0){
            for(int i = 0; i < questions.size(); i ++){
                ((MCSAQuestion)(questions.get(i))).reorderAnswers();
            }
        }
        else{
            ((MCSAQuestion)(questions.get(position- 1))).reorderAnswers();
        }
    }

    public void getAnswerFromStudent(int position) {
        System.out.println("Question " + position);
        (questions.get(position - 1)).getAnswerFromStudent(); //something is wrong here

    }

    public double getValue(){
        int sum = 0;
        for (int i = 0; i < questions.size(); i++){
            sum += (questions.get(i)).getValue();
        }
        //System.out.println("Total points: " + sum);
        return sum;
    }

    public void reportQuestionValue(){
        System.out.println();
        System.out.println("EXAM RESULTS");
        System.out.println("Q  POINTS");
        int sum = 0;
        for (int i = 0; i < questions.size(); i++){
            System.out.println("Q" + (i+ 1) + "  "+ (questions.get(i)).getValue());
            sum += questions.get(i).getValue();
        }
        //prints the total
        System.out.println("Total points earned on the exam: " + sum);
    }
    public void save(PrintWriter p){
        //System.out.println("Title: " + this.text);
        p.println(text);
        for(int i =0; i < questions.size(); i++){
           questions.get(i).save(p);
        }
    }
    public void saveStudentAnswers(PrintWriter p){
        Scanner scan =  ScannerFactory.getKeyboardScanner();
        System.out.println("Student Name: ");
        String ans = scan.nextLine();
        p.println(ans);
        for(int i =0; i < questions.size(); i++){
            System.out.println("Enter answer for Question " + (i+1) + ": ");
            questions.get(i).saveStudentAnswers(p);
        }
    }
    public void restoreStudentAnswer(Scanner sc){
        String file;
        int i =0;
        while(sc.hasNext()){

            file = sc.nextLine();
            if (file.equals("MCSAAnswer") || file.equals("MCMAAnswer") || file.equals("SAAnswer")){
                questions.get(i).restoreStudentAnswers(sc);
//                System.out.println("file" + file);
              i++;
            }

        }
    }

}