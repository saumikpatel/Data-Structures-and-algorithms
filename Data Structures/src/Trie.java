import java.util.HashMap;
import java.util.Map;

public class Trie {

	private class Node {
		Map<Character, Node> children;
		boolean endofword;

		// Constructor
		public Node() {
			children = new HashMap<>();
			endofword = false;
		}
	}// End of inner class

	private static Node root = null;

	Trie() {
		root = new Node();
	}

	public void insert(String data) {
		Node currentnode = root;

		for (int i = 0; i < data.length(); i++) {
			char ch = data.charAt(i);
			Node node = currentnode.children.get(ch);
			if (node == null) {
				node = new Node();
				// node.endofword=false;

				currentnode.children.put(ch, node);
				// currentnode.endofword=false;

			}
			currentnode = node;

		}
		currentnode.endofword = true;

	}

	@SuppressWarnings("unused")
	public boolean search(String data) {
		Node currentnode = root;

		for (int i = 0; i < data.length(); i++) {
			char ch = data.charAt(i);
			Node node = currentnode.children.get(ch);
			// System.out.println(node.endofword);
			if (node == null) {
				System.out.println("string does not exist");
				return false;
			}
			currentnode = node;
		}
		if (currentnode.endofword == true) {
			System.out.println("string  exist");
			return true;
		} else {
			System.out.println("string does not exist");
			return false;
		}
	}

	public void delete(String word) {
		if (search(word) == true) {
			delete(root, word, 0);
		}
	}

	// Returns true if parent should delete the mapping
	private boolean delete(Node parentNode, String word, int index) {

		char ch = word.charAt(index);
		System.out.println("Character " + ch);

		Node currentNode = parentNode.children.get(ch);
		if (currentNode.children.size() > 1) {
			System.out.println("Entering Case#1");
			delete(currentNode, word, index + 1);
			return false;
		}
		if (index == word.length() - 1) {
			System.out.println("Entering Case#2");
			if (currentNode.children.size() >= 1) {
				System.out.println("Entering Case#2");
				currentNode.endofword = false;
				return false;
			} else {
				parentNode.children.remove(ch);
			//	System.out.println("Character " + ch + " has no dependency, hence deleting it");
				return true;
			}
		}

		if (currentNode.endofword == true) {
			System.out.println("Entering Case#3");
			delete(currentNode, word, index + 1);
			return false;
		}

		System.out.println("Entering Case#1");

		boolean canThisNodeBeDeleted = delete(currentNode, word, index + 1); // CASE#4
		if (canThisNodeBeDeleted == true) {
			System.out.println("Character " + ch + " has no dependency, hence deleting it");
			parentNode.children.remove(ch);
			return true; // Current node can also be deleted
		} else {
			return false; // Someone is dependent on this node, hence dont delete it
		}

	}

	public static void main(String args[]) {
		Trie trie = new Trie();
		trie.insert("abcd");
		trie.insert("abce");
		// trie.insert("abcd");
//		trie.search("axy");
//		trie.search("abc");
//		trie.search("ab");
		trie.delete("abcd");
		trie.search("abcd");
		trie.search("abce");
		// System.out.println(children.get(2));
	}
}
