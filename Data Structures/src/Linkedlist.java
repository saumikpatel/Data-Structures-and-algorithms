
public class Linkedlist {
	static Node head;
	static Node tail;

	public static void insert(int data, String position) {
		Node node = new Node();
		node.data = data;

		if (head == null) {

			head = node;
			tail = node;
			node.next = null;

		} else if (position.equals("0")) {
			System.out.println("in begin");
			node.data = data;
			node.next = head;
			head = node;

		} else if (position.equals("last")) {
			System.out.println("in last");
			node.data = data;
			node.next = null;
			tail.next = node;
			tail = node;

		} else {
			Node n = head;
			int i = Integer.parseInt(position);
			for (int j = 0; j < i - 1; j++) {
				n = n.next;

			}

			node.next = n.next;
			n.next = node;
		}

	}
	
	public static void delete(String position) {
		if(position.equals("0")) {
			if(head.next==null) {
				head=null;
				tail=null;
			}
			else{
				head=head.next;
			}
		}
		else {
			int i = Integer.parseInt(position);
			Node n =head;
			Node n1=null;
			for(int  j=0;j<i-1;j++) {
				n=n.next;
			
			}
			
			if(n==tail) {
				tail=n;
			}
			else {
				n.next=n.next.next;
			}
			
		
		}
	}

	public static void show() {
		Node node = head;
		if(head==null) {
			System.out.println("no list");
		}else {
		while (node.next != null) {
			
			
			System.out.println(node.data);
			node = node.next;
		}
		System.out.println(node.data);
	}}

	public static void main(String args[]) {
		insert(10, "first");
		insert(20, "0");
		insert(30, "last");
		//insert(50, "2");
		insert(60, "3");
		delete("3");
	    insert(480, "last");
	    delete("3 ");
		show();
	}
}