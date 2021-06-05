package java;
// https://open.kattis.com/problems/addtwonumbers
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class AddTwoNumbers {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int sum = Integer.parseInt(input[0]) + Integer.parseInt(input[1]);
        pw.println(sum);
        pw.close();
        br.close();
    }
}
