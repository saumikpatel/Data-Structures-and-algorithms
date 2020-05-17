
public class linearqueueLinkedlist {
static Node head;
 static Node tail;


public static void enqueue( int data) {
	Node node= new Node();
	if(head==null) {
		node.data=data;
		head=node;
		tail= node;
		node.next=null;}
	else {
		node.data=data;
		tail.next=node;
		tail=node;
		node.next=null;
		
	}
}
	public static void dequeue() {
		if(head==null) {
			System.out.println("queue is empty");
		}
		else {
			head=head.next;
			
		}
}
	
	public static void show() {
		Node n=head;
		while(n.next!=null) {
			
			System.out.println(n.data);
			n=n.next;
		}
		System.out.println(n.data);
	}
	
	public static void main(String args[]) {
		enqueue(10);
		enqueue(20);
		enqueue(30);
		show();
		dequeue();
		show();
	}
}
