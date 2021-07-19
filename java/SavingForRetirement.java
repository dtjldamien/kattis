// https://open.kattis.com/problems/savingforretirement
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SavingForRetirement {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int ageBob = Integer.parseInt(input[0]);
        int ageRetireBob = Integer.parseInt(input[1]);
        int yearlySavingsBob = Integer.parseInt(input[2]);
        int ageAlice = Integer.parseInt(input[3]);
        int yearlySavingsAlice = Integer.parseInt(input[4]);
        int totalBobSavings = (ageRetireBob - ageBob) * yearlySavingsBob;
        int numYearsSavedAlice = totalBobSavings / yearlySavingsAlice;
        int ageRetireAlice = ageAlice + numYearsSavedAlice;
        if (numYearsSavedAlice * yearlySavingsAlice > totalBobSavings) {
            pw.println(ageRetireAlice);
        } else {
            pw.println(ageRetireAlice + 1);
        }
        pw.close();
        br.close();
    }
}
