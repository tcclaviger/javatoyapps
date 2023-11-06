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
     * Merges elements from two linked lists into a new list,
     * where elements are alternating between the two lists.
     * <p>
     * Note: You can assume that the lists are of the same length
     *
     * @param first  the head of the first list
     * @param second the head of the second list
     * @return the head reference of the new list
     */
    public Node merge(Node first, Node second) {
        Node currentOne = first;
        Node currentTwo = second;
        Node mergedHead = new Node(currentOne.data);
        currentOne = first.next;
        Node currentThree = mergedHead;
        int index = 1;

        while (currentTwo != null) {
            if (index % 2 == 0) {
                if (currentOne != null) {
                    currentThree.next = new Node(currentOne.data);
                    index++;
                    currentThree = currentThree.next;
                    currentOne = currentOne.next;
                }
            } else {
                currentThree.next = new Node(currentTwo.data);
                index++;
                currentThree = currentThree.next;
                currentTwo = currentTwo.next;
            }
        }
        return mergedHead;
    }

    /**
     * Reports whether a linked list is circular or not.
     *
     * @param head the head reference of a linked list
     * @return returns true if the list is circular or false otherwise
     */
    public boolean isCircular(Node head) {
        Node current = head;
        int size = 0;
        int index = 0;
        do {
            current = current.next;
            size++;
        } while (current != null && current != head);

        current = head;

        while (index < size) {
            if (current == null) {
                return false;
            } else if (current.next == head) {
                return true;
            } else
                current = current.next;
                index++;
        }
        return false;
    }

    /**
     * Returns the element in the central element in a linked list.
     * <p>
     * Note: The central position in a list with an odd number of elements
     * is self-explanatory. For even sized lists, you should pick the
     * lower index at the splitting point.
     * <p>
     * Hint: You will need to first count the number of elements in
     * the list before you can find the middle element. This problem
     * requires multiple traversals of the list
     *
     * @param head the head reference of a linked list
     * @return the element found in the central Node
     */
    public int findMiddle(Node head) {
        Node current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        current = head;
        int midLocation = 0;
        if (size % 2 == 0) {
            midLocation = (size / 2) - 1;
        } else {
            midLocation = size / 2;
        }
        int index = 0;
        while (index <= midLocation - 1) {
            index++;
            current = current.next;
        }
        return current.data;
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
     * Accepts a reference to a linked list of sorted values, then
     * reports whether the elements are in sorted order.
     * <p>
     * Note: To make things easier for this method, you can assume
     * that the list is only working with integer elements.
     *
     * @param head the head reference of the sorted list
     * @return returns true if the list is sorted, or otherwise false
     */
    public boolean isSorted(Node head) {
        Node current = head;
        int currentValue = current.data;
        int lastValue = current.data;

        while (current.next != null) {
            if (currentValue >= lastValue) {
                lastValue = current.data;
                current = current.next;
                currentValue = current.data;
            } else {
                return false;
            }
        }
        if (currentValue < lastValue) {
            return false;
        }
        return true;
    }

    /**
     * Removes the first Node from the linked list and moves
     * it to the end of the list. The new head reference of
     * the list is then returned.
     *
     * @param head the head reference of the list
     * @return the new head reference after moving the front
     * Node to the end of the list
     */
    public Node firstToLast(Node head) {
        int tempStore = head.data;
        head = head.next;
        Node current = head;
        do{
            if (current.next == null){
                current.next = new Node(tempStore);
                current = current.next;
            }
            current = current.next;
        }while(current!=null);
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
     * A recursive method that prints out the elements of a
     * link lists in reverse order. Elements at higher indices
     * should be printed before lower indices in the list.
     *
     * @param head the head reference to a linked list
     */
    public void printBackwards(Node head) {
        Node current = head;
        printBackwards(head, current);
        System.out.println();
    }

    private void printBackwards(Node head, Node current) {
        if (current != null) {
            printBackwards(head, current.next);
            System.out.print(" <- " + current.data);
        }
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

    /**
     * Swaps the positions of two elements in a linked list.
     * <p>
     * Hint: You do not need to adjust any Node references in the list.
     * Only the elements in two Nodes need to be swapped.
     *
     * @param head        the reference to a linked list
     * @param firstIndex  the first index of an element in the list
     * @param secondIndex the second index of an element in the list
     */
    public void swap(Node head, int firstIndex, int secondIndex) {
        int firstValue = 0, secondValue = 0, index = 0;
        Node current = head;
        while (current.next != null) {
            if (index == firstIndex) {
                firstValue = current.data;
            } else if (index == secondIndex) {
                secondValue = current.data;
            }
            current = current.next;
            index++;
        }
        current = head;
        index = 0;
        while (current.next != null) {
            if (index == firstIndex) {
                current.data = secondValue;
            } else if (index == secondIndex) {
                current.data = firstValue;
            }
            current = current.next;
            index++;
        }
    }

    /**
     * Accepts a linked list of integers and returns a partition of
     * the elements in the list around a pivot value. The method returns
     * two linked lists, in an array, where the first linked list has
     * elements found in the input list smaller than the pivot and
     * the second linked list has elements found larger than the pivot.
     * Elements equal to the pivot should be ignored.
     *
     * @param head  the reference to a linked list
     * @param pivot the element to pivot around
     * @return two linked lists in an array
     */
    public Node[] partition(Node head, int pivot) {
        Node headTwo = null;
        Node headThree = null;
        Node current = head;

        //set the first Node in each of the two new lists to a value instead of null
        while (headTwo == null || headThree == null) {
            if (headTwo == null) {
                if (current.data <= pivot) {
                    headTwo = new Node(current.data);
                }
            }
            if (headThree == null) {
                if (current.data > pivot) {
                    headThree = new Node(current.data);
                }
            }
            current = current.next;
        }

        //reset current to head to move through list again from the beginning for remaining elements
        current = head;
        Node currentTwo = headTwo;
        Node currentThree = headThree;

        //set the list node data elements according to problem rules, but omit the first position because it has been done above
        while (current != null) {
            if (current.data < pivot && current.data != currentTwo.data) {
                currentTwo.next = new Node(current.data);
                currentTwo = currentTwo.next;
            } else if (current.data > pivot && current.data != currentThree.data) {
                currentThree.next = new Node(current.data);
                currentThree = currentThree.next;
            }
            current = current.next;
        }

        Node[] pivotedLists = {headTwo, headThree};
        return pivotedLists;
    }

    /**
     * Accepts a linked list and removes the element in the list
     * at the specified position.
     * <p>
     * Note: You can assume that you are given a valid index in the
     * list.
     *
     * @param head  the reference to a linked list
     * @param index the position of an element to remove in the linked list
     * @return the head reference of the list after the removal
     */
    public Node removeAt(Node head, int index) {
        Node current = head;
        int currentIndex = 1;
        if (index == 0) {
            head = head.next;
        } else if (current.next.next != null) {
            while (current.next.next != null) {
                if (currentIndex == index) {
                    current.next = current.next.next;
                }
                currentIndex++;
                current = current.next;
            }
        }
        if (current.next.next == null && index == currentIndex) {
            current.next = null;
        }
        return head;
    }

    /**
     * Accepts a circular linked list and reports whether the list
     * has the same number of elements as the input size value.
     *
     * @param head the reference to a linked list
     * @param size the size value
     * @return returns true if the number of elements in the list is
     * equal to size, otherwise false
     */
    public boolean isSizeAccurate(Node head, int size) {
        Node current = head;
        int sizeCounted = 1;

        if (current.next == head && size == 1) {
            return true;
        }

        while (current.next != head) {
            sizeCounted++;
            current = current.next;
        }

        return sizeCounted == size;
    }
}
