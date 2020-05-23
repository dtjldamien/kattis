import java.util.Scanner;

public class Spavanac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minutes = sc.nextInt();
        if (minutes < 45) {
            minutes += 60;
            hour -= 1;
        }
        minutes -= 45;
        if (hour == - 1) {
            hour = 23;
        }
        System.out.printf("%d %d",  hour, minutes);
    }
}