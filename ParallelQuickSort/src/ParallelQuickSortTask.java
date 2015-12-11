import java.util.concurrent.RecursiveAction;

public class ParallelQuickSortTask extends RecursiveAction {
	
	private int[] list;
	
	ParallelQuickSortTask(int[] list) {
		this.list = list;
	}
	
	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		quickSort(list, 0, list.length - 1);
	}
	
	private static void quickSort(int[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			int[] firstHalf = new int[pivotIndex];
			System.arraycopy(list, 0, firstHalf, 0, firstHalf.length);
			int[] lastHalf = new int[list.length - pivotIndex - 1];
			System.arraycopy(list, pivotIndex + 1, lastHalf, 0, lastHalf.length);
			invokeAll(new ParallelQuickSortTask(firstHalf), new ParallelQuickSortTask(lastHalf));
			System.arraycopy(firstHalf, 0, list, 0, firstHalf.length);
			System.arraycopy(lastHalf, 0, list, pivotIndex + 1, lastHalf.length);
		}
	}

	/** Partition the array list[first..last] */
	private static int partition(int[] list, int first, int last) {
		int pivot = list[first]; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; // Index for backward search

		while (high > low) {
			// Search forward from left
			while (low <= high && list[low] <= pivot)
				low++;

			// Search backward from right
			while (low <= high && list[high] > pivot)
				high--;

			// Swap two elements in the list
			if (high > low) {
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}

		while (high > first && list[high] >= pivot)
			high--;

		// Swap pivot with list[high]
		if (pivot > list[high]) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		else {
			return first;
		}
	}

}
