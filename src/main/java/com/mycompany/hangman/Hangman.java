package com.mycompany.hangman;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hangman
 *
 * @author colin
 *
 */
public class Hangman
{
    private String word;
    private List<Character> alphabet = new ArrayList<>();

    private static final String letters = "abcdefghijklmnopqrstuvvwxyz";


    public Hangman(String word) {
        this.word = word;
        initialiseAlphabet();
    }

    private void initialiseAlphabet() {
        for (int i = 0; i < letters.length() - 1; i++) {
            alphabet.add(letters.charAt(i));
        }
    }


    private boolean hasWordContainLetter(char character) {
        return word.indexOf(character) != -1;
    }

    public String guessLetter(char character) {
        if (hasWordContainLetter(character)) {
            System.out.format("Word: %s has letter: %s%n", word, character);
        }
        alphabet.remove(new Character(character));
        return getPartialGuessedWord(character);
    }


    public List<Character> getAvailableCharactersFromAlphabet() {
        return alphabet;
    }

    private String getPartialGuessedWord(Character guessedCharacter) {
        String wordToBeGuessed = word;
        char[] wordCharArray = word.toCharArray();
        for (int i = 0; i < wordCharArray.length; i++) {
            if (!Character.valueOf(wordCharArray[i]).equals(guessedCharacter)) {
                wordToBeGuessed = wordToBeGuessed.replace(wordCharArray[i], '*');
            }
        }
        return wordToBeGuessed;
    }

    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.format("Incorrect number of arguments supplied %d: ", args.length);
        }

        //Hangman hangman = new Hangman(args[0]);

        Hangman hangman = new Hangman("Spotify");
        String result = hangman.guessLetter('A');
        System.out.println(result);
    }
}