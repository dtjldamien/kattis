
// https://open.kattis.com/problems/vauvau
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Vauvau {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] dogBehaviour = br.readLine().split(" ");
        String[] arrivalTimes = br.readLine().split(" ");

        int a = Integer.parseInt(dogBehaviour[0]); // first dog aggressive for a minutes
        int b = Integer.parseInt(dogBehaviour[1]); // first dog calm for b minutes
        int c = Integer.parseInt(dogBehaviour[2]); // second dog aggressive for c minutes
        int d = Integer.parseInt(dogBehaviour[3]); // second dog aggressive for d minutes

        int numDogsAttack;
        int time;
        for (int i = 0; i < 3; i++) {
            numDogsAttack = 0;
            time = Integer.parseInt(arrivalTimes[i]);
            if (time % (a + b) != 0 && (time % (a + b) <= a)) {
                numDogsAttack++; // second dog attack
            }
            if (time % (c + d) != 0 && (time % (c + d) <= c)) {
                numDogsAttack++; // second dog attack
            }
            if (numDogsAttack == 0) {
                pw.println("none");
            } else if (numDogsAttack == 1) {
                pw.println("one");
            } else if (numDogsAttack == 2) {
                pw.println("both");
            }
    
        }
        pw.close();
        br.close();
    }
}
