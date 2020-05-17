
public class StackLinkedlist {
	static Node head;

	public static void push(int data) {
		Node node = new Node();
		node.data = data;
		node.next = head;
		head = node;

	}

	public static void pop() {
		Node node = new Node();
		node = head;
		head = node.next;
		System.out.println("removed" + node.data);
	}

	public static void peek() {
		Node n = head;
		System.out.println(n.data);
	}

	public static void isempty() {
		if (head == null) {
			System.out.println("empty");

		} else {
			System.out.println("no");
		}

	}

	public static void deletestack() {
		head = null;
	}

	public static void main(String args[]) {
		isempty();
		push(10);
		push(20);
		push(30);
		peek();
		pop();
		peek();
		deletestack();
		isempty();

	}
}