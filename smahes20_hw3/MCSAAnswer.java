import java.io.PrintWriter;
import java.util.Scanner;

/*Name: Sakshi Maheshwari
NetID: smahes20*/
public class MCSAAnswer extends MCAnswer{

    public MCSAAnswer(String text, double creditIfSelected){
        super(text, creditIfSelected);

    }
    public MCSAAnswer(Scanner sc){
        super(sc);
        creditIfSelected = sc.nextDouble();
        text = sc.nextLine();

       //System.out.println("here in mcsaanswer" + text + creditIfSelected);
        MCSAAnswer ans = new MCSAAnswer(text, creditIfSelected);
    }
    public void save(PrintWriter p){

        p.print(creditIfSelected );
        p.println(text);
    }
}
