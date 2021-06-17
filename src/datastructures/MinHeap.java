/**
 * Following program demonstrates Min Heap functionalities with an array 
 * representation. 
 * 
 * Output
 * ------
 * Heap Array:
 * 2 3 0 0 0 0 0 0 0 0 0 
 *
 * Deleting the value at index '1'...
 * Inserting 15, 5, 4, 45...
 *
 * Heap Array:
 * 2 4 5 15 45 0 0 0 0 0 0 
 * 
 * Get Min = 2
 * Extract min = 2
 * 
 * Heap Array:
 * 4 15 5 45 0 0 0 0 0 0 0 
 * 
 * Decreasing (2,1):...
 * Get Min = 1
 *
 * Heap Array:
 * 1 15 4 45 0 0 0 0 0 0 0 
 *
 * Heap Size = 4
 * 
 *
 * @author pyav
 */

public class MinHeap {

    int capacity;
    int heapSize;
    int heapArray[];
    
    // Constructor
    MinHeap(int capacity) {
	this.capacity = capacity;
	this.heapSize = 0;
	this.heapArray = new int[this.capacity];
    }
    
    // The swap method
    void swap(int heapArray[], int a, int b) {
	int temp = heapArray[b];
	heapArray[b] = heapArray[a];
	heapArray[a] = temp;
    }
    
    // Return parent
    int parent(int i) {
	return (i - 1) / 2;
    }
    
    // Return left child
    int leftChild(int i) {
	return (2 * i) + 1;
    }
    
    // Return right child
    int rightChild(int i) {
	return (2 * i) + 2;
    }

    // Get the minimum value
    int getMin() {
	return heapArray[0];
    }
    
    // Extract the minimum value
    int extractMin() {
	if (heapSize <= 0) {
	    return Integer.MAX_VALUE;
	}
	
	if (heapSize == 1) {
	    return heapArray[--heapSize];
	}
	
	// Save the minimum value and delete it. Decrease heap size.
	int min = heapArray[0];
	heapArray[0] = heapArray[heapSize - 1];
	
	/* 
	 * A copy of value at the end should not be there, even if the 
	 * heapSize controls the length of the heap, as this is an array 
	 * representation.  
	 */
	heapArray[heapSize - 1] = 0;
	
	// Update the heap size
	heapSize -= 1;
	
	// Heapify
	minHeapify(0);
	
	// Return the minimum value
	return min;
    }
    
    // Heapify
    void minHeapify(int index) {
	int left = leftChild(index);
	int right = rightChild(index);
	int min = index;
	
	if ((left < heapSize) && (heapArray[left] < heapArray[min])) {
	    min = left;
	}

	if ((right < heapSize) && (heapArray[right] < heapArray[min])) {
	    min = right;
	}
	
	if (min != index) {
	    swap(heapArray, index, min);
	    minHeapify(min);
	}
    }
    
    // Change the value of the element at 'index' and assign it to 'newVal'
    void decreaseKey(int index, int newVal) {
	if (index > heapSize || index < 0) {
	    System.out.println("ERROR: Index out of range");
	    return;
	}
	
	// Change the value at the index
	heapArray[index] = newVal;
	
	int p = parent(index);
	while ((index != 0) && (heapArray[p] > heapArray[index])) {
	    swap(heapArray, p, index);
	    index = p;
	}
    }
    
    // Delete a key
    void deleteKey(int index) {
	decreaseKey(index, Integer.MIN_VALUE);
	extractMin();
    }
    
    // Insert an element
    void insertKey(int key) {
	int i = 0;
	
	if (heapSize >= capacity) {
	    System.out.println("ERROR: Heap array overflow");
	}
	
	// Enter the element
	heapSize += 1;
	i = heapSize - 1;
	heapArray[i] = key;
	
	// Stabilize if heap property is violated
	while (i >= 0 && heapArray[parent(i)] > heapArray[i]) {
	    swap(heapArray, parent(i), i);
	    i = parent(i);
	}
    }
    
    public static void main(String[] args) {
	
	MinHeap obj = new MinHeap(11);
	
	// Call insert and delete methods
	obj.insertKey(3);
	obj.insertKey(2);
	
	// Print heap array
	System.out.println("Heap Array:");
	for (int i : obj.heapArray) {
	    System.out.printf("%d ", i);
	}
	
	System.out.println("\n\nDeleting the value at index '1'...");
	obj.deleteKey(1); // Deletes '3'
	
	System.out.println("Inserting 15, 5, 4, 45...");
	obj.insertKey(15);
	obj.insertKey(5);
	obj.insertKey(4);
	obj.insertKey(45);
	
	System.out.println("\nHeap Array:");
	for (int i : obj.heapArray) {
	    System.out.printf("%d ", i);
	}
	
	// Other Heap functionalities
	System.out.printf("\n\nGet Min = %d", obj.getMin());
	System.out.printf("\nExtract min = %d\n\n", obj.extractMin());
	
	System.out.println("Heap Array:");
	for (int i : obj.heapArray) {
	    System.out.printf("%d ", i);
	}
	
	System.out.println("\n\nDecreasing (2,1):...");
	
	// Change the value at index '2'
	obj.decreaseKey(2, 1); 
	
	System.out.printf("Get Min = %d\n", obj.getMin());

	System.out.println("\nHeap Array:");
	for (int i : obj.heapArray) {
	    System.out.printf("%d ", i);
	}
	
	System.out.printf("\n\nHeap Size = %d", obj.heapSize);
    }

}
