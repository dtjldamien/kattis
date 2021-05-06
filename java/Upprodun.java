// https://open.kattis.com/problems/upprodun
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Upprodun {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            int remainder = m % n;
            int quotient = m / n;
            for (int i = 0; i < remainder; i++) {
                for (int j = 0; j < quotient + 1; j++) {
                    pw.print('*');
                }
                pw.println();
            }
            for (int i = remainder; i < n; i++) {
                for (int j = 0; j < quotient; j++) {
                    pw.print('*');
                }
                pw.println();
            }
            pw.close();
            br.close();    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
