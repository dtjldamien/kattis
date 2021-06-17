// https://open.kattis.com/problems/cups
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Comparable;

public class Cups {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        List<Cup> cups = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            try {
                int diameter = Integer.parseInt(input[0]);
                String color = input[1];
                cups.add(new Cup(color, diameter));
            } catch (final NumberFormatException e) {
                int diameter = Integer.parseInt(input[1]) * 2;
                String color = input[0];
                cups.add(new Cup(color, diameter));
            }        
        }
        Collections.sort(cups);
        for (Cup cup : cups) {
            pw.println(cup.color);
        }
        pw.close();
        br.close();
    }
}

class Cup implements Comparable<Cup> {

    String color;
    int diameter;

    public Cup(String color, int diameter) {
        this.color = color;
        this.diameter = diameter;
    }

    @Override
    public int compareTo(Cup another) {
        return this.diameter - another.diameter;
    }
}
