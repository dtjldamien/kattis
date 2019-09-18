import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainTeque {
    public static void main(String[] args) throws Exception {
        Kattio io = new Kattio(System.in, System.out);
        int N = io.getInt();
        String command;
        int num;
        Teque teque = new Teque(N);
        for (int i = 0; i < N; i++) {
            command = io.getWord();
            num = io.getInt();
            if (command.equals("get")) {
                io.println(teque.get(num));
            } else if (command.equals("push_back")) {
                teque.addBack(num);
            } else if (command.equals("push_front")) {
                teque.addFront(num);
            } else { // push_middle
                teque.addMiddle(num);
            }
        }
        io.close();
    }
}

class Teque {
    // attributes
    int[] frontArr;
    int frontArrHeadIdx; // start of front arr
    int frontArrTailIdx; // end of back arr
    int frontSize; // front arr size
    int[] backArr;
    int backArrHeadIdx; // start of back arr
    int backArrTailIdx; // end of back arr
    int backSize; // back arr size
    int totalSize;

    public Teque (int N) {
        frontArr = new int[N * 2 + 1];
        frontArrHeadIdx = N;
        frontArrTailIdx = N;
        backArr = new int[N * 2 + 1];
        backArrHeadIdx = N;
        backArrTailIdx = N;
    }

    // get item at index
    public int get(int index) {
        if (index < frontSize) {
            return frontArr[frontArrHeadIdx + index];
        } else {
            return backArr[index - frontSize + backArrHeadIdx];
        }
    }

    public void addFront(int n) {
        if (frontSize > 0) {
            frontArrHeadIdx--;
        }
        frontArr[frontArrHeadIdx] = n;
        frontSize++;
        totalSize++;
        balanceArrays();
    }

    public void addBack(int n) {
        if (backSize > 0) {
            backArrTailIdx++;
        }
        backArr[backArrTailIdx] = n;
        backSize++;
        totalSize++;
        balanceArrays();
    }

    public void addMiddle(int n) {
        if (totalSize % 2 == 0) { // even number of elements, add to back of front arr
            if (frontSize > 0) {
                frontArrTailIdx++;
            }
            frontArr[frontArrTailIdx] = n;
            frontSize++;
        } else { // odd number of elements, median is the first element of back arr
            if (frontSize > backSize) { // front arr has more elements, add to back arr
                if (backSize > 0) {
                    backArrHeadIdx--;
                }
                backSize++;
                backArr[backArrHeadIdx] = n;
            } else { // back arr has more elements, move first element of back arr to front arr and then add median to back arr
                if (frontSize > 0) {
                    frontArrTailIdx++;
                }
                frontArr[frontArrTailIdx] = backArr[backArrHeadIdx];
                frontSize++;
                backArr[backArrHeadIdx] = n;
            }
        }
        totalSize++;
        balanceArrays();
    }

    public void balanceArrays() {
        if (frontSize - backSize == 2) { // frontArr is larger, need to move to back arr
            if (backSize > 0) {
                backArrHeadIdx--;
            }
            backArr[backArrHeadIdx] = frontArr[frontArrTailIdx];
            frontArr[frontArrTailIdx] = 0;
            frontArrTailIdx--;
            frontSize--;
            backSize++;
        } else if (backSize - frontSize == 2) { // backArr is larger, need to move to front arr
            if (frontSize > 0) {
                frontArrTailIdx++;
            }
            frontArr[frontArrTailIdx] = backArr[backArrHeadIdx];
            backArr[backArrHeadIdx] = 0;
            backArrHeadIdx++;
            frontSize++;
            backSize--;
        } // arrays are balanced
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