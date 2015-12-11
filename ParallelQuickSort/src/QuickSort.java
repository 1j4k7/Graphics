import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class QuickSort {

	public static void quickSort(int[] list) {
		quickSort(list, 0, list.length - 1);
	}
	
	public static void parallelQuickSort(int[] list) {
		RecursiveAction task = new ParallelQuickSortTask(list);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);
	}

	private static void quickSort(int[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
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

	/** A test method */
	public static void main(String[] args) {
		int[] list = new int[10000];
		for (int i = 0; i < list.length; i++) {
			list[i] = (int)(Math.random() * 100);
		}
		long startTime = System.nanoTime();
		//int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		int[] sequentialList = new int[list.length];
		System.arraycopy(list, 0, sequentialList, 0, list.length);
		quickSort(sequentialList);
		for (int i = 0; i < sequentialList.length; i++)
			System.out.print(sequentialList[i] + " ");
		System.out.println();
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Sequential Time: " + totalTime + " nanoseconds");
		startTime = System.nanoTime();
		int[] parallelList = new int[list.length];
		System.arraycopy(list, 0, parallelList, 0, list.length);
		parallelQuickSort(parallelList);
		for (int i = 0; i < parallelList.length; i++)
			System.out.print(parallelList[i] + " ");
		System.out.println();
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("Parallel Time: " + totalTime + " nanoseconds");
		System.out.println(Runtime.getRuntime().availableProcessors() + " processors");
	}
}
