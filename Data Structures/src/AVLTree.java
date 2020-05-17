import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
	static Node root = null;

	static class Node {
		Node left;
		Node right;
		int data;
		int height;

	}

	public static void insert(int data) {
		root = helperinsert(root, data);
	}

	public static Node helperinsert(Node currentnode, int data) {

		if (currentnode == null) {
			Node node = new Node();
			node.data = data;
			node.height = 0;
			return node;
		} else if (data < currentnode.data) {
			currentnode.left = helperinsert(currentnode.left, data);
		} else {
			currentnode.right = helperinsert(currentnode.right, data);

		}
		int balance = checkBalance(currentnode.left, currentnode.right);
		if (balance > 1 && data < currentnode.left.data) {// ll
			currentnode = rightRotate(currentnode);
		} else if (balance < -1 && data > currentnode.right.data) {// rr
			currentnode = leftRotate(currentnode);
		} else if (balance > 1 && data > currentnode.left.data) {// lr
			currentnode.left = leftRotate(currentnode.left);
			currentnode = rightRotate(currentnode);
		} else if (balance < -1 && data < currentnode.right.data)// rl
		{
			currentnode.right = rightRotate(currentnode.right);
			currentnode = leftRotate(currentnode);
		}
		currentnode.height = claculateheight(currentnode);
		return currentnode;
	}

	public static int checkBalance(Node leftnode, Node rightnode) {
		if (leftnode == null && rightnode == null)
			return 0;
		else if (leftnode == null) {
			return -1 * (rightnode.height + 1); // if left node node is not there then simply return right node's
												// height + 1
												// we need to make it -1 because blank height is considered
												// having height as '-1'
		} else if (rightnode == null) {
			return (leftnode.height + 1);
		} else {
			return (leftnode.height - rightnode.height);
		}

	}

	public static int claculateheight(Node currentnode) {
		if (currentnode == null) {
			return 0;
		}
		int leftheight, rightheight;
		if (currentnode.left != null) {
			leftheight = currentnode.left.height;
		} else {
			leftheight = -1;
		}
		if (currentnode.right != null) {
			rightheight = currentnode.right.height;
		} else {
			rightheight = -1;
		}
		return 1 + Math.max(leftheight, rightheight);
	}

	public static void levelordertraverse() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node n = queue.remove();
			System.out.print(n.data + " ");
			if (n.left != null) {
				queue.add(n.left);
			}
			if (n.right != null) {
				queue.add(n.right);
			}
		}
	}

	private static Node leftRotate(Node currentNode) {
		Node newRoot = currentNode.right;
		currentNode.right = currentNode.right.left;
		newRoot.left = currentNode;
		currentNode.height = claculateheight(currentNode);
		newRoot.height = claculateheight(newRoot);
		return newRoot;
	}// end of method

	// Helper Method
	private static Node rightRotate(Node currentNode) {
		Node newRoot = currentNode.left;
		currentNode.left = currentNode.left.right;
		newRoot.right = currentNode;
		currentNode.height = claculateheight(currentNode);
		newRoot.height = claculateheight(newRoot);
		return newRoot;
	}// end of method

	public static void main(String args[]) {
		insert(30);
		insert(20);
		insert(40);
		insert(10);
		insert(5);
		insert(3);
		insert(4);
		insert(50);
		insert(60);
		insert(70);
		insert(65);
		levelordertraverse();
	}
}
