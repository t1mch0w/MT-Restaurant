public class Dinner implements Runnable {
	public int arrivedTime = 0;
	public int burger = 0;
	public int fries = 0;
	public int coke = 0;
	public int sundae = 0;
	public int seatedTable = -1;
	public int id = 0;
	public int sitTime = 0;
	public int currentTime = 0;
	public Table table = null;
	public Order order = null;
	public TableImpl ti = null;

	public Dinner(int id, int arrivedTime, int burger, int fries, int coke, int sundae, Table table, Order order) {
		this.id = id;
		this.arrivedTime = arrivedTime;
		this.order = order;
		this.table = table;
	}

	public void run() {
		// Get a Seat
		ti = table.sitInTable();
		seatedTable = ti.getId();

		if (arrivedTime > ti.getTime()) {
			sitTime = arrivedTime;
		}
		else {
			sitTime = ti.getTime();
		}

		// Output 
		System.out.format("Dinner %d get the table %d at time %d \n", id, ti.getId(), sitTime);

		// Add the Order
		OrderImpl oi = new OrderImpl(id, burger, fries, coke, sundae);
		order.putOrder(oi);	

		// Wait for Finish 
		order.checkFinish(id);

		// Eat for 30 mins
		System.out.format("Dinner %d Eat for 30 mins.\n", id);

		// Return the table
		table.returnTable(ti);
	}
}
