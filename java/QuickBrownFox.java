// https://open.kattis.com/problems/quickbrownfox
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.StringBuilder;

public class QuickBrownFox {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toLowerCase().toCharArray();
            int[] alphabets = new int[26];
            boolean isPangram = true;
            for (int j = 0; j < input.length; j++) {
                if (input[j] >= 'a' && input[j] <= 'z') {
                    alphabets[input[j] - 'a']++;
                }
            }
            StringBuilder missingLetters = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (alphabets[j] == 0) {
                    isPangram = false;
                    missingLetters.append((char) (j + 'a'));
                }
            }
            if (isPangram) {
                pw.println("pangram");
            } else {
                pw.printf("missing %s\n", missingLetters.toString());
            }
        }

        pw.close();
        br.close();
    }
}