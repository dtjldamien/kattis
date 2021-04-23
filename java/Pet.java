import java.util.Scanner;

public class Pet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] points = new int[5];
        int winningContestant = 1;
        int score1 = sc.nextInt();
        int score2 = sc.nextInt();
        int score3 = sc.nextInt();
        int score4 = sc.nextInt();
        points[0] = score1 + score2 + score3 + score4;
        int max = points[0];
        for (int i = 1; i < 5; i++) {
            score1 = sc.nextInt();
            score2 = sc.nextInt();
            score3 = sc.nextInt();
            score4 = sc.nextInt();
            points[i] = score1 + score2  + score3 + score4;
            if (points[i] > max) {
                winningContestant = i + 1;
                max = points[i];
            }
        }
        System.out.printf("%d %d", winningContestant, points[winningContestant - 1]);
        sc.close();
    }
}