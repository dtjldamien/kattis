// https://open.kattis.com/problems/schoolspirit
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SchoolSpirit {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int score = Integer.parseInt(br.readLine());
            scores.add(score);
        }
        Collections.sort(scores, Collections.reverseOrder());
        double currGroupScore = 0;
        for (int i = 0; i < n; i++) {
            currGroupScore += (Math.pow(0.8, i) * scores.get(i));
        }   
        currGroupScore /= 5;
        double totalGroupScore = 0; // if one student leaves
        for (int i = 0; i < n; i++) {
            double g = 0;
            int counter = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    g += (Math.pow(0.8, counter) * scores.get(j));
                    counter++;
                }
            }
            g /= 5;
            totalGroupScore += g;
        }
        totalGroupScore /= n;
        pw.println(currGroupScore);
        pw.println(totalGroupScore);
        pw.close();
        br.close();
    }
}
