package utils;

import java.util.Comparator;

public class Utility {

    // Bubble Sort
    public static <T> void bubbleSort(T[] array, Comparator<? super T> comparator) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    // swap array[j+1] and array[j]
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
    }

    // Insertion Sort
    public static <T> void insertionSort(T[] array, Comparator<? super T> comparator) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            T key = array[i];
            int j = i - 1;

            // Move elements of array[0..i-1], that are greater than key, to one position ahead
            while (j >= 0 && comparator.compare(array[j], key) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    // Selection Sort
    public static <T> void selectionSort(T[] array, Comparator<? super T> comparator) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (comparator.compare(array[j], array[min_idx]) < 0)
                    min_idx = j;

            // Swap the found minimum element with the first element
            T temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
    }

 // Generic merge sort method
    public static <T> void mergeSort(T[] array, Comparator<? super T> comparator) {
        if (array.length < 2) {
            return; // Array is already sorted if it's less than 2 elements.
        }
        int mid = array.length / 2;
        T[] left = (T[]) new Object[mid]; // Creating the left subarray
        T[] right = (T[]) new Object[array.length - mid]; // Creating the right subarray

        // Copying elements to the left subarray
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        // Copying elements to the right subarray
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }

        // Recursively sorting the two subarrays
        mergeSort(left, comparator);
        mergeSort(right, comparator);

        // Merging the sorted subarrays back into the original array
        merge(array, left, right, comparator);
    }

    // Generic merge method
    private static <T> void merge(T[] array, T[] left, T[] right, Comparator<? super T> comparator) {
        int i = 0, j = 0, k = 0; // Indices for left, right, and merged array

        // Compare elements from left and right subarrays and merge into the original array
        while (i < left.length && j < right.length) {
            if (comparator.compare(left[i], right[j]) <= 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy remaining elements from left subarray, if any
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Copy remaining elements from right subarray, if any
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // Quick Sort
    public static <T> void quickSort(T[] array, Comparator<? super T> comparator) {
        quickSort(array, 0, array.length - 1, comparator);
    }

    private static <T> void quickSort(T[] array, int low, int high, Comparator<? super T> comparator) {
        if (low < high) {
            int pi = partition(array, low, high, comparator);
            quickSort(array, low, pi - 1, comparator);
            quickSort(array, pi + 1, high, comparator);
        }
    }

    private static <T> int partition(T[] array, int low, int high, Comparator<? super T> comparator) {
        Object pivot = array[high];
        int i = (low - 1);  // Index of smaller element
        for (int j = low; j < high; j++) {
            if (comparator.compare(array[j], (T) pivot) < 0) {
                i++;

                // swap array[i] and array[j]
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // swap array[i+1] and array[high] (or pivot)
        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    // Heap Sort
    public static <T> void heapSort(T[] array, Comparator<? super T> comparator) {
        int n = array.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i, comparator);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            T temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // call max heapify on the reduced heap
            heapify(array, i, 0, comparator);
        }
    }

    // To heapify a subtree rooted with node i which is an index in array[]
    private static <T> void heapify(T[] array, int n, int i, Comparator<? super T> comparator) {
        int largest = i;  // Initialize largest as root
        int l = 2 * i + 1;  // left = 2*i + 1
        int r = 2 * i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && comparator.compare(array[l], array[largest]) > 0)
            largest = l;

        // If right child is larger than largest so far
        if (r < n && comparator.compare(array[r], array[largest]) > 0)
            largest = r;

        // If largest is not root
        if (largest != i) {
            T swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(array, n, largest, comparator);
        }
    }

}