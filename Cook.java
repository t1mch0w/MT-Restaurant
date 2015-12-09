public class Cook extends Thread{
	public int id = 0;
	public OrderImpl oi = null;
	public Order order;
	public Machine machine;
	public int time = 0;

	public Cook(int id, Order order, Machine machine) {
		this.id = id;
		this.order = order;
		this.machine = machine;
	}

	public void run(){
		while (true) {
			try {
				// Get the Order
				oi = order.getOrder();
				System.out.format("Cook %d serves for Dinner %d.\n", id, oi.id);

				// Use Machines
				while(oi.checkFinish()) {

					// Sundae
					if ((oi.sundae>0) && (machine.checkSundaeM())) {
						oi.time = machine.getSundaeM(oi.time);
	
						// Output
						System.out.format("Ice-cream machine is used for Dinner %d by Cook %d at %d min.\n", oi.id, id, oi.time - 1);
	
						oi.sundae--;	
						machine.releaseSundaeM();
					}
					// Coke
					else if ((oi.coke>0) && (machine.checkCokeM())) {
						oi.time = machine.getCokeM(oi.time);
	
						// Output
						System.out.format("Soda machine is used for Dinner %d by Cook %d at %d min.\n", oi.id, id, oi.time - 2);
	
						oi.coke--;
						machine.releaseCokeM();
					}
					// Fries
					else if ((oi.fries>0) && (machine.checkFriesM())) {
						oi.time = machine.getFriesM(oi.time);
	
						// Output
						System.out.format("Fries machine is used for Dinner %d by Cook %d at %d min.\n", oi.id, id, oi.time - 3);
	
						oi.fries--;
						machine.releaseFriesM();
					}
					// Burger
					else if ((oi.burger>0) && (machine.checkBurgerM())) {
						oi.time = machine.getBurgerM(oi.time);
	
						// Output
						System.out.format("Burger machine is used for Dinner %d by Cook %d at %d min.\n", oi.id, id, oi.time - 5);
						
						oi.burger--;	
						machine.releaseBurgerM();
					}
				}

				// Finish the Order
				order.putFinish(oi);		
			}
			catch (Exception e) {
			}
		}
	}
}
