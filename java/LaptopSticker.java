
// https://open.kattis.com/problems/laptopsticker
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LaptopSticker {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);
            String[] input = br.readLine().split(" ");
            int wc = Integer.parseInt(input[0]); // width of laptop computer
            int hc = Integer.parseInt(input[1]); // height of laptop computer
            int ws = Integer.parseInt(input[2]); // width of laptop sticker
            int hs = Integer.parseInt(input[3]); // height of laptop sticker

            boolean isFit = true;

            if (ws + 2 > wc) {
                isFit = false;
            }
            if (hs + 2 > hc) {
                isFit = false;
            }
            if (isFit) {
                pw.println("1");
            } else {
                pw.println("0");
            }
            pw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}