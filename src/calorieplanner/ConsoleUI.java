package calorieplanner;
import java.util.Scanner;


public class ConsoleUI {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Hallo, wie heißt du?");
		String name = scanner.nextLine();
		
		System.out.println("\nWas ist dein aktuelles Gewicht?");
		int weightcurrent = scanner.nextInt();
		
		System.out.println("\nWas ist dein Wunschgewicht?");
		int weightgoal = scanner.nextInt();
		
		System.out.println("\nIn wie viel Tagen willst du dieses erreicht haben?");
		int days = scanner.nextInt();
		
		System.out.println("\nWas ist dein täglicher Kalorienverbrauch?\nSollte dir dieser nicht bekannt sein kannst du ihn hier berechnen.\nhttps://www.tk.de/service/app/2004134/kalorienrechner/kalorienrechner.app");
		int calorieExpenditure = scanner.nextInt();
		
		int dailyCal = calorieExpenditure - ((weightcurrent - weightgoal) * 7000 / days);
		
		System.out.println("\n" + name + " du darfst täglich bis zu " + dailyCal + " Kalorien zu dir nehmen.");
		
	}

}
