// https://open.kattis.com/problems/tetration
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Tetration {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);
            double n = Double.parseDouble(br.readLine());
            pw.println(Math.pow(n, 1/n));
            pw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
