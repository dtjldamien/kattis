// https://open.kattis.com/problems/coconut
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class CountingClauses {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        if (m < 8) {
            pw.println("unsatisfactory");
        } else {
            pw.println("satisfactory");
        }
        pw.close();
        br.close();
    }
}
