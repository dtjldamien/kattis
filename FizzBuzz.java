import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println(checkOutput(i, x, y));
        }
        sc.close();
    }

    private static String checkOutput(int i, int x, int y) {
        boolean isDivisibleX = checkDivisible(i, x);
        boolean isDivisibleY = checkDivisible(i, y);
        if (isDivisibleX && isDivisibleY) {
            return "FizzBuzz";
        } else if (isDivisibleX) {
            return "Fizz";
        } else if (isDivisibleY) {
            return "Buzz";
        } else {
            return Integer.toString(i);
        }
    }

    private static boolean checkDivisible(int i, int j) {
        if (i % j == 0) {
            return true;
        } else {
            return false;
        }
    }
}