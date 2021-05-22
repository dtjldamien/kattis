
// https://open.kattis.com/problems/nineknights
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

public class NineKnights {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);
            String input;
            List<Knight> knights = new ArrayList<>();
            // read board
            for (int row = 0; row < 5; row++) {
                input = br.readLine();
                for (int col = 0; col < 5; col++) {
                    if (input.charAt(col) == 'k') {
                        knights.add(new Knight(row, col));
                    }
                }
            }
            // valid if no knight can attack another knight with a single move
            if (isValid(knights)) {
                pw.println("valid");
            } else {
                pw.println("invalid");
            }
            pw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isValid(List<Knight> knights) {
        if (knights.size() != 9) {
            return false;
        }
        for (int i = 0; i < 8; i++) {
            Knight a = knights.get(i);
            for (int j = i + 1; j < 9; j++) {
                Knight b = knights.get(j);
                // checking moves to the bottom is sufficient since we are iterating top down
                if (a.row + 1 == b.row && a.col - 2 == b.col) {
                    return false;
                }
                if (a.row + 2 == b.row && a.col - 1 == b.col) {
                    return false;
                }
                if (a.row + 1 == b.row && a.col + 2 == b.col) {
                    return false;
                }
                if (a.row + 2 == b.row && a.col + 1 == b.col) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Knight {
    int row;
    int col;

    public Knight(int row, int col) {
        this.row = row;
        this.col = col;
    }
}