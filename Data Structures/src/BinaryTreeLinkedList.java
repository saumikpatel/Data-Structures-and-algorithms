import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLinkedList {

	static Node root;

	public static class Node {
		int data;
		Node left;
		Node right;

	}

	public static void insert(int data) {
		Node node = new Node();
		node.data = data;
		node.left = null;
		node.right = null;
		if (root == null) {

			root = node;
		} else {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			while (!queue.isEmpty()) {

				Node n = queue.remove();
				if ((n.left != null) && (n.right != null)) {
					queue.add(n.left);
					queue.add(n.right);
				} else {
					if (n.left == null) {
						n.left = node;
						break;
					} else {
						n.right = node;
						break;
					}

				}
			}
		}

	}

	public static void delete(int data) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node n = queue.remove();
			if (n.data == data) {
				Node deepestnode = getDeepestNode();
				n.data = deepestnode.data;
				DeleteDeepestNode();
				return;
			} else {
				if (n.left != null) {
					queue.add(n.left);
				}
				if (n.right != null) {
					queue.add(n.right);
				}
			}
		}
		System.out.println("node not found");
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

	public static void preordertraversal(Node node) {
		if (node == null) {
			return;
		} else {
			System.out.print(node.data + " ");
			preordertraversal(node.left);
			preordertraversal(node.right);
		}
	}

	public static void postordertraversal(Node node) {
		if (node == null) {
			return;
		} else {

			postordertraversal(node.left);
			postordertraversal(node.right);
			System.out.print(node.data + " ");
		}
	}

	public static void INordertraversal(Node node) {
		if (node == null) {
			return;
		} else {

			INordertraversal(node.left);
			System.out.print(node.data + " ");
			INordertraversal(node.right);

		}
	}

	public static Node getDeepestNode() {

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		Node deepestnode = null;
		while (!queue.isEmpty()) {
			deepestnode = queue.remove();
			if (deepestnode.left != null)
				queue.add(deepestnode.left);
			if (deepestnode.right != null)
				queue.add(deepestnode.right);
		}
		return deepestnode;
	}

	public static void DeleteDeepestNode() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		Node previousNode, presentNode = null;
		while (!queue.isEmpty()) {
			previousNode = presentNode;
			presentNode = queue.remove();
			if (presentNode.left == null) {
				previousNode.right = null;
				return;
			} else if ((presentNode.right == null)) {
				presentNode.left = null;
				return;
			}
			queue.add(presentNode.left);
			queue.add(presentNode.right);
		}
	}

	public static void main(String args[]) {
		insert(10);
		insert(20);
		
		insert(30);
		insert(60);
		insert(70);
		insert(40);
		insert(50);
		insert(80);
		delete(30);
		levelordertraverse();
		
	}
}