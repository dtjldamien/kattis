
// https://open.kattis.com/problems/peg
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Peg {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        char[][] board = new char[7][7];
        for (int i = 0; i < 7; i++) {
            board[i] = br.readLine().toCharArray();
        }
        int count = 0; // number of legal moves
        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 7; col++) {
                if (board[row][col] == 'o') {
                    if (row - 2 >= 0) {
                        // move up
                        if (board[row - 1][col] == 'o' && board[row - 2][col] == '.') {
                            count++;
                        }
                    }
                    if (row + 2 < 7) {
                        // move down
                        if (board[row + 1][col] == 'o' && board[row + 2][col] == '.') {
                            count++;
                        }
                    }
                    if (col - 2 >= 0) {
                        // move left
                        if (board[row][col - 1] == 'o' && board[row][col - 2] == '.') {
                            count++;
                        }
                    }
                    if (col + 2 < 7) {
                        // move right
                        if (board[row][col + 1] == 'o' && board[row][col + 2] == '.') {
                            count++;
                        }
                    }
                }
            }
        }
        pw.println(count);
        pw.close();
        br.close();
    }
}
