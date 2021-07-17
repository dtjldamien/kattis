
// https://open.kattis.com/problems/veci
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class NPuzzle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        char[][] puzzle = new char[4][4];
        for (int i = 0; i < 4; i++) {
            puzzle[i] = br.readLine().toCharArray();
        }
        int sum = 0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (puzzle[row][col] == 'A') {
                    sum += Math.abs(row - 0) + Math.abs(col - 0);
                } else if (puzzle[row][col] == 'B') {
                    sum += Math.abs(row - 0) + Math.abs(col - 1);
                } else if (puzzle[row][col] == 'C') {
                    sum += Math.abs(row - 0) + Math.abs(col - 2);
                } else if (puzzle[row][col] == 'D') {
                    sum += Math.abs(row - 0) + Math.abs(col - 3);
                } else if (puzzle[row][col] == 'E') {
                    sum += Math.abs(row - 1) + Math.abs(col - 0);
                } else if (puzzle[row][col] == 'F') {
                    sum += Math.abs(row - 1) + Math.abs(col - 1);
                } else if (puzzle[row][col] == 'G') {
                    sum += Math.abs(row - 1) + Math.abs(col - 2);
                } else if (puzzle[row][col] == 'H') {
                    sum += Math.abs(row - 1) + Math.abs(col - 3);
                } else if (puzzle[row][col] == 'I') {
                    sum += Math.abs(row - 2) + Math.abs(col - 0);
                } else if (puzzle[row][col] == 'J') {
                    sum += Math.abs(row - 2) + Math.abs(col - 1);
                } else if (puzzle[row][col] == 'K') {
                    sum += Math.abs(row - 2) + Math.abs(col - 2);
                } else if (puzzle[row][col] == 'L') {
                    sum += Math.abs(row - 2) + Math.abs(col - 3);
                } else if (puzzle[row][col] == 'M') {
                    sum += Math.abs(row - 3) + Math.abs(col - 0);
                } else if (puzzle[row][col] == 'N') {
                    sum += Math.abs(row - 3) + Math.abs(col - 1);
                } else if (puzzle[row][col] == 'O') {
                    sum += Math.abs(row - 3) + Math.abs(col - 2);
                }
            }
        }
        pw.println(sum);
        pw.close();
        br.close();
    }
}
