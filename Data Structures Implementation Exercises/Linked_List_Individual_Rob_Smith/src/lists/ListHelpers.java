package lists;

/**
 * This class includes helper methods to create and print
 * singly-linked lists.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class ListHelpers
{
    /**
     * Prints the elements of a linked list that is circular.
     *
     * @param head the head of a linked list
     */
    public void printCircularList(Node head)
    {
        Node current = head;
        if (current != null)
        {
            System.out.print(current.data + " -> ");
            while (current.next != head)
            {
                System.out.print(current.next.data + " -> ");
                current = current.next;
            }
            System.out.println("(back to head)");
        }
    }

    /**
     * Prints the elements of a linked list.
     *
     * @param head the head of a linked list
     */
    public void printList(Node head)
    {
        Node current = head;
        while (current != null)
        {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Creates a singly linked list with the input elements
     * placed in the list.
     *
     * @param elements the list elements
     * @return the head of the new linked list
     */
    public Node createList(int[] elements)
    {
        Node head = new Node(elements[0]);
        Node current = head;
        for (int i = 1; i < elements.length; i++)
        {
            current.next = new Node(elements[i]);
            current = current.next;
        }
        return head;
    }

    /**
     * Creates a linked list with integer elements in the range [min, max].
     *
     * @param min the lower bound for new elements
     * @param max the upper bound for new elements
     * @return the head of the new linked list
     */
    public Node createList(int min, int max)
    {
        Node head = new Node(min);
        Node current = head;
        for (int i = min + 1; i <= max; i++)
        {
            current.next = new Node(i);
            current = current.next;
        }
        return head;
    }

    /**
     * Creates a circular linked list with integer elements in the range [min, max].
     *
     * @param min the lower bound for new elements
     * @param max the upper bound for new elements
     * @return the head of the new linked list
     */
    public Node createCircularList(int min, int max)
    {
        Node head = new Node(min);
        Node current = head;
        for (int i = min + 1; i <= max; i++)
        {
            current.next = new Node(i);
            current = current.next;
        }
        current.next = head;
        return head;
    }
}
