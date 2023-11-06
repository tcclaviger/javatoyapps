package driver;

import trees.TreeHelpers;
import trees.TreeOperations;
import trees.nodes.DictionaryNode;
import trees.nodes.Node;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * This file will contain your informal tests to
 * verify whether your tree routines are working
 * or not.
 *
 * @author Rob Smith
 * @author Josh Archer
 * @version 1.0
 */
public class ProgramTests {
    private TreeOperations ops = new TreeOperations();
    private TreeHelpers helps = new TreeHelpers();

    /**
     * Entry point to the test file. This starts the program.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        ProgramTests tests = new ProgramTests();

        //test our problems
        tests.problem1();
        tests.problem2();
        tests.problem3();
        tests.problem4();
        tests.problem5();
        tests.problem6();
        tests.problem7();
        tests.problem8();
        tests.problem9();
        tests.problem10();
        tests.problem11();
        tests.problem12();
        tests.problem13();
        tests.problem14();
        tests.problem15();
    }

    public void problem1(){
        System.out.println("\n-----------");
        System.out.println("|Problem 1|");
        System.out.println("-----------\n");
        Node root = TreeHelpers.randomTree(15);
        System.out.println("Before Invert: \n" + root);
        ops.invert(root);
        System.out.println("After Invert: \n" + root);
    }

    /**
     * Creates BST and then searches for a number. It displays the path from the located number to the root, or
     * a backwards traversal up the tree from the searched number.
     */
    public void problem2() {
        System.out.println("\n-----------");
        System.out.println("|Problem 2|");
        System.out.println("-----------\n");
        Node root = TreeHelpers.randomTree(12);
        System.out.println(root);
        System.out.println("Path to root: ");
        ops.bottomUpPath(root, 5);

        Node root2 = TreeHelpers.randomTree(13);
        System.out.println(root2);
        System.out.println("Path to root: ");
        ops.bottomUpPath(root2, 5);
    }

    /**
     * Creates trees, prints the tree structure, then prints the level-order search results for the trees created.
     */
    public void problem3() {
        System.out.println("\n-----------");
        System.out.println("|Problem 3|");
        System.out.println("-----------\n");
        ArrayList<Integer> bfsArray;
        int[] treeOneNums = {18,10,23,22,20,5,9,15,12};
        Node root = TreeHelpers.addAll(treeOneNums);
        System.out.println(root);
        bfsArray = ops.bfs(root);
        System.out.println("Level-Order Search: "+bfsArray);

        int[] treeTwoNums = {13,11,22,2,12,18,1,3,14,19,6,5};
        Node root2 = TreeHelpers.addAll(treeTwoNums);
        System.out.println(root2);
        bfsArray = ops.bfs(root2);
        System.out.println("Level-Order Search: "+bfsArray);
    }

    /**
     * Tests a BST for all values that are contained as internal nodes and adds those values
     * to an arraylist. Then prints the arraylist when complete scanning the BST for internal nodes.
     */
    public void problem4() {
        System.out.println("\n-----------");
        System.out.println("|Problem 4|");
        System.out.println("-----------\n");
        int count = 1;
        while (count!=0) {
            Node root = TreeHelpers.randomTree(count*7);
            ArrayList<Integer> internalNodes = ops.getInternalNodes(root);
            System.out.println(root);
            System.out.println("Internal Node elements: "+internalNodes+"\n");
            count--;
        }
    }

    /**
     * Tests a BST for all values that are contained as leaf nodes and adds those values
     * to an arraylist. then prints the arraylist when complete scanning the BST for leaf nodes.
     */
    public void problem5() {
        System.out.println("\n-----------");
        System.out.println("|Problem 5|");
        System.out.println("-----------\n");
        int count = 1;
        while (count!=0) {
            Node root = TreeHelpers.randomTree(count*6);
            ArrayList<Integer> leafNodes = ops.getLeafNodes(root);
            System.out.println(root);
            System.out.println("Leaf Node elements: "+leafNodes+"\n");
            count--;
        }
    }

