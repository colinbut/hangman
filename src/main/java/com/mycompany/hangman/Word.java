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
        this.word = word.toLowerCase();
        maskedWord = StringUtils.repeat(HangmanConstants.WORD_MASK, word.length());
    }


    //region accessors

    public String getWord() {
        return word;
    }

    public String getMaskedWord() {
        return maskedWord;
    }

    //endregion


    //region public method

    public boolean doesWordContainLetter(String letter) {
        System.out.println("Checking " + letter + " against " + word.toLowerCase());
        return word.contains(letter);
    }


    public void unmaskCharacterInWord(String letter) {

        if (letter.length() != 1) {
            throw new IllegalStateException("Not a single letter");
        }

        char character = letter.charAt(0);
        int positionToUnmask = findLetterPositionInWord(character);

        StringBuilder sb = new StringBuilder(maskedWord);
        sb.setCharAt(positionToUnmask, character);
        maskedWord = sb.toString();
    }

    //endregion


    //region private helper method

    private int findLetterPositionInWord(char character) {
        return word.indexOf(character);
    }

    //endregion


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Word{");
        sb.append("maskedWord='").append(maskedWord).append('\'');
        sb.append(", word='").append(word).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
