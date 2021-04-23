import java.util.Scanner;

public class Ladder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        double v = sc.nextDouble();
        double theta = Math.toRadians(v);
        int length = (int) Math.ceil(h / Math.sin(theta));
        System.out.println(length);
        sc.close();
    }
}