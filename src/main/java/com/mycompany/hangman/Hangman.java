package com.mycompany.hangman;

import java.util.HashSet;
import java.util.Set;

/**
 * Hangman
 *
 * @author colin
 */
public class Hangman {

    private final Set<AlphabetLetter> availableCharacters = new HashSet<>();
    private final Set<AlphabetLetter> guessedCharacters = new HashSet<>();

    private Word wordToGuess;


    public Hangman(String word) {
        this.wordToGuess = new Word(word);
        initialiseAvailableAlphabetLetters();
    }

    private void initialiseAvailableAlphabetLetters() {
        for (AlphabetLetter alphabetLetter : AlphabetLetter.values()) {
            availableCharacters.add(alphabetLetter);
        }
    }

    private void checkValidLetter(char character) {
        boolean valid = false;
        for (AlphabetLetter alphabetLetter : AlphabetLetter.values()) {
            if (alphabetLetter.getLetter().equalsIgnoreCase(String.valueOf(character))) {
                valid = true;
                break;
            }
        }

        if (!valid) {
            throw new IllegalArgumentException("Invalid character input");
        }
    }

    private void checkAlreadyGuessedLetter(char character) {
        if (guessedCharacters.contains(character)) {
            throw new IllegalArgumentException("Character already guessed");
        }
    }

    public void guessLetter(char character) {
        checkValidLetter(character);
        checkAlreadyGuessedLetter(character);

        if (wordToGuess.doesWordContainLetter(character)) {
            wordToGuess.unmaskCharacterInWord(character);
            addLetterToGuessed(character);
        }

    }

    private void addLetterToGuessed(char character) {
        AlphabetLetter alphabetLetter = AlphabetLetter.valueOf(
            String.valueOf(character).toUpperCase());

        guessedCharacters.add(alphabetLetter);
    }

    public Word getWordToGuess() {
        return wordToGuess;
    }

    public Set<AlphabetLetter> getAvailableCharactersForGuessing() {
        availableCharacters.removeAll(guessedCharacters);
        return availableCharacters;
    }


}
