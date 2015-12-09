import java.io.*;
import java.util.*;

public class Restaurant {

	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(args[0]));

		// First, # of Dinners 
		String line = br.readLine().trim();
		int numOfDin = Integer.parseInt(line);
		Dinner[] dinners = new Dinner[numOfDin];

		Order order = new Order(numOfDin);
		Machine machine = new Machine();

		// Second, # of Tables;
		line = br.readLine().trim();
		int numOfTab = Integer.parseInt(line);
		Table table = new Table(numOfTab);

		// Third, # of Cooks;
		line = br.readLine().trim();
		int numOfCook = Integer.parseInt(line);
		
		for (int i = 0; i < numOfCook; i++) {
			Cook cook = new Cook(i, order, machine);
			cook.start();
		}
		
		// Create the dinners
		for (int i = 0; i < numOfDin; i++) {
			Scanner s = new Scanner(br.readLine());
			int arrivedTime = s.nextInt();
			int burger = s.nextInt();
			int fries = s.nextInt(); 
			int coke = s.nextInt();
			int sundae = s.nextInt();
			dinners[i] = new Dinner(i, arrivedTime, burger, fries, coke, sundae, table, order);
		}

		// Start the dinners threads
		for (int i = 0; i < numOfDin; i++) {
			dinners[i].start();
			Thread.sleep(5);
		}
	}
}
