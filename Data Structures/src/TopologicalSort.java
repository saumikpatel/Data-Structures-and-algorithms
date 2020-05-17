import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
	static class Node {
		private ArrayList<Node> neighbors = new ArrayList<Node>();
		private boolean isVisited = false;
		private char name;

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
	}

	ArrayList<Node> nodeList = new ArrayList<Node>();

	public TopologicalSort() {

		char c = 'a';
		for (int i = 0; i < 8; i++) {
			Node node = new Node(c);
			c += 1;
			nodeList.add(node);
		}

//		for(int i=0;i<8;i++) {
//			System.out.println(nodeList.get(i).name);
//		}

	}

	Stack<Node> stack = new Stack<>();

	private void topologicalsort() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 8; i++) {
			Node node = nodeList.get(i);
			if (!node.isVisited()) {
				topologicalvisit(node);
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().getName() + " ");
		}
	}

	private void topologicalvisit(Node node) {

		// TODO Auto-generated method stub

		for (Node neighbor : node.getNeighbors()) { // for each neighbor of present node
			if (!neighbor.isVisited()) { // if neighbor is not visited then add it to queue
				topologicalvisit(neighbor);

			}
		}

		node.setVisited(true);
		stack.push(node);
	}

	private void addUndirectedEdge(char i, char j) {
		// TODO Auto-generated method stub
		Node first = nodeList.get(i - 97);
		Node second = nodeList.get(j - 97);
		System.out.println(first.name);
		System.out.println(second.name);
		first.getNeighbors().add(second);// Neighbour of first is second. Store it.
		//second.getNeighbors().add(first);
	}

	public static void main(String args[]) {
		TopologicalSort sort = new TopologicalSort();

		sort.addUndirectedEdge('a', 'c');
		sort.addUndirectedEdge('b', 'd');
		sort.addUndirectedEdge('b', 'c');
		sort.addUndirectedEdge('c', 'e');
		sort.addUndirectedEdge('e', 'h');
		sort.addUndirectedEdge('e', 'f');
		sort.addUndirectedEdge('f', 'g');
		sort.addUndirectedEdge('d', 'f');
//			sort.addUndirectedEdge(6, 9);
//			sort.addUndirectedEdge(7, 8);
//			graph.addUndirectedEdge(8, 9);
//			graph.addUndirectedEdge(9, 10);

		System.out.println("Following is topological Traversal " + "(starting from vertex 2)");

		sort.topologicalsort();
	}

}
