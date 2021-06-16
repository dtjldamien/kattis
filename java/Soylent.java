// https://open.kattis.com/problems/soylent
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Soylent {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int numBottles = (int) Math.ceil(1.0 * n / 400);
            pw.println(numBottles);
        }
        pw.close();
        br.close();
    }
}
