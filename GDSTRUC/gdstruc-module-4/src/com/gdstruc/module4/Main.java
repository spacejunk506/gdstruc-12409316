package com.gdstruc.module4;

import java.util.Scanner;
import java.util.Random;

public class Main
{
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Initialize ArrayQueue
        ArrayQueue queue = new ArrayQueue(7);

        // Initialize trackers for games created
        int gamesToCreate = 10; // Target amount of games to create
        int gamesCreated = 0;   // Current amount of games made
        boolean hasCreatedGame;

        // Trackers per game creation
        int totalPlayerCount = 0;   // TOTAL amount of players created (for ID)
        int targetPlayerCount = 5;  // TARGET amount of players to create a game
        int currentPlayerCount = 0; // Current amount of players in QUEUE

        int turn = 0;               // To reset to default amount of turns per game
        int currentTurn = turn;     // Current turns taken

        // Loop until the amount of games reaches target amount
        while (gamesCreated < gamesToCreate)
        {
            hasCreatedGame = false;

            // Start a turn while a game has not been created yet
            while (!hasCreatedGame)
            {
                // Display current turn count
                currentTurn++;
                System.out.println(
                        "-----------------------------------------------------------\n\n" +
                        "[TURN: " + currentTurn + "]"
                );

                // Random amount of players queueing
                int randomAmount = random.nextInt(7) + 1;
                totalPlayerCount = queue.addPlayers(totalPlayerCount, randomAmount);

                // Current amount of players in queue
                currentPlayerCount = queue.size();

                // Display players in queue
                System.out.println("\n\tPlayers currently in queue (" + currentPlayerCount + "):");
                queue.printQueue();

                // Check if target player count is reached
                if (currentPlayerCount >= targetPlayerCount)
                {
                    // While it is possible to create a game (e.g. if there are 10 queued players)
                    while (currentPlayerCount >= targetPlayerCount && gamesCreated < gamesToCreate)
                    {
                        System.out.println("\n\t[Target player count reached!]\n");

                        // Display players being dequeued (Game starts)
                        System.out.println("\tCreating a game for five (5) players:");
                        queue.removePlayers(targetPlayerCount);
                        currentPlayerCount = queue.size();

                        // Create a game
                        gamesCreated++;
                    }

                    hasCreatedGame = true;

                    // Display players still in queue
                    System.out.println("\n\tPlayers still in queue (" + currentPlayerCount + "):");
                    if (queue.size() == 0)
                    {
                        System.out.println("\t\tNone");
                    }
                    else
                    {
                        queue.printQueue();
                    }

                }

                // Display amount of games made
                System.out.println("\n[GAMES CREATED: " + gamesCreated + "/" + gamesToCreate + "]");

                if (gamesCreated < gamesToCreate)
                {
                    // Pressing enter ends the turn
                    System.out.println("\nPress ENTER to continue...");
                    scanner.nextLine();
                }
            }

            // After creating one or more game/s
            currentTurn = turn; // Reset turns
        }

        // Terminate the program when 10 games have been made
        System.out.println("\n-----------------------------------------------------------\n");
        System.out.println(gamesCreated + "/" + gamesToCreate + " games have been successfully made!");
        System.out.println("Terminating program...");
        scanner.close();
    }
}