import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IntegerLists {
    public static void main(String[] args) throws Exception {
        Kattio io = new Kattio(System.in, System.out);
        Integer numTestCase = io.getInt();
        for (int i = 0; i < numTestCase; i++) {
            String p = io.getWord(); // BAPAC program
            int n = io.getInt();
            String input = io.getWord();
            p = p.replaceAll("RR", ""); // RR = reverse a reversed string, goes back to original state
            int dropCount = 0;
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == 'D') {
                    dropCount++;
                }
            }
            if (dropCount > n) { // drop more integers than length of the list
                io.println("error");
            } else if (dropCount == n) { // drop all the integers in the list
                io.println("[]");
            } else {
                String[] arr = input.split(",");
                LinkedList linkedList = new LinkedList();
                arr[0] = arr[0].substring(1);
                arr[arr.length - 1] = arr[arr.length - 1].substring(0, arr[arr.length - 1].length() - 1);
                for (String val: arr) {
                    linkedList.add(new Node(val));
                }
                for (int l = 0; l < p.length(); l++) {
                    if (p.charAt(l) == 'D') {
                        linkedList.remove();
                    } else { // reverse
                        linkedList.reverse();
                    }
                }
                io.println(linkedList.toString());
            }
        }
        io.close();
    }
}

class LinkedList {
    public Node head;
    public Node tail;
    public boolean isReversed = false;
    public int size;

    public void reverse() {
        isReversed = !isReversed;
    }

    public int size() {
        return this.size;
    }

    public void add(Node n) {
        if (head == null) { // list is empty
            head = n;
            tail = n;
        } else {
            tail.setNext(n);
            n.setPrev(tail);
            tail = n;
        }
        size++;
    }

    public void remove() {
        if (size == 1) {
            head = null;
            tail = null;
        } else if (size == 2) {
            if (isReversed) {
                tail = head;
                head.setNext(null);
                head.setPrev(null);
            } else {
                head = tail;
                tail.setNext(null);
                head.setPrev(null);
            }
        } else {
            if (isReversed) {
                tail = tail.getPrev();
                tail.setNext(null);
            } else {
                head = head.getNext();
                head.setPrev(null);
            }
        }
        size--;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (isReversed) {
            Node curr = tail;
            for (int i = 0; i < size - 1; i++) {
                sb.append(curr.getItem());
                sb.append(",");
                curr = curr.getPrev();
            }
            sb.append(head.getItem());
        } else {
            Node curr = head;
            for (int i = 0; i < size - 1; i++) {
                sb.append(curr.getItem());
                sb.append(",");
                curr = curr.getNext();
            }
            sb.append(tail.getItem());
        }
        sb.append("]");
        return sb.toString();
    }
}

class Node {
    public String item;
    public Node next;
    public Node prev;

    public Node(String val) { 
        item = val;
    }

    public void setNext(Node n) {
        this.next = n;
    }

    public Node getNext() {
        return this.next;
    }

    public void setPrev(Node n) {
        this.prev = n;
    }

    public Node getPrev() {
        return this.prev;
    }

    public String getItem() {
        return this.item;
    }
}

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }

    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}