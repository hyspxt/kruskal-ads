package src.algorithm.sorting;

import java.util.ArrayList;
import java.util.Collections;

import src.datastructure.graph.WeightedEdge;

/**
 * This class contains various sorting algorithms
 */
public class Sorting {

	/* tried: insertion around 0.002 - 0.008 in pretty bad cases
	 * 		  counting around 0.002 - 0.005 
	 * 		  quick around 0.002 - 0.009
	 * 		  heap around < 0.002 (!) <- stabler on larger graph
	 * 
	 * * Mind that the above sorting algorithm are implemented, but not used in any way
	 * other than heap sort. The reason is that the heap sort has proven to be efficient
	 * (and quite stable) on the larger graphs.
	 */
	private static <D> void swap(ArrayList<WeightedEdge<D>> A, int i, int j) {
		WeightedEdge<D> tmp = A.get(i);
		A.set(i, A.get(j));
		A.set(j, tmp);
	}

	/**
	 * Sorts the specified array according to the ordering induced by the
	 * compareTo() method in &Theta;(n<sup>2</sup>)
	 * <p>
	 * Implements the selectionsort algorithm.
	 * <ul>
	 * <li>Worst/Average/Best-case cost: &Theta;(n<sup>2</sup>)
	 * </ul>
	 * 
	 * @param A   the array to be sorted
	 * @param <T> class of the object in the array
	 */
	public static <T extends Comparable<T>> void selectionsort(T A[]) {

	}

	/**
	 * Sorts the specified array into ascending numerical order in
	 * &Theta;(n<sup>2</sup>)
	 * <p>
	 * Implements the selectionsort algorithm.
	 * <ul>
	 * <li>Worst/Average/Best-case cost: &Theta;(n<sup>2</sup>)
	 * </ul>
	 * 
	 * @param A the array to be sorted
	 */
	public static void selectionsort(int A[]) {

	}

	/**
	 * Sorts the specified array according to the ordering induced by the
	 * compareTo() method in O(n<sup>2</sup>)
	 * <p>
	 * Implements the insertionsort algorithm.
	 * <ul>
	 * <li>Worst/Average-case cost: &Theta;(n<sup>2</sup>)
	 * <li>Best-case cost: &Theta;(n)
	 * </ul>
	 * 
	 * @param A   the array to be sorted
	 * @param <T> class of the object in the array
	 */
	public static <T extends Comparable<T>> void insertionsort(T A[]) {

	}

	/**
	 * Sorts the specified array into ascending numerical order in O(n<sup>2</sup>)
	 * <p>
	 * Implements the insertionsort algorithm.
	 * <ul>
	 * <li>Worst/Average-case cost: &Theta;(n<sup>2</sup>)
	 * <li>Best-case cost: &Theta;(n)
	 * </ul>
	 * 
	 * @param A the array to be sorted
	 */
	public static <D> void insertionsort(ArrayList<WeightedEdge<D>> A) {
		/* get the number of edges */
		int n = A.size();
        for (int i = 1; i < n; i++) { /* iterate through the edges */
            WeightedEdge<D> key = A.get(i);
            int j = i - 1;
			/* 
			 * Move elements of ArrayList A that are > than the key
			 * to the right of the current possition in the array
			 */
            while (j >= 0 && A.get(j).weight > key.weight) {
                A.set(j + 1, A.get(j)); /* right shift */
                j = j - 1;
            } /* replace the key */
            A.set(j + 1, key); 
        }
	}

	/**
	 * Sorts the specified array according to the ordering induced by the
	 * compareTo() method in &Theta;(nlogn)
	 * <P>
	 * Implements the mergesort algorithm.
	 * <ul>
	 * <li>Worst/Average/Best-case cost: &Theta;(nlogn)
	 * </ul>
	 * 
	 * @param A   the array to be sorted
	 * @param <T> class of the object in the array
	 */
	public static <T extends Comparable<T>> void mergesort(T A[]) {

	}

	/**
	 * Sorts the specified array into ascending numerical order in &Theta;(nlogn)
	 * <p>
	 * Implements the mergesort algorithm.
	 * <ul>
	 * <li>Worst/Average/Best-case cost: &Theta;(nlogn)
	 * </ul>
	 * 
	 * @param A the array to be sorted
	 */
	public static void mergesort(int A[]) {

	}

	/**
	 * Sorts the specified array according to the ordering induced by the
	 * compareTo() method in O(n<sup>2</sup>) and O(nlogn) on the average
	 * <p>
	 * Implements the quicksort algorithm.
	 * <ul>
	 * <li>Worst-case cost: &Theta;(n<sup>2</sup>)
	 * <li>Average/Best-case cost: &Theta;(nlogn)
	 * </ul>
	 * 
	 * @param A   ArrayList of weighted edges to be sorted
	 */
	public static <D> void quicksort(ArrayList<WeightedEdge<D>> A) {
        if (A == null || A.size() == 0)
            return; /* there is nothing to sort */
        quicksort(A, 0, A.size() - 1);
    }

