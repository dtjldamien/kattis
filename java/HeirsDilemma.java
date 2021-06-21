// https://open.kattis.com/problems/schoolspirit
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class HeirsDilemma {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int l = Integer.parseInt(input[0]);
        int h = Integer.parseInt(input[1]);
        int count = 0;
        for (int i = l; i <= h; i++) {
            if (isSatisfactory(i)) {
                count++;
            }
        }
        pw.println(count);
        pw.close();
        br.close();
    }

    public static boolean isSatisfactory(int i) {
        Set<Integer> set = new HashSet<Integer>();
        int count = 0;
        int val = i;
        while (val > 0) {                           
            int tempVal = val % 10;
            if (tempVal == 0) {
                return false; // sequence of six non-zero decimal digits
            }
            set.add(tempVal); 
            val = val / 10;
            count++;
        }
        if (count != set.size()) {
            return false; // contains duplicate digits
        }
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            if (i % iter.next() != 0) {
                return false;
            }
        }
        return true;
    }
}
