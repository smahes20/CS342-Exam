/*Name: Sakshi Maheshwari
NetID: smahes20*/

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class ExamTester {
    //public Random randomGenerator;

    public static void main(String[] args) {
        System.out.println("Name: Sakshi Maheshwari");
        System.out.println("NetID: smahes20");


        Scanner scan = null;
       try{

           scan = new Scanner(new BufferedReader(new FileReader("Exam.txt")));
           //System.out.println(scan.nextLine());
           //System.out.println(scan.hasNextLine());
       }
       catch (FileNotFoundException e) {
           e.printStackTrace();
       }
        Exam e1 = new Exam(scan);
        e1.print();
        System.out.println("*****REORDER QUESTIONS*****");
        e1.reorderQuestion();
        e1.print();

        String File = "PrintExam.txt";
        PrintWriter print = null;
        try{
            print = new PrintWriter(File);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }


        e1.save(print);
        print.close();

        String File2 = "studentans.txt";
        PrintWriter print2 = null;
        try{
            print2 = new PrintWriter(File2);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        e1.saveStudentAnswers(print2);
        print2.close();

        //clear memory
        e1 = null;

        try{

            scan = new Scanner(new BufferedReader(new FileReader("PrintExam.txt")));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        e1 = new Exam(scan);

        scan = null;
        try{

            scan = new Scanner(new BufferedReader(new FileReader("studentans.txt")));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        e1.restoreStudentAnswer(scan);
        e1.reportQuestionValue();
    }
}
