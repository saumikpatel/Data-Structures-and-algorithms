import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;




public class DFSSearch {
	static class Node {
		private ArrayList<Node> neighbors = new ArrayList<Node>();
		private boolean isVisited = false;
		private String name;

		public Node(String name) {
			this.setName(name);
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

		public void setName(String name) {
			this.name = name;
		}
}
	ArrayList<Node> nodeList = new ArrayList<Node>();
	public DFSSearch(int j) {
		// TODO Auto-generated constructor stub
		

		// create 10 nodes: v1-v10
		for (int i = 1; i < 11; i++) {
			Node node = new Node("V" + i);
			nodeList.add(node);
		}
//		for(int i=0;i<10;i++) {
//			//System.out.println(nodeList.get(i).name);
//		}
	}
	private void DFS() {
		// TODO Auto-generated method stub
		for(Node node: nodeList) {
			if(!node.isVisited())
				dfsVisit(node);
		}
	}



	private void dfsVisit(Node node) {
		// TODO Auto-generated method stub
		Stack<Node>stack = new Stack<>();
		stack.push(node); //add source node to queue
		while(!stack.isEmpty()) {
			Node presentNode  = stack.pop();
			presentNode.setVisited(true);
			System.out.print(presentNode.getName()+" ");
			for(Node neighbor: presentNode.getNeighbors()) { //for each neighbor of present node
				if(!neighbor.isVisited()) { //if neighbor is not visited then add it to queue
					stack.push(neighbor);
					neighbor.setVisited(true);
				}
			}//end of for loop
		}//end of while loop
		
	}
	private void addUndirectedEdge(int i, int j) {
		// TODO Auto-generated method stub
		Node first = nodeList.get(i-1);
		Node second = nodeList.get(j-1);
//		System.out.println(first.name);
//		System.out.println(second.name);
		first.getNeighbors().add(second);//Neighbour of first is second. Store it.
		second.getNeighbors().add(first);
	}

	public static void main(String args[]) {
		DFSSearch graph = new DFSSearch(4);

		graph.addUndirectedEdge(1, 2);
		graph.addUndirectedEdge(1, 4);
		graph.addUndirectedEdge(2, 3);
		graph.addUndirectedEdge(2, 5);
		graph.addUndirectedEdge(3, 6);
		graph.addUndirectedEdge(3, 10);
		graph.addUndirectedEdge(4, 7);
		graph.addUndirectedEdge(5, 8);
		graph.addUndirectedEdge(6, 9);
		graph.addUndirectedEdge(7, 8);
		graph.addUndirectedEdge(8, 9);
		graph.addUndirectedEdge(9, 10);

		System.out.println("ollowing is Breadth First Traversal " + "(starting from vertex 2)");

		graph.DFS();
	}
}