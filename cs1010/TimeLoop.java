import java.util.Scanner;

public class TimeLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numLoop = sc.nextInt();
        sc.close();
        for (int i = 1; i <= numLoop; i++) {
            System.out.printf("%d Abracadabra%n", i);
        }
    }
}