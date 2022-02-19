public class HuffmanTree {

    public PriorityQueue myQueue;
    public ArrayHeap myArray;
    public int arrayCount;
    public HuffmanNode myRoot;

    static class HuffmanNode {
        public char myChar;
        public int myFrequency;
        public HuffmanNode myLeft, myRight;

        public HuffmanNode(char element, int frequency) {
            this.myChar = element;
            this.myFrequency = frequency;
        }

        public void setMyLeft(HuffmanNode theNode) {
            this.myLeft = theNode;
        }
        public void setMyRight(HuffmanNode theNode) {
            this.myRight = theNode;
        }

        public String toString() {
            return "[Char: " + myChar + " | Freq: " + myFrequency + "]";
        }


        public int compareTo(HuffmanNode otherNode) {
            if (this.myFrequency < otherNode.myFrequency) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public HuffmanTree(ArrayHeap theArray) {
        myArray = theArray;
        arrayCount = myArray.getMyCount();
        while (myArray.getMyCount() >= 2) {
            int newNodeFreq;
            HuffmanNode left = theArray.removeMin();
            HuffmanNode right = theArray.removeMin();
            newNodeFreq = left.myFrequency + right.myFrequency;
            HuffmanNode root = new HuffmanNode(' ', newNodeFreq);
            root.setMyLeft(left);
            root.setMyRight(right);
            myArray.add(root);
        }
        myRoot = myArray.getRoot();
    }

//    public String toString() {
//        int count = myArray.getMyCount();
//        HuffmanNode current = myArray.getRoot();
//        StringBuilder s = new StringBuilder();
//        s.append("PARENT: [").append(this).append("Child: ").append(myRoot.myChar).append(" | Freq: ").append(myRoot.myFrequency);
//
//        while (count - 1 >= 0) {
//            if ()
//        }
//    }




}
