import java.util.Scanner;

public class R2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int s = sc.nextInt();
        sc.close();
        int r2 = s * 2 - r1;
        System.out.println(r2);
    }
}