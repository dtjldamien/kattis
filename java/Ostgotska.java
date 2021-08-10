package java;
// https://open.kattis.com/problems/ostgotska  
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Ostgotska {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int count = 0;
        for (String word : input) {
            if (word.contains("ae")) {
                count++;
            }
        }
        if (1.0 * count / input.length >= 0.4) {
            pw.println("dae ae ju traeligt va");
        } else {
            pw.println("haer talar vi rikssvenska");
        }
        pw.close();
        br.close();
    }
}
