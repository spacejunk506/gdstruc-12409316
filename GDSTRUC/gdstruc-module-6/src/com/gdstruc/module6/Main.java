package com.gdstruc.module6;

public class Main
{
    public static void main(String[] args)
    {
        // Create and print numbers array
        int numbers[] = { 60, 33, 12, 64, 17, 105, -53};
        System.out.println("\nNUMBERS ARRAY:");
        printNumbers(numbers);

        // Linear search
        System.out.println("\n\tLINEAR SEARCH");
        System.out.println("\tFor 105: " + linearSearch(numbers, 105));
        System.out.println("\tFor 420: " + linearSearch(numbers, 420));

        // Binary search
        System.out.println("\n\tBINARY SEARCH");
        System.out.println("\tFor 33: " + binarySearch(numbers, 33));
        System.out.println("\tFor 69: " + binarySearch(numbers, 69));

        // [Test for Quiz 5: Your Very Own Search Algorithm] --------------------------------------------------

        // Create and print item list
        System.out.println("\nITEM LIST:");
        ItemList items = new ItemList();
        items.printItemList();

        // Einstein ranking search (Test queries)
        System.out.println("\n\tEINSTEIN FIELD SEARCH");

        // Test 1: EXACT MATCH (Starts at SAME mass, not found immediately)
        System.out.println("\tTest 1 (Not immediate exact match)\n\t\tFor 'Space':"); // Mass: 5
        System.out.println("\t\t\t" + einsteinFieldSearch(items, "Space"));
            // Starts scan at "Human" at index 2 with EQUAL MASS (5)
            // 0 < 1 < (2) > 3 > 4 > 5 > 6! - Found at 6
            // Result: "Space"

        // Test 2: EXACT MATCH (Starts at SAME mass, found immediately)
        System.out.println("\tTest 2 (Immediate exact match)\n\t\tFor 'Time':"); // Mass: 7
        System.out.println("\t\t\t" + einsteinFieldSearch(items, "Time"));
            // Starts scan at "Time" at index 3 with EQUAL MASS (4)
            // 0 < 1 < 2 < !(3)! > 4 > 5 > 6 - Found at 3
            // Result: "Time"

        // Test 3: NON-EXISTENT - SIMILAR MASS (Starts at SAME mass, no matches)
        System.out.println("\tTest 3 (No match, w/ similar mass)\n\t\tFor 'Home':"); // Mass: 4
        System.out.println("\t\t\t" + einsteinFieldSearch(items, "Home"));
            // Starts scan at "Time" at index 3 with SAME MASS (4)
            // 0 < 1 < 2 < (3) > 4 > 5 > 6 - None
            // Result: null

        // Test 4: NON-EXISTENT - EXCEEDING MASS (Start at CLOSEST mass, no matches)
        System.out.println("\tTest 4 (No match, w/o similar mass)\n\t\tFor 'Universe Expansion':"); // Mass: 18
        System.out.println("\t\t\t" + einsteinFieldSearch(items, "Universe Expansion"));
            // Starts scan at "Dark Energy" at index 6 with CLOSEST MASS (11)
            // 0 < 1 < 2 < 3 < 4 < 5 < (6) - None
            // Result: null

        // Test 5: TYPO (Start at CLOSEST mass, no matches)
        System.out.println("\tTest 5 (Typo)\n\t\tFor 'Spacteime':"); // Mass: 18
        System.out.println("\t\t\t" + einsteinFieldSearch(items, "Spacteime"));
            // Starts scan at "Spacetime" at index 0 with CLOSEST MASS (9)
            // (0) > 1 > 2 > 3 > 4 > 5 > 6 - None
            // Result: null

        // Test 6: CASE-SENSITIVE (Start at CLOSEST mass, no matches)
        System.out.println("\tTest 6 (Wrong case)\n\t\tFor 'matter':"); // Mass: 18
        System.out.println("\t\t\t" + einsteinFieldSearch(items, "matter"));
        // Starts scan at "Matter" at index 6 with CLOSEST MASS (10)
        // 0 < 1 < 2 < 3 < 4 < (5) > 6 - None
        // Result: null
    }

    // LINEAR SEARCH
    public static int linearSearch(int[] input, int value)
    {
        for (int i = 0; i < input.length; i++)
        {
            if (input[i] == value)
            {
                return i;
            }
        }

        return -1;
    }

    // BINARY SEARCH
    public static int binarySearch(int[] input, int value)
    {
        int start = 0;
        int end = input.length -1;

        while (start <= end)
        {
            int middle = (start + end) / 2;

            if (input[middle] == value)
            {
                return middle;
            }
            else if (value < input[middle]) // Value might be at left half
            {
                end = middle - 1;
            }
            else if (value > input[middle]) // Value might be at right half
            {
                start = middle + 1;
            }
        }

        return -1;
    }

    public static void printNumbers(int numbers[])
    {
        for (int i = 0; i < numbers.length; i++)
        {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    // EINSTEIN FIELD SEARCH / RADIAL ENERGY SCAN -------------------------------------------------------------

    public static double computeMatchScore(String content, String query)
    {
        if (content.equals(query)) // Case-sensitive
        {
            return 1.0; // Perfect match
        }

        return 0.0; // Not a match
    }

    public static double computeEnergy(int mass, double contentMatch)
    {
        return mass * (contentMatch * contentMatch); // mass * contentMatch^2
    }

    public static Item einsteinFieldSearch(ItemList items, String query)
    {
        // If list is empty, return null
        if (items.getItemList().isEmpty()) return null;

        int queryMass = query.length();
        Item bestMatch = null;
        double bestEnergy = -1;

        // Find closest-mass start index
        int startIndex = 0;
        int smallestDiff = Integer.MAX_VALUE;

        for (int i = 0; i < items.getItemList().size(); i++)
        {
            int itemMass = items.getItemList().get(i).getMass();
            int diff = Math.abs(itemMass - queryMass);
            if (diff < smallestDiff)
            {
                smallestDiff = diff;
                startIndex = i;
            }
        }

        // Radial scan (left and right)
        int left = startIndex;
        int right = startIndex + 1;

        while (left >= 0 || right < items.getItemList().size())
        {
            // Left scan
            if (left >= 0)
            {
                Item item = items.getItemList().get(left);
                int mass = item.getMass();

                if (mass < bestEnergy && bestEnergy > 0)
                {
                    left = -1; // Early stop left scan
                }
                else
                {
                    double contentMatch = computeMatchScore(item.getContent(), query);
                    if (contentMatch == 1.0)
                    {
                        double energy = computeEnergy(item.getMass(),contentMatch);
                        if (energy > bestEnergy)
                        {
                            bestEnergy = energy;
                            bestMatch = item;
                        }
                    }
                    left--;
                }
            }

            // Right scan
            if (right < items.getItemList().size())
            {
                Item item = items.getItemList().get(right);
                int mass = item.getMass();

                if (mass < bestEnergy && bestEnergy > 0)
                {
                    right = items.getItemList().size(); // Early stop right scan
                }
                else
                {
                    double contentMatch = computeMatchScore(item.getContent(), query);
                    if (contentMatch == 1.0)
                    {
                        double energy = computeEnergy(item.getMass(), contentMatch);
                        if (energy > bestEnergy)
                        {
                            bestEnergy = energy;
                            bestMatch = item;
                        }
                    }
                    right++;
                }
            }
        }
        return bestMatch;
    }
}