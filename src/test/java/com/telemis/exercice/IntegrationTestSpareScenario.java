package com.telemis.exercice;

import com.telemis.exercice.game.Player;
import com.telemis.exercice.game.frame.Frame;
import com.telemis.exercice.score.ScoreContainer;
import com.telemis.exercice.score.ScoreManager;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by sebastien.vandamme@gmail.com on 28/09/2014.
 */
public class IntegrationTestSpareScenario {

    @Test
    public void testCalculerScenarioSpareInTwoLaunchesLastFrame() throws Exception {
        Player player1 = new Player("Joueur 1");

        player1.initializeNewFrame();
        player1.launch(Frame.TOTAL_NUMBER_OF_PINS);

        player1.initializeNewFrame();
        player1.launch(8);
        player1.launch(1);
        player1.launch(2);

        player1.initializeNewFrame();
        player1.launch(1);
        player1.launch(2);
        player1.launch(12);

        player1.initializeNewFrame();
        player1.launch(6);
        player1.launch(4);
        player1.launch(1);

        player1.initializeNewFrame();
        player1.launch(7);
        player1.launch(8);
        player1.launch(2);
        player1.launch(3);

        List<ScoreContainer> scoreJoueur1 = ScoreManager.calculer(player1.getFrames());

        assertNotNull(scoreJoueur1);
        assertEquals(5, scoreJoueur1.size());

        final ScoreContainer scoreFrame1 = scoreJoueur1.get(0);
        assertEquals(1, scoreFrame1.getFrameNumber());
        assertEquals(26, scoreFrame1.getFrameScore());

        List<String> lancersScores = scoreFrame1.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(3, lancersScores.size());
        assertEquals("X", lancersScores.get(0));
        assertEquals(StringUtils.EMPTY, lancersScores.get(1));
        assertEquals(StringUtils.EMPTY, lancersScores.get(2));

        ScoreContainer scoreFrame2 = scoreJoueur1.get(1);
        assertEquals(2, scoreFrame2.getFrameNumber());
        assertEquals(11, scoreFrame2.getFrameScore());

        lancersScores = scoreFrame2.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(3, lancersScores.size());
        assertEquals("8", lancersScores.get(0));
        assertEquals("1", lancersScores.get(1));
        assertEquals("2", lancersScores.get(2));

        ScoreContainer scoreFrame3 = scoreJoueur1.get(2);
        assertEquals(3, scoreFrame3.getFrameNumber());
        assertEquals(25, scoreFrame3.getFrameScore());

        lancersScores = scoreFrame3.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(3, lancersScores.size());
        assertEquals("1", lancersScores.get(0));
        assertEquals("2", lancersScores.get(1));
        assertEquals("/", lancersScores.get(2));

        ScoreContainer scoreFrame4 = scoreJoueur1.get(3);
        assertEquals(4, scoreFrame4.getFrameNumber());
        assertEquals(11, scoreFrame4.getFrameScore());

        lancersScores = scoreFrame4.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(3, lancersScores.size());
        assertEquals("6", lancersScores.get(0));
        assertEquals("4", lancersScores.get(1));
        assertEquals("1", lancersScores.get(2));

        ScoreContainer scoreFrame5 = scoreJoueur1.get(4);
        assertEquals(5, scoreFrame5.getFrameNumber());
        assertEquals(20, scoreFrame5.getFrameScore());

        lancersScores = scoreFrame5.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(4, lancersScores.size());
        assertEquals("7", lancersScores.get(0));
        assertEquals("/", lancersScores.get(1));
        assertEquals("2", lancersScores.get(2));
        assertEquals("3", lancersScores.get(3));
    }

