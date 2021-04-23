import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Everywhere {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<String> cities = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String input = sc.next();
                if (cities.contains(input)) {
                    continue;
                } else {
                    cities.add(input);
                }
            }
            System.out.println(cities.size());
        }
        sc.close();
    }
}