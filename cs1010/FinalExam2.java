// https://open.kattis.com/problems/finalexam2
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FinalExam2 {
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine()); // number of questions
        String[] correctAnswers = new String[n];
        int score = 0;
        correctAnswers[0] = br.readLine();
        for (int i = 1; i < n; i++) {
            correctAnswers[i] = br.readLine();
            if (correctAnswers[i].equals(correctAnswers[i - 1])) {
                score++;
            }
        }
        pw.println(score);
        pw.close();
        br.close();
    }
}