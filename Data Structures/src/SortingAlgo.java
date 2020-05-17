
public class SortingAlgo {

	static int[] array = { 30, 10, 50, 20, 60, 40 };
	static int n = array.length;

	public static void bubblesort() {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;

				}
			}
		}
	}

	public static void selectionsort() {
		for (int i = 0; i < n; i++) {
			int Sorted = i;
			for (int j = i + 1; j < n; j++) {
				if (array[j] < array[Sorted]) {
					Sorted = j;
				}

			}
			int temp = array[Sorted];
			array[Sorted] = array[i];
			array[i] = temp;
		}
	}

	public static void insertionsort() {
		for (int i = 0; i < n; i++) {
			int first = array[i];

			for (int j = i; j >= 0; j--) {
				if (first < array[j]) {
					int temp = array[j];
					array[j] = first;
					array[j + 1] = temp;
				}
			}
		}
	}

	private static void displaymergesort() {
		// TODO Auto-generated method stub
		int[] result = mergesort(array);
		System.out.println(" ");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	public static int[] mergesort(int[] b) {

		if (b.length <= 1) {
			return b;

		}

		int middle = b.length / 2;
		int[] leftarray = new int[middle];
		int[] rightarray = new int[b.length - middle];

		for (int i = 0; i < middle; i++) {
			leftarray[i] = b[i];
		}
		int x = 0;
		for (int j = middle; j < b.length; j++) {
			rightarray[x] = b[j];
			x++;
		}
		leftarray = mergesort(leftarray);
		rightarray = mergesort(rightarray);
		int[] result = new int[b.length];
		result = merge(leftarray, rightarray);
		return result;
	}

	static int[] merge(int[] left, int[] right) {
		int lengthResult = left.length + right.length;
		int indexL = 0;
		int indexR = 0;
		int resultIndex = 0;
		int[] result = new int[lengthResult];

		while (indexL < left.length || indexR < right.length) {
			if (indexL < left.length && indexR < right.length) {
				if (left[indexL] <= right[indexR]) {
					result[resultIndex] = left[indexL];
					indexL++;
					resultIndex++;
				} else {
					result[resultIndex] = right[indexR];
					indexR++;
					resultIndex++;
				}
			} else if (indexL < left.length) {
				result[resultIndex] = left[indexL];
				indexL++;
				resultIndex++;
			} else if (indexR < right.length) {
				result[resultIndex] = right[indexR];
				indexR++;
				resultIndex++;
			}
		}
		return result;
	}

	public static void displayquicksort() {
		quicksort(array, 0, array.length - 1);
		System.out.println(" ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
	}

	public static void quicksort(int[] array, int start, int end)

	{
		if (start < end) {
			int pivot = partition(array, start, end);
			quicksort(array, start, pivot - 1);
			quicksort(array, pivot + 1, end);
		}

	}

	private static int partition(int[] array, int start, int end) {
		// TODO Auto-generated method stub
		int i = start - 1;
//		System.out.println(start);
//		System.out.println(end);
		for (int j = start; j <= end; j++) {
			if (array[j] <= array[end]) {
				i++;
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
		}
		return i;
	}

	public static void display() {

		System.out.println(" ");
		for (int i = 0; i < array.length; i++) {

			System.out.print(array[i] + " ");
		}
	}

	public static void main(String srags[]) {

		bubblesort();
		display();
		selectionsort();
		display();
		insertionsort();
		display();
		// System.out.println((n-1)/2);
		// mergesort(array);
		displaymergesort();
		displayquicksort();
	}

}
