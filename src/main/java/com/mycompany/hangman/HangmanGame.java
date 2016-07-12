/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.hangman;

import java.io.IOException;

public class HangmanGame {

    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
          System.err.format("Incorrect number of arguments supplied %d: ", args.length);
        }

        //Hangman hangman = new Hangman(args[0]);

        Hangman hangman = new Hangman("Spotify");

    }
}
