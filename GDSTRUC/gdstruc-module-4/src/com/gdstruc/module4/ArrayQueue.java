package com.gdstruc.module4;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.NoSuchElementException;

public class ArrayQueue {

    Random random = new Random();

    private Player[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity)
    {
        queue = new Player[capacity];
    }

    public void add(Player player)
    {
        //resizes the array when it's full
        if (back == queue.length)
        {
            Player[] newArray = new Player[queue.length * 2];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }

        queue[back] = player;
        back++;
    }

    public Player remove()
    {
        if (size() == 0)
        {
            throw new NoSuchElementException();
        }

        Player removedPlayer = queue[front];
        queue[front] = null;
        front++;

        if (size() == 0) // Reset trackers when queue is empty
        {
            front = 0;
            back = 0;
        }

        return removedPlayer;
    }

    public Player peek()
    {
        if (size() == 0)
        {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public int size()
    {
        return back - front;
    }

    public void printQueue()
    {
        for (int i = front; i < back; i++)
        {
            System.out.println("\t\t" + queue[i]);
        }
    }

    public int addPlayers(int currentTotalPlayerCount, int amount)
    {
        currentTotalPlayerCount++;
        for (int i = 0; i < amount; i++)
        {
            // Generate a random value for player level
            int randomLevel = random.nextInt(100) + 1;

            this.add(new Player(
                    currentTotalPlayerCount++, // ID
                    createUsername(),   // Generate a username
                    randomLevel)        // Level
            );
        }
        return currentTotalPlayerCount;
    }

    public void removePlayers(int amount)
    {
        for (int i = 0; i < amount; i++)
        {
            System.out.println("\t\t" + this.remove());
        }
    }

    public String createUsername()
    {
        StringBuilder username = new StringBuilder();
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        int cluster = random.nextInt(2) + 1;
        int clusterLength = random.nextInt(5) + 2;

        for (int h = 0; h < cluster; h++)
        {
            for (int i = 0; i < clusterLength; i++)
            {
                if (i == 0)
                {
                    username.append(uppercase.charAt(random.nextInt(uppercase.length())));
                }
                else
                {
                    username.append(lowercase.charAt(random.nextInt(lowercase.length())));
                }
            }
        }

        return username.toString();
    }
}
