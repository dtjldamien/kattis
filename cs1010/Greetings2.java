//https://open.kattis.com/problems/greetings2
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Greetings2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String s = br.readLine();
        int numE = s.length() - 2;
        pw.print('h');
        for (int i = 0; i < numE * 2; i++) {
            pw.print('e');
        }
        pw.println('y');
        pw.close();
        br.close();
    }
}