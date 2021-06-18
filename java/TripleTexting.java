// https://open.kattis.com/problems/tripletexting
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TripleTexting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String s = br.readLine();
        String firstWord = s.substring(0, s.length() / 3);
        String secondWord = s.substring(s.length() / 3, 2 * s.length() / 3);
        String thirdWord = s.substring(2 * s.length() / 3);
        if (firstWord.equals(secondWord)) {
            pw.println(firstWord);
        } else if (firstWord.equals(thirdWord)) {
            pw.println(firstWord);
        } else {
            pw.println(secondWord);
        }
        pw.close();
        br.close();
    }
}
