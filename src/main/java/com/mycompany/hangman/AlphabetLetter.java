/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.hangman;

/**
 * Enumeration representing letters of the AlphabetLetter
 *
 * @author colin
 */
public enum AlphabetLetter {

    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    F("F"),
    G("G"),
    H("H"),
    I("I"),
    J("J"),
    K("K"),
    L("L"),
    M("M"),
    N("N"),
    O("O"),
    P("P"),
    Q("Q"),
    R("R"),
    S("S"),
    T("T"),
    U("U"),
    V("V"),
    W("W"),
    X("X"),
    Y("Y"),
    Z("Z");


    private String letter;

    AlphabetLetter(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }

    public static AlphabetLetter valueOf(char character) {
        return AlphabetLetter.valueOf(String.valueOf(character).toUpperCase());
    }


}
