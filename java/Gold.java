
// https://open.kattis.com/problems/gold
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.awt.Point;

public class Gold {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        // read grid
        String[] dimensions = br.readLine().split(" ");
        int w = Integer.parseInt(dimensions[0]);
        int h = Integer.parseInt(dimensions[1]);
        char[][] grid = new char[h][w];
        Point p = new Point();
        ArrayDeque<Point> queue = new ArrayDeque<>();
        for (int row = 0; row < h; row++) {
            char[] currLine = br.readLine().toCharArray();
            for (int col = 0; col < w; col++) {
                if (currLine[col] == 'P') {
                    p.x = row;
                    p.y = col;
                    queue.add(p);
                }
                grid[row][col] = currLine[col];
            }
        }
        // flood fill algorithm
        int numGold = 0;
        boolean[][] visited = new boolean[h][w];
        visited[p.x][p.y] = true;
        while (!queue.isEmpty()) {
            Point currPoint = queue.poll();
            if (grid[currPoint.x][currPoint.y] == 'G') {
                numGold++;
            }
            // sense a draft
            if (isDraft(currPoint.x, currPoint.y, grid)) {
                continue;
            }
            // avoid walking into a square containing a wall
            if (isValidMove(currPoint.x, currPoint.y - 1, grid) && !visited[currPoint.x][currPoint.y - 1]) {
                queue.add(new Point(currPoint.x, currPoint.y - 1));
                visited[currPoint.x][currPoint.y - 1] = true;
            }
            if (isValidMove(currPoint.x, currPoint.y + 1, grid) && !visited[currPoint.x][currPoint.y + 1]) {
                queue.add(new Point(currPoint.x, currPoint.y + 1));
                visited[currPoint.x][currPoint.y + 1] = true;
            }
            if (isValidMove(currPoint.x - 1, currPoint.y, grid) && !visited[currPoint.x - 1][currPoint.y]) {
                queue.add(new Point(currPoint.x - 1, currPoint.y));
                visited[currPoint.x - 1][currPoint.y] = true;
            }
            if (isValidMove(currPoint.x + 1, currPoint.y, grid) && !visited[currPoint.x + 1][currPoint.y]) {
                queue.add(new Point(currPoint.x + 1, currPoint.y));
                visited[currPoint.x + 1][currPoint.y] = true;
            }
        }
        pw.println(numGold);
        pw.close();
        br.close();
    }

    public static boolean isWithinBounds(int x, int y, int w, int h) {
        if (x >= 0 && x < w && y >= 0 && y < h) {
            return true;
        }
        return false;
    }

    public static boolean isDraft(int x, int y, char[][] grid) {
        if (isWithinBounds(x, y - 1, grid.length, grid[0].length)) {
            if (grid[x][y - 1] == 'T') {
                return true;
            }
        }
        if (isWithinBounds(x, y + 1, grid.length, grid[0].length)) {
            if (grid[x][y + 1] == 'T') {
                return true;
            }
        }
        if (isWithinBounds(x - 1, y, grid.length, grid[0].length)) {
            if (grid[x - 1][y] == 'T') {
                return true;
            }
        }
        if (isWithinBounds(x + 1, y, grid.length, grid[0].length)) {
            if (grid[x + 1][y] == 'T') {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidMove(int x, int y, char[][] grid) {
        if (isWithinBounds(x, y, grid.length, grid[0].length)) {
            if (grid[x][y] == '.' || grid[x][y] == 'G') {
                return true;
            }
        }
        return false;
    }
}
