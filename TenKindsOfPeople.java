import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class TenKindsOfPeople {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int r = io.getInt();
        int c = io.getInt();
        char[][] map = new char[r][c];
        for(int i = 0; i < r; i++) {
            map[i] = io.getWord().toCharArray();
        }

        // group map to accessiblility, increment counter of the group number when no other neighbours are accessible
        int[][] groupedBySegments = new int[r][c];
        int groupCounter = 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (groupedBySegments[i][j] == 0) {
                    recursiveDFS(map, groupedBySegments, i, j, groupCounter); // to segregate into groups
                    groupCounter++;
                }
            }
        }
        
        // run queries
        int n = io.getInt();
        for (int i = 0; i < n; i++) {
            int r1 = io.getInt() - 1;
            int c1 = io.getInt() - 1;
            int r2 = io.getInt() - 1;
            int c2 = io.getInt() - 1;
            if (groupedBySegments[r1][c1] == groupedBySegments[r2][c2]) {
                if (map[r1][c1] == '0') {
                    io.println("binary");
                } else { // map[r1][c1] == '1'
                    io.println("decimal");
                }
            } else {
                io.println("neither");
            }
        }
        io.close();
    }

    public static void recursiveDFS(char[][] map, int[][] groupedBySegments, int row, int col, int groupCounter) {
        groupedBySegments[row][col] = groupCounter; // mark current cell as visited
        if (row - 1 >= 0) { // check up
            if (groupedBySegments[row - 1][col] == 0 && map[row - 1][col] == map[row][col]) {
                recursiveDFS(map, groupedBySegments, row - 1, col, groupCounter);
            }
        }
        if (row + 1 < map.length) { // check down
            if (groupedBySegments[row + 1][col] == 0 && map[row + 1][col] == map[row][col]) {
                recursiveDFS(map, groupedBySegments, row + 1, col, groupCounter);
            }
        }
        if (col - 1 >= 0) { // check left
            if (groupedBySegments[row][col - 1] == 0 && map[row][col - 1] == map[row][col]) {
                recursiveDFS(map, groupedBySegments, row, col - 1, groupCounter);
            }
        }
        if (col + 1 < map[row].length) { // check right
            if (groupedBySegments[row][col + 1] == 0 && map[row][col + 1] == map[row][col]) {
                recursiveDFS(map, groupedBySegments, row, col + 1, groupCounter);
            }
        }
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
