// https://open.kattis.com/problems/loorolls
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LooRolls {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        long l = Long.parseLong(input[0]);
        long n = Long.parseLong(input[1]);
        long k = 1;
        long result = l % n;
        while (result != 0) {
            k++;
            n -= result;
            result = l % n;
        } 
        pw.println(k); 
        pw.close();
        br.close();
    }
}
