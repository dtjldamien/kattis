import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;

public class FerryLoading4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int c = Integer.parseInt(br.readLine());
        for (int i = 0; i < c; i++) {
            String[] input = br.readLine().split(" ");
            int l = Integer.parseInt(input[0]) * 100; // ferry length in cm
            int m = Integer.parseInt(input[1]); // no. of cars
            LinkedList<Integer> leftQueue = new LinkedList<>();
            LinkedList<Integer> rightQueue = new LinkedList<>();
            for (int j = 0; j < m; j++) {
                String[] carDetails = br.readLine().split(" ");
                int carLength = Integer.parseInt(carDetails[0]);
                String bank = carDetails[1];
                if (bank.equals("left")) {
                    leftQueue.add(carLength);
                } else {
                    rightQueue.add(carLength);
                }
            }
            int numCrossing = 0;
            int totalCarLength = 0;
            boolean isLeft = true; // ferry starts on the left bank
            while (!(leftQueue.isEmpty() && rightQueue.isEmpty())) {
                if (isLeft) { // ferry is at left bank
                    if (leftQueue.size() == 0) { // bank is empty, go to the right to check
                        totalCarLength = 0;
                        numCrossing++;
                        isLeft = false;
                    } else if (totalCarLength + leftQueue.peek() < l) {
                        totalCarLength += leftQueue.poll();
                    } else { // ferry no space
                        totalCarLength = 0;
                        numCrossing++;
                        isLeft = false;
                    }
                } else { // ferry is at right bank
                    if (rightQueue.size() == 0) { // bank is empty, go back to the left to check
                        totalCarLength = 0;
                        numCrossing++;
                        isLeft = true;
                    } else if (totalCarLength + rightQueue.peek() < l) {
                        totalCarLength += rightQueue.poll();
                    } else { // ferry no space
                        totalCarLength = 0;
                        numCrossing++;
                        isLeft = true;
                    }
                }
            }
            numCrossing++; // cross to the other side for the last time
            pw.println(numCrossing);
        }
        pw.close();
        br.close();
    }
}