import java.util.Scanner;

public class TwoStones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num % 2 == 0) {
            System.out.println("Bob");
        } else {
            System.out.println("Alice");
        }
        sc.close();
    }
}