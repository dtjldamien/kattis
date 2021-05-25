package java;

// https://open.kattis.com/problems/racingalphabet
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class RacingAlphabet {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            double distance = 0;
            int currPos = 0;
            if (input.charAt(0) == ' ') {
                currPos = 27;
            } else if (input.charAt(0) == '\'') {
                currPos = 28;
            } else {
                currPos = input.charAt(0) - 'A' + 1;
            }
            for (int j = 1; j < input.length(); j++) {
                int nextPos = 0;
                if (input.charAt(j) == ' ') {
                    nextPos = 27;
                } else if (input.charAt(j) == '\'') {
                    nextPos = 28;
                } else {
                    nextPos = input.charAt(j) - 'A' + 1;
                }
                int diff = 0;
                if (nextPos  > currPos) {
                    diff = nextPos - currPos;
                } else {
                    diff = currPos - nextPos;
                }
                if (diff > 14) {
                    distance += 28 - diff;
                } else {
                    distance += diff;
                }
                currPos = nextPos;
            }
            double timeTaken = input.length(); // time taken to pick up
            timeTaken += 1.0 * ((Math.PI * 60.0 / 28.0) * distance / 15.0);
            pw.println(timeTaken);
        }
        pw.close();
        br.close();
    }
}
