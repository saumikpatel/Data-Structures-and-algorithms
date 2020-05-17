
public class BinaryHeap {
	static int[] heap = new int[50];
	static int size = 0;

	public static void insert(int data) {
		heap[size + 1] = data;
		size = size + 1;
		HeapifyBottomToTop(size);
		levelorder();

	}
	
	public static void delete() {
		int extracted =heap[1];
	
		heap[1]=heap[size];
		System.out.print(heap[1]);
		size=size-1;
		System.out.print(size);
		heapifytopbottom(1);
		levelorder();
		
		
	}

	private static void heapifytopbottom(int index) {
		// TODO Auto-generated method stub
		int left= index*2;
		int right=(index*2)+1;
		int smallest=0;
		if(size<left) {
			return;
		}
		else if(size==left) {
			if(heap[index]>heap[left]) {
			int temp =heap[left];
			heap[left]=heap[index];
			heap[index]=temp;
			}
			return;
		}
		else {
			if(heap[left]>heap[right]) {
				smallest=right;
			}
			else {
				smallest=left;
			}
			if(heap[index]>heap[smallest]) {
				int temp=heap[smallest];
				heap[smallest]=heap[index];
				heap[index]=temp;
			}
		}
		//System.out.println(smallest);
		heapifytopbottom(smallest);

	}

	private static void levelorder() {
		// TODO Auto-generated method stub
		System.out.println("Printing all the elements of this Heap...");// Printing from 1 because 0th cell is dummy
		for (int i = 1; i <= size; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println("\n");

	}

	private static void HeapifyBottomToTop(int size2) {
		// TODO Auto-generated method stub
		int parent = size2 / 2;
		if (parent < 1) {
			return;
		}
		if (heap[size2] < heap[parent]) {
			int temp = heap[parent];
			heap[parent] = heap[size2];
			heap[size2] = temp;

		}
		HeapifyBottomToTop(parent);
	}

	public static void main(String args[]) {
		//System.out.println(9 / 2);
		insert(3);
		insert(5);
		insert(8);
		insert(17);
		insert(19);
		insert(36);
		insert(40);
		insert(25);
		insert(100);
	//	insert(1);
	//	insert(0);
		delete();
	}
}
