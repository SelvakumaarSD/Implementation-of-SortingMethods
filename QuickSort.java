public class QuickSort {
  public static void quickSort(int[] list) {
    quickSort(list, 0, list.length - 1);
  }

  private static void quickSort(int[] list, int first, int last) {
    if (last > first) {
      int pivotIndex = partition(list, first, last);
      quickSort(list, first, pivotIndex - 1);
      quickSort(list, pivotIndex + 1, last);
    }
  }
  
  // The choosePivot and partition methods below are adapted from
  // "Data Abstraction & Problem Solving with Java:  Walls & Mirrors"
  // by Frank M. Carrano and Janet J. Prichard.
  
  /** Choose's a pivot element for the partition algorithm and
   *  swaps it into the first position.
   *  Precondition:   array[first..last] is an array
   *                  first <= last
   *  Postcondition:  array[first] is the pivot element */
  private static void choosePivot(int[] list, int first, int last) {
  	// Currently this method always lets the first element be the
  	// pivot element.  But you could add code here to make the
  	// pivot selection more intelligent.
  }

  /** Partitions array[first..last]
   *  Precondition:  first <= last
   *  Postcondition: Returns the index of the pivot element of list[first..last].
   *  Upon completion of the method, this will be the index value lastS1 such that
   *    S1 = array[first..lastS1-1], all < pivot
   *         array[lastS1]                == pivot 
   *    S2 = array[lastS1+1..last],  all >= pivot */
  private static int partition(int[] array, int first, int last) {
  	choosePivot(array, first, last);
    int pivot = array[first]; // Choose the first element as the pivot
    int lastS1 = first; // index of last item in S1
    int tempItem;
    for (int firstUnknown = first + 1; firstUnknown <= last; firstUnknown++) {
    	// Invariant: array[first+1..lastS1] < pivot
    	//            array[lastS1+1..firstUnknown-1] >= pivot
    	
    	// Move item from unknown region to proper region
    	if (array[firstUnknown] < pivot) {
    		lastS1++;
    		tempItem = array[firstUnknown];
    		array[firstUnknown] = array[lastS1];
    		array[lastS1] = tempItem;
    	}
    	// else item from unknown belongs in S2
    }
    
    // Place pivot in proper position and return its location
    tempItem = array[first];
    array[first] = array[lastS1];
    array[lastS1] = tempItem;
    return lastS1;
  }

  /** A test method */
  public static void main(String[] args) {
    int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    quickSort(list);
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + " ");
  }
}
