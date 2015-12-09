public class Machine {
	public int burgerM = 1;
	public int friesM = 1;
	public int cokeM = 1;
	public int sundaeM = 1;
	public int burgerTime = 0;
	public int friesTime = 0;
	public int cokeTime = 0;
	public int sundaeTime = 0;

	public synchronized boolean checkBurgerM() {
		if (burgerM == 1) return true;
		return false;
	}


	public synchronized boolean checkFriesM() {
		if (friesM == 1) return true;
		return false;
	}

	public synchronized boolean checkCokeM() {
		if (cokeM == 1) return true;
		return false;
	}

	public synchronized boolean checkSundaeM() {
		if (sundaeM == 1) return true;
		return false;
	}

	public synchronized int getBurgerM(int time) throws InterruptedException {
		while(burgerM==0) {
			wait();
		}

		if (burgerTime < time) {
			burgerTime = time + 5;
		}
		else {
			burgerTime += 5;
		}

		burgerM = 0;

		return burgerTime;
	}

	public synchronized void releaseBurgerM() {
		burgerM = 1;
		notifyAll();
	}

	public synchronized int getFriesM(int time) throws InterruptedException {
		while(friesM==0) {
			wait();
		}

		if (friesTime < time) {
			friesTime = time + 3;
		}
		else {
			friesTime += 3;
		}

		friesM = 0;

		return friesTime;
	}

	public synchronized void releaseFriesM() {
		friesM = 1;
		notifyAll();
	}

	public synchronized int getCokeM(int time) throws InterruptedException {
		while(cokeM==0) {
			wait();
		}

		if (cokeTime < time) {
			cokeTime = time + 2;
		}
		else {
			cokeTime += 2;
		}
		
		cokeM = 0;

		return cokeTime;
	}

	public synchronized void releaseCokeM() {
		cokeM = 1;
		notifyAll();
	}

	public synchronized int getSundaeM(int time) throws InterruptedException {
		while(sundaeM==0) {
			wait();
		}

		if (sundaeTime < time) {
			sundaeTime = time + 1;
		}
		else {
			sundaeTime += 1;
		}

		sundaeM = 0;

		return sundaeTime;
	}

	public synchronized void releaseSundaeM() {
		sundaeM = 1;
		notifyAll();
	}

}
