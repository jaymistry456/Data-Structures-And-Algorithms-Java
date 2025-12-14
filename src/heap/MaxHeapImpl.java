package heap;

class MaxHeap {
    private int[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    public int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public void fixHeapAbove(int index) {
        int valueToBubbleUp = heap[index];
        int parentIndex = getParentIndex(index);
        while(index > 0 && heap[parentIndex] < valueToBubbleUp) {
            heap[index] = heap[parentIndex];
            index = parentIndex;
            parentIndex = getParentIndex(index);
        }
        heap[index] = valueToBubbleUp;
    }

    public void fixHeapBelow(int index, int lastHeapIndex) {
        int valueToBubbleDown = heap[index];
        while(index <= lastHeapIndex) {
            int leftChildIndex = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);
            int childIndexToSwap;
            // index has leftChild and rightChild
            if(leftChildIndex <= lastHeapIndex && rightChildIndex <= lastHeapIndex) {
                childIndexToSwap = heap[leftChildIndex] > heap[rightChildIndex] ? leftChildIndex : rightChildIndex;
            }
            // index has only leftChild
            else if(leftChildIndex <= lastHeapIndex) {
                childIndexToSwap = leftChildIndex;
            }
            // index has no children
            else {
                break;
            }
            if(heap[childIndexToSwap] > valueToBubbleDown) {
                heap[index] = heap[childIndexToSwap];
                index = childIndexToSwap;
            }
            else {
                break;
            }
        }
        heap[index] = valueToBubbleDown;
    }

    public void insert(int value) {
        if(isFull()) {
            throw new IllegalStateException("Heap is full!");
        }
        heap[size] = value;
        fixHeapAbove(size);
        size++;
    }

    public int delete(int index) {
        if(isEmpty() || index >= size) {
            throw new IllegalStateException("Heap is empty or index is out of bounds!");
        }
        int deletedValue = heap[index];
        heap[index] = heap[size - 1];
        size--;
        int parentIndex = getParentIndex(index);
        if(index != 0 && heap[parentIndex] < heap[index]) {
            fixHeapAbove(index);
        }
        else {
            fixHeapBelow(index, size - 1);
        }
        return deletedValue;
    }

    public void sort() {
        for(int lastHeapIndex = size - 1; lastHeapIndex >= 0; lastHeapIndex--) {
            int temp = heap[0];
            heap[0] = heap[lastHeapIndex];
            heap[lastHeapIndex] = temp;
            fixHeapBelow(0, lastHeapIndex - 1);
        }
    }

    public int peek() {
        if(isEmpty()) {
            throw new IllegalStateException("Heap is empty!");
        }
        return heap[0];
    }

    public void printHeap() {
        System.out.println("-------Heap-------");
        for(int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
        System.out.println("------------------");
    }

}

public class MaxHeapImpl {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);
        heap.printHeap();
        System.out.println(heap.peek());
        heap.delete(0);
        System.out.println(heap.peek());
        heap.sort();
        heap.printHeap();
    }
}
