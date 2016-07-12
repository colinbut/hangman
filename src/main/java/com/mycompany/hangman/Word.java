/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.hangman;

import org.apache.commons.lang3.StringUtils;

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

    public boolean doesWordContainLetter(char letter) {
        return word.contains(String.valueOf(letter));
    }


    public void unmaskWord(char character) {
        int positionToUnmask = findLetterPositionInWord(character);
        char[] maskedWordCharacters = maskedWord.toCharArray();
        for (int i = 0; i < maskedWord.length(); i++) {
            if (i == positionToUnmask) {
                maskedWordCharacters[i] = word.charAt(positionToUnmask);
            }
        }
        maskedWord = String.copyValueOf(maskedWordCharacters);
    }

    private int findLetterPositionInWord(char character) {
        return word.indexOf(character);
    }

}
