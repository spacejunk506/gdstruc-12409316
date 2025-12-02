package com.gdstruc.module5;

public class Main
{
    public static void main(String[] args)
    {
        // Create players
        Player ploo = new Player(134, "Plooful", 135);
        Player wardell = new Player(536, "TSM Wardell", 640);
        Player deadlyJimmy = new Player(32, "DeadlyJimmy", 34);
        Player subroza = new Player(4931, "Subroza", 604);
        Player annieDro = new Player(6919, "C9 Annie", 593);

        // Initialize hashtable and store players
        SimpleHashtable hashtable = new SimpleHashtable();
        hashtable.put(ploo.getUserName(), ploo);
        hashtable.put(wardell.getUserName(), wardell);
        hashtable.put(deadlyJimmy.getUserName(), deadlyJimmy);
        hashtable.put(subroza.getUserName(), subroza);
        hashtable.put(annieDro.getUserName(), annieDro);

        // Display initial hashtable
        System.out.println("\nBEFORE REMOVAL:");
        hashtable.printHashtable();

        // Remove an element from hashtable
        System.out.println("\nREMOVE TEST #1: Removing Subroza");
        hashtable.remove("Subroza");
        hashtable.printHashtable();

        // Check if element still exists
        System.out.println("\nREMOVE TEST #2: Check if Subroza still exists");
        System.out.println("Result: " + hashtable.get("Subroza"));
    }
}