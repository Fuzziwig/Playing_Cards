package input;

import java.util.Arrays;
import java.util.Objects;

/**
 * The type Card that implements Comparable interface for comparing Card objects.
 *
 * @author Jakob Madsen
 * @version 1.0
 */
public class Card implements Comparable<Card>{

    private int id=0;
    private String[] CardTypes = {"Spade","Hearts","Diamond","Clubs" };

    /**
     * Instantiates a new Card.
     */
    public Card(){
        this.id = 0;
    }

    /**
     * Instantiates a new Card.
     *
     * @param id the id of the card
     */
    public Card(int id){
        //card has to be within the 52 defined cards
        if (id>52 || id <1) {
            this.id = 0;
        }
        else {
            this.id = id;
        }
    }

    /**
     * Gets id of the card.
     *
     * @return the id of the card
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets id of the card.
     *
     * @param id the id of the card
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Checks equality of a Card object with another Card.
     *
     * @param c the Object that has to be of type Card
     */
    @Override
    public boolean equals(Object c) {
        if (c == null) { return false; }
        if (c instanceof Card) {
           if (this.getId() == ((Card) c).getId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Overridden toString method for making the full name of card
     */
    @Override
    public String toString() {
        if (this.id==0 || this.id>52) { return ""; }
        int index = (this.id-1)/13;
        String cardPrefix = "";
        String cardPostfix=CardTypes[index];
        index = (this.id-(index*13));

        switch(index) {
            case 1 : cardPrefix = "Ace"; break;
            case 11 : cardPrefix = "Jack"; break;
            case 12 : cardPrefix = "Queen"; break;
            case 13 : cardPrefix = "King"; break;
            default : cardPrefix = Integer.toString(index);
        }
        return cardPrefix+" of "+cardPostfix;
    }

    /**
     * Overridden compareTo for Comparable Interface method
     */
    @Override
    public int compareTo(Card o) {
        return (o.getId()-this.getId());
    }

    /**
     * Is empty boolean to check if card has a value.
     *
     * @return the boolean
     */
    public boolean isEmpty(){
        return this.id==0;
    }
}
