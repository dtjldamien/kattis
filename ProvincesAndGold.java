import java.util.Scanner;

public class ProvincesAndGold {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numGold = sc.nextInt();
        int numSilver = sc.nextInt();
        int numCopper = sc.nextInt();
        int buyingPower = numGold * 3 + numSilver * 2 + numCopper * 1;
        StringBuilder output = new StringBuilder();
        if (buyingPower >= 8) {
            output.append("Province or ");
        } else if (buyingPower >= 5) {
            output.append("Duchy or ");
        } else if (buyingPower >= 2) {
            output.append("Estate or ");
        }
        if (buyingPower >= 6) {
            output.append("Gold");
        } else if (buyingPower >= 3) {
            output.append("Silver");
        } else {
            output.append("Copper");
        }
        System.out.println(output);
    }
}