    @Test
    public void testCalculerScenarioSpareInThreeLaunchesLastFrame() throws Exception {
        Player player1 = new Player("Joueur 1");

        player1.initializeNewFrame();
        player1.launch(Frame.TOTAL_NUMBER_OF_PINS);

        player1.initializeNewFrame();
        player1.launch(8);
        player1.launch(1);
        player1.launch(2);

        player1.initializeNewFrame();
        player1.launch(1);
        player1.launch(2);
        player1.launch(12);

        player1.initializeNewFrame();
        player1.launch(6);
        player1.launch(4);
        player1.launch(1);

        player1.initializeNewFrame();
        player1.launch(7);
        player1.launch(3);
        player1.launch(5);
        player1.launch(3);
        player1.launch(3);

        List<ScoreContainer> scoreJoueur1 = ScoreManager.calculer(player1.getFrames());

        assertNotNull(scoreJoueur1);
        assertEquals(5, scoreJoueur1.size());

        final ScoreContainer scoreFrame1 = scoreJoueur1.get(0);
        assertEquals(1, scoreFrame1.getFrameNumber());
        assertEquals(26, scoreFrame1.getFrameScore());

        List<String> lancersScores = scoreFrame1.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(3, lancersScores.size());
        assertEquals("X", lancersScores.get(0));
        assertEquals(StringUtils.EMPTY, lancersScores.get(1));
        assertEquals(StringUtils.EMPTY, lancersScores.get(2));

        ScoreContainer scoreFrame2 = scoreJoueur1.get(1);
        assertEquals(2, scoreFrame2.getFrameNumber());
        assertEquals(11, scoreFrame2.getFrameScore());

        lancersScores = scoreFrame2.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(3, lancersScores.size());
        assertEquals("8", lancersScores.get(0));
        assertEquals("1", lancersScores.get(1));
        assertEquals("2", lancersScores.get(2));

        ScoreContainer scoreFrame3 = scoreJoueur1.get(2);
        assertEquals(3, scoreFrame3.getFrameNumber());
        assertEquals(25, scoreFrame3.getFrameScore());

        lancersScores = scoreFrame3.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(3, lancersScores.size());
        assertEquals("1", lancersScores.get(0));
        assertEquals("2", lancersScores.get(1));
        assertEquals("/", lancersScores.get(2));

        ScoreContainer scoreFrame4 = scoreJoueur1.get(3);
        assertEquals(4, scoreFrame4.getFrameNumber());
        assertEquals(11, scoreFrame4.getFrameScore());

        lancersScores = scoreFrame4.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(3, lancersScores.size());
        assertEquals("6", lancersScores.get(0));
        assertEquals("4", lancersScores.get(1));
        assertEquals("1", lancersScores.get(2));

        ScoreContainer scoreFrame5 = scoreJoueur1.get(4);
        assertEquals(5, scoreFrame5.getFrameNumber());
        assertEquals(21, scoreFrame5.getFrameScore());

        lancersScores = scoreFrame5.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(5, lancersScores.size());
        assertEquals("7", lancersScores.get(0));
        assertEquals("3", lancersScores.get(1));
        assertEquals("/", lancersScores.get(2));
        assertEquals("3", lancersScores.get(3));
        assertEquals("3", lancersScores.get(3));
    }

    @Test
    public void testCalculerScenarioSpareStrikeStrike() throws Exception {
        Player player1 = new Player("Joueur 1");

        player1.initializeNewFrame();
        player1.launch(8);
        player1.launch(7);

        player1.initializeNewFrame();
        player1.launch(Frame.TOTAL_NUMBER_OF_PINS);

        player1.initializeNewFrame();
        player1.launch(Frame.TOTAL_NUMBER_OF_PINS);

        player1.initializeNewFrame();
        player1.launch(4);
        player1.launch(5);
        player1.launch(2);

        player1.initializeNewFrame();
        player1.launch(1);
        player1.launch(0);
        player1.launch(5);

        List<ScoreContainer> scoreJoueur1 = ScoreManager.calculer(player1.getFrames());

        assertNotNull(scoreJoueur1);
        assertEquals(5, scoreJoueur1.size());

        final ScoreContainer scoreFrame1 = scoreJoueur1.get(0);
        assertEquals(1, scoreFrame1.getFrameNumber());
        assertEquals(45, scoreFrame1.getFrameScore());

        List<String> lancersScores = scoreFrame1.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(3, lancersScores.size());
        assertEquals("8", lancersScores.get(0));
        assertEquals("/", lancersScores.get(1));
        assertEquals(StringUtils.EMPTY, lancersScores.get(2));

        ScoreContainer scoreFrame2 = scoreJoueur1.get(1);
        assertEquals(2, scoreFrame2.getFrameNumber());
        assertEquals(39, scoreFrame2.getFrameScore());

        lancersScores = scoreFrame2.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(3, lancersScores.size());
        assertEquals("X", lancersScores.get(0));
        assertEquals(StringUtils.EMPTY, lancersScores.get(1));
        assertEquals(StringUtils.EMPTY, lancersScores.get(2));

        ScoreContainer scoreFrame3 = scoreJoueur1.get(2);
        assertEquals(3, scoreFrame3.getFrameNumber());
        assertEquals(26, scoreFrame3.getFrameScore());

        lancersScores = scoreFrame3.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(3, lancersScores.size());
        assertEquals("X", lancersScores.get(0));
        assertEquals(StringUtils.EMPTY, lancersScores.get(1));
        assertEquals(StringUtils.EMPTY, lancersScores.get(2));

        ScoreContainer scoreFrame4 = scoreJoueur1.get(3);
        assertEquals(4, scoreFrame4.getFrameNumber());
        assertEquals(11, scoreFrame4.getFrameScore());

        lancersScores = scoreFrame4.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(3, lancersScores.size());
        assertEquals("4", lancersScores.get(0));
        assertEquals("5", lancersScores.get(1));
        assertEquals("2", lancersScores.get(2));

        ScoreContainer scoreFrame5 = scoreJoueur1.get(4);
        assertEquals(5, scoreFrame5.getFrameNumber());
        assertEquals(6, scoreFrame5.getFrameScore());

        lancersScores = scoreFrame5.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(3, lancersScores.size());
        assertEquals("1", lancersScores.get(0));
        assertEquals("0", lancersScores.get(1));
        assertEquals("5", lancersScores.get(2));
    }
}
