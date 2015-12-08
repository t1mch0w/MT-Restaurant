import java.util.concurrent.*;

public class Table {
	public LinkedBlockingQueue<TableImpl> tableQueue = new LinkedBlockingQueue<TableImpl>();

	public Table(int n) throws Exception{
		for (int i = 0; i < n; i++) {
			TableImpl ti = new TableImpl(i, 0);
			tableQueue.put(ti);
		}
	}

	public synchronized TableImpl sitInTable() throws Exception{
		while(tableQueue.isEmpty()) {
			wait();
		}
		TableImpl ti = tableQueue.poll();

		return ti;
	}

	public synchronized void returnTable(TableImpl ti) throws Exception{
		tableQueue.put(ti);
	}

}
