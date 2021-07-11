
// https://open.kattis.com/problems/crne
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Crne {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        // use long, 1 ≤ N ≤ 10^9
        long n = Long.parseLong(br.readLine());
        // to maximize number of pieces
        // x is the horizontal cuts
        long numHorizontal = (n / 2);
        // n - x is the number of vertical cuts
        long numVertical = n - numHorizontal;
        // maxium number of pieces
        long numPieces = (numHorizontal + 1) * (numVertical + 1);
        pw.println(numPieces);
        pw.close();
        br.close();
    }
}
