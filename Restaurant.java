import java.io.*;

public class Restaurant {

	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(args[0]));

		Order order = new Order();
		Machine machine = new Machine();

		// First, # of Dinners 
		String line = br.readLine().trim();
		int numOfDin = Integer.parseInt(line);
		Dinner[] dinners = new Dinner[numOfDin];

		// Second, # of Tables;
		line = br.readLine().trim();
		int numOfTab = Integer.parseInt(line);
		Table table = new Table(numOfTab);

		// Third, # of Cooks;
		line = br.readLine().trim();
		int numOfCook = Integer.parseInt(line);
		
		for (int i = 0; i < numOfCook; i++) {
			Cook cook = new Cook(i, order, machine);
			cook.run();
		}
		
		// Create the dinners
		for (int i = 0; i < numOfDin; i++) {
			line = br.readLine().trim();
			String[] data = line.split(" ");
			int arrivedTime = Integer.parseInt(data[0]);
			int burger = Integer.parseInt(data[1]);
			int fries = Integer.parseInt(data[2]); 
			int coke = Integer.parseInt(data[3]);
			int sundae = Integer.parseInt(data[4]);
			dinners[i] = new Dinner(i, arrivedTime, burger, fries, coke, sundae, table, order);
		}

		// Start the dinners threads
		for (int i = 0; i < numOfDin; i++) {
			dinners[i].run();
		}

	}
}