    /**
     * Reads the contents of the dictionary.txt file in ./Files into an ArrayList one line
     * at a time. Then shuffles the ArrayList, splits each line on the colon and creates a BST
     * of DictionaryNodes that contain the split values for word and definition pairs. Then checks
     * to see if the BST contains specified words, if they're found, prints the definition of the word
     * otherwise prints null.
     */
    public void problem6() {
        System.out.println("\n-----------");
        System.out.println("|Problem 6|");
        System.out.println("-----------\n");
        ArrayList<String> words = new ArrayList<>();
        try(Scanner reader = new Scanner(new FileInputStream(("./Files/dictionary.txt")))){
            while(reader.hasNextLine()){
                words.add(reader.nextLine());
            }
        } catch (FileNotFoundException ex){
            System.out.println("error reading from file "+ex.getMessage());
        }
        Collections.shuffle(words);
        String[] splitFirstWord = words.get(0).split(":");
        DictionaryNode dictRoot = new DictionaryNode(splitFirstWord[0], splitFirstWord[1]);
        words.remove(0);
        for (String word : words){
            String[] splitWords= word.split(":");
            ops.addWordToTree(dictRoot, splitWords[0], splitWords[1]);
        }
        System.out.println(dictRoot);
        System.out.println("Trichotillomania means"+ops.getDefinition(dictRoot, "Trichotillomania"));
        System.out.println("Liminal means"+ops.getDefinition(dictRoot, "Liminal"));
        System.out.println("Zeitgeist means"+ops.getDefinition(dictRoot, "Zeitgeist"));
        System.out.println("Cheetah means"+ops.getDefinition(dictRoot, "Cheetah"));
    }

    /**
     * Generates two BSTs and searches them for the minimum and maximum values
     * then prints those values to the console after printing the BST.
     */
    public void problem7() {
        System.out.println("\n-----------");
        System.out.println("|Problem 7|");
        System.out.println("-----------\n");
        Node root = TreeHelpers.randomTree(17);
        System.out.println(root);
        System.out.println("Minimum element: "+ops.findMin(root));
        System.out.println("Minimum element: "+ops.findMax(root));

        Node root2 = TreeHelpers.randomTree(13);
        System.out.println(root2);
        System.out.println("Minimum element: "+ops.findMin(root2));
        System.out.println("Minimum element: "+ops.findMax(root2));

    }

    /**
     * Creates a binary search tree of strings derived from the list of movie files and prints the tree to the console.
     */
    public void problem8() {
        System.out.println("\n-----------");
        System.out.println("|Problem 8|");
        System.out.println("-----------\n");
        System.out.println(ops.createMovieTree());
    }

    /**
     * Creates a random BST using loop instead of recursion by navigating the tree and adding a new node where appropriate
     * to comply with BST property. Then prints the BST when complete.
     */
    public void problem9() {
        System.out.println("\n-----------");
        System.out.println("|Problem 9|");
        System.out.println("-----------\n");
        Random rand = new Random();
        Node root = new Node(rand.nextInt(50));
        int treeSize = 20;
        for (int i = 0; i < treeSize; i++) {
            ops.iterativeAdd(root, rand.nextInt(50));
        }
        System.out.println(root);
    }

    /**
     * Generates random trees and searches trees for values using a loop instead of recursion in the iterativeContains()
     * method by comparing values of current to search num and moving the direction required to find the target num
     * in the shortest route possible if present and returns true. If not found returns false.
     */
    public void problem10() {
        System.out.println("\n-----------");
        System.out.println("|Problem 10|");
        System.out.println("-----------\n");
        int [] searchNums = {17,12,14,7,1,9};
        int [] fixedTreeNums = {17,8,20,1,10,18,21,9,15};
        Node root = TreeHelpers.addAll(fixedTreeNums);
        System.out.println(root);
        for(int searchnum : searchNums){
            System.out.println("iterativeContains("+searchnum+"): "+ops.iterativeContains(root, searchnum));
        }

        Node root2 = TreeHelpers.randomTree(12);
        System.out.println(root2);
        for(int searchnum : searchNums){
            System.out.println("iterativeContains("+searchnum+"): "+ops.iterativeContains(root2, searchnum));
        }

        Node root3 = TreeHelpers.randomTree(17);
        System.out.println(root3);
        for(int searchnum : searchNums){
            System.out.println("iterativeContains("+searchnum+"): "+ops.iterativeContains(root3, searchnum));
        }

    }

