import java.util.concurrent.*;
import java.util.*;

public class Order {
	public LinkedBlockingQueue<OrderImpl> orderQueue = new LinkedBlockingQueue<OrderImpl>();
	public ArrayList<OrderImpl> finishQueue = new ArrayList<OrderImpl>();

	public synchronized OrderImpl getOrder() throws Exception{
		while(orderQueue.isEmpty()) {
			wait();
		}
		return orderQueue.poll();
	}

	public synchronized void putOrder(OrderImpl oi) throws Exception{
		orderQueue.put(oi);
	}

	public synchronized void checkFinish(int id) throws Exception{
		while(traverse(id)) {
			wait();
		}
	}

	public synchronized void putFinish(OrderImpl oi) {
		finishQueue.add(oi);
	}

	public boolean traverse(int id) {
		for (OrderImpl ooi: finishQueue) {
			if (ooi.id == id) {
				finishQueue.remove(ooi);
				return false;
			}
		}
		return true;
	}
}
