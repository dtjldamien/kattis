
// https://open.kattis.com/problems/hittingtargets
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

public class HittingTargets {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int m = Integer.parseInt(br.readLine());
        List<Circle> circles = new ArrayList<>();
        List<Rectangle> rectangles = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("rectangle")) {
                rectangles.add(new Rectangle(Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]), Integer.parseInt(input[4])));
            } else if (input[0].equals("circle")) {
                circles.add(new Circle(Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3])));
            }
        }
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int count = 0 ;
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            for (Circle circle : circles) {
                // if distance from center of the circle to the point is less than the radius, the point is in the circle
                if (Math.pow(x - circle.x, 2) + Math.pow(y - circle.y, 2) <= Math.pow(circle.radius, 2)) {
                    count++;
                }
            }
            for (Rectangle rectangle: rectangles) {
                if (x >= rectangle.x1 && y >= rectangle.y1 && x <= rectangle.x2 && y <= rectangle.y2) {
                    count++;
                }
            }
            pw.println(count);
        }
        pw.close();
        br.close();
    }
}

class Circle {
    int x;
    int y;
    int radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
}

class Rectangle {
    int x1;
    int y1;
    int x2;
    int y2;
    
    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}
