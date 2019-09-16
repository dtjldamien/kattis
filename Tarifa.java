import java.util.Scanner;

public class Tarifa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        int dataAvailable = x; 
           for (int i = 0; i < n; i++) {
            dataAvailable -= sc.nextInt(); 
            dataAvailable += x;
        }
        System.out.printf("%d", dataAvailable);
        sc.close();
    }
}