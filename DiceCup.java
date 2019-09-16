import java.util.Scanner;

public class DiceCup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int sum = n + m;
        int[] arr = new int[sum + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i + j]++;
            }
        }
        int max = arr[2];
        for (int i = 3; i < sum; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        for (int i = 2; i < sum; i++) {
            if  (arr[i] == max) {
                System.out.printf("%d%n", i);
            }
        }
        sc.close();
    }
}