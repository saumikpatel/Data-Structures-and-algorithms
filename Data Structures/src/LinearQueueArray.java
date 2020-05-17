
public class LinearQueueArray {
	
	static int[] queue = new int[5];
	static int top = -1;
	static int begining = -1;

	public static void enqueue(int data) {
		top = top + 1;
		queue[top] = data;

	}

	public static void dequeue() {
		begining = begining + 1;
		System.out.println("removed" + queue[begining]);
		if (begining == top) {
			begining = -1;
			top = -1;
		}
	}
	public static void isfull() {
		if(top==queue.length-1) {
			System.out.println("full");
		}
		else {
			System.out.println(" not full");	
		}
	}
	public static void isempty() {
		if(top==-1) {
			System.out.println("empty");
		}
		else {
			System.out.println(" not empty");	
		}
	}
	public static void show() {
		for(int i=begining+1;i<queue.length;i++) {
			System.out.print(queue[i]);
		}
	}
	
	public static void main(String args[]) {
		isempty();
		enqueue(10);
		enqueue(20);
		enqueue(30);
		enqueue(40);
		enqueue(50);
		show();
		isfull();
		dequeue();
		show();
		dequeue();
		dequeue();
		dequeue();
		dequeue();
		isempty();
	}
}

