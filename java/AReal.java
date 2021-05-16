// https://open.kattis.com/problems/areal
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class AReal {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        double a = Double.parseDouble(br.readLine());
        pw.println(4 * Math.sqrt(a));
        pw.close();
        br.close();
    }
}
