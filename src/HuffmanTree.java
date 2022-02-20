import java.util.LinkedList;
import java.util.Queue;

public class HuffmanTree {

    public PriorityQueue myQueue;
    public ArrayHeap myHeap;
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
            return "[Char: " + myChar + " | Freq: " + myFrequency + "] ";
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
        arrayCount = myQueue.getMyCount();
        while (myQueue.getMyCount() >= 2) {
            int newNodeFreq;
            HuffmanNode left = theQueue.removeMin();
            HuffmanNode right = theQueue.removeMin();
            newNodeFreq = left.myFrequency + right.myFrequency;
            HuffmanNode root = new HuffmanNode(' ', newNodeFreq);
            root.setMyLeft(left);
            root.setMyRight(right);
            myQueue.add(root);
        }
        myRoot = myQueue.getRoot();
    }

    public String toString() {
        String st = "";
        Queue<HuffmanNode> queue = new LinkedList<>();
        queue.add(myRoot);
        while (!queue.isEmpty()) {
            HuffmanNode curr = queue.poll();
            System.out.println("Frequency [" + curr.myFrequency + "] Character [" + curr.myChar + "]");

            if (curr.myLeft != null) {
                queue.add(curr.myLeft);
            }

            if (curr.myRight != null) {
                queue.add(curr.myRight);
            }
        }

        return st;
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
