// https://open.kattis.com/problems/okvir
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

public class Okvir {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] firstLine = br.readLine().split(" ");
        String[] secondLine = br.readLine().split(" ");
        int m = Integer.parseInt(firstLine[0]);
        int n = Integer.parseInt(firstLine[1]);
        int u = Integer.parseInt(secondLine[0]);
        int l = Integer.parseInt(secondLine[1]);
        int r = Integer.parseInt(secondLine[2]);
        int d = Integer.parseInt(secondLine[3]);
        List<String> input = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            input.add(br.readLine());
        }
        int numRows = u + d + m;
        int numCols = l + r + n;
        char[][] board = new char[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (row < u || row >= m + u || col < l || col >= l + n) {
                    if (row % 2 == 0) {
                        if (col % 2 == 0) {
                            board[row][col] = '#';
                            pw.print('#');
                        } else {
                            board[row][col] = '.';
                            pw.print('.');
                        }
                    } else {
                        if (col % 2 == 0) {
                            board[row][col] = '.';
                            pw.print('.');
                        } else {
                            board[row][col] = '#';
                            pw.print('#');
                        }
                    }
                } else {
                    pw.print(input.get(row - u).charAt(col - l));
                }
            }
            pw.println();
        }
        pw.close();
        br.close();
    }
}
