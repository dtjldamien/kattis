package java;
// https://open.kattis.com/problems/flowlayout
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FlowLayout {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int m = Integer.parseInt(br.readLine());
        while (m != 0) {
            // new window
            String[] input = br.readLine().split(" ");
            int objWidth = Integer.parseInt(input[0]);
            int objHeight = Integer.parseInt(input[1]);
            int rowWidth = 0;
            int rowHeight = 0;
            int resultWidth = 0;
            int resultHeight = 0;
            while (objWidth != -1 && objHeight != -1)  {
                if (objWidth + rowWidth <= m) {
                    // continue in the same row
                    rowWidth += objWidth;
                    rowHeight = Math.max(rowHeight, objHeight);
                } else {
                    // add a new row
                    // calculate maximum width, and add up height
                    resultWidth = Math.max(resultWidth, rowWidth);
                    resultHeight += rowHeight;
                    // set the dimensions for the new row
                    rowWidth = objWidth;
                    rowHeight = objHeight;    
                }
                // take in next object
                input = br.readLine().split(" ");
                objWidth = Integer.parseInt(input[0]);
                objHeight = Integer.parseInt(input[1]);    
            }
            // calculate and output dimensions of the resulting window
            resultWidth = Math.max(resultWidth, rowWidth);
            resultHeight += rowHeight;
            pw.printf("%d x %d\n", resultWidth, resultHeight);
            m = Integer.parseInt(br.readLine());
        }
        pw.close();
        br.close();
    }
}
