import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class IsItHalloween {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        if (input[0].equals("OCT") && input[1].equals("31")) {
            pw.println("yup");
        } else if (input[0].equals("DEC") && input[1].equals("25")) {
            pw.println("yup");
        } else {
            pw.println("nope");
        }
        pw.close();
        br.close();
    }
}