package com.gdstruc.midterm;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class CardStack
{
    private final LinkedList<Card> stack;
    private final String stackName;

    public CardStack(String stackName)
    {
        stack = new LinkedList<>();
        this.stackName = stackName;
    }

    public void push(Card card) { stack.push(card); }

    public boolean isEmpty() { return stack.isEmpty(); }

    public Card pop() { return stack.pop(); }

    public Card peek() { return stack.peek(); }

    public void populateDeck()
    {
        if (!isEmpty()) { return; }

        int id = 1;

        for (int i = 1; i <= 3; i++)
            for (int rank = 1; rank <= 10; rank++)
            {
                String suit = switch (i)
                {
                    case 1 -> "Space";
                    case 2 -> "Time";
                    case 3 -> "Matter";
                    default -> throw new IllegalStateException("Unexpected value: " + i);
                };

                stack.push(new Card(id, suit, rank));
                id++;
            }
    }

    public void printDeck()
    {
        ListIterator<Card> iterator = stack.listIterator();
        System.out.println("\nList of cards in " + stackName + " (" + stack.size() + "):");
        if (this.isEmpty())
        {
            System.out.println("(There are no cards in " + stackName + ".)");
            return;
        }
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }

    public CardStack moveCardsTo(CardStack newStack)
    {
        if (this.isEmpty())
        {
            System.out.println(stackName + " has no cards...");
        }

        Random random = new Random();
        int amountToMove = random.nextInt(5) + 1;
        int amountMoved = 0;

        for (int i = 1; i <= amountToMove; i++)
        {
            if (this.isEmpty())
            {
                break;
            }
            newStack.push(this.pop());
            amountMoved++;
        }

        notifyCardsMoved(amountMoved);

        return newStack;
    }

    public void notifyCardsMoved(int amountMoved)
    {
        String cardOrCards = " card";
        if (amountMoved != 1) { cardOrCards += "s were "; }
        else { cardOrCards += " was "; }

        String action = switch (stackName)
        {
            case "PLAYER DECK" -> "drawn";
            case "PLAYER HAND" -> "discarded";
            case "DISCARD PILE" -> "retrieved";
            default -> throw new IllegalStateException("Unexpected value: " + stackName);
        };
        System.out.println(amountMoved + cardOrCards + action + ".");
    }

    public void printCardAmount()
    {
        System.out.print("\nNumber of cards in " + stackName + ": " + stack.size());
    }
}
