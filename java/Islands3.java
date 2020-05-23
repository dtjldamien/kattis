import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class Islands3 {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int r = io.getInt(); // number of rows
        int c = io.getInt(); // number of columns
        char[][] image = new char[r][c];
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            image[i] = io.getWord().toCharArray();
        }
        int islandCount = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (image[i][j] == 'L' && visited[i][j] == false) {
                    recursiveDFS(image, visited, i, j);
                    islandCount++;
                }
            }
        }
        io.println(islandCount);
        io.close();
    }

    public static void recursiveDFS(char[][] image, boolean[][] visited, int row, int col) {
        visited[row][col] = true; // mark current cell as visited
        if (row - 1 >= 0) { // check up
            if (visited[row - 1][col] == false && (image[row - 1][col] == 'C' || image[row - 1][col] == 'L')) {
                recursiveDFS(image, visited, row - 1, col);
            }
        }
        if (row + 1 < image.length) { // check down
            if (visited[row + 1][col] == false && (image[row + 1][col] == 'C' || image[row + 1][col] == 'L')) {
                recursiveDFS(image, visited, row + 1, col);
            }
        }
        if (col - 1 >= 0) { // check left
            if(visited[row][col - 1] == false && (image[row][col - 1] == 'C' || image[row][col - 1] == 'L')) {
                recursiveDFS(image, visited, row, col - 1);
            }
        }
        if (col + 1 < image[row].length) { // check right
            if (visited[row][col + 1] == false && (image[row][col + 1] == 'C' || image[row][col + 1] == 'L')) {
                recursiveDFS(image, visited, row, col + 1);
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
