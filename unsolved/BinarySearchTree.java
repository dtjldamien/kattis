import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.lang.StringBuilder;

public class BinarySearchTree {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int N = io.getInt();
        BST bst = new BST();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            bst.insert(io.getInt());
            sb.append(bst.counter);
            sb.append("\n");
        }
        io.print(sb.toString());
        io.close();
    }
}

class BST {
    public BSTVertex root;
    int counter;

    public BST() {
        root = null;
        counter = 0;
    }

    // public method called to insert a new key with value v into BST
    public void insert(int v) {
        root = insert(root, v);
    }

    // helper recursive method to perform insertion of new vertex into BST
    public BSTVertex insert(BSTVertex T, int v) {
        if (T == null) {
            return new BSTVertex(v);          // insertion point is found
        }
        if (T.key < v) {                                 // search to the right
            counter++;
            T.right = insert(T.right, v);
        } else {                                         // search to the left
            counter++;
            T.left = insert(T.left, v);
        }
        return T;                                        // return the updated BST
    }
}

class BSTVertex {
    public BSTVertex left, right;
    public int key;

    BSTVertex(int v) {
        key = v;
        left = null;
        right = null;
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
