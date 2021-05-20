// https://open.kattis.com/problems/magictrick
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class MagicTrick {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        char[] s = br.readLine().toCharArray();
        HashSet<Character> set = new HashSet<>();
        boolean hasDuplicate = false;
        for (int i = 0; i < s.length; i++) {
            if (set.contains(s[i])) {
                pw.println(0);
                hasDuplicate = true;
                break;
            } else {
                set.add(s[i]);
            }
        }
        if (!hasDuplicate) {
            pw.println(1);
        }
        pw.close();
        br.close();
    }
}
