public class ArrayHeap {

    protected final HuffmanTree.HuffmanNode[] myHeap;
    protected int mySize;
    protected int myCount;

    public ArrayHeap(int theSize) {
        this.mySize = theSize + 1;
        this.myCount = 0;
        myHeap = new HuffmanTree.HuffmanNode[mySize];
    }

    public int getMyCount() {
        return this.myCount;
    }

    public int getMySize() {
        return this.mySize;
    }

    public HuffmanTree.HuffmanNode getRoot() {
        return myHeap[1];
    }

    public int parent(int index) {
        return (index / 2);
    }

    private int leftChild(int index) {
        return (2 * index);
    }

    private int rightChild(int index) {
        return (2 * index) + 1;
    }

    public boolean isLeaf(int index) {
        return index <= myCount && index > (myCount / 2);
    }

    public void add(HuffmanTree.HuffmanNode theNode) {
        myHeap[++myCount] = theNode;
        heapify(1);
    }

    public HuffmanTree.HuffmanNode removeMin() {
        HuffmanTree.HuffmanNode removed = myHeap[1];
        myHeap[1] = myHeap[myCount];
        myHeap[myCount] = null;
        myCount--;
        heapify(1);
        return removed;
    }

    public void swap(int indexA, int indexB) {
        HuffmanTree.HuffmanNode tempNode;
        tempNode = myHeap[indexA];
        myHeap[indexA] = myHeap[indexB];
        myHeap[indexB] = tempNode;
    }

    private void heapify(int index) {
        if (myCount >= 3) {
            if (!isLeaf(index) && myCount != 0) {
                if (myHeap[index].compareTo(myHeap[leftChild(index)]) == -1 ||
                        myHeap[index].compareTo(myHeap[rightChild(index)]) == -1) {
                    if (myHeap[leftChild(index)].compareTo(myHeap[rightChild(index)]) == 1) {
                        swap(index, leftChild(index));
                        heapify(leftChild(index));
                    } else {
                        swap(index, rightChild(index));
                        heapify(rightChild(index));
                    }
                }
            }
        } else if(myCount == 2){
            if (myHeap[1].compareTo(myHeap[2]) == -1) {
                swap(1, 2);
            }
        }
    }
}
