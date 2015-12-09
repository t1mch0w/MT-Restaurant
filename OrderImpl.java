public class OrderImpl {
	public int id;
	public int burger;
	public int fries;
	public int coke;
	public int sundae;
	public int time = 0;

	public OrderImpl(int id,int burger, int fries, int coke, int sundae, int time) {
		this.id = id;
		this.burger = burger;
		this.fries = fries;
		this.coke = coke;
		this.sundae = sundae;
		this.time = time;
	}

	public synchronized boolean checkFinish() {
		if ((burger==0) && (fries == 0) && (coke == 0) && (sundae == 0)) {
			return false;
		}
		return true;
	}

}
