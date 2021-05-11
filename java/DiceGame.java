// https://open.kattis.com/problems/dicegame
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class DiceGame {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);
            String[] gunnarsDice = br.readLine().split(" ");
            String[] emmasDice = br.readLine().split(" ");
            int gunnar = 0;
            int emma = 0;
            for (int i = 0; i < 4; i++) {
                gunnar += Integer.parseInt(gunnarsDice[i]);
                emma += Integer.parseInt(emmasDice[i]);
            }
            if (gunnar == emma) {
                pw.println("Tie");
            } else if (gunnar > emma) {
                pw.println("Gunnar");
            } else {
                pw.println("Emma");
            }
            pw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}