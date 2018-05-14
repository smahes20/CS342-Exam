/*Name: Sakshi Maheshwari
NetID: smahes20*/

import java.io.PrintWriter;
import java.util.Scanner;

public class MCMAAnswer extends MCAnswer {

    public MCMAAnswer(String text, double creditIfSelected) {
        super(text, creditIfSelected);
    }
    public MCMAAnswer(Scanner sc){
        super(sc);
        creditIfSelected = sc.nextDouble();
//        System.out.println(creditIfSelected);
        text = sc.nextLine();
//        System.out.println(text);
        //System.out.println("here in mcsaanswer" + text + creditIfSelected);
        MCSAAnswer ans = new MCSAAnswer(text, creditIfSelected);
    }
    public void save(PrintWriter p){

        p.print(creditIfSelected );
        p.println(text);
    }
}
