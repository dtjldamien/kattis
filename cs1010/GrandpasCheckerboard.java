
// https://open.kattis.com/problems/thisaintyourgrandpascheckerboard
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GrandpasCheckerboard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }
        boolean isRowSatisfied = true;
        for (int row = 0; row < n; row++) {
            int blackCount = 0;
            int whiteCount = 0;
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < n; col++) {
                sb.append(board[row][col]);
                if (board[row][col] == 'B') {
                    blackCount++;
                } else if (board[row][col] == 'W') {
                    whiteCount++;
                }
            }
            if (whiteCount != blackCount) {
                isRowSatisfied = false;
            }
            String rowString = sb.toString();
            if (rowString.contains("BBB") || rowString.contains("WWW")) {
                isRowSatisfied = false;
            }
        }
        boolean isColSatisfied = true;
        for (int col = 0; col < n; col++) {
            int blackCount = 0;
            int whiteCount = 0;
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < n; row++) {
                sb.append(board[row][col]);
                if (board[row][col] == 'B') {
                    blackCount++;
                } else if (board[row][col] == 'W') {
                    whiteCount++;
                }
            }
            if (whiteCount != blackCount) {
                isColSatisfied = false;
            }
            String colString = sb.toString();
            if (colString.contains("BBB") || colString.contains("WWW")) {
                isColSatisfied = false;
            }
        }
        if (isRowSatisfied && isColSatisfied) {
            pw.println("1");
        } else {
            pw.println("0");
        }
        pw.close();
        br.close();
    }
}
