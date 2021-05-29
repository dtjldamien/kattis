// https://open.kattis.com/problems/hangman
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Set;
import java.util.HashSet;

public class Hangman {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String word = br.readLine();
        String guess = br.readLine();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }
        int idx = 0;
        int count = 0;
        while (count < 10 && !set.isEmpty()) {
            if (set.contains(guess.charAt(idx))) {
                set.remove(guess.charAt(idx));
            } else {
                count++;
            }
            idx++;
        }
        if (count < 10) {
            pw.println("WIN");
        } else {
            pw.println("LOSE");
        }
        pw.close();
        br.close();
    }
}
