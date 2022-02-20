public class ArrayHeap {

    protected HuffmanTree.HuffmanNode[] myHeap;
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

//    public boolean isLeaf(int index) {
//        return index <= myCount && index > (myCount / 2);
//    }

    public boolean isLeaf(int index) {
        return rightChild(index) >= myCount || leftChild(index) >= myCount;
    }

    public void add(HuffmanTree.HuffmanNode theNode) {
        myHeap[++myCount] = theNode;
        heapifyUp(myCount);
    }

    public HuffmanTree.HuffmanNode removeMin() {
        HuffmanTree.HuffmanNode removed = myHeap[1];
        myHeap[1] = myHeap[myCount];
        myHeap[myCount] = null;
        myCount--;
        heapifyDown(1);
        return removed;
    }

    public void swap(int indexA, int indexB) {
        HuffmanTree.HuffmanNode tempNode;
        tempNode = myHeap[indexA];
        myHeap[indexA] = myHeap[indexB];
        myHeap[indexB] = tempNode;
    }

//    private void heapifyDown(int index) {
//        if (myCount >= 3) {
//            if (!isLeaf(index) && myCount != 0) {
//                if (rightChild(index) <= myCount) {
//                    if (myHeap[index].compareTo(myHeap[leftChild(index)]) == -1 ||
//                            myHeap[index].compareTo(myHeap[rightChild(index)]) == -1) {
//                        if (myHeap[leftChild(index)].compareTo(myHeap[rightChild(index)]) == 1) {
//                            swap(index, leftChild(index));
//                            heapifyDown(leftChild(index));
//                        } else if (rightChild(index) <= myCount) {
//                            swap(index, rightChild(index));
//                            heapifyDown(rightChild(index));
//                        }
//                    }
//                }
//            }
//        } else if(myCount == 2){
//            if (myHeap[1].compareTo(myHeap[2]) == -1) {
//                swap(1, 2);
//            }
//        }
//    }

//    private void buildHeap() {
//        for (int i = (index ))
//    }

    private void heapifyDown(int index) {
        if (myCount >= 3) {
            if (!isLeaf(index)) {
                if (myHeap[index].compareTo(myHeap[leftChild(index)]) == -1) {
                    swap(index, leftChild(index));
                    heapifyDown(leftChild(index));
                } else if ((rightChild(index) <= myCount && myHeap[index].compareTo(myHeap[rightChild(index)]) == -1)) {
                    swap(index, rightChild(index));
                    heapifyDown(rightChild(index));
                }
            }
        } else if (myCount == 2) {
            if (myHeap[1].compareTo(myHeap[2]) == -1) {
                swap(1, 2);
            }
        }
    }

    private void heapifyUp(int index) {
        if (index != 1) {
            if (myHeap[index].compareTo(myHeap[parent(index)]) == 1) {
                swap(index, parent(index));
                heapifyUp(parent(index));
            }
        }
    }
}
