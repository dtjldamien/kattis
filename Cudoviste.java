
// https://open.kattis.com/problems/cudoviste
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Cudoviste {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);
            String[] input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);
            char[][] map = new char[r][c];
            String row;
            for (int i = 0; i < r; i++) {
                row = br.readLine();
                for (int j = 0; j < c; j++) {
                    map[i][j] = row.charAt(j);
                }
            }
            int carCount;
            boolean hasBuilding;
            int zeroCount = 0;
            int oneCount = 0;
            int twoCount = 0;
            int threeCount = 0;
            int fourCount = 0;
            for (int i = 0; i + 1 < r; i++) {
                for (int j = 0; j + 1 < c; j++) {
                    carCount = 0;
                    hasBuilding = false;
                    for (int k = 0; k < 2; k++) {
                        for (int l = 0; l < 2; l++) {
                            if (map[i + k][j + l] == '#') {
                                hasBuilding = true;
                                continue;
                            } else {
                                if (map[i + k][j + l] == 'X') {
                                    carCount++;
                                }
                            }
                        }
                    }
                    if (hasBuilding) {
                        continue;
                    } else {
                        if (carCount == 0) {
                            zeroCount++;
                        } else if (carCount == 1) {
                            oneCount++;
                        } else if (carCount == 2) {
                            twoCount++;
                        } else if (carCount == 3) {
                            threeCount++;
                        } else if (carCount == 4) {
                            fourCount++;
                        }    
                    }
                }
            }
            pw.println(zeroCount);
            pw.println(oneCount);
            pw.println(twoCount);
            pw.println(threeCount);
            pw.println(fourCount);
            pw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
