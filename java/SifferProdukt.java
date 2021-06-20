// https://open.kattis.com/problems/sifferprodukt
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SifferProdukt {
        public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int x = Integer.parseInt(br.readLine());
        int product = 1;
        while (true) {
            while (x != 0) {
                if (x % 10 != 0) {
                    product = product * (x % 10);
                }
                x /= 10;
            }    
            if (product < 10) {
                break;
            } else {
                x = product;
                product = 1;    
            }
        }
        pw.println(product);
        pw.close();
        br.close();
    }
}
