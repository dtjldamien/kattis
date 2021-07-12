
// https://open.kattis.com/problems/coconut
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Coconut {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        LinkedList<Hand> game = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            game.addLast(new Hand(i, 1));
        }
        while (game.size() > 1) {
            for (int i = 0; i < s - 1; i++) {
                // go around the circle
                game.addLast(game.removeFirst());
            }
            // last touched hand
            Hand curr = game.peek();
            if (curr.state == 1) {
                // split into two fists and start from the first half of the coconut
                curr.state++;
                game.addFirst(new Hand(curr.playerNumber, 2));
            } else if (curr.state == 2) {
                // palm down and starts from the next hand
                game.poll();
                curr.state++;
                game.addLast(curr);
            } else if (curr.state == 3) {
                // place hand behind their back
                game.poll();
            }
        }
        Hand winner = game.poll();
        pw.println(winner.playerNumber);
        pw.close();
        br.close();
    }
}

class Hand {
    int playerNumber;
    int state;
    // 1 represents folded
    // 2 represents first
    // 3 represents palm down

    public Hand(int playerNumber, int state) {
        this.playerNumber = playerNumber;
        this.state = state;
    }
}
