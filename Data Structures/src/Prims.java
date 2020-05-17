import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Prims {

	    static class Node implements Comparable<Node> {
		private ArrayList<Node> neighbors = new ArrayList<Node>();
		private HashMap<Node, Integer> weightMap = new HashMap<>();
		private boolean isVisited = false;
		private String name;
		private int distance;
		private Node parent;

		public Node(String string) {
			this.setName(string);
		}

		public boolean isVisited() {
			return isVisited;
		}

		public void setVisited(boolean isVisited) {
			this.isVisited = isVisited;
		}

		public ArrayList<Node> getNeighbors() {
			return neighbors;
		}

		public void setNeighbors(ArrayList<Node> neighbors) {
			this.neighbors = neighbors;
		}

		public String getName() {
			return name;
		}

		public void setName(String string) {
			this.name = string;
		}

		public HashMap<Node, Integer> getWeightMap() {
			return weightMap;
		}

		public void setWeightMap(HashMap<Node, Integer> weightMap) {
			this.weightMap = weightMap;
		}

		public void setDistance(int i) {
			// TODO Auto-generated method stub
			this.distance = i;
		}

		public int getDistance() {
			// TODO Auto-generated method stub
			return distance;
		}

		public void setParent(Node currentnode) {
			// TODO Auto-generated method stub
			this.parent = currentnode;
		}

		public Node getParent() {
			// TODO Auto-generated method stub
			return parent;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.distance - o.distance;
		}

	}

	public Prims(ArrayList<Node> nodeList) {
		// TODO Auto-generated constructor stub
	}

	static ArrayList<Node> nodeList = new ArrayList<>();

	public static void main(String[] args) {

		// Create 5 nodes: A,B,C,D,E
		for (int i = 0; i < 5; i++) {
			nodeList.add(new Node("" + (char) (65 + i)));
		}

		Prims graph = new Prims(nodeList);
		graph.addWeightedUndirectedEdge(1, 2, 10); // Add undirected Edge between A-B with Weight 10
		graph.addWeightedUndirectedEdge(1, 3, 20); // Add undirected Edge between A-C with Weight 20
		graph.addWeightedUndirectedEdge(2, 3, 30); // Add undirected Edge between B-C with Weight 30
		graph.addWeightedUndirectedEdge(2, 4, 5); // Add undirected Edge between B-D with Weight 5
		graph.addWeightedUndirectedEdge(3, 4, 15); // Add undirected Edge between C-D with Weight 15
		graph.addWeightedUndirectedEdge(3, 5, 6); // Add undirected Edge between C-E with Weight 6
		graph.addWeightedUndirectedEdge(4, 5, 8); // Add undirected Edge between D-E with Weight 8

		System.out.println("Printing Prim's Algo from source: E");
		graph.prims(nodeList.get(4));

	}

	private void prims(Node node) {
		// TODO Auto-generated method stub
		for (int counter = 0; counter < nodeList.size(); counter++) {
			nodeList.get(counter).setDistance(Integer.MAX_VALUE);
		}
		node.setDistance(0);

		PriorityQueue<Node> queue = new PriorityQueue<>();

		queue.addAll(nodeList);
		while (!queue.isEmpty()) {
			Node presentNode = queue.remove();
			System.out.println(presentNode.getName());
			for (Node neighbor : presentNode.getNeighbors()) {
				if (queue.contains(neighbor)) {// If vertex is not processed, only then enter in if-else
					// If known weight of this ‘adjacent vertex’ is more than current edge,
					// then update ‘adjacent vertex’s’ distance and parent
					if (neighbor.getDistance() > presentNode.getWeightMap().get(neighbor)) {
						neighbor.setDistance(presentNode.getWeightMap().get(neighbor));
						neighbor.setParent(presentNode);
						queue.remove(neighbor); // Refresh the priority queue
						queue.add(neighbor);
					}
				}
			}
		}

		int cost = 0;
		// print table of node with minimum distance and shortest path from source
		for (Node nodeToCheck : nodeList) {
			System.out.println("Node " + nodeToCheck.getName() + ", key: " + nodeToCheck.getDistance() + ", Parent: "
					+ nodeToCheck.getParent());
			cost = cost + nodeToCheck.getDistance();
		} // end of for loop

		System.out.println("\nTotal cost of MST: " + cost);

	}

	private void addWeightedUndirectedEdge(int i, int j, int k) {
		// TODO Auto-generated method stub
		Node first = nodeList.get(i - 1);
		Node second = nodeList.get(j - 1);
		first.getNeighbors().add(second);
		second.getNeighbors().add(first);
		first.getWeightMap().put(second, k);
		second.getWeightMap().put(first, k);
	}
}
