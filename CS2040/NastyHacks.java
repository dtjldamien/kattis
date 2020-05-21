import java.util.Scanner;

public class NastyHacks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int r = sc.nextInt();
            int e = sc.nextInt();
            int c = sc.nextInt();
            int profitAdvertise = e - c;
            if (profitAdvertise > r) {
                System.out.println("advertise");
            } else if (profitAdvertise == r) {
                System.out.println("does not matter");
            } else {
                System.out.println("do not advertise");
            }
        }
    }
}