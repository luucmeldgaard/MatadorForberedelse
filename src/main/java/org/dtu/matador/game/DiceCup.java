package org.dtu.matador.game;

public class DiceCup {

    static Die die = new Die(6);

    public int roll() {
        return die.roll() + die.roll();
    }
}
