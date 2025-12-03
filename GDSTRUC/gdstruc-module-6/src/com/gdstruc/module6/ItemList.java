package com.gdstruc.module6;

import java.util.ArrayList;
import java.util.List;

public class ItemList
{
    private List<Item> itemList;

    public ItemList()
    {
        itemList = new ArrayList<>();

        itemList.add(new Item(0, "Spacetime")); // Mass of 9
        itemList.add(new Item(1, "Dark Energy")); // Mass of 11
        itemList.add(new Item(2, "Human")); // Mass of 5
        itemList.add(new Item(3, "Time")); // Mass of 4
        itemList.add(new Item(4, "Antimatter")); // Mass of 10
        itemList.add(new Item(5, "Matter")); // Mass of 6
        itemList.add(new Item(6, "Space")); // Mass of 5
    }

    public List<Item> getItemList()
    {
        return itemList;
    }

    public void printItemList()
    {
        for (int i = 0; i < itemList.size(); i++)
        {
            System.out.println(itemList.get(i).getIndex() + " - " + itemList.get(i));
        }
    }
}
