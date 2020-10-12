import java.util.*;

public class InPlaceIntHeapSort {

    public static void heapSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            createHeap(i, array);
        }

        for (int i = n-1; i >= 0; i--){
            sortChildren(array, i);
        }
    }

    /** Create Heap from Array of Integers */
    public static void createHeap(int cur, int[] array){
        while (cur > 0) {
            // Swap if the current element is greater than its parent
            int p = (cur - 1) / 2;
            if (array[cur] > array[p]) {
                int temp = array[cur];
                array[cur] = array[p];
                array[p] = temp;
            }
            cur = p;
        }
    }

    /** Move Down element at index i to its appropriate position */
    public static void sortChildren(int[] array, int i) {
        
        int temp = array[0];
        array[0] = array[i];
        array[i] = temp;
        
        int cur = 0;
        while (cur < i) {
            int leftChild = 2 * cur + 1;
            int rightChild = 2 * cur + 2;

            // Find the maximum between two children
            if (leftChild >= i)
                break;
            int max = leftChild;
            if (rightChild < i) {
                if (array[max] < array[rightChild]) {
                    max = rightChild;
                }
            }

            // Swap if the current node is less than the maximum
            if (array[cur] < array[max]) {
                temp = array[max];
                array[max] = array[cur];
                array[cur] = temp;
                cur = max;
            } else
                break; // The tree is a heap
        }
    }

    /** A test method */
    public static void main(String[] args) {
        int[] list = { 2, 3, 2, 5, 6, 1, -2, 3, 14, 12 };
        heapSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}