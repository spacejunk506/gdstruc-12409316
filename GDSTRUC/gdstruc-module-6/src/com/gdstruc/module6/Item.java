package com.gdstruc.module6;

import java.util.Objects;

public class Item
{
    private int index;
    private String content;
    private int mass;
    // Other data can be stored here

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return index == item.index &&
                mass == item.mass &&
                Objects.equals(content, item.content);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(index, content, mass);
    }

    @Override
    public String toString()
    {
        return "Item{" +
                "index=" + index +
                ", content='" + content + "\'" +
                ", mass=" + mass +
                '}';
    }

    public Item(int index, String content)
    {
        this.index = index;
        this.content = content;
        this.mass = content.length();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }
}