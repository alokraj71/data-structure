package ds;

public class BasicQueue<T> {

	private T[] data;
	private int front;
	private int end;

	public BasicQueue() {
		this(1000);
	}

	public BasicQueue(int size) {
		this.front = -1;
		this.end = -1;
		data = (T[]) new Object[size];
	}

	public int size() {
		if (front == -1 && end == -1) {
			return 0;
		} else {
			return end - front + 1;
		}
	}

	public void enQueue(T item) {
		/* check for queue i full or not */
		if ((end + 1) % data.length == front) {
			throw new IllegalStateException("Queue is full");
		}
		if (size() == 0) {
			front++;
			end++;
			data[end] = item;
		} else {
			end++;
			data[end] = item;
		}
	}

	public T deQueue() {
		T item = null;
		if (size() == 0) {
			throw new IllegalStateException("Queue is empety");
		} else if (front == end) {
			item = data[front];
			data[front] = null;
		} else {
			item = data[front];
			data[front] = null;
			front++;
		}
		return item;
	}

	public boolean contain(T item) {
		boolean found = false;
		if (size() == 0) {
			return found;
		}
		for (int i = front; i < end; i++) {
			if (data[i].equals(item)) {
				found = true;
			}
		}
		return found;
	}

	public T access(int position) {
		if (size() == 0) {
			throw new IllegalStateException("Queue is empety");
		}
		if (position > data.length) {
			throw new IllegalStateException("Could not find any item at this position");
		}
		return data[position + 1];
	}
}
