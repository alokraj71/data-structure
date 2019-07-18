package ds;

public class BasicLinkedList<T> {

	private class Node {
		private T nodeItem;
		private Node nextNode;

		public Node(T item) {
			this.nodeItem = item;
			this.nextNode = null;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public Node getNextNode() {
			return nextNode;
		}
	}

	Node first;
	Node last;
	int size;

	public BasicLinkedList() {
		first = null;
		last = null;
		size = 0;
	}

	public void add(T item) {
		if (first == null) {
			first = new Node(item);
			last = first;
		} else {
			Node newNode = new Node(item);
			last.setNextNode(newNode);
			last = newNode;
		}
		size++;
	}

	public int size() {
		return size;
	}

	public boolean remove(T item) {
		boolean removed = false;
		if (first == null)
			throw new IllegalStateException("List is empety");
		while (first.nextNode != null) {
			first = first.nextNode;
			if (first.nodeItem.equals(item)) {
				first = first.getNextNode();
				removed = true;
				size--;
			}
		}
		return removed;
	}
}
