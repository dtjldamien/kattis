package java;

// https://open.kattis.com/problems/prva
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;

public class Prva {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] dimensions = br.readLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        char[][] arr = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        PriorityQueue<String> words = new PriorityQueue<>();
        // vertical check
        for (int i = 0; i < rows; i++) {
            StringBuilder curr = new StringBuilder();
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] != '#') {
                    curr.append(arr[i][j]);
                } else {
                    if (curr.length() > 1) {
                        words.add(curr.toString());
                    }
                    curr = new StringBuilder();
                }
            }
            if (curr.length() > 1) {
                words.add(curr.toString());
            }
        }
        // horizontal check
        for (int i = 0; i < cols; i++) {
            StringBuilder curr = new StringBuilder();
            for (int j = 0; j < rows; j++) {
                if (arr[j][i] != '#') {
                    curr.append(arr[j][i]);
                } else {
                    if (curr.length() > 1) {
                        words.add(curr.toString());
                    }
                    curr = new StringBuilder();
                }
            }
            if (curr.length() > 1) {
                words.add(curr.toString());
            }
        }
        pw.println(words.poll());
        pw.close();
        br.close();
    }
}
