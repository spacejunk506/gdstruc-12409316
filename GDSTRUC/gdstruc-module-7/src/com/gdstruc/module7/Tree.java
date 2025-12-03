package com.gdstruc.module7;

import java.util.NoSuchElementException;

public class Tree
{
    private Node root;

    public Node get(int value)
    {
        if (root != null)
        {
            return root.get(value);
        }
        return null;
    }

    public Node getMin()
    {
        if (root == null)
        {
            throw new NoSuchElementException();
        }

        // Follow to the left to get the lowest value
        Node currentMin = root;
        while (currentMin.getLeftChild() != null)
        {
            currentMin = currentMin.getLeftChild();
        }

        return currentMin;
    }

    public Node getMax()
    {
        if (root == null)
        {
            throw new NoSuchElementException();
        }

        // Follow to the right to get the highest value
        Node currentMax = root;
        while (currentMax.getRightChild() != null)
        {
            currentMax = currentMax.getRightChild();
        }

        return currentMax;
    }

    public void insert(int value)
    {
        if (root == null)
        {
            root = new Node(value);
        }
        else
        {
            root.insert(value);
        }
    }

    public void traverseInOrder()
    {
        if (root != null)
        {
            root.traverseInOrder();
        }
    }

    public void traverseInOrderDescending()
    {
        if (root != null)
        {
            root.traverseInOrderDescending();
        }
    }
}
