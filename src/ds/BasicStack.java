package ds;

/**
 * @author alok
 *
 * @param <T>
 */
public class BasicStack<T> {
	private T[] data;
	private int stackPointer;

	/**
	 * Constructor
	 */
	@SuppressWarnings("unchecked")
	public BasicStack() {
		data = (T[]) new Object[1000];
		stackPointer = 0;
	}

	/**
	 * @param newItem
	 */
	public void push(T newItem) {
		data[stackPointer++] = newItem;
	}

	/**
	 * @return
	 */
	public T pop() {
		if (stackPointer == 0) {
			throw new IllegalStateException("No more item on stack");
		}
		return data[--stackPointer];
	}

	public boolean conatin(T item) {
		boolean found = false;

		for (int i = 0; i < stackPointer; i++) {
			if (data[i].equals(item)) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public T access(T item) {
		while(stackPointer>0) {
			T tempItem = pop();
			if(item.equals(tempItem)) {
				return item;
			}
		}
		throw new IllegalStateException("Could not find item on stack: " + item);
	}

}
