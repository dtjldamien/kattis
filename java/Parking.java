package java;
// https://open.kattis.com/problems/parking
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Parking {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] prices = br.readLine().split(" ");
        int a = Integer.parseInt(prices[0]);
        int b = Integer.parseInt(prices[1]);
        int c = Integer.parseInt(prices[2]);

        int[] numTrucksAtEachTime = new int[101];

        String[] truck1 = br.readLine().split(" ");
        int truck1Arr = Integer.parseInt(truck1[0]);
        int truck1Dep = Integer.parseInt(truck1[1]);
        for (int i = truck1Arr; i < truck1Dep; i++) {
            numTrucksAtEachTime[i]++;
        }

        String[] truck2 = br.readLine().split(" ");
        int truck2Arr = Integer.parseInt(truck2[0]);
        int truck2Dep = Integer.parseInt(truck2[1]);
        for (int i = truck2Arr; i < truck2Dep; i++) {
            numTrucksAtEachTime[i]++;
        }

        String[] truck3 = br.readLine().split(" ");
        int truck3Arr = Integer.parseInt(truck3[0]);
        int truck3Dep = Integer.parseInt(truck3[1]);
        for (int i = truck3Arr; i < truck3Dep; i++) {
            numTrucksAtEachTime[i]++;
        }

        int totalPrice = 0;
        for (int t = 1; t <= 100; t++) {
            if (numTrucksAtEachTime[t] == 1) {
                totalPrice += a;
            } else if (numTrucksAtEachTime[t] == 2) {
                totalPrice += b * 2;
            } else if (numTrucksAtEachTime[t] == 3) {
                totalPrice += c * 3;
            }
        }
        pw.println(totalPrice);
        pw.close();
        br.close();
    }
}
