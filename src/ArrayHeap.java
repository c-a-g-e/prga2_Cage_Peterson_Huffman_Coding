public class ArrayHeap {

    private HuffmanTree.HuffmanNode[] Heap;

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

    public void add() {

    }

    public HuffmanTree.HuffmanNode removeMin() {

    }



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

}
