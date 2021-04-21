import java.util.Scanner;

public class Skener {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numRow = sc.nextInt();
        int numCol = sc.nextInt();
        int zoomRow = sc.nextInt();
        int zoomCol = sc.nextInt();
        StringBuilder output = new StringBuilder();
        for (int r = 0; r < numRow; r++) {
            String line = sc.next();
            StringBuilder newLine = new StringBuilder();
            for (int idx = 0; idx < line.length(); idx++) {
                for (int zoomC = 0; zoomC < zoomCol; zoomC++) {
                    newLine.append(line.charAt(idx));
                }
            }
            for (int zoomR = 0; zoomR < zoomRow; zoomR++) {
                if (zoomR == zoomRow - 1) {
                    output.append(newLine);
                } else {
                    output.append(newLine + "\n");
                }
            }
            if (r != numRow - 1) {
                output.append("\n");
            }
        }
        System.out.println(output);
    }
}