    /**
     * Creates a binary tree and checks the binary tree for the presence of numbers in testInternalNums. If the number is found
     * returns true if the number is found in an internal node, otherwise returns false if it's stored as a leaf node or not
     * present in the binary search tree.
     */
    public void problem11() {
        System.out.println("\n-----------");
        System.out.println("|Problem 11|");
        System.out.println("-----------\n");
        int[] isInternalNums = {22,5,37,-10,8,35,14,30,31};
        int[] testInternalNums = {37,14,30,22,-20,35,29};
        Node root = helps.addAll(isInternalNums);
        System.out.println(root);
        for(int testNum : testInternalNums){
            System.out.println("isInternal("+testNum+"): "+ops.isInternal(root, testNum));
        }
    }

    /**
     * Creates a binary tree and checks the binary tree for the presence of numbers in testLeafNums. If the number is found
     * returns true if the number is found in a leaf, otherwise returns false if it's stored as an internal node or not
     * present in the binary search tree.
     */
    public void problem12() {
        System.out.println("\n-----------");
        System.out.println("|Problem 12|");
        System.out.println("-----------\n");
        int[] isLeafNums = {22,5,37,-10,8,35,14,30,31};
        int[] testLeafNums = {37,31,30,22,-10,14,29};
        Node root = helps.addAll(isLeafNums);
        System.out.println(root);
        for(int testNum : testLeafNums){
            System.out.println("isLeaf("+testNum+"): "+ops.isLeaf(root, testNum));
        }
    }

    /**
     * Creates 3 random BSTs and searched for values in the BST between Low and High (5 and 20), adds found
     * values to an array, then prints the array out to console. Loops 3 times to get 3 different random BSTs.
     */
    public void problem13() {
        System.out.println("\n-----------");
        System.out.println("|Problem 13|");
        System.out.println("-----------\n");
        ArrayList<Integer> foundNums;
        int count = 1;
        while (count!=0) {
            Node root = TreeHelpers.randomTree(10);
            int low = 5;
            int high = 20;
            System.out.println(root);
            foundNums = ops.inRange(root, low, high);
            System.out.println("Found in range ["+low+","+high+"]: "+foundNums);
            count--;
        }
    }

    /**
     * Creates random binary trees and passes the root node to the largestbeforeroot() in treeOperations to locate
     * the largest number in the tree which is smaller than the root, then prints the result.
     */
    public void problem14() {
        System.out.println("\n-----------");
        System.out.println("|Problem 14|");
        System.out.println("-----------\n");
        Node root = TreeHelpers.randomTree(11);
        System.out.println(root);
        System.out.println("Largest element smaller than root is: "+ops.largestBeforeRoot(root));

        Node root2 = TreeHelpers.randomTree(21);
        System.out.println(root2);
        System.out.println("Largest element smaller than root is: "+ops.largestBeforeRoot(root2));

        Node root3 = TreeHelpers.randomTree(31);
        System.out.println(root3);
        System.out.println("Largest element smaller than root is: "+ops.largestBeforeRoot(root3));
    }

    /**
     * Creates random binary trees and passes the root node to the smallestAfterRoot() in treeOperations to locate
     * the smallest number in the tree which is larger than the root, then prints the result.
     */
    public void problem15() {
        System.out.println("\n-----------");
        System.out.println("|Problem 15|");
        System.out.println("-----------\n");
        Node root = TreeHelpers.randomTree(11);
        System.out.println(root);
        System.out.println("Smallest element larger than root is: "+ops.smallestAfterRoot(root));

        Node root2 = TreeHelpers.randomTree(21);
        System.out.println(root2);
        System.out.println("Smallest element larger than root is: "+ops.smallestAfterRoot(root2));

        Node root3 = TreeHelpers.randomTree(31);
        System.out.println(root3);
        System.out.println("Smallest element larger than root is: "+ops.smallestAfterRoot(root3));
    }
}