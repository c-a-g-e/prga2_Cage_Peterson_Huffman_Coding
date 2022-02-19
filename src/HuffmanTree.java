public class HuffmanTree {

    public PriorityQueue myQueue;
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

    public HuffmanTree(PriorityQueue theQueue) {
        myQueue = theQueue;
        while (myQueue.getMyCount() >= 2) {
            int newNodeFreq;
            HuffmanNode left = theQueue.removeNext();
            HuffmanNode right = theQueue.removeNext();
            newNodeFreq = left.myFrequency + right.myFrequency;
            HuffmanNode root = new HuffmanNode(' ', newNodeFreq);
            root.setMyLeft(left);
            root.setMyRight(right);
            myQueue.add(root);
        }
        myRoot = myQueue.getRoot();
    }

//    public String toString() {
//        StringBuilder s = new StringBuilder();
//        s.append("PARENT: [").append(this).append("Child: ").append(myRoot.myChar).append(" | Freq: ").append(myRoot.);
//    }




}
