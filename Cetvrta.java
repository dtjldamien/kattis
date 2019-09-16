import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Cetvrta {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int[] xCoordinates = new int[3];
        int[] yCoordinates = new int[3];
        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().split(" ");
            xCoordinates[i] = Integer.parseInt(input[0]);
            yCoordinates[i] = Integer.parseInt(input[1]);
        }
        int x = xCoordinates[0];
        if (xCoordinates[0] == xCoordinates[2]) {
            x = xCoordinates[1];
        } else if (xCoordinates[0] == xCoordinates[1]) {
            x = xCoordinates[2];
        }
        int y = yCoordinates[0];
        if (yCoordinates[0] == yCoordinates[2]) {
            y = yCoordinates[1];
        } else if (yCoordinates[0] == yCoordinates[1]) {
            y = yCoordinates[2];
        }
        pw.println(x + " " + y);
        pw.close();
        br.close();
    }
}