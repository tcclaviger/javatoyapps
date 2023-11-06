package driver;

import lists.ListHelpers;
import lists.ListOperations;
import lists.Node;
//Problems Assigned for extra credit are #s: 1,5,6,9,11

/**
 * This class includes informal tests to verify the methods
 * in the ListOperations class. This is the extra credit portion of the linked lists
 * individual assignment. No outside resources used.
 *
 * @author Rob Smith
 * @version 1.0
 */
public class ProgramTests {
    private final ListHelpers helpers = new ListHelpers();
    private final ListOperations operations = new ListOperations();

    public static void main(String[] args) {
        ProgramTests tester = new ProgramTests();

        System.out.println("_________");
        System.out.println("Extra Credit");
        System.out.println("_________\n");
        System.out.println("\nProblem 1: ");
        tester.problem1();
        System.out.println("\nProblem 5: ");
        tester.problem5();
        System.out.println("\nProblem 6: ");
        tester.problem6();
        System.out.println("\nProblem 9: ");
        tester.problem9();
        System.out.println("\nProblem 11: ");
        tester.problem11();
    }

    /**
     * Merges three linkedLists based on the order passed as parameter to the join method. Returns a single linkedlist
     * that has all elements from the three provided lists in the order provided.
     */
    public void problem1() {
        int[] joinOne = {1, 2, 3, 4};
        int[] joinTwo = {5, 6, 7, 8};
        int[] joinThree = {9, 10, 11, 12};
        Node headOne = helpers.createList(joinOne);
        Node headTwo = helpers.createList(joinTwo);
        Node headThree = helpers.createList(joinThree);

        helpers.printList(headOne);
        helpers.printList(headTwo);
        helpers.printList(headThree);
        Node joinedHead = operations.join(headOne, headTwo, headThree);
        System.out.println("List after:");
        helpers.printList(joinedHead);
    }

    /**
     * Checks a sorted list against a value. The value is then inserted in the list in the location
     * to maintain sorted order and the amended list is returned with the new value added in the correct
     * location.
     */
    public void problem5() {
        int[] testValues = {1, 2, 3, 4, 5, 6, 7};
        int[] insert = {0, 4, 8};
        Node testList = helpers.createList(testValues);
        helpers.printList(testList);

        System.out.println("Inserting " + insert[0]);
        testList = operations.insertSorted(testList, insert[0]);
        helpers.printList(testList);

        System.out.println("Inserting " + insert[1]);
        testList = operations.insertSorted(testList, insert[1]);
        helpers.printList(testList);

        System.out.println("Inserting " + insert[2]);
        testList = operations.insertSorted(testList, insert[2]);
        helpers.printList(testList);
    }

    /**
     * Moves parameter from position located in linked list to be the last element in the linked list.
     */
    public void problem6() {
        int[] testedValues = {1, 2, 3, 4, 5, 6, 7};
        int[] move = {3, 6, 1};
        Node movedList = helpers.createList(testedValues);
        helpers.printList(movedList);

        System.out.println("Moving " + move[0]);
        movedList = operations.moveToEnd(movedList, move[0]);
        helpers.printList(movedList);

        System.out.println("Moving " + move[1]);
        movedList = operations.moveToEnd(movedList, move[1]);
        helpers.printList(movedList);

        System.out.println("Moving " + move[2]);
        movedList = operations.moveToEnd(movedList, move[2]);
        helpers.printList(movedList);
    }

    /**
     * This takes linked lists and removes all duplicate elements from ir.
     */
    public void problem9() {
        int[] testNums = {3, 3, 4, 4, 4, 5, 5, 6, 6, 6, 6, 7, 8, 8};
        Node dupHead = helpers.createList(testNums);
        helpers.printList(dupHead);
        System.out.println("Removing Duplicates:");
        dupHead = operations.removeDuplicates(dupHead);
        helpers.printList(dupHead);
    }

    /**
     * Compares two linked lists elements. If at any point the elements are the same in the same position for both
     * linked lists, it returns false. If the lists are uneven length it returns false.
     */
    public void problem11() {
        int[] listOne = {1, 2, 3, 4, 5, 6, 7};
        int[] listOneCompare = {1, 2, 3, 4, 5, 6, 7};
        int[] listTwo = {1, 2, 3};
        int[] listTwoCompare = {1, 2, 3, 4, 5, 6};
        int[] listThree = {6, 4, 11, 3};
        int[] listThreeCompare = {6, 4, 17, 22};

        Node headOne = helpers.createList(listOne);
        Node headOneCompare = helpers.createList(listOneCompare);
        helpers.printList(headOne);
        helpers.printList(headOneCompare);
        System.out.println("Equal? " + operations.areEqual(headOne, headOneCompare) + "\n");

        Node headTwo = helpers.createList(listTwo);
        Node headTwoCompare = helpers.createList(listTwoCompare);
        helpers.printList(headTwo);
        helpers.printList(headTwoCompare);
        System.out.println("Equal? " + operations.areEqual(headTwo, headTwoCompare) + "\n");

        Node headThree = helpers.createList(listThree);
        Node headThreeCompare = helpers.createList(listThreeCompare);
        helpers.printList(headThree);
        helpers.printList(headThreeCompare);
        System.out.println("Equal? " + operations.areEqual(headThree, headThreeCompare) + "\n");


    }
}