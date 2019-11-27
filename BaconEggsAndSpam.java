import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.StringBuilder;

public class BaconEggsAndSpam {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        while (n != 0) {
            // key - menu item
            // value - customers
            HashMap<String, ArrayList<String>> orders = new HashMap<>();
            Set<String> menu = new HashSet<>();
            for (int i = 0; i < n; i++) {
                String[] order = br.readLine().split(" ");
                for (int j = 1; j < order.length; j++) {
                    if (menu.contains(order[j])) {
                        orders.get(order[j]).add(order[0]);
                    } else {
                        ArrayList<String> customers = new ArrayList<>();
                        customers.add(order[0]);
                        orders.put(order[j], customers);
                        menu.add(order[j]);
                    }
                }
            }
            List<String> menuList = new ArrayList<>(menu);
            Collections.sort(menuList);
            for (String menuItem : menuList) {
                StringBuilder sb = new StringBuilder(menuItem);
                ArrayList<String> customers = orders.get(menuItem);
                Collections.sort(customers); // list of names need to be sorted lexicographically
                for (String customer : customers) {
                    sb.append(" ");
                    sb.append(customer);
                }
                pw.println(sb.toString());
            }
            pw.println();
            n = Integer.parseInt(br.readLine());
        }
        pw.close();
    }
}