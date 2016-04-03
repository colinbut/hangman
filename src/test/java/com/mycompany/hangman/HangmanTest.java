package com.mycompany.hangman;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        Assert.assertEquals("*******", hangman.guessLetter('a'));
        Assert.assertEquals("**o****", hangman.guessLetter('o'));
        Assert.assertEquals("*po****", hangman.guessLetter('p'));
        Assert.assertEquals("*po****", hangman.guessLetter('g'));
        Assert.assertEquals("*pot***", hangman.guessLetter('t'));
        Assert.assertEquals("*poti**", hangman.guessLetter('i'));

        System.out.println(hangman.getAvailableCharactersFromAlphabet());

    }

    @Test
    public void testGetAvailableCharactersFromAlphabet() {

        hangman.guessLetter('S');

        System.out.println(hangman.getAvailableCharactersFromAlphabet());
    }

}
