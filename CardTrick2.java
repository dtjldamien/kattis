import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.StringBuilder;

public class CardTrick2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int numTestCases = Integer.parseInt(br.readLine());
        int n; // number of cards
        int[] cards; // array of cards
        int counter; // number of empty slots
        int idx = 0; // idx of array
        StringBuilder sb; // string builder to print the output
        for (int i = 0; i < numTestCases; i++) {
            n = Integer.parseInt(br.readLine());
            cards = new int[n];
            if (n == 1) {
                cards[0] = 1; // edge case, only one card
            } else {
                cards[1] = 1; // second card will always be Ace of Spades
                idx = 2; // start from the next empty positon
                for (int num = 2; num < n; num++) {
                    counter = 0;
                    while (counter != num) {
                        idx = (idx + 1) % n;
                        if (cards[idx] == 0) { // stimulate removal of cards
                            counter++;
                        }
                    }
                    cards[idx] = num;
                    // move to the next empty position to restart to process
                    counter = 0;
                    while (counter != 1) {
                        idx = (idx + 1) % n;
                        if (cards[idx] == 0) {
                            counter++;
                        }
                    }
                }
                for (int j = 0; j < n; j++) { // last card
                    if (cards[j] == 0) {
                        cards[j] = n;
                        break;
                    }
                }
            }
            sb = new StringBuilder();
            for (int k = 0; k < n; k++) {
                sb.append(cards[k] + " ");
            }
            pw.println(sb.toString());
        }
        pw.close();
        br.close();
    }
}