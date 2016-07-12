package com.mycompany.hangman;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple Hangman.
 *
 * @author colin
 */
public class HangmanTest {

    private Hangman hangman;

    @Before
    public void setup() {
        hangman = new Hangman("Spotify");
    }

    @Test
    public void testGuessLetter() {
        hangman.guessLetter('t');
        assertEquals("***t***", hangman.getWordToGuess().getMaskedWord());
    }

}
