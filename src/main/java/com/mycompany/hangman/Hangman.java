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

    private void checkAlreadyGuessedLetter(char character) {
        if (guessedCharacters.contains(AlphabetLetter.valueOf(character))) {
            throw new IllegalArgumentException("Character already guessed");
        }
    }

    public void guessLetter(char character) {

        System.out.println("Guessing: " + character);

        checkAlreadyGuessedLetter(character);

        String letter = String.valueOf(character).toLowerCase();

        if (wordToGuess.doesWordContainLetter(letter)) {
            wordToGuess.unmaskCharacterInWord(letter);
        }
        addLetterToGuessed(character);
    }

    private void addLetterToGuessed(char character) {
        guessedCharacters.add(AlphabetLetter.valueOf(character));
    }

    public Word getWordToGuess() {
        return wordToGuess;
    }

    public Set<AlphabetLetter> getAvailableCharactersForGuessing() {
        availableCharacters.removeAll(guessedCharacters);
        return availableCharacters;
    }

    private int getRemainingLettersToGuess() {
        String wordToGuessMasked = wordToGuess.getMaskedWord();
        int numberOfMaskedLetters = 0;
        for (char ch : wordToGuessMasked.toCharArray()) {
            // if the character is '*'
            if (HangmanConstants.WORD_MASK.equals(String.valueOf(ch))) {
                numberOfMaskedLetters++;
            }
        }
        return numberOfMaskedLetters;
    }

    public boolean stillHasMoreLettersToGuess() {
        return getRemainingLettersToGuess() > 0;
    }


}
