package com.telemis.exercice;

import com.telemis.exercice.game.Lancer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sebastien.vandamme@gmail.com on 18/09/2014.
 */
public class LancerTest {

    @Test(expected = IllegalStateException.class)
    public void testCreateLancerNegative() throws Exception {
        new Lancer(-1);
    }

    @Test
    public void testCreateLancerZero() throws Exception {
        Lancer lancer = new Lancer(0);
        assertEquals(0, lancer.getFallenPins());
    }

    @Test
    public void testCreateLancer() throws Exception {
        Lancer lancer = new Lancer(8);
        assertEquals(8, lancer.getFallenPins());
    }
}
