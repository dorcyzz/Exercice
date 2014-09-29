package com.telemis.exercice.game;

import com.telemis.exercice.game.enums.ScoreType;
import com.telemis.exercice.game.frame.FiveLaunchesFrame;
import com.telemis.exercice.game.frame.Frame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 */
public class FiveLaunchesFrameTest {

    private Frame frame;

    @Before
    public void setup() {
        this.frame = new FiveLaunchesFrame();
    }

    @Test
    public void testAddLancerNormal() throws Exception {
        assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(8));
        assertEquals(7, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(0));
        assertEquals(7, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(1));
        assertEquals(6, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(2));
        assertEquals(4, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(1));
        assertEquals(3, this.frame.getStandingPins());
    }

    @Test(expected = IllegalStateException.class)
    public void testAddFiveLancer() throws Exception {
        this.frame.addLaunch(new Launch(8));
        this.frame.addLaunch(new Launch(0));
        this.frame.addLaunch(new Launch(1));
        this.frame.addLaunch(new Launch(2));
        this.frame.addLaunch(new Launch(3));
        this.frame.addLaunch(new Launch(1));
    }

    @Test(expected = IllegalStateException.class)
    public void testAddLancerWithNegative() throws Exception {
        this.frame.addLaunch(new Launch(-1));
        fail("Ne devrait pas aller jusqu'ici");
    }

    @Test
    public void testGetStandingPinNormal() throws Exception {
        assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(8));
        assertEquals(7, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(5));
        assertEquals(2, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(1));
        assertEquals(1, this.frame.getStandingPins());
    }

    @Test
    public void testGetStandingPinSpareTwoLaunches() throws Exception {
        assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(8));
        assertEquals(7, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(7));
        assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
    }

    @Test
    public void testGetStandingPinSpareThreeLaunches() throws Exception {
        assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(8));
        assertEquals(7, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(5));
        assertEquals(2, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(2));
        assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
    }

    @Test
    public void testGetStandingPinStrike() throws Exception {
        assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(Frame.TOTAL_NUMBER_OF_PINS));
        assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
    }

    @Test
    public void testIsSpareWithTwoLaunch() throws Exception {
        assertEquals(ScoreType.NORMAL, this.frame.getScoreType());
        assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(8));
        assertEquals(7, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(7));
        assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(7));
        assertEquals(8, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(4));
        assertEquals(4, this.frame.getStandingPins());
        assertEquals(ScoreType.SPARE, this.frame.getScoreType());
    }

    @Test
    public void testIsSpareWithThreeLaunch() throws Exception {
        assertEquals(ScoreType.NORMAL, this.frame.getScoreType());
        assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(8));
        assertEquals(7, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(6));
        assertEquals(1, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(1));
        assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(6));
        assertEquals(9, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(1));
        assertEquals(8, this.frame.getStandingPins());
        assertEquals(ScoreType.SPARE, this.frame.getScoreType());
    }

    @Test
    public void testIsStrike() throws Exception {
        assertEquals(ScoreType.NORMAL, this.frame.getScoreType());
        assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
        this.frame.addLaunch(new Launch(Frame.TOTAL_NUMBER_OF_PINS));
        assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
        assertEquals(ScoreType.STRIKE, this.frame.getScoreType());
    }
}
