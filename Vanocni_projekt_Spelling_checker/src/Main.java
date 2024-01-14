import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner write = new Scanner(System.in);

        while(true){
            System.out.println("Write here: ");
            Dictionary dc = new Dictionary();
            System.out.println(dc);
            String s = write.nextLine();
            s = s.split(" ")[0];
            System.out.println(dc.returnFamiliarWords(s));
        }
    }
}