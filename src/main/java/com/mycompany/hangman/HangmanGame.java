/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.hangman;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author colin
 */
public class HangmanGame {

    private Hangman hangman;

    public HangmanGame(Hangman hangman) {
        this.hangman = hangman;
    }

    public void playRandomGame() {
        while (hangman.stillHasMoreLettersToGuess()) {
            hangman.guessLetter(getRandomCharacter());
            System.out.println(hangman.getWordToGuess().getMaskedWord());
        }
    }

    public static void playAutomatedHangmanGame() {
        Hangman hangman = new Hangman("Spotify");
        HangmanGame hangmanGame = new HangmanGame(hangman);
        hangmanGame.playRandomGame();
    }

    public static void main(String[] args) throws IOException {

//        if (args.length != 1) {
//          System.err.format("Incorrect number of arguments supplied %d: ", args.length);
//        }

        //Hangman hangman = new Hangman(args[0]);
    }

    private char getRandomCharacter() {
        Random random = new Random();

        List<AlphabetLetter> alphabetLetters = new ArrayList<>(
            hangman.getAvailableCharactersForGuessing());

        AlphabetLetter randomLetter = alphabetLetters.get(random.nextInt(alphabetLetters.size()));

        return randomLetter.getLetter().charAt(0);
    }
}
