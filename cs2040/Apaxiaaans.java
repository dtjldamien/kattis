import java.util.Scanner;

public class Apaxiaaans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String output = String.valueOf(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                continue;
            } else {
                output += input.charAt(i);
            }
        }
        System.out.println(output);
    }
}