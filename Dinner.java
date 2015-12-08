Public class Dinner implements Runnable {
	private int ArrivedTime;
	private int SeatedTable = -1;
	private Order order;

	public Dinner(int ArrivedTime, int Burger, int Fries, int Coke, int Sundae) {
		this.ArrivedTime = ArrivedTime;
		order = new Order(Burger, Fries, Coke, Sundae);
	}

	public void run() {
		Thread.sleep(ArrivedTime);
		while (checkTable()) {
			wait();
		}
		
	}

	public synchronized boolean checkTable() {
		if (TableQueue.isEmpty()) {
			return true;
		}
		else {
			SeatedTable = TableQueue.poll();
			return false;
		}
	}
}
