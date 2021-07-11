// https://open.kattis.com/problems/okviri
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Okviri {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String input = br.readLine();
        char[][] peterPan = { 
            { '.', '.', '#', '.', '.' }, 
            { '.', '#', '.', '#', '.' }, 
            { '#', '.', 'X', '.', '#' },
            { '.', '#', '.', '#', '.' }, 
            { '.', '.', '#', '.', '.' } 
        };
        char[][] wendy = { 
            { '.', '.', '*', '.', '.' }, 
            { '.', '*', '.', '*', '.' }, 
            { '*', '.', 'X', '.', '*' },
            { '.', '*', '.', '*', '.' }, 
            { '.', '.', '*', '.', '.' } 
        };
        char[][] output = new char[5][input.length() * 4 + 1];
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                output[row][col] = peterPan[row][col];
                if (row == 2 && col == 2) {
                    output[row][col] = input.charAt(0);
                }
            }
        }
        for (int i = 1; i < input.length(); i++) {
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    if ((i + 1) % 3 == 0) { // if it is a wendy frame
                        output[row][col + i * 4] = wendy[row][col];
                    } else {
                        if (i % 3 == 0 && col == 0) { // if the previous frame is a wendy frame, use wendy frame's first column
                            output[row][col + i * 4] = wendy[row][col];
                        } else { // use peter  pan's frame
                            output[row][col + i * 4] = peterPan[row][col];
                        }
                    }
                    if (row == 2 && col % 4 == 2) { // input the character at the center
                        output[row][col + i * 4] = input.charAt(i);
                    }
                }
                if (input.length() % 3 == 0) { // put in the last column, using a wendy frame
                    output[row][input.length() * 4] = wendy[row][4];
                } else { // put in the last column, using a peter pan frame
                    output[row][input.length() * 4] = peterPan[row][4];
                }
            }
        }
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < input.length() * 4 + 1; col++) {
                pw.print(output[row][col]); // output
            }
            pw.println();
        }
        pw.close();
        br.close();
    }
}
