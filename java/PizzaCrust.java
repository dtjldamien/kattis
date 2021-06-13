// https://open.kattis.com/problems/sorttwonumbers
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PizzaCrust {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        double percCheese = 100.0 * Math.pow(r - c, 2) / (r * r);
        pw.println(percCheese);
        pw.close();
        br.close();
    }
}
