package java;
// https://open.kattis.com/problems/mirror
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Mirror {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            String[] input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);
            char[][] image = new char[r][c];
            // read and mirror left to right
            for (int row = 0; row < r; row++) {
                char[] currRow = br.readLine().toCharArray();
                for (int col = 0; col < c; col++) {
                    image[row][col] = currRow[c - col - 1];
                }
            }
            pw.printf("Test %d\n", i);
            // print and mirrow top to bottom
            for (int row = 0; row < r; row++) {
                for (int col = 0; col < c; col++) {
                    pw.print(image[r - 1 - row][col]);
                }
                pw.println();
            }
        }
        pw.close();
        br.close();
    }

}
