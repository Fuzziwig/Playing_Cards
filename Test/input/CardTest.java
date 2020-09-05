package input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void testEquals() {
        Card C1 = new Card(5);
        Card C2 = new Card(5);
        assertTrue(C1.equals(C2));
    }

    @Test
    void testNotEquals() {
        Card C1 = new Card(5);
        Card C2 = new Card(2);
        assertFalse(C1.equals(C2));
    }

    @Test
    void testCompareTo() {
        //greater og lower test
        Card C1 = new Card(5);
        Card C2 = new Card(2);
        assertTrue(C1.compareTo(C2)<0);
        assertTrue(C2.compareTo(C1)>0);
        //equals test
        Card C3 = new Card(5);
        assertTrue(C1.compareTo(C3)==0);
    }

    @Test
    void testToStringEmpty() {
        //empty
        Card C1 = new Card();
        assertTrue(C1.toString().equals(""));
    }

    @Test
    void testToStringNotEmpty() {
        //not empty
        Card C1 = new Card(1);
        assertTrue(C1.toString().equals("Ace of Spade"));
    }

}