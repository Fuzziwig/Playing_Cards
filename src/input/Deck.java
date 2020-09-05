package input;

import java.util.*;
import java.util.function.Consumer;

/**
 * The type Deck that implements Iterable interface for iterating over Cards in the Deck.
 *
 * @author Jakob Madsen
 * @version 1.0
 */
public class Deck implements Iterable<Card>{

    private List<Card> Cards = new ArrayList<>();
    private int cardAmount = 52;

    /**
     * Instantiates a new Deck.
     */
    public Deck (){
        for (int i = 0; i<this.cardAmount;i++){
            this.Cards.add(new Card(i+1));
        }
    }

    /**
     * Shuffle cards.
     */
    public void shuffleCards(){
        Random rand = new Random();
        int tmp = 0;
        for (Card c : this.Cards){
            int shuffleindex = rand.nextInt(52);
            tmp = c.getId();
            c.setId(this.Cards.get(shuffleindex).getId());
            this.Cards.get(shuffleindex).setId(tmp);
        }
    }

    /**
     * Draw top card card.
     *
     * @return the card
     */
    public Card drawTopCard(){
        Card drawCard = new Card();
        for (Card c : this.Cards){
            if (c.getId()!=0) {
                drawCard = c;
                this.Cards.remove(0);
                break;
            }
        }
        return drawCard;
    }

    /**
     * Cards left int.
     *
     * @return the int for how many Card objects are left in the Deck
     */
    public int cardsLeft(){
        int counter  = 0;
        for (Card c : this.Cards){
            if (c.getId()!=0) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Checks equality of a Deck object with another Deck.
     *
     * @param d the Object that has to be of type Deck
     * The two Deck objects are iterated over and Card equals method is used to compare every Card Object
     */
    @Override
    public boolean equals(Object d) {
        if (d == null) { return false; }
        if (d instanceof Deck) {
            if (this.Cards.size()==((Deck) d).Cards.size()) {
                Iterator<Card> c1 = this.Cards.iterator();
                Iterator<Card> c2 = ((Deck) d).Cards.iterator();

                while (c1.hasNext() && c2.hasNext()){
                    if (!c1.next().equals(c2.next())) {
                        return false;
                    }
                }
            }
        }
        else return false;
        return true;
    }

    /**
     * Overridden toString method for making a String with all the Card objects in the Deck
     */
    @Override
    public String toString() {
        return "Deck{" +
                "Cards=" + Cards +
                '}';
    }

    @Override
    public Iterator<Card> iterator() {
        return Cards.iterator();
    }

    @Override
    public void forEach(Consumer<? super Card> action) {

    }

    @Override
    public Spliterator<Card> spliterator() {
        return null;
    }

}