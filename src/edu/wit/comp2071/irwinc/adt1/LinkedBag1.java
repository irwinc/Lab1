/**
 Connor Irwin
 comp2071
 adt1
 5/23/2016
 */

package edu.wit.comp2071.irwinc.adt1;

/**
 A class of bags whose entries are stored in a chain of linked nodes.
 The bag is never full.
 @author Frank M. Carrano
 @version 4.0
 */
public class LinkedBag1<T> implements BagInterface<T>
{
    private Node firstNode;       // Reference to first node
    private int numberOfEntries;

    public LinkedBag1()
    {
        firstNode = null;
        numberOfEntries = 0;
    } // end default constructor

    /** Adds a new entry to this bag.
     @param newEntry  The object to be added as a new entry.
     @return  True. */
    public boolean add(T newEntry) // OutOfMemoryError possible
    {
        // Add to beginning of chain:
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;  // Make new node reference rest of chain
        // (firstNode is null if chain is empty)
        firstNode = newNode;       // New node is at beginning of chain
        numberOfEntries++;

        return true;
    } // end add

    /** Retrieves all entries that are in this bag.
     @return  A newly allocated array of all the entries in this bag. */
    public T[] toArray()
    {
        // The cast is safe because the new array contains null entries.
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast

        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
        } // end while

        return result;
        // Note: The body of this method could consist of one return statement,
        // if you call Arrays.copyOf
    } // end toArray

    /** Sees whether this bag is empty.
     @return  True if the bag is empty, or false if not. */
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    } // end isEmpty

    /** Gets the number of entries currently in this bag.
     @return  The integer number of entries currently in the bag. */
    public int getCurrentSize()
    {
        return numberOfEntries;
    } // end getCurrentSize

// STUBS:

    /** Removes one unspecified entry from this bag, if possible.
     @return  Either the removed entry, if the removal
     was successful, or null. */
    public T remove()
    {
        T result = null;
        if (firstNode != null)
        {
            result = firstNode.data;
            firstNode = firstNode.next;
            numberOfEntries--;
        }
        return result; // STUB
    } // end remove

    /** Removes one occurrence of a given entry from this bag.
     @param anEntry  The entry to be removed.
     @return  True if the removal was successful, or false otherwise. */
    public boolean remove(T anEntry)
    {
        if (firstNode != null) //checks if linked list is empty
        {
         Node currentNode = firstNode;
            if (contains(anEntry)) //checks if linked list contains specified item
            {
                for (int i = 0; i < getCurrentSize(); i++) //loops through linked list
                {
                    if (currentNode.data == anEntry) //checks if current node matches specified entry
                    {
                        currentNode.data = firstNode.data;
                        firstNode = firstNode.next;
                        numberOfEntries--;
                        return true;
                    }
                    else
                    {
                        currentNode = currentNode.next;
                    }
                }
            }
        }
        return false;
    } // end remove

    /** Removes all entries from this bag.
     * */
    public void clear()
    {
        while (!isEmpty())
        {
            remove();
        }
        // STUB
    } // end clear

    /** Counts the number of times a given entry appears in this bag.
     @param anEntry  The entry to be counted.
     @return  The number of times anEntry appears in the bag. */
    public int getFrequencyOf(T anEntry)
    {
        Node currentNode = firstNode;
        int count = 0;
        for (int i = 0; i < getCurrentSize(); i++)
        {
            if (currentNode.data == anEntry)
            {
                count++;
            }
            currentNode = currentNode.next;
        }
        return count; // STUB
    } // end getFrequencyOf

    /** Tests whether this bag contains a given entry.
     @param anEntry  The entry to locate.
     @return  True if the bag contains anEntry, or false otherwise. */
    public boolean contains(T anEntry)
    {
        Node currentNode = firstNode;
        for (int i = 0; i < getCurrentSize(); i++)
        {
            if (currentNode.data == anEntry)
            {
                return true;
            }
            else
            {
                currentNode = currentNode.next;
            }
        }
        return false; // STUB
    } // end contains

    private class Node
    {
        private T    data; // Entry in bag
        private Node next; // Link to next node

        private Node(T dataPortion)
        {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        } // end constructor
    } // end Node

    /** Method for testing.
     * */
//    public static void main(String[] args)
//    {
//        //LinkedBag1 bag = new LinkedBag1();
//        LinkedBag1 <String> bag = new LinkedBag1<>();
//        bag.add("banana");
//        bag.add("potato");
//        bag.add("orange");
//        bag.add("carrot");
//        bag.add("banana");
//        bag.add("pineapple");
//        bag.add("banana");
//
//        if (bag.isEmpty()) {
//            System.out.println("The bag is empty.");
//        }
//        else {
//            System.out.println("The bag contains items.");
//        }
//
//        System.out.println("There are " + bag.getCurrentSize() + " item(s) in the bag.");
//        Object[] bagArray = bag.toArray();
//        System.out.print("This bag contain the following items; ");
//
//        for (int i = 0; i < bag.getCurrentSize(); i++)
//        {
//           System.out.print(bagArray[i] + ", ");
//        }
//        System.out.println("\n");
//        System.out.println("Counting bananas.");
//        System.out.println("This bag contains " + bag.getFrequencyOf("banana") + " banana(s).");
//
//        System.out.println("Checking to see if bag contains watermelon.");
//        if (bag.contains("watermelon"))
//        {
//            System.out.println("Bag contains watermelon.");
//        }
//        else
//        {
//            System.out.println("Bag does not contain watermelon. \n");
//        }
//
//        System.out.println("Removing an item from the bag.");
//        System.out.println(bag.remove() + " was removed from the bag.");
//        System.out.print("This bag now contains the following items: ");
//        bagArray = bag.toArray();
//        for (int i = 0; i < bag.getCurrentSize(); i++)
//        {
//            System.out.print(bagArray[i] + ", ");
//        }
//        System.out.println("\n");
//
//        System.out.println("Removing a banana from the bag.");
//        bag.remove("banana");
//        bagArray = bag.toArray();
//        System.out.print("This bag now contains the following items: ");
//        for (int i = 0; i < bag.getCurrentSize(); i++)
//        {
//            System.out.print(bagArray[i] + ", ");
//        }
//        System.out.println("\n");
//
//        System.out.println("Emptying bag.");
//        bag.clear();
//        bagArray = bag.toArray();
//        if (!bag.isEmpty())
//        {
//            System.out.println("ERROR: Bag failed to empty.");
//            System.out.print("ERROR: This bag still contains the following items; ");
//
//            for (int i = 0; i < bag.getCurrentSize(); i++)
//            {
//                System.out.print(bagArray[i] + ", ");
//            }
//            System.out.println();
//            System.exit(-1);
//        }
//        else
//        {
//            System.out.println("Bag is now empty.");
//        }
//
//    } // end main

} // end LinkedBag1
