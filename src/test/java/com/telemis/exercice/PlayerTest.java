package com.telemis.exercice;

import com.telemis.exercice.game.Frame;
import com.telemis.exercice.game.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by sebastien.vandamme@gmail.com on 18/09/2014.
 */
public class PlayerTest {

    private Player player;

    @Before
    public void setup() {
        this.player = new Player("Joueur test");
    }

    @Test(expected = IllegalStateException.class)
    public void testGetFrameCouranteWithoutInitialisation() throws Exception {
        this.player.getFrameCourante();
    }

    @Test
    public void testGetFrameCourante() throws Exception {
        this.player.initializeNewFrame();
        Frame frame1 = this.player.getFrameCourante();
        assertNotNull(frame1);
        this.player.initializeNewFrame();
        Frame frame2 = this.player.getFrameCourante();
        assertNotNull(frame2);

        assertNotEquals(frame1, frame2);
        assertNotSame(frame1, frame2);
    }

    @Test
    public void testInitialiseNouvelleFrameFiveTimes() throws Exception {
        for (int i = 0; i < 5; ++i) {
            this.player.initializeNewFrame();
        }
    }

    @Test(expected = IllegalStateException.class)
    public void testInitialiseNouvelleFrameMoreThanFiveTimes() throws Exception {
        for (int i = 0; i < 6; ++i) {
            this.player.initializeNewFrame();
        }
    }

    @Test
    public void testInitialiseNouvelleFrame() throws Exception {
        assertEquals(0, this.player.getFrames().size());
        this.player.initializeNewFrame();
        assertEquals(1, this.player.getFrames().size());
        this.player.initializeNewFrame();
        assertEquals(2, this.player.getFrames().size());
        this.player.initializeNewFrame();
        assertEquals(3, this.player.getFrames().size());
        this.player.initializeNewFrame();
        assertEquals(4, this.player.getFrames().size());
        this.player.initializeNewFrame();
        assertEquals(5, this.player.getFrames().size());
    }

    @Test(expected = IllegalStateException.class)
    public void testLancerWithoutInitialisation() throws Exception {
        this.player.lancer(5);
    }

    @Test(expected = IllegalStateException.class)
    public void testMoreThanThreeLancer() throws Exception {
        this.player.initializeNewFrame();
        this.player.lancer(5);
        this.player.lancer(0);
        this.player.lancer(8);
        this.player.lancer(3);
    }

    @Test
    public void testLancer() throws Exception {
        this.player.initializeNewFrame();
        assertEquals(15, this.player.getFrameCourante().getStandingQuilles());
        this.player.lancer(5);
        assertEquals(10, this.player.getFrameCourante().getStandingQuilles());
        this.player.lancer(0);
        assertEquals(10, this.player.getFrameCourante().getStandingQuilles());
        this.player.lancer(8);
        assertEquals(2, this.player.getFrameCourante().getStandingQuilles());

        this.player.initializeNewFrame();
        assertEquals(15, this.player.getFrameCourante().getStandingQuilles());
        this.player.lancer(5);
        assertEquals(10, this.player.getFrameCourante().getStandingQuilles());
        this.player.lancer(10);
        assertEquals(0, this.player.getFrameCourante().getStandingQuilles());
        this.player.lancer(8);
        assertEquals(0, this.player.getFrameCourante().getStandingQuilles());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetFramesIsNotModifiableAdd() {
        List<Frame> frames = this.player.getFrames();
        frames.add(new Frame(false));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetFramesIsNotModifiableSet() {
        List<Frame> frames = this.player.getFrames();
        frames.set(1, new Frame(false));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetFramesIsNotModifiableClear() {
        List<Frame> frames = this.player.getFrames();
        frames.clear();
    }
}