    private static <D> void quicksort(ArrayList<WeightedEdge<D>> A, int l, int r) {
        if (l < r) { /* partion index */
            int pi = partition(A, l, r); 
            /* recursive step on both list halves */
            quicksort(A, l, pi - 1);
            quicksort(A, pi + 1, r);
        }
    }

    private static <D> int partition(ArrayList<WeightedEdge<D>> A, int low, int high) {
        /* last element of the sublist */
		WeightedEdge<D> pivot = A.get(high);
		/* index of the smaller element in the sublist */
        int i = low - 1; 
        for (int j = low; j < high; j++) { /* check pivot weight and current element weight */
            if (A.get(j).weight <= pivot.weight) {
                i++; /* if smaller or eq, swap them */
				swap(A, i, j);
            }
        } /* swap the pivot with the element in position i+1 */
		swap(A, i + 1, high); 
        return i + 1;
    }

	/**
	 * Sorts the specified array into ascending numerical order in O(n<sup>2</sup>)
	 * and O(nlogn) on the average
	 * <p>
	 * Implements the quicksort algorithm.
	 * <ul>
	 * <li>Worst-case cost: &Theta;(n<sup>2</sup>)
	 * <li>Average/Best-case cost: &Theta;(nlogn)
	 * </ul>
	 * 
	 * @param A the array to be sorted
	 */
	public static void quicksort(int A[]) {

	}

	/**
	 * Sorts the specified array into ascending numerical order in &Theta;(n+k)
	 * <p>
	 * Implements the countingsort algrithm.
	 * <ul>
	 * <li>Worst/Average/Best-case cost: &Theta;(n+k), where k =
	 * max(<code>A</code>)-min(<code>A</code>)+1
	 * </ul>
	 * 
	 * @param A ArrayList of weighted edges to be sorted
	 */
	public static <D> void countingsort(ArrayList<WeightedEdge<D>> A) {

	}

	/**
	 * Sorts the specified array according to the ordering induced by the
	 * compareTo() method in &Theta;(nlogn)
	 * <p>
	 * Implements the heapsort algorithm.
	 * <ul>
	 * <li>Worst/Average-cost: &Theta;(nlogn)
	 * <li>Best-case cost: &Theta;(n)
	 * </ul>
	 * 
	 * @param A   ArrayList of weighted edges to be sorted
	 */

	public static <D> void heapsort(ArrayList<WeightedEdge<D>> A) {
		heapify(A, A.size() - 1, 0);
		for (int c = (A.size() - 1); c > 0; c--) {
			WeightedEdge<D> k = findmax(A);
			deletemax(A, c);
			A.set(c, k);
		}
	}

	/*	Heapsort is actually the selection sort algorithm chosen to implement in Kruskal's algorithm.
	*   It is based on the heap data structure (in binary tree form).
		Parameters of the entry function (heapsort) were initially the array to be sorted
		as a <T extends Comparable<T>> type, but casting the WeightedEdge<D> to Comparable<WeightedEdge<D>>
		caused some issues in mantaining the edges weights in the sorting process.
		Therefore, the entry function was changed to accept an ArrayList<WeightedEdge<D>> (and so all 
		support functions), in fact simplyfing adding edges in Kruskal function (compute).

	 */
	private static <D> void heapify(ArrayList<WeightedEdge<D>> A, int n, int i) {
		if (i >= n)
			return;
		heapify(A, n, left(i));
		heapify(A, n, right(i));
		fixheap(A, n, i);
	}

	private static int left(int i) {
		return (2 * i + 1);
	}

	private static int right(int i) {
		return (2 * i + 2);
	}

	private static <D> void fixheap(ArrayList<WeightedEdge<D>> A, int c, int i) {
		int l = left(i), r = right(i);
		if (l > c)
			return;
		int max = l;
		if (r <= c && A.get(l).weight < A.get(r).weight)
			max = r;
		/* compareTo() and comparable type seems troublesome here
		 * change it in favour of the weight field */
		if (A.get(i).weight < A.get(max).weight) {
			swap(A, i, max);
			fixheap(A, c, max);
		}
	}

	private static <D> WeightedEdge<D> findmax(ArrayList<WeightedEdge<D>> A) {
		return A.get(0);
	}

	private static <D> void deletemax(ArrayList<WeightedEdge<D>> A, int c) {
		if (c <= 0)
			return;
		A.set(0, A.get(c));
		c--;
		fixheap(A, c, 0);
	}

}