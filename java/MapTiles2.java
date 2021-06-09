// https://open.kattis.com/problems/maptiles2
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MapTiles2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        char[] input = br.readLine().toCharArray();
        int zoom = input.length;
        int x = 0;
        int y = 0;
        for (int i = 0; i < zoom; i++) {
            if (input[i] == '1' || input[i] == '3') {
                x += (int) Math.pow(2, zoom - i - 1);
            } 
            if (input[i] == '2' || input[i] == '3') {
                y += (int) Math.pow(2, zoom - i - 1);
            }
        }
        pw.printf("%d %d %d\n", input.length, x, y);
        pw.close();
        br.close();
    }
}
