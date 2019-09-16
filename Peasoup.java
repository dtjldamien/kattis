import java.util.Scanner;

public class Peasoup {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numRestaurant = Integer.parseInt(sc.nextLine());
		boolean hasBoth = false;
		for (int i = 0; i < numRestaurant; i++) {
			int numMenuItem = Integer.parseInt(sc.nextLine());
			String restaurantName = sc.nextLine();
			boolean hasPeaSoup = false;
			boolean hasPancakes = false;
			for (int j = 0; j < numMenuItem; j++) {
				String menuItem = sc.nextLine();
				if (menuItem.equals("pea soup")) {
					hasPeaSoup = true;
				} else if (menuItem.equals("pancakes")) {
					hasPancakes = true;
				}
			}
			if (hasPeaSoup == true && hasPancakes == true) {
				System.out.println(restaurantName);
				hasBoth = true;
				sc.close();
				break; // first restaurant to have both pea soup and pancakes
			}
		}
		if (hasBoth == false) {
			System.out.println("Anywhere is fine I guess");
			sc.close();
		}
	}
}
