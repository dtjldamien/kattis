package java;
// https://open.kattis.com/problems/sorttwonumbers
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Prozor {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        char[][] picture = new char[r][s];
        for (int i = 0; i < r; i++) {
            picture[i] = br.readLine().toCharArray();
        }
        int maxCount = 0;
        int maxRow = 0;
        int maxCol = 0;
        for (int row = 0; row < r - k + 1; row++) {
            for (int col = 0; col < s - k + 1; col++) {
                int count = 0;
                for (int racketRow = row + 1; racketRow < row + k - 1; racketRow++) {
                    for (int racketCol = col + 1; racketCol < col + k - 1; racketCol++) {
                        if (picture[racketRow][racketCol] == '*') {
                            count++;
                        }
                    }
                }
                if (count > maxCount) {
                    maxCount = count;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }
        for (int col = maxCol + 1; col < maxCol + k; col++) {
            picture[maxRow][col] = '-';
            picture[maxRow + k - 1][col] = '-';
        }
        for (int row = maxRow + 1; row < maxRow + k; row++) {
            picture[row][maxCol] = '|';
            picture[row][maxCol + k - 1] = '|';
        }
        picture[maxRow][maxCol] = '+';
        picture[maxRow + k - 1][maxCol] = '+';
        picture[maxRow][maxCol + k - 1] = '+';
        picture[maxRow + k - 1][maxCol + k - 1] = '+';
        pw.println(maxCount);
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < s; col++) {
                pw.print(picture[row][col]);
            }
            pw.println();
        }
        pw.close();
        br.close();
    }

}
