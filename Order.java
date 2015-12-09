import java.util.concurrent.*;
import java.util.*;

public class Order {
	public LinkedBlockingQueue<OrderImpl> orderQueue = new LinkedBlockingQueue<OrderImpl>();
	public ArrayList<OrderImpl> finishQueue = new ArrayList<OrderImpl>();
	public ArrayList<OrderImpl> eatQueue = new ArrayList<OrderImpl>();
	public int total = 0;
	public volatile int current = 0;

	public Order(int total) {
		this.total = total;
	}

	public synchronized OrderImpl getOrder() throws Exception{
		while(orderQueue.isEmpty()) {
			wait();
		}
		return orderQueue.poll();
	}

	public synchronized void putOrder(OrderImpl oi) throws Exception{
		orderQueue.put(oi);
		notifyAll();
	}

	public synchronized void checkFinish(int id) throws Exception{
		while(traverse(id)) {
			wait();
		}
	}

	public synchronized void putFinish(OrderImpl oi) {
		finishQueue.add(oi);
		notifyAll();
	}

	public boolean traverse(int id) {
		for (OrderImpl ooi: finishQueue) {
			if (ooi.id == id) {
				return false;
			}
		}
		return true;
	}

	public synchronized boolean checkFinish() {
		current++;
		if (current == total) {
			return true;
		}
		return false;
	}
}
