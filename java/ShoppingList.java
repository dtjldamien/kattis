
// https://open.kattis.com/problems/shoppinglist
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class ShoppingList {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        String[] firstList = br.readLine().split(" ");
        Set<String> set = new HashSet<>();
        for (String item : firstList) {
            set.add(item);
        }
        for (int i = 1; i < n; i++) {
            Set<String> newSet = new HashSet<>();
            String[] nextList = br.readLine().split(" ");
            for (String item : nextList) {
                if (set.contains(item)) {
                    newSet.add(item);
                }
            }
            set = newSet;
        }
        List<String> items = new ArrayList<>(set);
        Collections.sort(items);
        pw.println(items.size());
        for (String item : items) {
            pw.println(item);
        }
        pw.close();
        br.close();
    }
}
