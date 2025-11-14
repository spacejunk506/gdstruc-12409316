package com.gdstruc.midterm;

import java.util.Objects;

public class Card
{
    private int cardId;
    private String suit;
    private int rank;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cardId == card.cardId &&
                rank == card.rank &&
                Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(cardId, suit, rank);
    }

    @Override
    public String toString()
    {
        String rankString = String.valueOf(rank);

        switch (rank)
        {
            case 1:
                rankString += "st";
                break;
            case 2:
                rankString += "nd";
                break;
            case 3:
                rankString += "rd";
                break;
            default:
                rankString += "th";
        }

        return rankString + " of " + suit;
    }

    public Card(int cardId, String suit, int rank)
    {
        this.cardId = cardId;
        this.suit = suit;
        this.rank = rank;
    }

    public int getCardId() { return cardId; }

    public void setCardId(int cardId) {  this.cardId = cardId; }

    public String getCardSuit() { return suit; }

    public void setCardSuit(String suit) { this.suit = suit; }

    public int getCardRank() { return rank; }

    public void setCardRank(int rank) { this.rank = rank; }
}
