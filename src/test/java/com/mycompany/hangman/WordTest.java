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

/**
 * @author colin
 */
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
        word.unmaskCharacterInWord("o");
        assertEquals("**o****", word.getMaskedWord());
    }

    @Test
    public void test_doesWordContainLetter_method() {
        assertTrue(word.doesWordContainLetter("i"));
    }

}
