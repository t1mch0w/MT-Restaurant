public class Dinner extends Thread {
	public int arrivedTime = 0;
	public int burger = 0;
	public int fries = 0;
	public int coke = 0;
	public int sundae = 0;
	public int seatedTable = -1;
	public int id = 0;
	public int time = 0;
	public Table table = null;
	public Order order = null;
	public TableImpl ti = null;

	public Dinner(int id, int arrivedTime, int burger, int fries, int coke, int sundae, Table table, Order order) {
		this.id = id;
		this.arrivedTime = arrivedTime;
		this.order = order;
		this.table = table;
		this.burger = burger;
		this.fries = fries;
		this.coke = coke;
		this.sundae = sundae;
	}

	public void run() {
		try {
			// Get a Seat
			ti = table.sitInTable();
			seatedTable = ti.getId();

			if (arrivedTime > ti.getTime()) {
				time = arrivedTime;
			}
			else {
				time = ti.getTime();
			}

			// Output 
			System.out.format("Dinner %d gets the table %d at %d min.\n", id, ti.getId(), time);

			// Add the Order
			OrderImpl oi = new OrderImpl(id, burger, fries, coke, sundae, time);
			order.putOrder(oi);	

			// Wait for Finish 
			order.checkFinish(id);
			time = oi.time;

			// Output
			System.out.format("Dinner %d gets the food at %d min.\n", id, time);
			time += 30;

			// Return the table
			ti.time = time;
			table.returnTable(ti);

			// Final check 
			if (order.checkFinish()) {
				// Output
				System.out.format("The last dinner %d leaves at %d min.\n", id, time);

				System.exit(-1);
			}

		}
		catch (Exception e) {
		}
	}
}
