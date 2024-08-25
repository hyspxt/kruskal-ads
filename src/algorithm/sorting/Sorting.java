package src.algorithm.sorting;

/**
 * This class contains various sorting algorithms
 */
public class Sorting {

	private static <T extends Comparable<T>> void swap(T A[], int i, int j) {
		T tmp = A[i];
		A[i]  = A[j];
		A[j]  = tmp;
	}
	

	/**
	 * Sorts the specified array according to the ordering induced by the compareTo() method in &Theta;(n<sup>2</sup>)
	 * <p>
	 * Implements the selectionsort algorithm.
	 * <ul>
	 * <li> Worst/Average/Best-case cost: &Theta;(n<sup>2</sup>)
	 * </ul>
	 * @param A the array to be sorted
	 * @param <T> class of the object in the array
	 */
	public static <T extends Comparable<T>> void selectionsort(T A[]) {

	}



	/**
	 * Sorts the specified array into ascending numerical order in &Theta;(n<sup>2</sup>)
	 * <p>
	 * Implements the selectionsort algorithm.
	 * <ul>
	 * <li> Worst/Average/Best-case cost: &Theta;(n<sup>2</sup>)
	 * </ul>
	 * @param A the array to be sorted
	 */
	public static void selectionsort(int A[]) {

	}

	/**
	 * Sorts the specified array according to the ordering induced by the compareTo() method in O(n<sup>2</sup>)
	 * <p>
	 * Implements the insertionsort algorithm.
	 * <ul>
	 * <li> Worst/Average-case cost: &Theta;(n<sup>2</sup>)
	 * <li> Best-case cost: &Theta;(n)
	 * </ul>
	 * @param A the array to be sorted
	 * @param <T> class of the object in the array
	 */
	public static <T extends Comparable<T>> void insertionsort(T A[]) {

	}

	/**
	 * Sorts the specified array into ascending numerical order in O(n<sup>2</sup>)
	 * <p>
	 * Implements the insertionsort algorithm.
	 * <ul>
	 * <li> Worst/Average-case cost: &Theta;(n<sup>2</sup>)
	 * <li> Best-case cost: &Theta;(n)
	 * </ul>
	 * @param A the array to be sorted
	 */
	public static void insertionsort(int A[]) {

	}

	/**
	 * Sorts the specified array according to the ordering induced by the compareTo() method in &Theta;(nlogn)
	 * <P>
	 * Implements the mergesort algorithm.
	 * <ul>
	 * <li> Worst/Average/Best-case cost: &Theta;(nlogn)
	 * </ul>
	 * @param A the array to be sorted
	 * @param <T> class of the object in the array
	 */
	public static <T extends Comparable<T>> void mergesort(T A[]) {
		
	}

 	/**
	 * Sorts the specified array into ascending numerical order in &Theta;(nlogn)
	 * <p>
	 * Implements the mergesort algorithm.
	 * <ul>
	 * <li> Worst/Average/Best-case cost: &Theta;(nlogn)
	 * </ul>
	 * @param A the array to be sorted
	 */
	public static void mergesort(int A[]) {

	}


	/**
	 * Sorts the specified array according to the ordering induced by the compareTo() method in O(n<sup>2</sup>) and O(nlogn) on the average
	 * <p>
	 * Implements the quicksort algorithm.
	 * <ul>
	 * <li> Worst-case cost:  &Theta;(n<sup>2</sup>)
	 * <li> Average/Best-case cost: &Theta;(nlogn)
	 * </ul>
	 * @param A the array to be sorted
	 * @param <T> class of the object in the array
	 */
	public static <T extends Comparable<T>> void quicksort(T A[]) {
		quick_sort(A, 0, A.length - 1);
	}

	public static <T extends Comparable<T>> void quick_sort(T A[], int l, int r) {
        if (l < r) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(A, l, r);

            // Recursively sort elements before and after the partition
            quick_sort(A, l, pivotIndex - 1);
            quick_sort(A, pivotIndex + 1, r);
        }
	}	

	private static <T extends Comparable<T>> int partition(T A[], int low, int high) {
        // Use the last element as the pivot
        T pivot = A[high];

        // Index of the smaller element
        int i = low - 1;

        // Traverse the array and partition it based on the pivot
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (A[j].compareTo(pivot) <= 0) {
                i++;

                // Swap A[i] and A[j]
                swap(A, i, j);
            }
        }

        // Swap the pivot element with the element at i + 1
        swap(A, i + 1, high);

        // Return the partition point
        return i + 1;
    }

	/**
	 * Sorts the specified array into ascending numerical order in O(n<sup>2</sup>) and O(nlogn) on the average
	 * <p>
	 * Implements the quicksort algorithm.
	 * <ul>
	 * <li> Worst-case cost:  &Theta;(n<sup>2</sup>)
	 * <li> Average/Best-case cost: &Theta;(nlogn)
	 * </ul>
	 * @param A the array to be sorted
	 */
	public static void quicksort(int A[]) {

	}

	/**
	 * Sorts the specified array into ascending numerical order in &Theta;(n+k)
	 * <p>
	 * Implements the countingsort algrithm.
	 * <ul>
	 * <li> Worst/Average/Best-case cost: &Theta;(n+k), where k = max(<code>A</code>)-min(<code>A</code>)+1
	 * </ul>
	 * @param A the array to be sorted
	 */
	public static void countingsort(int A[]) {
		if (A.length == 0) 
			return;
		int min = A[0], max = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] < min) min = A[i];
			if (A[i] > max) max = A[i];
		}
		int range = max - min + 1;
		int[] count = new int[range];
		for (int i = 0; i < A.length; i++)
			count[A[i] - min]++;

		int index = 0;
		for (int i = 1; i < range; i++){
			A[index++] = i + min;
			count[i]--;
		}
	}

	/**
	 * Sorts the specified array according to the ordering induced by the compareTo() method in &Theta;(nlogn)
	 * <p>
	 * Implements the heapsort algorithm.
	 * <ul>
	 * <li> Worst/Average-cost: &Theta;(nlogn)
	 * <li> Best-case cost: &Theta;(n)	
	 * </ul>
	 * @param A the array to be sorted
	 * @param <T> class of the object in the array
	 */
		
	public static <T extends Comparable<T>> void heapsort(T A[]) {
		heapify(A, A.length - 1, 0);
		for (int c = (A.length - 1); c > 0; c--) {
			T k = findmax(A);
			deletemax(A, c);
			A[c] = k;
		}
	}
	
	private static <T extends Comparable<T>> void heapify(T A[], int n, int i) {
		if (i >= n) return;
		heapify(A, n, left(i));
		heapify(A, n, right(i));
		fixheap(A, n, i);
	}
	
	private static int left(int i) {
		return ( 2*i + 1 );
	}

	private static int right(int i) {
		return ( 2*i + 2 );
	}
			
	private static <T extends Comparable<T>> void fixheap(T A[], int c, int i) {
		int l = left(i), r = right(i);
		if (l > c) return;
		int max = l;
		if (r <= c && A[l].compareTo(A[r]) < 0)
			max = r;
		if (A[i].compareTo(A[max]) < 0) {
			swap(A, i, max);
			fixheap(A, c, max);
		}
	}
	
	private static <T extends Comparable<T>> T findmax(T A[]) {
		return A[0];
	}
	
	private static <T extends Comparable<T>> void deletemax(T A[], int c) {
		if (c <= 0) return;
		A[0] = A[c];
		c--;
		fixheap(A, c, 0);
	}		
					
}