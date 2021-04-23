import java.util.Scanner;

public class Cold {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int numColdDays = 0;
        for (int i = 0; i < n; i++) {
            if (sc.nextInt() < 0) {
                numColdDays++;
            }
        }
        System.out.println(numColdDays);
        sc.close();
    }
}