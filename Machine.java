public class Machine {
	public int burgerM = 1;
	public int friesM = 1;
	public int cokeM = 1;
	public int sundaeM = 1;

	public synchronized void getBurgerM() throws InterruptedException {
		while(burgerM==0) {
			wait();
		}
		burgerM = 0;
	}

	public synchronized void releaseBurgerM() {
		burgerM = 1;
	}

	public synchronized void getFriesM() throws InterruptedException {
		while(friesM==0) {
			wait();
		}
		friesM = 0;
	}

	public synchronized void releaseFriesM() {
		friesM = 1;
	}

	public synchronized void getCokeM() throws InterruptedException {
		while(cokeM==0) {
			wait();
		}
		cokeM = 0;
	}

	public synchronized void releaseCokeM() {
		cokeM = 1;
	}

	public synchronized void getSundaeM() throws InterruptedException {
		while(sundaeM==0) {
			wait();
		}
		sundaeM = 0;
	}

	public synchronized void releaseSundaeM() {
		sundaeM = 1;
	}

}
