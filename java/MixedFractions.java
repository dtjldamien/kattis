// https://open.kattis.com/problems/mixedfractions
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MixedFractions {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int numerator = Integer.parseInt(input[0]);
        int denominator = Integer.parseInt(input[1]);
        while (numerator != 0 && denominator != 0) {
            int quotient = numerator / denominator;
            numerator -= quotient * denominator;
            pw.printf("%d %d / %d\n", quotient, numerator, denominator);
            input = br.readLine().split(" ");
            numerator = Integer.parseInt(input[0]);
            denominator = Integer.parseInt(input[1]);    
        }
        pw.close();
        br.close();
    }
}
