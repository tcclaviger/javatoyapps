package driver;

import lists.ListHelpers;
import lists.ListOperations;
import lists.Node;
//Problems Assigned are #s:  7, 10, 12, 14, 15
//Problems Assigned for part 2 are #s: 2,3,4,8,13
//Extra: 1,5,6,9,11

/**
 * This class includes informal tests to verify the methods
 * in the ListOperations class.
 *
 * @author Rob Smith
 * @version 1.1
 */
public class ProgramTests {
    private final ListHelpers helpers = new ListHelpers();
    private final ListOperations operations = new ListOperations();

    public static void main(String[] args) {
        ProgramTests tester = new ProgramTests();

        System.out.println("_________");
        System.out.println("Part One:");
        System.out.println("_________\n");
        System.out.println("Problem 7: ");
        tester.problem7();
        System.out.println("\nProblem 10: ");
        tester.problem10();
        System.out.println("\nProblem 12: ");
        tester.problem12();
        System.out.println("\nProblem 14: ");
        tester.problem14();
        System.out.println("\nProblem 15: \n");
        tester.problem15();

        System.out.println("_________");
        System.out.println("Part Two:");
        System.out.println("_________\n");
        System.out.println("\nProblem 2: ");
        tester.problem2();
        System.out.println("\nProblem 3: ");
        tester.problem3();
        System.out.println("\nProblem 4: ");
        tester.problem4();
        System.out.println("\nProblem 8: ");
        tester.problem8();
        System.out.println("\nProblem 13: ");
        tester.problem13();

        System.out.println("_________");
        System.out.println("Extra:");
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
     * Merges to lists into one list while alternating between the lists to build the third list
     */
    public void problem2() {
        int[] mergeOne = {1, 2, 3, 4, 5};
        int[] mergeTwo = {6, 7, 8, 9, 10};
        Node headOne = helpers.createList(mergeOne);
        Node headTwo = helpers.createList(mergeTwo);

        helpers.printList(headOne);
        helpers.printList(headTwo);
        Node mergedHead = operations.merge(headOne, headTwo);
        System.out.println("List After: ");
        helpers.printList(mergedHead);
    }

    /**
     * Checks if a list is a circular list or not and displays the result of the check as a boolean.
     */
    public void problem3() {
        int[] isNotCircularArray = {1, 2, 3, 4, 5};
        Node isNotCircularList = helpers.createList(isNotCircularArray);
        Node isCircularList = helpers.createCircularList(1, 5);

        helpers.printCircularList(isCircularList);
        System.out.println("Circular list? " + operations.isCircular(isCircularList));
        helpers.printList(isNotCircularList);
        System.out.println("Circular list? " + operations.isCircular(isNotCircularList));
    }

    /**
     * Takes a list and returns the element located at the center of the list.
     */
    public void problem4() {
        int[] middleOne = {1, 2, 3, 4, 5, 6, 7};
        int[] middleTwo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Node midListOne = helpers.createList(middleOne);
        Node midListTwo = helpers.createList(middleTwo);

        helpers.printList(midListOne);
        System.out.println("Middle Element - " + operations.findMiddle(midListOne));
        helpers.printList(midListTwo);
        System.out.println("Middle Element - " + operations.findMiddle(midListTwo));
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
     * Creates test lists using arrays as input, prints the list being tested, then returns whether it is in sorted order as true/false
     */
    public void problem7() {
        int[] testArrayNumsOrdered = {1, 2, 3, 4, 5, 6, 7};
        int[] testArrayNumsUnordered = {1, 2, 11, 4, 5, 6, 7};
        Node listOne = helpers.createList(testArrayNumsOrdered);
        Node listTwo = helpers.createList(testArrayNumsUnordered);

        helpers.printList(listOne);
        System.out.println("Sorted? " + operations.isSorted(listOne));
        helpers.printList(listTwo);
        System.out.println("Sorted? " + operations.isSorted(listTwo));
    }

    /**
     * Prints a list in order, then moves the first value to the last position and prints the new list. This test
     * repeats for the length of the list to match requirements.
     */
    public void problem8() {
        int[] moveToLast = {1, 2, 3, 4, 5, 6, 7};
        Node moveToLastHead = helpers.createList(moveToLast);
        helpers.printList(moveToLastHead);
        for (int i = 0; i < moveToLast.length; i++) {
            moveToLastHead = operations.firstToLast(moveToLastHead);
            helpers.printList(moveToLastHead);
        }
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
     * Recursive solution to printing a list in reverse order. Provide a list and it will print last to first.
     */
    public void problem10() {
        int[] reverseList = {1, 2, 3, 4, 5, 6, 7};
        Node rHead = helpers.createList(reverseList);
        helpers.printList(rHead);
        System.out.println("Printing backwards: ");
        operations.printBackwards(rHead);
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

    /**
     * Creates an array of ints, build the list, then swaps list node's data using swap() method in ListOperations
     */
    public void problem12() {

        int[] testArraySwap = {1, 2, 3, 4, 5, 6, 7};
        Node testHead = helpers.createList(testArraySwap);
        helpers.printList(testHead);

        System.out.println("Swapping index 2 and 4");
        operations.swap(testHead, 2, 4);
        helpers.printList(testHead);

        System.out.println("Swapping index 0 and 3");
        operations.swap(testHead, 0, 3);
        helpers.printList(testHead);
    }

    /**
     * Split a list into two lists around a pivot point. List 1 will have values less than pivot and List 2 will have
     * values greater than pivot. Values matching pivot are omitted. An array of lists is returned to primt out.
     */
    public void problem13() {
        int[] pivotArray = {6, 4, 11, 3, 17, 2, 5};
        Node pivotList = helpers.createList(pivotArray);
        helpers.printList(pivotList);

        System.out.println("\nPivot around 9");
        Node[] resultList = operations.partition(pivotList, 9);
        helpers.printList(resultList[0]);
        helpers.printList(resultList[1]);

        System.out.println("\nPivot around 5");
        resultList = operations.partition(pivotList, 5);
        helpers.printList(resultList[0]);
        helpers.printList(resultList[1]);
    }

    /**
     * Creates an array of ints, build the list, then removes a node at a given index and returns list without removed node
     */
    public void problem14() {
        int[] testArrayPop = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node testPop = helpers.createList(testArrayPop);
        helpers.printList(testPop);

        System.out.println("Remove index 0");
        testPop = operations.removeAt(testPop, 0);
        helpers.printList(testPop);

        System.out.println("Remove index 5");
        operations.removeAt(testPop, 5);
        helpers.printList(testPop);

        System.out.println("Remove index 7");
        operations.removeAt(testPop, 7);
        helpers.printList(testPop);
    }

    /**
     * Builds the circular list using createCircularList(), then checks for a size match using isSizeAccurate() method in ListOperations finally prints result
     */
    public void problem15() {
        Node circularHead = helpers.createCircularList(1, 5);
        helpers.printCircularList(circularHead);
        System.out.println("Is size 4? " + operations.isSizeAccurate(circularHead, 4));
        System.out.println("Is size 5? " + operations.isSizeAccurate(circularHead, 5));

        System.out.println();
        Node circularHeadTwo = helpers.createCircularList(1, 10);
        helpers.printCircularList(circularHeadTwo);
        System.out.println("Is size 7? " + operations.isSizeAccurate(circularHeadTwo, 7));
        System.out.println("Is size 10? " + operations.isSizeAccurate(circularHeadTwo, 10));

        //verifies correct count when size is 1
/*        Node circularHeadThree = helpers.createCircularList(0,0);
        helpers.printCircularList(circularHeadThree);
        System.out.println("Is size 0? "+operations.isSizeAccurate(circularHeadThree, 0));
        System.out.println("Is size 1? "+operations.isSizeAccurate(circularHeadThree, 1));*/
    }
}