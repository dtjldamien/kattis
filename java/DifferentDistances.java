// https://open.kattis.com/problems/differentdistances

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class DifferentDistances {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        while (true) {
            String[] input = br.readLine().split(" ");
            double x1 = Double.parseDouble(input[0]);
            if (x1 == 0) {
                break;
            }
            double y1 = Double.parseDouble(input[1]);
            double x2 = Double.parseDouble(input[2]);
            double y2 = Double.parseDouble(input[3]); 
            double p = Double.parseDouble(input[4]); 
            double dist = Math.pow(Math.pow(Math.abs(x1 - x2), p) + Math.pow(Math.abs(y1 - y2), p), 1/p);
            pw.println(dist);
        }
        pw.close();
        br.close();
    }
}