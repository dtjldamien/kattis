import java.util.Scanner;

public class Trik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] commands = input.toCharArray();
        int[] cups = {1, 0, 0};
        for (char command : commands) {
            swap(cups, command);
        }
        if (cups[0] == 1) {
            System.out.println(1);
        } else if (cups[1] == 1) {
            System.out.println(2);
        } else {
            System.out.println(3);
        }
    }

    public static void swap(int[] cups, char command) {
        if (command == 'A') {
            int temp = cups[0];
            cups[0] = cups[1];
            cups[1] = temp;
        } else if (command == 'B') {
            int temp = cups[1];
            cups[1] = cups[2];
            cups[2] = temp;
        } else {
            int temp = cups[2];
            cups[2] = cups[0];
            cups[0] = temp;
        }
    }
}