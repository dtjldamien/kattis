import java.util.Scanner;

public class ReverseBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }
        // parseInt(String s, int radix) radix -> converts from base (radix) to decimal
        System.out.println(Integer.parseInt(sb.toString(), 2));
    }
}