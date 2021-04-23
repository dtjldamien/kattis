import java.util.Scanner;

public class Bijele {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int numKings = sc.nextInt();
        int numQueens = sc.nextInt();
        int numRooks = sc.nextInt();
        int numBishops = sc.nextInt();
        int numKnights = sc.nextInt();
        int numPawns = sc.nextInt();

        sb.append(1 - numKings + " ");
        sb.append(1 - numQueens + " ");
        sb.append(2 - numRooks + " ");
        sb.append(2 - numBishops + " ");
        sb.append(2 - numKnights + " ");
        sb.append(8 - numPawns + " ");
        System.out.println(sb);
        sc.close();
    }
}