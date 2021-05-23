
// https://open.kattis.com/problems/fyi
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FYI {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String n = br.readLine();
        if (n.substring(0, 3).equals("555")) {
            pw.println("1");
        } else {
            pw.println("0");
        }
        pw.close();
        br.close();
    }
}