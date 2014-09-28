package com.telemis.exercice.game;

import com.telemis.exercice.game.enums.ScoreType;
import com.telemis.exercice.game.frame.FiveLaunchFrame;
import com.telemis.exercice.game.frame.Frame;
import com.telemis.exercice.game.frame.ThreeLaunchFrame;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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

    /**
     * Created by sebastien.vandamme@gmail.com on 20/09/2014.
     */
    public static class LancerTest {

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

    /**
     * Created by sebastien.vandamme@gmail.com on 20/09/2014.
     */
    public static class PlayerTest {

        private Player player;

        @Before
        public void setup() {
            this.player = new Player("Joueur test");
        }

        @Test(expected = IllegalStateException.class)
        public void testGetFrameCouranteWithoutInitialisation() throws Exception {
            this.player.getCurrentFrame();
        }

        @Test
        public void testGetFrameCourante() throws Exception {
            this.player.initializeNewFrame();
            Frame frame1 = this.player.getCurrentFrame();
            assertNotNull(frame1);
            this.player.initializeNewFrame();
            Frame frame2 = this.player.getCurrentFrame();
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
            this.player.launch(5);
        }

        @Test(expected = IllegalStateException.class)
        public void testMoreThanThreeLancer() throws Exception {
            this.player.initializeNewFrame();
            this.player.launch(5);
            this.player.launch(0);
            this.player.launch(8);
            this.player.launch(3);
        }

        @Test
        public void testLancer() throws Exception {
            this.player.initializeNewFrame();
            assertEquals(15, this.player.getCurrentFrame().getStandingPins());
            this.player.launch(5);
            assertEquals(10, this.player.getCurrentFrame().getStandingPins());
            this.player.launch(0);
            assertEquals(10, this.player.getCurrentFrame().getStandingPins());
            this.player.launch(8);
            assertEquals(2, this.player.getCurrentFrame().getStandingPins());

            this.player.initializeNewFrame();
            assertEquals(15, this.player.getCurrentFrame().getStandingPins());
            this.player.launch(5);
            assertEquals(10, this.player.getCurrentFrame().getStandingPins());
            this.player.launch(10);
            assertEquals(0, this.player.getCurrentFrame().getStandingPins());
            this.player.launch(8);
            assertEquals(0, this.player.getCurrentFrame().getStandingPins());
        }

        @Test(expected = UnsupportedOperationException.class)
        public void testGetFramesIsNotModifiableAdd() {
            List<Frame> frames = this.player.getFrames();
            frames.add(new ThreeLaunchFrame());
        }

        @Test(expected = UnsupportedOperationException.class)
        public void testGetFramesIsNotModifiableSet() {
            List<Frame> frames = this.player.getFrames();
            frames.set(1, new ThreeLaunchFrame());
        }

        @Test(expected = UnsupportedOperationException.class)
        public void testGetFramesIsNotModifiableClear() {
            List<Frame> frames = this.player.getFrames();
            frames.clear();
        }
    }

    /**
     * Created by sebastien.vandamme@gmail.com on 20/09/2014.
     */
    public static class ThreeLaunchFrameTest {

        private Frame frame;

        @Before
        public void setup() {
            this.frame = new ThreeLaunchFrame();
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
        }

        @Test(expected = IllegalStateException.class)
        public void testAddFourLancer() throws Exception {
            this.frame.addLancer(new Lancer(8));
            this.frame.addLancer(new Lancer(0));
            this.frame.addLancer(new Lancer(1));
            this.frame.addLancer(new Lancer(2));
        }

        @Test(expected = IllegalStateException.class)
        public void testAddLancerWithNegative() throws Exception {
            this.frame.addLancer(new Lancer(-1));
            fail("Ne devrait pas aller jusqu'ici");
        }

        @Test
        public void testGetStandingPins() throws Exception {
            assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
            this.frame.addLancer(new Lancer(8));
            assertEquals(7, this.frame.getStandingPins());
            this.frame.addLancer(new Lancer(5));
            assertEquals(2, this.frame.getStandingPins());
            this.frame.addLancer(new Lancer(8));
            assertEquals(0, this.frame.getStandingPins());
        }

        @Test
        public void testIsSpareWithTwoLaunch() throws Exception {
            assertEquals(ScoreType.NORMAL, this.frame.getScoreType());
            assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
            this.frame.addLancer(new Lancer(8));
            assertEquals(7, this.frame.getStandingPins());
            this.frame.addLancer(new Lancer(7));
            assertEquals(0, this.frame.getStandingPins());
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
            assertEquals(0, this.frame.getStandingPins());
            assertEquals(ScoreType.SPARE, this.frame.getScoreType());
        }

        @Test
        public void testIsStrike() throws Exception {
            assertEquals(ScoreType.NORMAL, this.frame.getScoreType());
            assertEquals(Frame.TOTAL_NUMBER_OF_PINS, this.frame.getStandingPins());
            this.frame.addLancer(new Lancer(15));
            assertEquals(0, this.frame.getStandingPins());
            assertEquals(ScoreType.STRIKE, this.frame.getScoreType());
        }
    }
}
