import java.util.ArrayList;
import java.util.HashMap;


public class DisjointSet {
	private ArrayList<Node> nodes = new ArrayList<>();

	public static class Node {
		public String name;

		private HashMap<Node, Integer> weightMap = new HashMap<>();

		private DisjointSet set; // used in DisjointSet Algorithm

		public Node(String name) {
			// TODO Auto-generated constructor stub
			this.name = name;
		}

		public void setSet(DisjointSet set2) {
			// TODO Auto-generated method stub
			this.set = set2;
		}

		public String getName() {
			// TODO Auto-generated method stub
			return name;
		}

		public DisjointSet getSet() {
			// TODO Auto-generated method stub
			return set;
		}

	}

	public static void main(String[] args) {

		// Constructor for ArrayList
		ArrayList<Node> nodeList = new ArrayList<>();

		// create 10 nodes: 1-10
		for (int i = 0; i < 10; i++) {
			nodeList.add(new Node("" + (char) (65 + i)));
		}

		// Calling DisjointSet
		DisjointSet.driver(nodeList);

	}// end of method

	private static void driver(ArrayList<Node> nodeList) {
		// TODO Auto-generated method stub
		makeset(nodeList);
		for (int i = 0; i < nodeList.size() - 1; i++) {
			Node firstNode = nodeList.get(i);
			Node secondNode = nodeList.get(i + 1);
			System.out.println("Checking if node " + firstNode.getName() + " and " + secondNode.getName()
					+ " belongs to different set, if yes, will Union them...");
			System.out.println("\nFirst Set name is: " + firstNode.getName());
			firstNode.getSet().printAllNodesOfThisSet();
			System.out.println("\nSecond Set name is: " + secondNode.getName());
			secondNode.getSet().printAllNodesOfThisSet();
			if (!findSet(firstNode).equals(findSet(secondNode))) {
				System.out.println("\nMaking union " + firstNode + " and " + secondNode);
				DisjointSet unionedSet = union(firstNode, secondNode);
				unionedSet.printAllNodesOfThisSet();
			}
		}
	}

	private static DisjointSet union(Node node1, Node node2) {
		// TODO Auto-generated method stub
		if (node1.getSet().equals(node2.getSet())) { // if two nodes are of same set then no union needed
			return null;
		} else {

			// get set object of two nodes
			DisjointSet set1 = node1.getSet();
			DisjointSet set2 = node2.getSet();
			if (set1.getNodes().size() > set2.getNodes().size()) {
				ArrayList<Node> nodeSet2 = set2.getNodes();
				for (Node node : nodeSet2) { // update each node of second set to merge to set1
					node.setSet(set1);
					set1.getNodes().add(node);
				}
				return set1;
			} else {
				ArrayList<Node> nodeSet1 = set1.getNodes();
				for (Node node : nodeSet1) { // update each node of second set to merge to set1
					node.setSet(set2);
					set2.getNodes().add(node);
				}
				return set2;
			}
		}
	}

	private static DisjointSet findSet(Node firstNode) {
		// TODO Auto-generated method stub
		return firstNode.getSet();
	}

	private void printAllNodesOfThisSet() {
		// TODO Auto-generated method stub
		System.out.println("Printing all nodes of the set: ");
		for (Node node : nodes) {
			System.out.print(node.getName() + "  ");
		}
		System.out.println();

	}

	private static void makeset(ArrayList<Node> nodeList) {
		// TODO Auto-generated method stub
		for (Node node : nodeList) {
			DisjointSet set = new DisjointSet();
			set.getNodes().add(node);
			node.setSet(set);
		}
	}

	private ArrayList<Node> getNodes() {
		// TODO Auto-generated method stub
		return nodes;
	}
}
