package java;
// https://open.kattis.com/problems/peragrams
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Peragrams {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String input = br.readLine();
        int[] freq = new int[26];
        for (int i = 0; i < input.length(); i++) {
            freq[input.charAt(i) - 'a']++;
        }
        int numOddFreq = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                numOddFreq++;
            }
        }
        if (numOddFreq == 0 || numOddFreq == 1) {
            pw.println(0);
        } else {
            pw.println(numOddFreq - 1);
        }
        pw.close();
        br.close();
    }
}
