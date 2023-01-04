package org.dtu.matador.game;

import org.junit.Assert;
import org.junit.Test;

public class DieTest {

    @Test
    public void testDieInRange() {
        Die die = new Die(6);
        int result;
        for (int i = 0; i < 1000; i++) {
            result = die.roll();
            Assert.assertTrue(result <= 6 && result >= 1);
        }
    }

}