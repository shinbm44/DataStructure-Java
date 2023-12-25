package heap;



public class Heap <E extends Comparable> implements PQinterface<E> {
    private E[] A;
    private int numItems;

    public Heap(int arraySize) {
        A = (E[]) new Comparable[arraySize];
    }

    public Heap(E[] B, int numItems) {
        A = B;
        numItems = 0;
    }

    private void percolateUp(int i) {
        int parent = (i - 1) / 2;
        if (parent >= 0 && A[i].compareTo(A[parent]) > 0) {
            E tmp = A[i];
            A[i] = A[parent];
            A[parent] = tmp;
            percolateUp(parent);
        }
    }

    private void percolateDown(int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        if (leftChild <= numItems - 1) {
            if (rightChild <= numItems - 1 && A[leftChild].compareTo(A[rightChild]) < 0) {
                leftChild = rightChild;
            }
            if (A[i].compareTo(A[leftChild]) < 0) {
                E tmp = A[i];
                A[i] = A[leftChild];
                A[leftChild] = tmp;
                percolateDown(leftChild);
            }
        }
    }

    public void buildHeap() {
        if (numItems >= 2)
            for (int i = (numItems - 2) / 2; i >= 0; i--)
                percolateDown(i);
    }

    @Override
    public void insert(E newItem) throws PQException {
        if (numItems < A.length) {
            A[numItems] = newItem;
            percolateUp(numItems);
            numItems++;
        } else throw new PQException("Heap Error : Insert()-overflow!");
    }

    @Override
    public E deleteMax() throws PQException {
        E max = A[0];
        if (!isEmpty()) {
            A[0] = A[numItems - 1];
            numItems--;
            percolateDown(0);
            return max;
        } else throw new PQException("Heap Error : DeleteMax()-Underflow");
    }

    @Override
    public E max() throws PQException {
        if (!isEmpty()) {
            return A[0];
        } else throw new PQException("Heap Error : Max()-Empty!");
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public void clear() {
        A = (E[]) new Comparable[A.length];
        numItems = 0;
    }
}


