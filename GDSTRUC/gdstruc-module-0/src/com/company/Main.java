package com.company;

public class Main {

    public static void main(String[] args) {

        int[] numbers = new int[5];

        numbers[0] = 90;
        numbers[1] = 85;
        numbers[2] = -15;
        numbers[3] = 50;
        numbers[4] = 105;

        int index = -1;

        for (int i = 0; i < numbers.length; i++)
        {
            if (numbers[i] == 50)
            {
                index = i;
                break;
            }
        }

        System.out.println(index);
    }
}