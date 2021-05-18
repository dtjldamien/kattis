//https://open.kattis.com/problems/closingtheloop
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ClosingTheLoop {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            int s = Integer.parseInt(br.readLine());
            String input[] = br.readLine().split(" ");
            List<Integer> red = new ArrayList<>();
            List<Integer> blue = new ArrayList<>();
            for (int j = 0; j < s; j++) {
                String piece = input[j];
                Integer length = Integer.parseInt(piece.substring(0, piece.length() - 1));
                if (piece.charAt(piece.length() - 1) == 'B') {
                    blue.add(length);
                } else {
                    red.add(length);
                }
            }
            // sort in descending order of length
            Collections.sort(red);
            Collections.sort(blue);
            Collections.reverse(red);
            Collections.reverse(blue);
            int numSegments = Math.min(red.size(), blue.size());
            int totalLength = 0;
            for (int j = 0; j < numSegments; j++) {
                totalLength += red.get(j);
                totalLength += blue.get(j);
                // joining 2 segments together
                totalLength -= 1;
            }
            // join all segments together and form a loop
            totalLength -= 1 * numSegments;
            totalLength = Math.max(totalLength, 0);
            pw.printf("Case #%d: %d\n", i, totalLength);
        }
        pw.close();
        br.close();
    }
}