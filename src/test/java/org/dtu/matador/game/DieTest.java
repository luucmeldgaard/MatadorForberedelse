package org.dtu.matador.game;

import org.junit.Assert;
import org.junit.Test;

public class DieTest {

    @Test
    public void testDieInRange() {
        Die die = new Die();
        int result;
        for (int i = 0; i < 1000; i++) {
            result = die.roll(6);
            Assert.assertTrue(result <= 6 && result >= 1);
        }
    }

}