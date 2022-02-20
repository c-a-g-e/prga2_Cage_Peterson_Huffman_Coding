public class PriorityQueue extends ArrayHeap{

    public PriorityQueue(int theSize) {
        super(theSize);
    }

//    public void addElement(char element, int priority) {
//        HuffmanTree.HuffmanNode tempNode = new HuffmanTree.HuffmanNode(element, priority);
//        if (myCount == 0) {
//            myHeap[1] = tempNode;
//            myCount++;
//        } else {
//            myHeap[++myCount] = tempNode;
//            int current = myCount;
//            while (current != 1 && myHeap[current].compareTo(myHeap[current - 1]) == 1) {
//                swap(current, current - 1);
//                current--;
//            }
//        }
//
//    }

    public void addElement(char element, int priority) {
        HuffmanTree.HuffmanNode tempNode = new HuffmanTree.HuffmanNode(element, priority);
        add(tempNode);
    }

    public HuffmanTree.HuffmanNode removeNext() {
        HuffmanTree.HuffmanNode removed = myHeap[1];
        myHeap[1] = myHeap[myCount];
        myHeap[myCount] = null;
        myCount--;
        return removed;
    }

//    public HuffmanTree.HuffmanNode removeNext() {
//        return removeMin();
//    }

//    public void printQueue() {
//        for (int i = 1; i < mySize; i++) {
//            System.out.print(" PARENT: " + myHeap[i]);
//            if (!isLeaf(i)) {
//                System.out.println(" LEFT CHILD: " + myHeap[2 * i]
//                        + " RIGHT CHILD: " + myHeap[2 * i + 1]);
//            }
//            System.out.println();
//        }
//    }

    public void printQueue() {
        for (int i = 1; i < mySize; i++) {
            System.out.print(myHeap[i]);
        }
    }

}
