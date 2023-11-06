package trees;

import trees.nodes.DictionaryNode;
import trees.nodes.Node;
import trees.nodes.StringNode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This class contains a group of tree operations.
 *
 * @author Josh Archer
 * @author Rob Smith
 * @version 1.0
 */
public class TreeOperations {
    /**
     * #1 - Inverts the elements in a binary search tree. An inverted
     * tree is tree that contains the same elements as another
     * tree, but the elements are mirrored horizontally. For example:
     * <p>
     * Binary tree:
     * 22
     * /   \
     * 9    25
     * /  \     \
     * 2    15   31
     * <p>
     * Inverted tree:
     * 22
     * /    \
     * 25    9
     * /     /  \
     * 31    15   2
     *
     * @param root the root of a binary tree
     */
    public void invert(Node root) {
        if (root != null) {
            invert(root.left);
            invert(root.right);
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }

    /**
     * #2 - Searches for an element in a binary tree and
     * prints the elements found during the search, from
     * the bottom of the tree back to the root.
     * <p>
     * For example, given the following tree:
     * <p>
     * 22
     * /   \
     * 9    25
     * /  \     \
     * 2    15   31
     * <p>
     * Searching for element 15 will print out - 15, 9, 22
     * <p>
     * Hint: A Stack can be used to print the elements in reverse
     * order.
     *
     * @param root        the root of a binary search tree
     * @param searchValue the element to search for
     */
    public void bottomUpPath(Node root, int searchValue) {
        Stack<Integer> path = new Stack<>();
        bottomUpPath(root, searchValue, path);
        if (path.peek() == searchValue) {
            for (int i = path.size()-1; i >= 0; i--) {
                System.out.println(path.pop());
            }
        } else{
            System.out.println("Search value not found.");
        }
    }

    private void bottomUpPath(Node current, int searchValue, Stack<Integer> path) {
        if (current.data == searchValue) {
            path.add(current.data);
            return;
        } else if (current.data > searchValue && current.left != null) {
            path.add(current.data);
            bottomUpPath(current.left, searchValue, path);
        }else if (current.data < searchValue && current.right !=null){
            path.add(current.data);
            bottomUpPath(current.right, searchValue, path);
        }else{
            return;
        }
    }

    /**
     * #3 - This method returns the Level-Order (or Breadth-First) search
     * on a tree. This method returns an array list of elements in the
     * tree, level by level through the tree from top to bottom. For
     * example, given the following tree:
     * <p>
     * 22
     * /   \
     * 9    25
     * /  \     \
     * 2    15   31
     * <p>
     * would return the list: [22, 9, 25, 2, 15, 31]
     *
     * @param root the root of a binary tree
     * @return a list of elements in the input tree
     */
    public ArrayList<Integer> bfs(Node root) {
        Queue<Node> bfsQueue = new LinkedList<>();
        ArrayList<Integer> traversal = new ArrayList<>();
        bfsQueue.add(root);
        while (bfsQueue.size() > 0) {
            Node next = bfsQueue.remove();
            traversal.add(next.data);
            if (next.left != null) {
                bfsQueue.add(next.left);
            }
            if (next.right != null) {
                bfsQueue.add(next.right);
            }
        }
        return traversal;
    }

    /**
     * #4 - Identifies the elements in the internal nodes of a binary
     * tree and returns them in a list. For example, given the following
     * tree:
     * <p>
     * 22
     * /   \
     * 9    25
     * /  \     \
     * 2    15   31
     * <p>
     * would return the list: [22, 9, 25] in any order
     *
     * @param root the root of a binary tree
     * @return a list of elements from internal nodes in the tree
     */
    public ArrayList<Integer> getInternalNodes(Node root) {
        ArrayList<Integer> listInternals = new ArrayList<>();
        getInternalNodes(root, listInternals);
        return listInternals;
    }

    private void getInternalNodes(Node root, ArrayList<Integer> list) {
        if (root.left != null) {
            list.add(root.data);
            getInternalNodes(root.left, list);
        }
        if (root.right!=null){
            if(!list.contains(root.data)){
                list.add(root.data);
            }
            getInternalNodes(root.right, list);
        }
    }

    /**
     * Identifies the elements in the leaf nodes of a binary tree
     * and returns them in a list. For example, given the following
     * tree:
     * <p>
     * 22
     * /   \
     * 9    25
     * /  \     \
     * 2    15   31
     * <p>
     * would return the list: [2, 15, 31] in any order
     *
     * @param root the root of a binary tree
     * @return a list of elements from leaf nodes in the tree
     */
    public ArrayList<Integer> getLeafNodes(Node root) {
        ArrayList<Integer> leafNodes = new ArrayList<>();
        getLeafNodes(root, leafNodes);
        return leafNodes;
    }

    private void getLeafNodes(Node root, ArrayList<Integer> leafNodes){
        if (root==null){
            return;
        }else if (root.left == null && root.right == null){
            leafNodes.add(root.data);
        }
        if(root.left !=null){
            getLeafNodes(root.left, leafNodes);
        }
        if(root.right!=null){
            getLeafNodes(root.right, leafNodes);
        }
    }

    /**
     * #6 - Adds a word/definition pair to a binary tree of DictionaryNode objects
     * that are sorted using the word.
     *
     * @param root       the root of a binary search tree
     * @param word       a dictionary word
     * @param definition the definition of the word
     */
    public DictionaryNode addWordToTree(DictionaryNode root, String word, String definition) {
        if (word.compareTo(root.word) < 0 && root.left != null) {
            addWordToTree(root.left, word, definition);
        } else if (word.compareTo(root.word) < 0) {
            root.left = new DictionaryNode(word, definition);
        } else if (word.compareTo(root.word) > 0 && root.right != null) {
            addWordToTree(root.right, word, definition);
        } else {
            root.right = new DictionaryNode(word, definition);
        }
        return root;
    }

    /**
     * Accepts a dictionary node and searches the tree for the definition
     * matching the word.
     *
     * @param root the root of a binary search tree with word/definition pairs
     * @param word the word to search for
     * @return the definition of the word, stored in the tree, or null if the
     * word is not in the tree
     */
    public String getDefinition(DictionaryNode root, String word) {
        if (root != null) {
            if (word.compareTo(root.word) == 0) {
                return root.definition;
            } else if (word.compareTo(root.word) < 0) {
                return getDefinition(root.left, word);
            } else {
                return getDefinition(root.right, word);
            }
        }
        return " null.";
    }

    /**
     * #7 - Returns the smallest element in the tree.
     *
     * @param root the root of the binary search tree
     * @return the minimum element
     */
    public int findMin(Node root) {
        List<Integer> traversal = new ArrayList<>();
        findMin(root, traversal);
        return traversal.get(0);
    }

    private void findMin(Node current, List<Integer> traversal) {
        if (current != null) {
            findMin(current.left, traversal);
            traversal.add(current.data);
            findMin(current.right, traversal);
        }
    }

    /**
     * #7 - Returns the largest element in the tree.
     *
     * @param root the root of the binary search tree
     * @return the maximum element
     */
    public int findMax(Node root) {
        List<Integer> traversal = new ArrayList<>();
        findMax(root, traversal);
        return traversal.get(traversal.size() - 1);
    }

    private void findMax(Node current, List<Integer> traversal) {
        if (current != null) {
            findMax(current.left, traversal);
            traversal.add(current.data);
            findMax(current.right, traversal);
        }
    }

    /**
     * #8 - Creates a binary search tree of StringNode objects
     * that stores movie titles from an input file. The movie
     * elements are read in sorted order, but then shuffled
     * into random positions before insertion into the tree.
     *
     * @return a root of a random binary search tree of 250
     * movie titles.
     */
    public StringNode createMovieTree() {
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner reader = new Scanner(new FileInputStream(("./Files/movies.txt")))) {
            while (reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error reading from file " + ex.getMessage());
        }
        Collections.shuffle(lines);
        StringNode root = new StringNode(lines.get(0));
        for (String line : lines) {
            iterativeAdd(root, line);
        }
        return root;
    }

    private static StringNode iterativeAdd(StringNode current, String element) {
        boolean added = false;
        do {
            if (element.compareTo(current.data) == 0) {
                return current;
            } else if (element.compareTo(current.data) < 0 && current.left != null) {
                current = current.left;
            } else if (element.compareTo(current.data) < 0) {
                added = true;
                current.left = new StringNode(element);
            } else if (element.compareTo(current.data) > 0 && current.right != null) {
                current = current.right;
            } else {
                added = true;
                current.right = new StringNode(element);
            }
        } while (!added);
        return current;
    }
    /**
     * #9 - This method uses loops (rather than recursion) to add
     * the input element to a binary search tree.
     *
     * @param root    the root of a binary search tree
     * @param element the element to insert into the tree
     */
    public Node iterativeAdd(Node root, int element) {
        Node current = root;
        while (true) {
            if (current.data == element) {
                return current;
            } else if (current.data > element && current.left == null) {
                return current.left = new Node(element);
            } else if (current.data < element && current.right == null) {
                return current.right = new Node(element);
            } else if (current.data > element) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
    }

    /**
     * #10 - This method uses loops (rather than recursion) to search
     * for the input element in a binary search tree.
     *
     * @param root    the root of a binary search tree
     * @param element the element to insert into the tree
     * @return true if the element is found, or otherwise false
     */
    public boolean iterativeContains(Node root, int element) {
        Node current = root;
        int num = root.data;
        while (num != element) {
            if (current.data < element && current.right != null) {
                current = current.right;
                num = current.data;
            } else if (current.data > element && current.left != null) {
                current = current.left;
                num = current.data;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * #11 - Searches for an element in the input tree and returns
     * true if the element is found in an internal node in the tree.
     *
     * @param root    the root of a binary search tree
     * @param element the element to search for
     * @return false if the element is not found or is not located in
     * an internal node, or otherwise false
     */
    public boolean isInternal(Node root, int element) {
        return false;
    }

    /**
     * #12 - Searches for an element in the input tree and returns
     * true if the element is found in a leaf node in the tree.
     *
     * @param root    the root of a binary search tree
     * @param element the element to search for
     * @return false if the element is not found or is not located in
     * a leaf node, or otherwise false
     */
    public boolean isLeaf(Node root, int element) {
        Node current = root;
        if (root == null) {
            return false;
        } else if (current.data == element && (current.left == null && current.right == null)) {
            return true;
        } else if (element > current.data) {
            if (current.right != null) {
                return isLeaf(current.right, element);
            }
        } else if (current.left != null) {
            return isLeaf(current.left, element);
        }
        return false;
    }

    /**
     * #13 - Finds all elements in the tree within the specified bounds
     * (inclusive) and returns them in a list.
     *
     * @param root the root of a binary search tree
     * @param low  the low bound
     * @param high the high bound
     * @return a list of elements in the range [low, high]
     */
    public ArrayList<Integer> inRange(Node root, int low, int high) {
        ArrayList<Integer> foundNums = new ArrayList<>();
        inRange(root, low, high, foundNums);
        return foundNums;
    }

    private void inRange(Node root, int low, int high, ArrayList<Integer> foundNums) {
        if (root == null){
            return;
        }else if (root.data >= low && root.data <= high) {
            foundNums.add(root.data);
            inRange(root.left, low, high, foundNums);
            inRange(root.right, low, high, foundNums);
        } else if (root.data <= high){
            inRange(root.right, low, high, foundNums);
        } else{
            inRange(root.left, low, high, foundNums);
        }
    }

    /**
     * #14 - Finds the largest element that is smaller than the root element. If no elements
     * are smaller than the root, then the root is returned instead.
     *
     * @param root the root of a binary search tree
     * @return the largest element in the tree that is also smaller than the root, or the
     * root if there are no elements smaller than the root
     */
    public int largestBeforeRoot(Node root) {
        if (root.left == null) {
            return root.data;
        } else if (root.left.right == null) {
            return root.left.data;
        }
        return largestBeforeRoot(root.left, 0);
    }

    private int largestBeforeRoot(Node current, int num) {
        if (current.right != null) {
            return largestBeforeRoot(current.right, num);
        }
        return current.data;
    }

    /**
     * #15 - Finds the smallest element that is larger than the root element. If no elements
     * are larger than the root, then the root is returned instead.
     *
     * @param root the root of a binary search tree
     * @return the smallest element in the tree that also is larger than the root, or the
     * root if there are no elements larger than the root
     */
    public int smallestAfterRoot(Node root) {
        if (root.right == null) {
            return root.data;
        } else if (root.right.left == null) {
            return root.right.data;
        }
        return smallestAfterRoot(root.right, 0);
    }

    private int smallestAfterRoot(Node current, int num) {
        if (current.left != null) {
            return smallestAfterRoot(current.left, num);
        }
        return current.data;
    }
}
