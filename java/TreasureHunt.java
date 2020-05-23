import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TreasureHunt {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] dimensions = br.readLine().split(" ");
        int r = Integer.parseInt(dimensions[0]);
        int c = Integer.parseInt(dimensions[1]);
        char[][] map = new char[r][c];
        for (int row = 0; row < r; row++) {
            String input = br.readLine();
            for (int col = 0; col < c; col++) {
                map[row][col] = input.charAt(col);
            }
        }
        int playerRow = 0;
        int playerCol = 0;
        int numMoves = 0;
        try {
            while (map[playerRow][playerCol] != 'T') {
                numMoves++;
                char direction = map[playerRow][playerCol];
                map[playerRow][playerCol] = 'X';
                switch (direction) {
                    case 'N':
                        playerRow--;
                        break;
                    case 'S':
                        playerRow++;
                        break;
                    case 'W':
                        playerCol--;
                        break;
                    case 'E': 
                        playerCol++;
                        break;
                    case 'X':
                        throw new LostException("Lost");
                }
            }
            pw.println(numMoves);
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            pw.println("Out");
        } catch (LostException lostException) {
            pw.println("Lost");
        }
        pw.close();
        br.close();
    }
}

class LostException extends Exception {
    public LostException(String errorMessage) {
        super(errorMessage);
    }
}