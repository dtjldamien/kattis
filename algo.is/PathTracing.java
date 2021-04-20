
// https://open.kattis.com/problems/pathtracing
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class PathTracing {
    public static void main(String[] args) throws Exception {
        Kattio io = new Kattio(System.in, System.out);
        String move;
        int currRow = 500;
        int currCol = 500;
        int minRow = 500;
        int minCol = 500;
        int maxRow = 500;
        int maxCol = 500;
        char[][] map = new char[1001][1001];

        // billy starts off at the centre of the map
        map[currRow][currCol] = 'S';
        while (io.hasMoreTokens()) {
            move = io.getWord();

            // update Billy's position
            if (move.equals("up")) {
                currRow--;
            } else if (move.equals("down")) {
                currRow++;
            } else if (move.equals("left")) {
                currCol--;
            } else if (move.equals("right")) {
                currCol++;
            }

            // update boundaries
            if (currRow > maxRow) {
                maxRow = currRow;
            } else if (currRow < minRow) {
                minRow = currRow;
            }

            if (currCol > maxCol) {
                maxCol = currCol;
            } else if (currCol < minCol) {
                minCol = currCol;
            }

            if (map[currRow][currCol] != 'S') {
                map[currRow][currCol] = '*';
            }
        }

        // mark end location
        map[currRow][currCol] = 'E';

        for (int i = minRow - 1; i <= maxRow + 1; i++) {
            for (int j = minCol - 1; j <= maxCol + 1; j++) {
                if (i == minRow - 1 || i == maxRow + 1 || j == minCol - 1 || j == maxCol + 1) {
                    io.print('#');
                } else {
                    // within boundaries
                    // null in character array has the same value as '0'
                    if (map[i][j] == 0) {
                        io.print(' ');
                    } else {
                        io.print(map[i][j]);
                    }
                }
            }
            io.println();
        }
        io.close();
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
                    if (line == null)
                        return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) {
            }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
