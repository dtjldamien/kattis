
// https://open.kattis.com/problems/sjecista
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Sjecista {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        int numIntersections = (n - 3) * (n - 2) * (n - 1) * n / 24;
        pw.println(numIntersections);
        pw.close();
        br.close();
    }
}
