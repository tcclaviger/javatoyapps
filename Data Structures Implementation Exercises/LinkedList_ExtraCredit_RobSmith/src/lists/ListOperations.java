package lists;

/**
 * This class contains a group of linked list operations
 *
 * @author Josh Archer
 * @author Rob Smith
 * @version 1.0
 */
public class ListOperations {
    private final ListHelpers helpers = new ListHelpers();

    /**
     * Joins together three linked lists into a single linked
     * list. The elements in the first list come first, then
     * the elements in the second, and finally the elements in
     * the third list.
     *
     * @param first  the head of the first list
     * @param second the head of the second list
     * @param third  the head of the third list
     * @return the head reference of the new list
     */
    public Node join(Node first, Node second, Node third) {
        Node currentOne = first;
        Node currentTwo = second;
        Node currentThree = third;
        Node joinedHead = new Node(currentOne.data);
        currentOne = currentOne.next;
        Node currentJoined = joinedHead;

        while (currentOne != null) {
            currentJoined.next = new Node(currentOne.data);
            currentOne = currentOne.next;
            currentJoined = currentJoined.next;
        }
        while (currentTwo != null) {
            currentJoined.next = new Node(currentTwo.data);
            currentTwo = currentTwo.next;
            currentJoined = currentJoined.next;
        }
        while (currentThree != null) {
            currentJoined.next = new Node(currentThree.data);
            currentThree = currentThree.next;
            currentJoined = currentJoined.next;
        }
        return joinedHead;
    }

    /**
     * Accepts a list of sorted elements in linked list nodes
     * and inserts a new value into the list in sorted order.
     * <p>
     * Note: To make things easier for this method, you can assume
     * that the list is only working with integer elements.
     *
     * @param head the head of a sorted linked list, each element in
     *             the list should store an integer
     * @return returns the head of the linked list after the insert
     * has completed
     */
    public Node insertSorted(Node head, int newValue) {
        Node insertedHead;
        if (head.data >= newValue) {
            insertedHead = new Node(newValue);
            insertedHead.next = head;
            return insertedHead;
        } else {
            Node current = head;
            while (current.next != null) {
                if (current.data == newValue) {
                    Node newValueNode = new Node(newValue);
                    newValueNode.next = current.next;
                    current.next = newValueNode;
                    current = current.next.next;
                } else {
                    current = current.next;
                }
            }
            if (current.data < newValue) {
                Node newValueNode = new Node(newValue);
                current.next = newValueNode;
                newValueNode.next = null;
                return head;
            } else {
                return head;
            }
        }
    }

    /**
     * Finds the first occurrence of an element in the linked list,
     * then removes the Node containing that element and moves the
     * Node to the end of the list.
     * <p>
     * Note: You can assume that the search value exists somewhere
     * in the list.
     * Note: This method should only move the first occurrence of
     * the search value when found.
     *
     * @param head        the head reference of a linked list
     * @param searchValue the element to search for
     * @return returns the head of the list after the element has
     * moved
     */
    public Node moveToEnd(Node head, int searchValue) {
        int tempStore = 0;
        Node current = head;
        if (head.data == searchValue) {
            tempStore = head.data;
            head = head.next;
            current = head;
        }
        do {
            if (current.next.data == searchValue) {
                tempStore = current.next.data;
                current.next = current.next.next;
            }
            current = current.next;
        } while (current.next != null);
        current.next = new Node(tempStore);
        return head;
    }

    /**
     * Accepts a linked list of sorted elements and removes
     * all duplicate elements from the list.
     * <p>
     * Note: To make things easier for this method, you can assume
     * that the list is only working with integer elements.
     *
     * @param head the head reference of the linked list
     * @return returns the head reference of the list after removing
     * all duplicate elements
     */
    public Node removeDuplicates(Node head) {
        Node current = head;
        while (current.next != null) {
            if (current.data != current.next.data) {
                current = current.next;
            } else {
                current.next = current.next.next;
            }
        }
        return head;
    }

    /**
     * Reports whether two linked lists contain the same elements
     * at the same positions in each list.
     *
     * @param first  the reference to the first linked list
     * @param second the reference to the second linked list
     * @return returns true if both lists contain the same elements
     * at the same positions in each list, otherwise it returns false
     * <p>
     * Note: Comparisons between elements should be made using
     * the equals() method.
     */
    public boolean areEqual(Node first, Node second) {
        Node currentOne = first;
        Node currentTwo = second;
        while (currentTwo != null && currentOne != null) {
            if (currentOne.data != currentTwo.data) {
                return false;
            } else {
                currentOne = currentOne.next;
                currentTwo = currentTwo.next;
            }
        }
        return (currentOne == null && currentTwo == null);
    }
}
