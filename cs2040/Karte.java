
// https://open.kattis.com/problems/karte
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class Karte {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String input = br.readLine();
        HashSet<Integer> pSet = new HashSet<>();
        HashSet<Integer> kSet = new HashSet<>();
        HashSet<Integer> hSet = new HashSet<>();
        HashSet<Integer> tSet = new HashSet<>();
        boolean hasDuplicate = false;
        for (int i = 0; i < input.length(); i += 3) {
            String currCard = input.substring(i, i + 3);
            char suit = currCard.charAt(0);
            int num = Integer.parseInt(currCard.substring(1, 3));
            if (suit == 'P') {
                if (pSet.contains(num)) {
                    hasDuplicate = true;
                    break;
                } else {
                    pSet.add(num);
                }
            } else if (suit == 'K') {
                if (kSet.contains(num)) {
                    hasDuplicate = true;
                    break;
                } else {
                    kSet.add(num);
                }
            } else if (suit == 'H') {
                if (hSet.contains(num)) {
                    hasDuplicate = true;
                    break;
                } else {
                    hSet.add(num);
                }
            } else {
                if (tSet.contains(num)) {
                    hasDuplicate = true;
                    break;
                } else {
                    tSet.add(num);
                }
            }
        }
        if (hasDuplicate) {
            pw.println("GRESKA");
        } else {
            pw.printf("%d %d %d %d\n", 13 - pSet.size(), 13 - kSet.size(), 13 - hSet.size(), 13 - tSet.size());
        }
        pw.close();
        br.close();
    }
}