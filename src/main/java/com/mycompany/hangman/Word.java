/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.hangman;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author colin
 */
public class Word {

    private final String word;
    private String maskedWord;


    public Word(String word) {
        this.word = word;
        maskedWord = StringUtils.repeat("*", word.length());
    }


    public String getWord() {
        return word;
    }

    public String getMaskedWord() {
        return maskedWord;
    }


    public void unmaskWord(int positionToUnmask) {
        char[] maskedWordCharacters = maskedWord.toCharArray();
        for (int i = 0; i < maskedWord.length(); i++) {
            if (i == positionToUnmask) {
                maskedWordCharacters[i] = word.charAt(positionToUnmask);
            }
        }
        maskedWord = Arrays.toString(maskedWordCharacters);
    }

}
