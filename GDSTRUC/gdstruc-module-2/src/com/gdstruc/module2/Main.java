package com.gdstruc.module2;

public class Main {

    public static void main(String[] args) {

        Player asuna = new Player(1, "Asuna", 100);
        Player lethalBacon = new Player(2, "LethalBacon", 205);
        Player hpDeskJet = new Player(3, "HPDeskjet", 34);

        PlayerLinkedList playerLinkedList = new PlayerLinkedList();

        // Adding player to list
        playerLinkedList.addToFront(asuna);
        playerLinkedList.addToFront(lethalBacon);
        playerLinkedList.addToFront(hpDeskJet);

        // [Removing the first player in the list]
        System.out.println("\nREMOVING FIRST PLAYER");

        System.out.print("  BEFORE: ");     // INITIAL LIST
        playerLinkedList.printSize();       // Size counter
        playerLinkedList.printList();       // Print list elements

        System.out.print("  AFTER:  ");     // UPDATED LIST
        playerLinkedList.removeFront();     // Removed first element
        playerLinkedList.printSize();       // Size counter
        playerLinkedList.printList();       // Print list elements

        // [Testing contains() & indexOf() Functions]
        System.out.println("\nCHECK IF CONTAINS PLAYER & GET INDEX");

        System.out.print("  TEST 1: Check for recently removed player (HPDeskJet)\n");
        playerLinkedList.printContainsAndIndex(new Player(3, "HPDeskjet", 34));

        System.out.print("  TEST 2: Check for player succeeding recently removed (LethalBacon)\n");
        playerLinkedList.printContainsAndIndex(new Player(2, "LethalBacon", 205));
    }
}