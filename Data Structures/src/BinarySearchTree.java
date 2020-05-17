import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	static Node root = null;

	public static class Node {
		int data;
		Node left;
		Node right;

	}

	static void insert(int value) {
		root = helperinsert(root, value);
	}

	public static Node helperinsert(Node currentroot, int data) {

		if (currentroot == null) {
			Node node = new Node();
			node.data = data;

			return node;
		} else if (data < currentroot.data) {
			currentroot.left = helperinsert(currentroot.left, data);
		} else {
			currentroot.right = helperinsert(currentroot.right, data);

		}
		return currentroot;
	}

	public static void searchnode(Node root, int data) {
		if (root == null) {
			System.out.println("value not found");
		} else if (root.data == data) {
			System.out.println(root.data);
		} else {
			if (data < root.data) {
				searchnode(root.left, data);
			} else {
				searchnode(root.right, data);
			}
		}
	}

	public static void delete(Node root, int data) {
		System.out.println("deleted"+data);
		root=helperdeletenode(root, data);
	}

	public static Node helperdeletenode(Node root, int data) {

		if (root == null) {
			System.out.println("Value not found in BST");

		}
		if (data < root.data) {
			root.left = helperdeletenode(root.left, data);
		} else if (data > root.data) {
			root.right = helperdeletenode(root.right, data);
		} else if (root.data == data) {
			//System.out.println(root.data);
			if ((root.left != null) && (root.right != null)) {
				//System.out.println("in double node");
				Node temp = root;
				Node minimumnode = minimumElement(temp.right);
				//System.out.println(minimumnode.data);
				root.data = minimumnode.data;
				root.right = helperdeletenode(root.right, minimumnode.data);

			} else if ((root.left == null) && (root.right == null)) {
				//System.out.println("in 0 child");
				root = null;
			} else if (root.left != null) {
				//System.out.println("in left child");
				root = root.left;
			} else if (root.right != null) {
				//System.out.println("in right child");
				root = root.right;
			}

		}
		return root;
	}

//	
//	public static Node deleteNodeOfBST(Node root, int value) {
//		if (root == null) {
//			System.out.println("Value not found in BST");
//			return null;
//		}
//		if (value < root.data) {
//			root.left=deleteNodeOfBST(root.left, value);
//		} 
//		else if (value > root.data) {
//			root.right=deleteNodeOfBST(root.right, value);
//		} else {   // If cur rentNode is the node to be deleted
//
//			if (root.left != null && root.right != null) { // if nodeToBeDeleted have both children
//				Node temp = root;
//			Node minNodeForRight = minimumElement(temp.right);// Finding minimum element from right subtree
//				root.data=minNodeForRight.data; // Replacing current node with minimum node from right subtree
//				root.right=deleteNodeOfBST(root.right, minNodeForRight.data);  // Deleting minimum node from right now
//			} else if (root.left != null) {// if nodeToBeDeleted has only left child
//				root = root.left;
//			} else if (root.right != null) {// if nodeToBeDeleted has only right child
//				root = root.right;
//			} else // if nodeToBeDeleted do not have child (Leaf node)
//				root = null;
//		}
//		return root;
//	}
	public static Node minimumElement(Node root) {

		if (root.left == null)
			return root;
		else {
			//System.out.println(root.left.data);
			return minimumElement(root.left);

		}
	}// end of method
//	static void printTreeGraphically() {
//		Queue<Node> queue = new LinkedList<Node>();
//		Queue<Integer> level = new LinkedList<Integer>();
//		
//		int CurrentLevel = 1;
//		boolean previousLevelWasAllNull = false;
//		queue.add(root);
//		level.add(1);
//		
//		System.out.println("\nPrinting Level order traversal of Tree...");
//		if(root == null) {
//			System.out.println("Tree does not exists !");
//			return;
//		}
//		
//		while (!queue.isEmpty()) {
//			if(CurrentLevel == level.peek()) { //if we are in the same level
//				if(queue.peek()==null) {
//					queue.add(null);level.add(CurrentLevel+1);
//				}else {
//					queue.add(queue.peek().left);level.add(CurrentLevel+1);
//					queue.add(queue.peek().right);level.add(CurrentLevel+1);
//					previousLevelWasAllNull = false;
//				}
//				System.out.print(queue.remove().data + "  ");level.remove();
//			}else { //level has changed
//				System.out.println("\n");
//				CurrentLevel++;
//				if(previousLevelWasAllNull == true) {
//					break;
//				}
//				previousLevelWasAllNull = true;
//			}
//		}//end of loop
//	}//end of method
//	

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

	public static void main(String args[]) {
		insert(100);
		insert(50);
		insert(120);
		insert(30);
		insert(60);
		insert(150);
		insert(110);
		insert(75);
		insert(20);
		delete(root, 120);
//		printTreeGraphically();
		levelordertraverse();
		// searchnode(root, 20);

	}
}
