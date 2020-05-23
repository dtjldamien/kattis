import java.util.Scanner;

public class Pot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numInput = sc.nextInt();
        double sum = 0;
        for (int i = 0; i < numInput; i++) {
            int p = sc.nextInt();
            int pow = p % 10;
            int num = p / 10;
            sum += Math.pow(num, pow);
        }
        System.out.printf("%.0f", sum);
    }
}