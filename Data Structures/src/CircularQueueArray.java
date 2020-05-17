
public class CircularQueueArray {
	static int[] queue = new int[5];
	static int top = -1;
	static int start = -1;

	public static void enqueue(int data) {
		if (isfull()) {
			System.out.println("queue is full");
		} else {
			if((top==-1)&&(start==-1)) {
				top = top + 1;
				queue[top] = data;	
				start=start+1;
			}
				else if (top == queue.length - 1) {
				top = 0;
				queue[top] = data;
			} else {
				top = top + 1;
				queue[top] = data;
			}
		}
	}

	public static void dequeue() {
		if (isempty()) {
			System.out.println("queue is empty");
		} else if (start == top) {
			start = -1;
			top = -1;
		} else if (start == queue.length - 1) {
			start = 0;
		} else {
			start = start + 1;
		}
	}

	public static boolean isfull() {
		if (top + 1 == start) {
			return true;
		} else if ((start == 0) && (top == queue.length - 1)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isempty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}
	public static void show() {
		for(int i=0;i<queue.length;i++) {
			System.out.print(queue[i]);
		}
	}
	
	public static void main(String args[]) {
		System.out.println(isempty());
		enqueue(10);
		enqueue(20);
		enqueue(30);
		enqueue(40);
		enqueue(50);
		show();
		System.out.println(isfull());
		dequeue();
		show();
		System.out.println(isfull());
		enqueue(60);
		show();
		System.out.println(top);
		System.out.println(start);
//		dequeue();
//		show();
//		dequeue();
//		show();
//		dequeue();
//		show();
//		dequeue();
//		show();
		dequeue();
		System.out.println(start);
		dequeue();
		System.out.println(start);
		dequeue();
		System.out.println(start);
		dequeue();
		System.out.println(start);
		System.out.println(isfull());
		dequeue();
		
		System.out.println(start);
		System.out.println(isempty());
		
		
	}
}
