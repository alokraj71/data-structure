package ds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author alok @ Binary Tree implementation for basic operations
 */
public class BasicBinaryTree<X extends Comparable<X>> {
	/* Node class */
	private class Node<X> {
		Node left;
		Node right;
		X value;

		Node(X newValue) {
			this.value = newValue;
			this.left = null;
			this.right = null;
		}
	} // Node class ends

	/* Impl of BT */
	Node rootNode;

	/**
	 * @param value add new value to binary tree
	 */
	public void add(X value) {
		rootNode = addRecursive(rootNode, value);
	}

	/**
	 * @param current
	 * @param newValue
	 * @return root node of tree after addition of new value
	 */
	private Node addRecursive(Node current, X newValue) {
		if (current.equals(null)) {
			return new Node(newValue);
		}
		if (((Comparable<X>) newValue).compareTo((X) current.value) > 0) {
			current.right = addRecursive(current.right, newValue);
		} else if (((Comparable<X>) newValue).compareTo((X) current.value) < 0) {
			current.left = addRecursive(current.left, newValue);
		} else {
			return current;
		}
		return current;
	}

	/**
	 * @param value
	 * @return boolean true/false if value exist
	 */
	public boolean containsNode(X value) {
		return containsNodeRecursive(rootNode, value);
	}

	/**
	 * @param current
	 * @param valueToFind
	 * @return
	 */
	private boolean containsNodeRecursive(Node current, X valueToFind) {
		if (current.equals(null)) {
			return false;
		}
		if (valueToFind.equals(rootNode.value)) {
			return true;
		}
		return ((((Comparable<X>) valueToFind).compareTo((X) current.value)) > 0)
				? containsNodeRecursive(current.right, valueToFind)
				: containsNodeRecursive(current.right, valueToFind);
	}

	public void delete(X value) {
		rootNode = deleteRecursive(rootNode, value);
	}

	private Node deleteRecursive(Node current, X valueToDelete) {
		if (current.equals(null)) {
			return null;
		}
		if (valueToDelete.equals(current.value)) {
			/* CASE 1 - No children */
			if (current.left.equals(null) && current.right.equals(null)) {
				return null;
			}
			/* CASE 2 - Only 1 child */
			if (current.right.equals(null)) {
				return current.left;
			}
			if (current.left.equals(null)) {
				return current.right;
			}
			/* CASE 3 - 2 childs */
			X smallestValue = findSmallestValue(current);
			current.value = smallestValue;
			current.right = deleteRecursive(current.right, smallestValue);
			return current;
		}
		if (valueToDelete.compareTo((X) current.value) < 0) {
			current.left = deleteRecursive(current.left, valueToDelete);
			return current;
		}
		current.right = deleteRecursive(current.right, valueToDelete);
        return current;
	}

	private X findSmallestValue(Node current) {
		return rootNode.left.equals(null) ? (X) rootNode.value : findSmallestValue(rootNode.left);
	}
	
	 public void traverseInOrder(Node node) {
	        if (!node.equals(null)) {
	            traverseInOrder(node.left);
	            System.out.print(" " + node.value);
	            traverseInOrder(node.right);
	        }
	    }

	 public void traversePreOrder(Node node) {
	        if (!node.equals(null)) {
	            System.out.print(" " + node.value);
	            traversePreOrder(node.left);
	            traversePreOrder(node.right);
	        }
	    }
	 
	 public void traversePostOrder(Node node) {
	        if (!node.equals(null)) {
	            traversePostOrder(node.left);
	            traversePostOrder(node.right);
	            System.out.print(" " + node.value);
	        }
	    }
	 
	 public void traverseLevelOrder() {
	        if (rootNode.equals(null)) {
	            return;
	        }

	        Queue<Node> nodes = new LinkedList<>();
	        nodes.add(rootNode);

	        while (!nodes.isEmpty()) {

	            Node node = nodes.remove();

	            System.out.print(" " + node.value);

	            if (node.left != null) {
	                nodes.add(node.left);
	            }

	            if (node.left != null) {
	                nodes.add(node.right);
	            }
	        }
	    }

	    
	    public void traverseInOrderWithoutRecursion() {
	        Stack<Node> stack = new Stack<Node>();
	        Node current = rootNode;
	        stack.push(rootNode);
	        while(! stack.isEmpty()) {
	            while(current.left != null) {
	                current = current.left;                
	                stack.push(current);                
	            }
	            current = stack.pop();
	            System.out.print(" " + current.value);
	            if(current.right != null) {
	                current = current.right;                
	                stack.push(current);
	            }
	        }
	    }
	    
	    public void traversePreOrderWithoutRecursion() {
	        Stack<Node> stack = new Stack<Node>();
	        Node current = rootNode;
	        stack.push(rootNode);
	        while(! stack.isEmpty()) {
	            current = stack.pop();
	            System.out.print(" " + current.value);
	            
	            if(current.right != null)
	                stack.push(current.right);
	                
	            if(current.left != null)
	                stack.push(current.left);
	        }        
	    }
	    
	    public void traversePostOrderWithoutRecursion() {
	        Stack<Node> stack = new Stack<Node>();
	        Node prev = rootNode;
	        Node current = rootNode;
	        stack.push(rootNode);

	        while (!stack.isEmpty()) {
	            current = stack.peek();
	            boolean hasChild = (current.left != null || current.right != null);
	            boolean isPrevLastChild = (prev == current.right || (prev == current.left && current.right == null));

	            if (!hasChild || isPrevLastChild) {
	                current = stack.pop();
	                System.out.print(" " + current.value);
	                prev = current;
	            } else {
	                if (current.right != null) {
	                    stack.push(current.right);
	                }
	                if (current.left != null) {
	                    stack.push(current.left);
	                }
	            }
	        }   
	    }    
}
