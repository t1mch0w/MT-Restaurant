public class TableImpl {
	public int id;
	public int time = 0;

	public TableImpl(int id, int time) {
		this.id = id;
		this.time = time;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public int getTime() {
		return time;
	}
}
