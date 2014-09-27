package com.telemis.exercice;

import com.telemis.exercice.game.Lancer;
import com.telemis.exercice.game.enums.ScoreType;
import com.telemis.exercice.game.frame.FiveLaunchFrame;
import com.telemis.exercice.game.frame.Frame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 */
public class FiveLaunchFrameTest {

    private Frame frame;

    @Before
    public void setup() {
        this.frame = new FiveLaunchFrame();
    }

    @Test
    public void testAddLancerNormal() throws Exception {
        assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(8));
        assertEquals(7, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(0));
        assertEquals(7, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(1));
        assertEquals(6, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(2));
        assertEquals(4, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(1));
        assertEquals(3, this.frame.getStandingPins());
    }

    @Test(expected = IllegalStateException.class)
    public void testAddFiveLancer() throws Exception {
        this.frame.addLancer(new Lancer(8));
        this.frame.addLancer(new Lancer(0));
        this.frame.addLancer(new Lancer(1));
        this.frame.addLancer(new Lancer(2));
        this.frame.addLancer(new Lancer(3));
        this.frame.addLancer(new Lancer(1));
    }

    @Test(expected = IllegalStateException.class)
    public void testAddLancerWithNegative() throws Exception {
        this.frame.addLancer(new Lancer(-1));
        fail("Ne devrait pas aller jusqu'ici");
    }

    @Test
    public void testGetStandingPinNormal() throws Exception {
        assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(8));
        assertEquals(7, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(5));
        assertEquals(2, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(1));
        assertEquals(1, this.frame.getStandingPins());
    }

    @Test
    public void testGetStandingPinSpareTwoLaunches() throws Exception {
        assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(8));
        assertEquals(7, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(7));
        assertEquals(15, this.frame.getStandingPins());
    }

    @Test
    public void testGetStandingPinSpareThreeLaunches() throws Exception {
        assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(8));
        assertEquals(7, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(5));
        assertEquals(2, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(2));
        assertEquals(15, this.frame.getStandingPins());
    }

    @Test
    public void testGetStandingPinStrike() throws Exception {
        assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(15));
        assertEquals(15, this.frame.getStandingPins());
    }

    @Test
    public void testIsSpareWithTwoLaunch() throws Exception {
        assertEquals(ScoreType.NORMAL, this.frame.getScoreType());
        assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(8));
        assertEquals(7, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(7));
        assertEquals(15, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(7));
        assertEquals(8, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(4));
        assertEquals(4, this.frame.getStandingPins());
        assertEquals(ScoreType.SPARE, this.frame.getScoreType());
    }

    @Test
    public void testIsSpareWithThreeLaunch() throws Exception {
        assertEquals(ScoreType.NORMAL, this.frame.getScoreType());
        assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(8));
        assertEquals(7, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(6));
        assertEquals(1, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(1));
        assertEquals(15, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(6));
        assertEquals(9, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(1));
        assertEquals(8, this.frame.getStandingPins());
        assertEquals(ScoreType.SPARE, this.frame.getScoreType());
    }

    @Test
    public void testIsStrike() throws Exception {
        assertEquals(ScoreType.NORMAL, this.frame.getScoreType());
        assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
        this.frame.addLancer(new Lancer(15));
        assertEquals(15, this.frame.getStandingPins());
        assertEquals(ScoreType.STRIKE, this.frame.getScoreType());
    }
}
