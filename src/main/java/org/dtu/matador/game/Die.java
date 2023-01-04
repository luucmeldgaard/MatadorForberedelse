package org.dtu.matador.game;

import java.util.Random;

public class Die {

    int sides;

    public Die(int sides) {
        this.sides = sides;
    }

    public int roll() {
        Random rand = new Random();
        return rand.nextInt(1,sides + 1);
    }

}
