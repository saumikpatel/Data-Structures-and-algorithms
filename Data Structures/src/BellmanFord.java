import java.util.ArrayList;
import java.util.HashMap;




public class BellmanFord {
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

	public BellmanFord() {
		char c = 'a';
		for (int i = 0; i < 5; i++) {
			Node node = new Node(c);
			c += 1;
			nodeList.add(node);
			node.setDistance(Integer.MAX_VALUE/10);
		}

	}

	private void addWeightedEdge(int i, int j, int k) {
		// TODO Auto-generated method stub
		Node first = nodeList.get(i - 1);
		Node second = nodeList.get(j - 1);

		first.getNeighbors().add(second);
		first.getWeightMap().put(second, k);

	}

	private void Bellmanford(Node sourcenode) {
		// TODO Auto-generated method stub
	//	PriorityQueue<Node> queue = new PriorityQueue<>();
		sourcenode.setDistance(0); // This will make sure that we start from this vertex in priority queue as
		//System.out.println(node.getDistance());						// distance is min
		//queue.addAll(nodeList);
		
		for(int i=1;i<nodeList.size();i++) {
			for(Node currentnode : nodeList) {
			//Node currentnode = queue.remove();
			System.out.println(currentnode.name);	
			for (Node neighbor : currentnode.getNeighbors()) {
				//if (queue.contains(neighbor)) {
					if (neighbor.getDistance() > currentnode.getDistance() + currentnode.getWeightMap().get(neighbor)) {
						neighbor.setDistance(currentnode.getDistance() + currentnode.getWeightMap().get(neighbor));
						neighbor.setParent(currentnode);
					//queue.remove(neighbor);
					//	queue.add(neighbor);
					//}
					}
				}
			}
		
	}
		
		for(Node presentNode: nodeList) {
			for(Node neighbor: presentNode.getNeighbors()) {
				// if distance of neighbor is greater than tentative new path then we have a negative cycle, return from here.. 
				if(neighbor.getDistance() > (presentNode.getDistance()+presentNode.getWeightMap().get(neighbor))) {
					System.out.println("Negative cycle found: \n");
					System.out.println("Vertex Name: " + neighbor.getName());
					System.out.println("Old Distance: " + neighbor.getDistance());
					int newDistance = presentNode.getDistance()+presentNode.getWeightMap().get(neighbor);
					System.out.println("New distance: " + newDistance);
					return;
				}
			}
		}//end of loop
		System.out.println("Negative cycle not found !");
		System.out.println("\n\nPrinting Paths now: ");
		for (Node nodeToCheck : nodeList) {
			if (nodeToCheck.getDistance() != Integer.MAX_VALUE / 10) {
				System.out.print("Node " + nodeToCheck + ", distance: " + nodeToCheck.getDistance() + ", Path: ");
				pathPrint(nodeToCheck);
			} else {
				System.out.print("No path for node " + nodeToCheck);
			}
			System.out.println();
		}//end of loop
	}
	


private static void pathPrint(Node node) {
	if(node.getParent()!=null) {
		pathPrint(node.getParent());
		System.out.print("->"+node.name);
	}
	else 
		System.out.print(node.name);
}//end of method
	public static void main(String args[]) {
		BellmanFord graph = new BellmanFord();
		graph.addWeightedEdge(1, 3, 6); // Add A-> C , weight 6
		graph.addWeightedEdge(1, 4, 3); // Add A-> D , weight 3
		graph.addWeightedEdge(2, 1, 3); // Add B-> A , weight 3
		graph.addWeightedEdge(3, 4, -2); // Add C-> D , weight 2
		graph.addWeightedEdge(4, 3, 1); // Add D-> C , weight 1
		graph.addWeightedEdge(4, 2, 1); // Add D-> B , weight 1
		graph.addWeightedEdge(5, 2, 4); // Add E-> B , weight 4
		graph.addWeightedEdge(5, 4, 2); // Add E-> D , weight 2
		System.out.println(nodeList.get(4).name);
		graph.Bellmanford(nodeList.get(4));
	}
}
