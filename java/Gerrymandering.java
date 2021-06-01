// https://open.kattis.com/problems/gerrymandering
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Gerrymandering {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int P = Integer.parseInt(input[0]);
        int D = Integer.parseInt(input[1]);
        int[] numVotesA = new int[D];
        int[] numVotesB = new int[D];
        for (int i = 0; i < P; i++) {
            String[] precinct = br.readLine().split(" ");
            int district = Integer.parseInt(precinct[0]) - 1;
            numVotesA[district] += Integer.parseInt(precinct[1]); 
            numVotesB[district] += Integer.parseInt(precinct[2]); 
        }
        int totalWastedA = 0;
        int totalWastedB = 0;
        int totalVotes = 0;
        for (int i = 0; i < D; i++) {
            String winner;
            int numWastedA;
            int numWastedB;
            totalVotes += numVotesA[i];
            totalVotes += numVotesB[i];
            if (numVotesA[i] > numVotesB[i]) {
                winner = "A";
                numWastedA = numVotesA[i] - ((numVotesA[i] + numVotesB[i]) / 2 + 1);
                numWastedB = numVotesB[i];
            } else {
                winner = "B";
                numWastedA = numVotesA[i];
                numWastedB = numVotesB[i] - ((numVotesA[i] + numVotesB[i]) / 2 + 1);
            }
            totalWastedA += numWastedA;
            totalWastedB += numWastedB;
            pw.printf("%s %d %d\n", winner, numWastedA, numWastedB);
        }
        double efficiencyGap = 1.0 * Math.abs(totalWastedA - totalWastedB) / totalVotes;
        pw.println(efficiencyGap);
        pw.close();
        br.close();
    }
}
