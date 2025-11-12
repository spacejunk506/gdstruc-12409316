package com.gdstruc.module2;

public class PlayerLinkedList {
    private PlayerNode head;
    private int size;

    public void addToFront(Player player)
    {
        PlayerNode playerNode = new PlayerNode(player);
        playerNode.setNextPlayer(head);
        head = playerNode;
        size++;
    }

    public void printList()
    {
        PlayerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null)
        {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNextPlayer();
        }
        System.out.println("null");
    }

    public void removeFront()
    {
        if (head == null)
        {
            return;
        }
        Player playerToRemove = head.getPlayer();
        head = head.getNextPlayer();

        updateSize();
    }

    public int getSize()
    {
        return size;
    }

    public void updateSize()
    {
        int updateSize = 0;

        PlayerNode current = head;
        while (current != null)
        {
            current = current.getNextPlayer();
            updateSize++;
        }

        size = updateSize;
    }

    public void printSize()
    {
        System.out.print("(List Size: " + size + ")  ");
    }

    public boolean contains(Player player)
    {
        PlayerNode current = head;
        while (current != null)
        {
            if (current.getPlayer().equals(player))
            {
                return true;
            }
            current = current.getNextPlayer();
        }
        return false;
    }

    public int indexOf(Player player)
    {
        int index = 0;

        PlayerNode current = head;
        while (current != null)
        {
            if (current.getPlayer().equals(player))
            {
                return index;
            }
            current = current.getNextPlayer();
            index++;
        }

        return -1;
    }

    public void printContainsAndIndex(Player player)
    {
        boolean containsPlayer = contains(player);
        int indexOfPlayer = indexOf(player);

        System.out.print("    - This list ");

        if (!containsPlayer)
        {
            System.out.print("does not contain " + player.getName());
        }
        else
        {
            System.out.print("contains " + player.getName() + " at index " + indexOfPlayer);
        }

        System.out.print(".\n");
    }
}
