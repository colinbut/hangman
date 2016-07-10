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
        hangman.guessLetter('a');
        Assert.assertEquals("*******", hangman.getWord());

        hangman.guessLetter('o');

        Assert.assertEquals("**o****", hangman.getWord());

        hangman.guessLetter('p');
        Assert.assertEquals("*po****", hangman.getWord());

        hangman.guessLetter('g');
        Assert.assertEquals("*po****", hangman.getWord());

        hangman.guessLetter('t');
        Assert.assertEquals("*pot***", hangman.getWord());

        hangman.guessLetter('i');
        Assert.assertEquals("*poti**", hangman.getWord());

        System.out.println(hangman.getAvailableCharactersFromAlphabet());

    }

    @Test
    public void testGetAvailableCharactersFromAlphabet() {

        hangman.guessLetter('S');

        System.out.println(hangman.getAvailableCharactersFromAlphabet());
    }

}
