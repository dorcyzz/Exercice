package com.telemis.exercice.game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 */
public class LaunchTest {

    @Test(expected = IllegalStateException.class)
    public void testCreateLancerNegative() throws Exception {
        new Launch(-1);
    }

    @Test
    public void testCreateLancerZero() throws Exception {
        Launch launch = new Launch(0);
        assertEquals(0, launch.getFallenPins());
    }

    @Test
    public void testCreateLancer() throws Exception {
        Launch launch = new Launch(8);
        assertEquals(8, launch.getFallenPins());
    }
}
