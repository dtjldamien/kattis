//https://open.kattis.com/problems/chanukah
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Chanukah {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int p = Integer.parseInt(br.readLine());
        for (int i = 0; i < p; i++) {
            String[] input = br.readLine().split(" ");
            int k = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            pw.print(k);
            pw.print(' ');
            int numCandles = n + (n * (n + 1) / 2);
            pw.println(numCandles);
        }
        pw.close();
        br.close();
    }
}