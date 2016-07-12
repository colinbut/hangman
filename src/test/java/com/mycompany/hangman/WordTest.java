/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.hangman;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WordTest {

    private Word word;

    @Before
    public void setUp() {
        word = new Word("Spotify");
    }


    @Test
    public void test_getMaskedWord_whenInitialised() {
        assertTrue(word.getMaskedWord().equals("*******"));
    }

    @Test
    public void test_unmaskWord_withPositionToUnmask() {
        int positionToUnmask = 2;
        word.unmaskWord('o');
        assertEquals("**o****", word.getMaskedWord());
    }

}
