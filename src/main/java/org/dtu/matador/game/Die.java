package org.dtu.matador.game;

import java.util.Random;

public class Die {

    public Die() {}

    public int roll(int sides) {
        Random rand = new Random();
        return rand.nextInt(1,7);
    }

}
