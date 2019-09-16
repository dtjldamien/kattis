import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Sibice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numMatches = sc.nextInt();
        int width = sc.nextInt();
        int height = sc.nextInt();
        // can be placed along the diagonals to fit longer match sticks
        double hyp = Math.sqrt(width * width + height * height);
        List<String> outputList = new ArrayList<>(numMatches);
        for (int i = 0; i < numMatches; i++) {
            int matchLength = sc.nextInt();
            if (matchLength > hyp) {
                outputList.add("NE");
            } else {
                outputList.add("DA");
            }
        }
        for (String output : outputList) {
            System.out.println(output);
        }
    }
}