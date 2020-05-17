
public class DoubleCircularLinkedList {
	static Node head;
	static Node tail;

	public static void insert(int data, String position) {
		Node node = new Node();
		node.data = data;
		if (head == null) {
			System.out.println("in creation");
			head = node;
			tail = node;
			node.next = node;
			node.prev = node;

		}
		else{
			 if (position.equals("0")) {
				 System.out.println("in 0");
			node.next = head;
			node.prev = tail;
			head.prev = node;
			head = node;
			tail.next = node;

		} else if (position.equals("last")) {
			System.out.println("in last");
			node.prev = tail;
			node.next = head;
			head.prev = node;
			tail.next = node;
			tail = node;

		}
		else {
			int pos =Integer.parseInt(position);
			Node n=head;
			for(int i=0;i<pos-1;i++) {
				n=n.next;
			}
			node.next=n.next;
			node.prev=n;
			n.next=node;
			node.next.prev=node;
		}
		}	
		
	}
	
	public static void delete() {
		
	}
	public static void show() {
		Node n =head;
		while(n!=tail) {
			System.out.println(n.data);
			n=n.next;
		}
		System.out.println(n.data);
	}
	
	public static void  reverseprint() {
		Node n= tail;
		while(n!=head) {
			System.out.println(n.data);
			n=n.prev;
		}
		System.out.println(n.data);
	}
	public static void main(String args[]) {
		insert(10,"0" );
		insert(20,"0" );
		insert(30,"last");
		insert(40,"1" );
		reverseprint();
	}
}
