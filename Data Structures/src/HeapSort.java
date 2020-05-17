
public class HeapSort {
	static int[] array = { 30, 10, 50, 20,40, 60, 40 };
	static int[] heap = new int[8];
	static int size=0;
	
	
	public static void heapsort() {
		for(int i=0;i<array.length;i++) {
			insert(array[i]);
		}
		int x=0;
		for(int i=1;i<heap.length;i++) {
			array[x]=delete();
			x++;
		}
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]+ " ");
		}
	}
	
	
	public static void insert(int data) {
		heap[size + 1] = data;
		size = size + 1;
		HeapifyBottomToTop(size);
		
	}
	
	public static int delete() {
		int extracted =heap[1];
	
		heap[1]=heap[size];
		//System.out.print(heap[1]);
		size=size-1;
	//	System.out.print(size);
	
		heapifytopbottom(1);
		
		return extracted;
		
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
	public static void main(String args[])
{
		heapsort();
}
	
}
	
