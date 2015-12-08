public class Table {
	public LinkedBlockingQueue TableQueue = new LinkedBlockingQueue();

	public Table(int n) {
		for (int i = 0; i < n; i++) {
			TableQueue.put(i);
		}
	}
}