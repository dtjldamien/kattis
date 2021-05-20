// https://open.kattis.com/problems/ratingproblems
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class RatingProblems {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        double n = Double.parseDouble(input[0]);
        double k = Double.parseDouble(input[1]);
        double totalScore = 0;
        for (int i = 0; i < k; i++) {
            totalScore += Double.parseDouble(br.readLine());
        }
        double minScore = (totalScore + (n - k) * -3) / n;
        double maxScore = (totalScore + (n - k) * 3) / n;
        pw.printf("%s %s\n", minScore, maxScore);
        pw.close();
        br.close();
    }
}
