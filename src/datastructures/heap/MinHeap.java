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

    MinHeap(int capacity) {
        this.capacity = capacity;
        this.heapSize = 0;
        this.heapArray = new int[this.capacity];
    }

    void swap(int heapArray[], int a, int b) {
        int temp = heapArray[b];
        heapArray[b] = heapArray[a];
        heapArray[a] = temp;
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int leftChild(int i) {
        return (2 * i) + 1;
    }

    int rightChild(int i) {
        return (2 * i) + 2;
    }

    int getMin() {
        return heapArray[0];
    }

    int extractMin() {
        if (heapSize <= 0) {
            return Integer.MAX_VALUE;
        }

        if (heapSize == 1) {
            return heapArray[--heapSize];
        }

        int min = heapArray[0];
        heapArray[0] = heapArray[heapSize - 1];

        /* 
         * A copy of value at the end should not be there, even if the 
         * heapSize controls the length of the heap, as this is an array 
         * representation.  
         */
        heapArray[heapSize - 1] = 0;
        heapSize -= 1;
        minHeapify(0);

        return min;
    }

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

    void decreaseKey(int index, int newVal) {
        if (index > heapSize || index < 0) {
            System.out.println("ERROR: Index out of range");
            return;
        }

        heapArray[index] = newVal;
        int p = parent(index);
        while ((index != 0) && (heapArray[p] > heapArray[index])) {
            swap(heapArray, p, index);
            index = p;
        }
    }

    void deleteKey(int index) {
        decreaseKey(index, Integer.MIN_VALUE);
        extractMin();
    }

    void insertKey(int key) {
        if (heapSize >= capacity) {
            System.out.println("ERROR: Heap array overflow");
        }

        int i = heapSize;
        heapSize += 1;
        heapArray[i] = key;

        while (i >= 0 && heapArray[parent(i)] > heapArray[i]) {
            swap(heapArray, parent(i), i);
            i = parent(i);
        }
    }

    public static void main(String[] args) {
        MinHeap obj = new MinHeap(11);
        obj.insertKey(3);
        obj.insertKey(2);
        System.out.println("Heap Array:");
        for (int i : obj.heapArray) {
            System.out.printf("%d ", i);
        }

        System.out.println("\n\nDeleting the value at index '1'...");
        obj.deleteKey(1);

        System.out.println("Inserting 15, 5, 4, 45...");
        obj.insertKey(15);
        obj.insertKey(5);
        obj.insertKey(4);
        obj.insertKey(45);

        System.out.println("\nHeap Array:");
        for (int i : obj.heapArray) {
            System.out.printf("%d ", i);
        }

        System.out.printf("\n\nGet Min = %d", obj.getMin());
        System.out.printf("\nExtract min = %d\n\n", obj.extractMin());

        System.out.println("Heap Array:");
        for (int i : obj.heapArray) {
            System.out.printf("%d ", i);
        }

        System.out.println("\n\nDecreasing (2,1):...");

        obj.decreaseKey(2, 1); 

        System.out.printf("Get Min = %d\n", obj.getMin());

        System.out.println("\nHeap Array:");
        for (int i : obj.heapArray) {
            System.out.printf("%d ", i);
        }

        System.out.printf("\n\nHeap Size = %d", obj.heapSize);
    }

}
