public class Cook implements Runnable{
	public int id = 0;
	public OrderImpl oi = null;
	public Order order;
	public Machine machine;

	public Cook(int id, Order order, Machine machine) {
		this.id = id;
		this.order = order;
		this.machine = machine;
	}

	public void run() {
		while (true) {
			// Get the Order
			oi = order.getOrder();

			// Use Machines

			// Burger
			for( int i = 0; i < oi.burger; i++) {
				machine.getBurgerM();
				machine.releaseBurgerM();
			}

			// Fries
			for( int i = 0; i < oi.burger; i++) {
				machine.getFriesM();
				machine.releaseFriesM();
			}

			// Coke
			for( int i = 0; i < oi.burger; i++) {
				machine.getCokeM();
				machine.releaseCokeM();
			}

			// Sundae
			for( int i = 0; i < oi.burger; i++) {
				machine.getSundaeM();
				machine.releaseSundaeM();
			}

			// Finish the Order
			order.putFinish(oi);		
		}
	}
}
