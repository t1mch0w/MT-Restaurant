public class Order {
	private int Burger;
	private int Fries;
	private int Coke;
	private int Sundae;

	public Order(int Burger, int Fries, int Coke, int Sundae) {
		this.Burger = Burger;
		this.Fries = Fries;
		this.Coke = Coke;
		this.Sundae = Sundae;
	}

	public boolean ifFinished() {
		if ((Burger==0) && (Fries == 0) && (Coke == 0) && (Sundae == 0)) {
			return true;
		}
		return false;
	}
}