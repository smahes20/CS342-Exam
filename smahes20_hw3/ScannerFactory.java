
/*Name: Sakshi Maheshwari
NetID: smahes20*/
import java.util.*;
public class ScannerFactory {
    private static Scanner KeyboardScanner = null;
    public static Scanner getKeyboardScanner(){
        if (KeyboardScanner == null){
            KeyboardScanner = new Scanner(System.in);
        }
        return KeyboardScanner;
    }
//    public void finalize(){
//        KeyboardScanner.close();
//        return;
//    }
}
