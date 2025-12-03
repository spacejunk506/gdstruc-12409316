package com.gdstruc.module7;

public class Main
{
    public static void main (String[] args)
    {
        // Initialize tree
        Tree tree = new Tree();

        // Add nodes to tree
        tree.insert(25);
        tree.insert(17);
        tree.insert(29);
        tree.insert(10);
        tree.insert(16);
        tree.insert(-5);
        tree.insert(60);
        tree.insert(55);

        // Traverse the tree in ASCENDING order
        System.out.println("\nTraversing in Order (ASCENDING)");
        tree.traverseInOrder();

        // Getting node with the MINIMUM value in the tree
        System.out.println("\nGetting node with MINIMUM value\n\t" + tree.getMin());

        // Getting node with tje MAXIMUM value in the tree
        System.out.println("\nGetting node with MAXIMUM value\n\t" + tree.getMax());

        // Traverse the tree in DESCENDING order
        System.out.println("\nTraversing in Order (DESCENDING)");
        tree.traverseInOrderDescending();
    }
}