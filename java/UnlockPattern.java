// https://open.kattis.com/problems/unlockpattern

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UnlockPattern {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int[][] pattern = new int[3][3];
        for (int i = 0; i < 3; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                pattern[i][j] = Integer.parseInt(line[j]);
            }
        }
        double totalLength = 0;
        int prevRow = 0;
        int prevCol = 0;
        for (int i = 1; i <= 9; i++) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (pattern[row][col] == i) {
                        if (i == 1) {
                            prevRow = row;
                            prevCol = col;
                        } else {
                            totalLength += Math.sqrt(Math.pow(row - prevRow, 2) + Math.pow(col - prevCol, 2));
                            prevRow = row;
                            prevCol = col;
                        }
                    }
                }
            }
        }
        pw.println(totalLength);
        pw.close();
        br.close();
    }
}