/**
 * Following program demonstrates K-ary Heap operations
 *
 * Output:
 * ------
 * Heap after building:
 * 10 9 6 7 8 4 5 
 * Heap after insert element = 3:
 * 10 9 6 7 8 4 5 3 
 * Extracted Max element:
 * 10
 * Heap after extract Max (n = 7):
 * 9 8 6 7 3 4 5 
 */

public class KaryHeap {
    private int[] arr;
    private int capacity;
    private int n;
    private int k;

    private void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    private void restoreDown(int[] arr, int len, int index, int k) {
        int[] childIdx = new int[k];
        while(true) {
            for (int i = 1; i <= k; i++) {
                childIdx[i-1] = ((k*index + i) < len)? (k*index + i): -1;
            }
            int maxChild = -1, maxChildIdx = -1;
            for (int i = 1; i <= k; i++) {
                if (childIdx[i-1] != -1 && arr[childIdx[i-1]] > maxChild) {
                    maxChild = arr[childIdx[i-1]];
                    maxChildIdx = childIdx[i-1];
                }
            }
            if (maxChild == -1) {
                break;
            }
            if (arr[index] < arr[maxChildIdx]) {
                swap(arr, index, maxChildIdx);
            }
            index = maxChildIdx;
        }
    }

    private void restoreUp(int[] arr, int index, int k) {
        int parentIdx = (index-1)/k;
        while(parentIdx >= 0) {
            if (arr[index] > arr[parentIdx]) {
                swap(arr, index, parentIdx);
                index = parentIdx;
                parentIdx = (index-1)/k;
            } else {
                break;
            }
        }
    }

    public void buildHeap(int[] arr, int n, int k) {
        for (int i = (n-1)/k; i >=0; i--){
            restoreDown(arr, n, i, k);
        }
    }

    public int insertElement(int[] arr, int n, int k, int element) {
        arr[n] = element;
        n++;
        restoreUp(arr, n, k);
        return n;
    }

    public int[] extractMax(int[] arr, int n, int k) {
        int max = arr[0];
        arr[0] = arr[n-1];
        n--;
        restoreDown(arr, n, 0, k);
        return new int[] {n, max};
    }

    public static void main(String[] args) {
        int capacity = 50;
        int[] arr = new int[capacity];
        arr[0] = 4;
        arr[1] = 5;
        arr[2] = 6;
        arr[3] = 7;
        arr[4] = 8;
        arr[5] = 9;
        arr[6] = 10;
        int n = 7;
        int k = 3;
        KaryHeap obj = new KaryHeap();
        obj.buildHeap(arr, n, k);
        System.out.println("Heap after building:");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", arr[i]);
        }
        int element = 3;
        n = obj.insertElement(arr, n, k, element);
        System.out.println("\nHeap after insert element = 3:");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println("\nExtracted Max element:");
        int[] val = obj.extractMax(arr, n, k);
        n = val[0];
        System.out.println(val[1]);
        System.out.printf("Heap after extract Max (n = %d):\n", n);
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }

}

