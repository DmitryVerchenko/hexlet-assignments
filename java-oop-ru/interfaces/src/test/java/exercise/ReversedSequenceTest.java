package exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReversedSequenceTest {

    @Test
    void testToString() {
        var actual = new ReversedSequence("abcdef").toString();
        var expected = "fedcba";
        assertEquals(actual,expected);
    }

    @Test
    void length() {
        var actual =new ReversedSequence("abcdef").length();
        var expected = 6;
        assertEquals(actual,expected);
    }

    @Test
    void charAt() {
        var actual =new ReversedSequence("abcdef").charAt(1);
        var expected = 'e';
        assertEquals(actual,expected);
    }

    @Test
    void subSequence() {
        var actual =new ReversedSequence("abcdef").subSequence(1,4);
        var expected = "edc";
        assertEquals(actual,expected);
    }
}