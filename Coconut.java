
// https://open.kattis.com/problems/coconut
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Coconut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int p = Integer.parseInt(input[1]);
        CircularLinkedList list = new CircularLinkedList();
        for (int i = 1; i <= p; i++) {
            list.addNode(i);
        }
        for (int i = 1; i <= p; i++) {

        }
        pw.close();
        br.close();
    }
}

class Coconut {
    int player;
    int state;
    Node nextNode;

    public Coconut(int player) {
        this.player = player;
        this.state = 2;
    }

    public void addNode(int value) {
        Coconut newNode = new Coconut(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }

        tail = newNode;
        tail.nextNode = head;
    }
}
