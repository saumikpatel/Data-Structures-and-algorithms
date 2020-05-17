import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.NodeList;

public class FloydWarshall {

	static class Node implements Comparable<Node> {
		private ArrayList<Node> neighbors = new ArrayList<Node>();
		private HashMap<Node, Integer> weightMap = new HashMap<>();
		private boolean isVisited = false;
		private char name;
		private int distance;
		private Node parent;

		public Node(char c) {
			this.setName(c);
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

		public char getName() {
			return name;
		}

		public void setName(char c) {
			this.name = c;
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

//		public int compareTo(Node o) {
//			return this.distance - o.distance;
//		}

	}

	static ArrayList<Node> nodeList = new ArrayList<Node>();

	public FloydWarshall() {
		// TODO Auto-generated constructor stub {
		char c = 'a';
		for (int i = 0; i < 4; i++) {
			Node node = new Node(c);
			c += 1;
			nodeList.add(node);
			node.setDistance(Integer.MAX_VALUE / 10);
		}

	}

	private void addWeightedEdge(int i, int j, int k) {
		// TODO Auto-generated method stub
		Node first = nodeList.get(i - 1);
		Node second = nodeList.get(j - 1);

		first.getNeighbors().add(second);
		first.getWeightMap().put(second, k);

	}

	private void floyd() {
		// TODO Auto-generated method stub
		// creating matrix
		int size = nodeList.size();
		int[][] v = new int[size][size];

		for (int i = 0; i < nodeList.size(); i++) {
			Node first = nodeList.get(i);
			for (int j = 0; j < nodeList.size(); j++) {
				Node second = nodeList.get(j);
				if (i == j) {
					v[i][j] = 0;
				} else if (first.getWeightMap().containsKey(second)) {
					v[i][j] = first.getWeightMap().get(second);
				} else { // no direct edge between i & j, so mark it as infinity [divided by 10 to avoid
							// arithmetic overflow]
					v[i][j] = Integer.MAX_VALUE / 10;
				}
			}
		}
		for (int k = 0; k < nodeList.size(); k++) {
			for (int i = 0; i < nodeList.size(); i++) {
				for (int j = 0; j < nodeList.size(); j++) {
					if (v[i][j] > v[i][k] + v[k][j]) { // if update possible, then update path
						v[i][j] = v[i][k] + v[k][j]; // this will keep a track on path
					}
				}
			}
		}
		for (int i = 0; i < size; i++) {
			System.out.print("Printing distance list for node "+nodeList.get(i).name+": ");
			for (int j = 0; j < size; j++) {
				System.out.print(v[i][j]+" ");
			}
			System.out.println();
		}


	}

	public static void main(String args[]) {
		FloydWarshall graph = new FloydWarshall();
		graph.addWeightedEdge(1, 4, 1);// Add A-> D , weight 1
		graph.addWeightedEdge(1, 2, 8);// Add A-> B , weight 8
		graph.addWeightedEdge(2, 3, 1);// Add B-> C , weight 1
		graph.addWeightedEdge(3, 1, 4);// Add C-> A , weight 4
		graph.addWeightedEdge(4, 2, 2);// Add D-> B , weight 2
		graph.addWeightedEdge(4, 3, 9);// Add D-> C , weight 9

		graph.floyd();
	}

}
