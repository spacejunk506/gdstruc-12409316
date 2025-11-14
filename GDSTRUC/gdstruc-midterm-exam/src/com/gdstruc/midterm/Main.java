package com.gdstruc.midterm;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // Initialize CardStacks
        CardStack playerDeck = new CardStack("PLAYER DECK");
        CardStack playerHand = new CardStack("PLAYER HAND");
        CardStack discardPile = new CardStack("DISCARD PILE");

        // Populate Deck with 30 cards
        playerDeck.populateDeck();

        // Loop while there are still cards in player deck
        while (!playerDeck.isEmpty())
        {
            // Commands are given at random every turn
            int randomNum = (int)(Math.random() * 3);
            switch (randomNum)
            {
                // Draw x cards
                case 0:
                    System.out.println("\n[DRAWING...]");
                    playerHand = playerDeck.moveCardsTo(playerHand);
                    break;
                // Discard x cards
                case 1:
                    System.out.println("\n[DISCARDING...]");
                    discardPile = playerHand.moveCardsTo(discardPile);
                    break;
                // Get x cards from discard pile
                case 2:
                    System.out.println("\n[RETRIEVING...]");
                    playerHand = discardPile.moveCardsTo(playerHand);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + randomNum);
            }

            // Display info at the end of every turn
            playerHand.printDeck();         // List of cards the player is currently holding
            playerDeck.printCardAmount();   // Number of remaining cards in player deck
            discardPile.printCardAmount();  // Number of cards in discard pile

            // End loop immediately when there are no cards left in player deck
            if (playerDeck.isEmpty()) break;

            System.out.print("\n\n[Press any key to continue...]\n > ");
            scanner.nextLine();
            System.out.print("\n-----------------------------------------------------------\n");
        }

        System.out.print("\n\n-----------------------------------------------------------\n");
        System.out.println("\n[END - There are no more cards left to draw from the deck.]");
    }
}