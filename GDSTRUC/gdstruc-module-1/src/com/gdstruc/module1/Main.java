package com.gdstruc.module1;

public class Main {

    public static void main(String[] args){
        int[] numbers = new int[10];
        setDefaultNumbers(numbers); //Set default values

        // [BUBBLE SORT - DESCENDING]
        System.out.println("\nBUBBLE SORT - DESCENDING");

        System.out.print("  BEFORE:");
        printArrayElements(numbers);            //Show unsorted array

        System.out.print("\n  AFTER: ");
        bubbleSort(numbers, false);   //Bubble sort
        printArrayElements(numbers);            //Show sorted array

        System.out.println("\n  Sorting Process:");     //For Checking
        setDefaultNumbers(numbers);                     //Return to default values
        printArrayElements(numbers);                    //Show unsorted array
        bubbleSort(numbers, true);            //Show sorting process w/ sorted array

        // [SELECTION SORT - DESCENDING]
        System.out.println("\n\nSELECTION SORT - DESCENDING");

        setDefaultNumbers(numbers);         //Return to default values

        System.out.print("  BEFORE:");
        printArrayElements(numbers);        //Show unsorted array

        System.out.print("\n  AFTER: ");
        selectionSort(numbers, false);    //Selection sort
        printArrayElements(numbers);                //Show sorted array

        System.out.println("\n  Sorting Process:");     //For Checking
        setDefaultNumbers(numbers);                     //Return to default values
        printArrayElements(numbers);                    //Show unsorted array
        selectionSort(numbers, true);         //Show sorting process w/ sorted array

        System.out.println(" ");
    }

    private static void bubbleSort(int[] arr, boolean doesCheck)
    {
        for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--)
        {
            for (int i = 0; i < lastSortedIndex; i++)
            {
                if (arr[i] < arr[i + 1])
                {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }

                if (doesCheck)
                {
                    System.out.println(" ");
                    printArrayElements(arr);
                }
            }
        }
    }

    private static void selectionSort(int[] arr, boolean doesCheck)
    {
        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex != 0; lastUnsortedIndex--)
        {
            int smallestIndex = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++)
            {
                if (arr[i] < arr[smallestIndex])
                {
                    smallestIndex = i;
                }
            }

            int temp = arr[lastUnsortedIndex];
            arr[lastUnsortedIndex] = arr[smallestIndex];
            arr[smallestIndex] = temp;

            if (doesCheck)
            {
                System.out.println(" ");
                printArrayElements(arr);
            }
        }
    }

    private static void printArrayElements(int[] arr)
    {
        System.out.print("      ");
        for (int i : arr)
        {
            System.out.print(i + " ");
        }
    }

    private static void setDefaultNumbers(int[] arr)
    {
        arr[0] = 35;
        arr[1] = 69;
        arr[2] = 1;
        arr[3] = 10;
        arr[4] = -50;
        arr[5] = 320;
        arr[6] = 63;
        arr[7] = 50;
        arr[8] = 26;
        arr[9] = 13;
    }
}