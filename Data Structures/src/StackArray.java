
public class StackArray {
	static int[] stack = new int[5];
	static int top = -1;

	public static void push(int data) {
		top = top + 1;
		stack[top] = data;

	}

	public static void pop() {
		int data = stack[top];
		stack[top] = 0;
		top = top - 1;
		System.out.println("poppes " + data);
	}

	public static void peek() {
		System.out.println(stack[top]);
	}

	public static void show() {
		for (int i = 0; i < stack.length; i++) {
			System.out.println(stack[i]);
		}
	}

	public static boolean isfull() {
		if (top == stack.length - 1) {
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

	public static void main(String args[]) {
		push(50);
		push(30);
		push(20);
		push(10);
		push(10);
		show();
		pop();
		pop();
		pop();
		pop();
		pop();
		show();
		// peek();
		System.out.println(isfull());
		System.out.println(isempty());
	}
}
