import java.util.Scanner;

public class SpeedLimit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n != -1) {
            int dist = 0;
            int timeHour = 0;
            for (int i = 0; i < n; i++) {
                int speed = sc.nextInt();
                int totalTime = sc.nextInt();
                dist += speed * (totalTime - timeHour);
                timeHour = totalTime;
            }
            System.out.printf("%d miles\n", dist);
            n = sc.nextInt();
        }
    }
}