package com.telemis.exercice;

import com.telemis.exercice.game.Frame;
import com.telemis.exercice.game.Lancer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sebastien.vandamme@gmail.com on 18/09/2014.
 */
public class FrameTest {

    private Frame frame;

    @Before
    public void setup() {
        this.frame = new Frame();
    }

    @Test
    public void testAddLancerNormal() throws Exception {
        assertEquals(Frame.NOMBRE_TOTAL_QUILLES, this.frame.getQuilleDebout());
        this.frame.addLancer(new Lancer(8));
        assertEquals(7, this.frame.getQuilleDebout());
        this.frame.addLancer(new Lancer(0));
        assertEquals(7, this.frame.getQuilleDebout());
        this.frame.addLancer(new Lancer(1));
        assertEquals(6, this.frame.getQuilleDebout());
    }

    @Test(expected = IllegalStateException.class)
    public void testAddLancerWithNegative() throws Exception {
        this.frame.addLancer(new Lancer(-1));
        fail("Ne devrait pas aller jusqu'ici");
    }

    @Test
    public void testGetQuilleDebout() throws Exception {
        assertEquals(Frame.NOMBRE_TOTAL_QUILLES, this.frame.getQuilleDebout());
        this.frame.addLancer(new Lancer(8));
        assertEquals(7, this.frame.getQuilleDebout());
        this.frame.addLancer(new Lancer(5));
        assertEquals(2, this.frame.getQuilleDebout());
        this.frame.addLancer(new Lancer(8));
        assertEquals(0, this.frame.getQuilleDebout());
    }

    @Test
    public void testIsSpareWithTwoLaunch() throws Exception {
        assertFalse(this.frame.isSpare());
        assertEquals(Frame.NOMBRE_TOTAL_QUILLES, this.frame.getQuilleDebout());
        this.frame.addLancer(new Lancer(8));
        assertEquals(7, this.frame.getQuilleDebout());
        this.frame.addLancer(new Lancer(7));
        assertEquals(0, this.frame.getQuilleDebout());
        assertTrue(this.frame.isSpare());
    }

    @Test
    public void testIsSpareWithThreeLaunch() throws Exception {
        assertFalse(this.frame.isSpare());
        assertEquals(Frame.NOMBRE_TOTAL_QUILLES, this.frame.getQuilleDebout());
        this.frame.addLancer(new Lancer(8));
        assertEquals(7, this.frame.getQuilleDebout());
        this.frame.addLancer(new Lancer(6));
        assertEquals(1, this.frame.getQuilleDebout());
        this.frame.addLancer(new Lancer(1));
        assertEquals(0, this.frame.getQuilleDebout());
        assertTrue(this.frame.isSpare());
    }

    @Test
    public void testIsStrike() throws Exception {
        assertFalse(this.frame.isStrike());
        assertEquals(Frame.NOMBRE_TOTAL_QUILLES, this.frame.getQuilleDebout());
        this.frame.addLancer(new Lancer(15));
        assertEquals(0, this.frame.getQuilleDebout());
        assertTrue(this.frame.isStrike());
    }
}
