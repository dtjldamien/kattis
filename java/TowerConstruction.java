package java;

// https://open.kattis.com/problems/tornbygge
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TowerConstruction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int prevBrick = Integer.parseInt(input[0]);
        int count = 1;
        for (int i = 1; i < n; i++) {
            int currBrick = Integer.parseInt(input[i]);
            if (currBrick > prevBrick) {
                count++;
            }
            prevBrick = currBrick;
        }
        pw.println(count);
        pw.close();
        br.close();
    }
}
