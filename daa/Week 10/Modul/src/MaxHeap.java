public class MaxHeap {
    private int maxHeap[];
    private int heapSize;
    private int length;

    public MaxHeap(int length) {
        this.heapSize = 0;
        this.length = length;
        this.maxHeap = new int[length + 1];
    }

    public MaxHeap(int[] arr) {
        this.heapSize = arr.length;
        this.length = arr.length;
        this.maxHeap = new int[length + 1];

        for (int i = 0; i < length; i++) {
            this.maxHeap[i + 1] = arr[i];
        }
    }

    private int getLeft(int i) {
        return i<<1;
    }

    private int getRight(int i) {
        return (i<<1) | 1;
    }

    private int getParent(int i) {
        return i>>1;
    }

    private void maxHeapify(int i) {
        int left = getLeft(i);
        int right = getRight(i);
        int largest = i;

        if ((left < heapSize) && (maxHeap[left] > maxHeap[largest])) {
            largest = left;
        }

        if ((right < heapSize) && (maxHeap[right] > maxHeap[largest])) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    private void buildMaxHeap() {
        for (int i = heapSize / 2; i > 0; i--) {
            maxHeapify(i);
        }
    }

    private void insertKey(int key) {
        heapSize = heapSize - 1;
        maxHeap[heapSize] = Integer.MIN_VALUE;

        increaseKey(heapSize, key);
    }

    private boolean increaseKey(int i, int key) {
        if (key < maxHeap[i]) {
            return false;
        }else {
            maxHeap[i] = key;

            while((i > 1) && (maxHeap[getParent(i)] < maxHeap[i])) {
                swap(getParent(i), i);
                i = getParent(i);
            }

            return true;
        }
    }

    private int extractMax() {
        int max = maxHeap[1];

        maxHeap[1] = heapSize - 1;
        heapSize = heapSize - 1;

        maxHeapify(1);

        return max;
    }

    private void swap(int i, int largest) {
        int temp = maxHeap[i];
        maxHeap[i] = maxHeap[largest];
        maxHeap[largest] = temp;
    }

    public void heapSort(){
        buildMaxHeap();

        for (int i = maxHeap.length; i > 2; i--) {
            swap(maxHeap[1],maxHeap[i]);
            heapSize--;
            maxHeapify(1);
        }
    }
}
