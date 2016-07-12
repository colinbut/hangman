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


}
