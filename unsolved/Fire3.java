import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Arrays;

public class Fire3 {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int r = io.getInt(); // number of rows
        int c = io.getInt(); // number of columns
        char[][] maze = new char[r][c];
        Queue<Point> queue = new LinkedList<>();
        Point startingPoint = new Point(0, 0, 'J', 0); // will be updated later
        for (int i = 0; i < r; i++) {
            char[] row = io.getWord().toCharArray();
            for (int j = 0; j < c; j++) {
                maze[i][j] = row[j];
                if (maze[i][j] == 'J') {
                    startingPoint.x = j;
                    startingPoint.y = i;
                } else if (maze[i][j] == 'F') {
                    queue.add(new Point(j, i, 'F', 0));
                }
            }
        }
        int numJ = 1; // number of positions Joe may be in at that point of time
        boolean hasEscaped = false;
        while (!queue.isEmpty()) {
            // System.out.println(Arrays.deepToString(maze)); // line to debug
            Point u = queue.poll();
            if (u.c == 'J') {
                numJ--;
                if (maze[u.y][u.x] == 'J') { // valid joe position that fire has not spread to
                    if (u.x == c - 1 || u.x == 0 || u.y == 0 || u.y == r - 1) { // at joe is at the boundaries
                        io.println(u.time + 1);
                        hasEscaped = true;
                        break;
                    } else {
                        if (u.x > 0) {
                            if (maze[u.y][u.x - 1] == '.') { // move left
                                maze[u.y][u.x - 1] = 'J';
                                numJ++;
                                queue.add(new Point(u.x - 1, u.y, 'J', u.time + 1));
                            }
                        }
                        if (u.x < c - 1) {
                            if (maze[u.y][u.x + 1] == '.') { // move right
                                maze[u.y][u.x + 1] = 'J';
                                numJ++;
                                queue.add(new Point(u.x + 1, u.y, 'J', u.time + 1));
                            }
                        }
                        if (u.y > 0) {
                            if (maze[u.y - 1][u.x] == '.') { // move up
                                maze[u.y - 1][u.x] = 'J';
                                numJ++;
                                queue.add(new Point(u.x, u.y - 1, 'J', u.time + 1));
                            }
                        }
                        if (u.y < r - 1) {
                            if (maze[u.y + 1][u.x] == '.') { // move down
                                maze[u.y + 1][u.x] = 'J';
                                numJ++;
                                queue.add(new Point(u.x, u.y + 1, 'J', u.time + 1));
                            }
                        }
                    }
                    if (numJ == 0) {
                        break;
                    }
                }
            } else { // u == 'F'
                if (u.x > 0) {
                    if (maze[u.y][u.x - 1] != '#') { // move left
                        maze[u.y][u.x - 1] = 'F';
                        queue.add(new Point(u.x - 1, u.y, 'F', u.time + 1));
                    }
                }
                if (u.x < c - 1) {
                    if (maze[u.y][u.x + 1] != '#') { // move right
                        maze[u.y][u.x + 1] = 'F';
                        queue.add(new Point(u.x + 1, u.y, 'F', u.time + 1));
                    }
                }
                if (u.y > 0) {
                    if (maze[u.y - 1][u.x] != '#') { // move up
                        maze[u.y - 1][u.x] = 'F';
                        queue.add(new Point(u.x, u.y - 1, 'F', u.time + 1));
                    }
                }
                if (u.y < r - 1) {
                    if (maze[u.y + 1][u.x] != '#') { // move down
                        maze[u.y + 1][u.x] = 'F';
                        queue.add(new Point(u.x, u.y + 1, 'F', u.time + 1));
                    }
                }
            }
        }
        if (!hasEscaped) {
            io.println("IMPOSSIBLE");
        }
        io.close();
    }
}

class Point {
    int x;
    int y;
    char c;
    int time; // timestamp of when joe or the fire reached that cell

    public Point(int x, int y, char c, int time) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.time = time;
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
