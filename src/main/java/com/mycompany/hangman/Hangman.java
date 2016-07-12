package com.mycompany.hangman;

import java.util.HashSet;
import java.util.Set;

/**
 * Hangman
 *
 * @author colin
 */
public class Hangman {


    private Set<AlphabetLetter> availableCharacters = new HashSet<>();
    private Set<Character> guessedCharacters = new HashSet<>();

    private Word wordToGuess;


    public Hangman(String word) {
        this.wordToGuess = new Word(word);
    }

    private void checkValidLetter(char character) {
        boolean valid = false;
        for (AlphabetLetter alphabetLetter : AlphabetLetter.values()) {
            if (alphabetLetter.getLetter().equals(String.valueOf(character))) {
                valid = true;
                break;
            }
        }

        if (!valid) {
            throw new IllegalArgumentException("Invalid character input");
        }
    }

    public void guessLetter(char character) {
        checkValidLetter(character);
        if (wordToGuess.doesWordContainLetter(character)) {
            wordToGuess.unmaskWord(character);
        }
    }


}
