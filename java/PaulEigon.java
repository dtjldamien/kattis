package java;
// https://open.kattis.com/problems/pauleigon
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;

public class PaulEigon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int p = Integer.parseInt(input[1]);
        int q = Integer.parseInt(input[2]);
        if ((p + q) % (2 * n) < n) {
            pw.println("paul");
        } else {
            pw.println("opponent");
        }
        pw.close();
        br.close();
    }
}
