import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        checkFilePrintWriter();
        checkScanner();

        //testFileRead();
        System.out.println();
        //scan.nextLine();
        testPriorityQueueConstruction();

        //HuffmanTree tree = new HuffmanTree(myQueue);

        printWriter.close();
    }

    /**
     * The file to be outputted to.
     */
    public static File out = new File("output.txt");
    /**
     * the scanner used to scan the input file.
     */
    public static Scanner scan = null;
    /**
     * a printwriter object that is used to print to the output file.
     */
    public static PrintWriter printWriter = null;
    /**
     * the filewriter object that is used to print to the output file.
     */
    public static FileWriter fileWriter;

    public static PriorityQueue myQueue;

    /**
     * Checks the File and Print writer objects. Will throw an exception if the file is not found.
     */
    private static void checkFilePrintWriter() {
        try {
            fileWriter = new FileWriter(out);
            printWriter = new PrintWriter(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks the scanner object. Will throw an exception if the input file is not found.
     */
    private static void checkScanner(){
        try {
            scan = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Map<Character,Integer> createTable(String input) {

        Map<Character,Integer> frequencyTable = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            if (frequencyTable.containsKey(input.charAt(i))) {
                int count = frequencyTable.get(input.charAt(i));
                frequencyTable.put(input.charAt(i), count + 1);
            } else {
                frequencyTable.put(input.charAt(i), 1);
            }
        }

        return frequencyTable;

    }

    private static void printTable(Map<Character, Integer> theTable) {
        printWriter.println("======================================");
        printWriter.printf("%-10s%-15s%-13s\n","Char","Frequency","Code");
        printWriter.println("--------------------------------------");
        for (Map.Entry<Character, Integer> entry : theTable.entrySet()) {
            printWriter.printf("%-10s%-15s%-13s\n",entry.getKey(),entry.getValue(),"Code");
        }
        printWriter.println("======================================");
    }

    private static void testFileRead() {
        String in = scan.nextLine();
        System.out.println(createTable(in));
    }

    private static void testPriorityQueueConstruction() {
        String in = scan.nextLine();
        Map<Character, Integer> newMap = createTable(in);
        printTable(newMap);
        myQueue = new PriorityQueue(newMap.size());
        for (Map.Entry<Character, Integer> entry : newMap.entrySet()) {
            myQueue.addElement(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<Character, Integer> entry : newMap.entrySet()) {
            System.out.println("[" + entry.getKey() + "] [" + entry.getValue() + "]");
        }
        myQueue.printQueue();
    }

    private static void testBuildTree() {
        HuffmanTree tree = new HuffmanTree(myQueue);
    }

//    public void printTable(Map<Character, Integer> theMap) {
//        for ()
//    }

}
