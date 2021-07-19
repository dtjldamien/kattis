
// https://open.kattis.com/problems/timebomb
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.StringBuilder;

public class Timebomb {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String row1 = br.readLine();
        String row2 = br.readLine();
        String row3 = br.readLine();
        String row4 = br.readLine();
        String row5 = br.readLine();
        int code = 0;
        boolean isValid = true;
        for (int i = 0; i < row1.length(); i += 4) {
            if (row1.substring(i, i + 3).equals("***") && row2.substring(i, i + 3).equals("* *")
                    && row3.substring(i, i + 3).equals("* *") && row4.substring(i, i + 3).equals("* *")
                    && row5.substring(i, i + 3).equals("***")) {
                code = code * 10; // 0
            } else if (row1.substring(i, i + 3).equals("  *") && row2.substring(i, i + 3).equals("  *")
                    && row3.substring(i, i + 3).equals("  *") && row4.substring(i, i + 3).equals("  *")
                    && row5.substring(i, i + 3).equals("  *")) {
                code = code * 10 + 1;
            } else if (row1.substring(i, i + 3).equals("***") && row2.substring(i, i + 3).equals("  *")
                    && row3.substring(i, i + 3).equals("***") && row4.substring(i, i + 3).equals("*  ")
                    && row5.substring(i, i + 3).equals("***")) {
                code = code * 10 + 2;
            } else if (row1.substring(i, i + 3).equals("***") && row2.substring(i, i + 3).equals("  *")
                    && row3.substring(i, i + 3).equals("***") && row4.substring(i, i + 3).equals("  *")
                    && row5.substring(i, i + 3).equals("***")) {
                code = code * 10 + 3;
            } else if (row1.substring(i, i + 3).equals("* *") && row2.substring(i, i + 3).equals("* *")
                    && row3.substring(i, i + 3).equals("***") && row4.substring(i, i + 3).equals("  *")
                    && row5.substring(i, i + 3).equals("  *")) {
                code = code * 10 + 4;
            } else if (row1.substring(i, i + 3).equals("***") && row2.substring(i, i + 3).equals("*  ")
                    && row3.substring(i, i + 3).equals("***") && row4.substring(i, i + 3).equals("  *")
                    && row5.substring(i, i + 3).equals("***")) {
                code = code * 10 + 5;
            } else if (row1.substring(i, i + 3).equals("***") && row2.substring(i, i + 3).equals("*  ")
                    && row3.substring(i, i + 3).equals("***") && row4.substring(i, i + 3).equals("* *")
                    && row5.substring(i, i + 3).equals("***")) {
                code = code * 10 + 6;
            } else if (row1.substring(i, i + 3).equals("***") && row2.substring(i, i + 3).equals("  *")
                    && row3.substring(i, i + 3).equals("  *") && row4.substring(i, i + 3).equals("  *")
                    && row5.substring(i, i + 3).equals("  *")) {
                code = code * 10 + 7;
            } else if (row1.substring(i, i + 3).equals("***") && row2.substring(i, i + 3).equals("* *")
                    && row3.substring(i, i + 3).equals("***") && row4.substring(i, i + 3).equals("* *")
                    && row5.substring(i, i + 3).equals("***")) {
                code = code * 10 + 8;
            } else if (row1.substring(i, i + 3).equals("***") && row2.substring(i, i + 3).equals("* *")
                    && row3.substring(i, i + 3).equals("***") && row4.substring(i, i + 3).equals("  *")
                    && row5.substring(i, i + 3).equals("***")) {
                code = code * 10 + 9;
            } else {
                isValid = false;
                break;
            }
        }
        if (isValid && code % 6 == 0) {
            pw.println("BEER!!");
        } else {
            pw.println("BOOM!!");
        }
        pw.close();
        br.close();
    }
}