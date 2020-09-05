package input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void shuffleCards() {
        Deck d1 = new Deck();
        Deck d2 = new Deck();
        d1.shuffleCards();
        assertFalse(d1.equals(d2));
    }

    @Test
    void drawTopCard() {
        Deck d = new Deck();
        Card c = d.drawTopCard();
        Card t = new Card(1);
        assertTrue(c.equals(t));
    }

    @Test
    void cardsLeft() {
        Deck d = new Deck();
        assertTrue(d.cardsLeft()==52);
        d.drawTopCard();
        assertTrue(d.cardsLeft()==51);
    }

    @Test
    void testEquals() {
        Deck d1 = new Deck();
        Deck d2 = new Deck();
        assertTrue(d1.equals(d2));
        d1.shuffleCards();
        assertFalse(d1.equals(d2));
    }

}