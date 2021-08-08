
// https://open.kattis.com/problems/helpme
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.StringBuilder;

public class HelpMe {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        List<ChessPiece> white = new ArrayList<>();
        List<ChessPiece> black = new ArrayList<>();
        br.readLine();
        for (int row = 1; row <= 8; row++) {
            String[] pieces = br.readLine().split("|");
            br.readLine();
            for (int col = 0; col < 8; col++) {
                System.out.println(pieces[col]);
                char currPiece = pieces[col].charAt(1);
                if (!(currPiece == ':') || !(currPiece == '.')) {
                    ChessPiece chessPiece = new ChessPiece(currPiece, (char) (col + 97), row);
                    if (chessPiece.isWhite) {
                        white.add(chessPiece);
                    } else {
                        black.add(chessPiece);
                    }
                }
            }
        }
        Collections.sort(white);
        StringBuilder sbWhite = new StringBuilder("White: ");
        for (ChessPiece chessPiece : white) {
            sbWhite.append(chessPiece.toString());
            sbWhite.append(",");
        }
        pw.println(sbWhite.substring(0, sbWhite.length())); // remove last ","

        Collections.sort(black);
        StringBuilder sbBlack = new StringBuilder("Black: ");
        for (ChessPiece chessPiece : black) {
            sbWhite.append(chessPiece.toString());
            sbWhite.append(",");
        }
        pw.println(sbBlack.substring(0, sbBlack.length())); // remove last ","
        pw.close();
        br.close();
    }
}

class ChessPiece implements Comparable<ChessPiece> {
    char letter;
    char column;
    int row;
    boolean isWhite;

    public ChessPiece(char letter, char column, int row) {
        this.column = column;
        this.row = row;
        // pieces of the white player are shown in upper-case letters,
        // while the black player’s pieces are lower-case letters
        if (Character.isUpperCase(letter)) {
            isWhite = true;
        } else {
            isWhite = false;
        }
        this.letter = Character.toUpperCase(letter);
    }

    @Override
    public int compareTo(ChessPiece another) {
        if (this.letter == another.letter) {
            if (this.row == another.row) {
                // If two pieces of the same type appear in the same row, the one with the
                // smaller column letter must appear first.
                return this.column - another.column;
            } else {
                // In case two pieces of the same type appear in the input, the piece with the
                // smaller row number must be described before the other one if the pieces are
                // white, and the one with the larger row number must be described first if the
                // pieces are black
                if (isWhite) {
                    return this.row - another.row;
                } else {
                    return another.row - this.row;
                }
            }
        }
        // The pieces in the must appear in the following order:
        // Kings, Queens, Rooks, Bishops, Knights, and pawns.
        if (this.letter == 'K') {
            return -1;
        } else if (another.letter == 'K') {
            return 1;
        } else if (this.letter == 'Q') {
            return -1;
        } else if (another.letter == 'Q') {
            return 1;
        } else if (this.letter == 'R') {
            return -1;
        } else if (another.letter == 'R') {
            return 1;
        } else if (this.letter == 'B') {
            return -1;
        } else if (another.letter == 'B') {
            return 1;
        } else if (this.letter == 'N') {
            return -1;
        } else if (another.letter == 'N') {
            return 1;
        }
        return 0; // stub
    }

    @Override
    public String toString() {
        // The description of a piece consists of the type of the piece (except for
        // pawns). This letter is immediatelly followed by the position of the piece in
        // the standard chess notation – column and row
        if (this.letter == 'P') {
            return String.format("%c%d", this.column, this.row);
        } else {
            return String.format("%c%c%d", this.letter, this.column, this.row);
        }
    }
}
