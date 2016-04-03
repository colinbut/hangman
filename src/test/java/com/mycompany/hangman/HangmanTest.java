package com.mycompany.hangman;

import org.junit.Test;

/**
 * Unit test for simple Hangman.
 */
public class HangmanTest {

    private Hangman hangman = new Hangman();

    @Test
    public void testPlayHangman() {
        hangman.play('A');
    }

}
