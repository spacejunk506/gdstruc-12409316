package com.gdstruc.module3;

public class Main {

    public static void main(String[] args)
    {
        LinkedStack stack = new LinkedStack();

        // [PUSHING]
        stack.push(new Player(1, "aceu", 100));
        stack.push(new Player(2, "Sinatraa", 100));
        stack.push(new Player(3, "Subroza", 95));
        stack.push(new Player(4, "ploo", 90));
        stack.printStack();

        // [PEEKING]
        System.out.println("\nPEEKING: " + stack.peek() + "\n");
        stack.printStack();

        // [POPPING]
        System.out.println("\nPOPPING: " + stack.pop() + "\n");
        stack.printStack();
    }
}