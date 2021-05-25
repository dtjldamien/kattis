// https://open.kattis.com/problems/goatrope
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GoatRope {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        // fence post
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        // house
        int x1 = Integer.parseInt(input[2]);
        int y1 = Integer.parseInt(input[3]);
        int x2 = Integer.parseInt(input[4]);
        int y2 = Integer.parseInt(input[5]);
        double dist = 0;
        // check top
        if (x > x1 && x <= x2) {
            if (y < y1) {
                dist = y1 -y;
            } else {
                dist = y - y2;
            }
        } else if (y >= y1 && y <= y2) {
            if (x < x1) {
                dist = x1 -x;
            } else {
                dist = x - x2;
            }
        } else if (x < x1) {
            if (y < y1) {
                dist = Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2));
            } else {
                dist = Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y2, 2));
            }
        } else {
            if (y < y1) {
                dist = Math.sqrt(Math.pow(x - x2, 2) + Math.pow(y - y1, 2));
            } else {
                dist = Math.sqrt(Math.pow(x - x2, 2) + Math.pow(y - y2, 2));
            }
        }
        pw.println(dist);
        pw.close();
        br.close();
    }
}
