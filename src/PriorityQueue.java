public class PriorityQueue extends ArrayHeap{

    private HuffmanTree.HuffmanNode[] Heap;
    private int myQueueSize;
    private int myCount;

    public PriorityQueue(int queueSize) {
        this.myQueueSize = queueSize + 1;
        this.myCount = 0;
        Heap = new HuffmanTree.HuffmanNode[myQueueSize];
    }

    public HuffmanTree.HuffmanNode[] getHeap() {
        return this.Heap;
    }

    public int getMyQueueSize() {
        return this.myQueueSize;
    }

    public int getMyCount() {
        return this.myCount;
    }

    public HuffmanTree.HuffmanNode getRoot() {
        return Heap[1];
    }

    private int parent(int index) {
        return (index / 2);
    }

    private int leftChild(int index) {
        return (2 * index);
    }

    private int rightChild(int index) {
        return (2 * index) + 1;
    }

    private boolean isLeaf(int index) {
        return index <= myCount && index > (myCount / 2);
    }

    //private boolean isEmpty

    private void swap(int indexA, int indexB) {
        HuffmanTree.HuffmanNode tempNode;
        tempNode = Heap[indexA];
        Heap[indexA] = Heap[indexB];
        Heap[indexB] = tempNode;
    }

    private void heapify(int index) {
//        if (!isLeaf(index) && myCount != 0) {
//            if (Heap[index].compareTo(Heap[leftChild(index)]) == -1 ||
//                    Heap[index].compareTo(Heap[rightChild(index)]) == -1) {
//                if (Heap[leftChild(index)].compareTo(Heap[rightChild(index)]) == 1) {
//                    swap(index, leftChild(index));
//                    heapify(leftChild(index));
//                } else {
//                    swap(index, rightChild(index));
//                    heapify(rightChild(index));
//                }
//            }
//        }
//        if (!isLeaf(index) && myCount != 0) {
//            if (myCount >= 3) {
//                if (Heap[index].compareTo(Heap[leftChild(index)]) == -1 ||
//                        Heap[index].compareTo(Heap[rightChild(index)]) == -1) {
//                    if (Heap[leftChild(index)].compareTo(Heap[rightChild(index)]) == 1) {
//                        swap(index, leftChild(index));
//                        heapify(leftChild(index));
//                    } else {
//                        swap(index, rightChild(index));
//                        heapify(rightChild(index));
//                    }
//                }
//            } else if (Heap[1].compareTo(Heap[2]) == -1) {
//                swap(1, 2);
//            }
//        }
        if (!isLeaf(index) && myCount != 0) {
            if (Heap[index].compareTo(Heap[leftChild(index)]) == -1 ||
                    Heap[index].compareTo(Heap[rightChild(index)]) == -1) {
                if (Heap[leftChild(index)].compareTo(Heap[rightChild(index)]) == 1) {
                    swap(index, leftChild(index));
                    heapify(leftChild(index));
                } else {
                    swap(index, rightChild(index));
                    heapify(rightChild(index));
                }
            }
        }
    }

    public void addElement(char element, int priority) {
        HuffmanTree.HuffmanNode tempNode = new HuffmanTree.HuffmanNode(element, priority);
        if (myCount == 0) {
            Heap[1] = tempNode;
            myCount++;
        } else {
            Heap[++myCount] = tempNode;
            int current = myCount;
            while (current != 1 && Heap[current].compareTo(Heap[parent(current)]) == 1) {
                swap(current, parent(current));
                current = parent(current);
            }
        }

    }

    public HuffmanTree.HuffmanNode removeNext() {
//        HuffmanTree.HuffmanNode result;
//        Heap[0] = Heap[myQueueSize]; //index 0 holds the last node temporarily
//        Heap[myQueueSize] = Heap[1]; //insert the first (min) value to last position
//        Heap[1] = Heap[0];           //insert last node being held at index 0 into the first position
//        result = Heap[myQueueSize];
//        Heap[myQueueSize] = null;
//        heapify(1);
//        return result;
        HuffmanTree.HuffmanNode removed = Heap[1];
        Heap[1] = Heap[myCount];
        Heap[myCount] = null;
        myCount--;
        heapify(1);
        return removed;
    }

    public void printQueue() {
        for (int i = 1; i < myQueueSize; i++) {
            System.out.print(" PARENT: " + Heap[i]);
            if (!isLeaf(i)) {
                System.out.println(" LEFT CHILD: " + Heap[2 * i]
                        + " RIGHT CHILD: " + Heap[2 * i + 1]);
            }
            System.out.println();
        }
    }

    public void add(HuffmanTree.HuffmanNode theNode) {
        Heap[++myCount] = theNode;
        heapify(1);
    }

}
