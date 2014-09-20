package com.telemis.exercice.score;

import com.telemis.exercice.game.Joueur;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ScoreManagerTest {

    @Test
    public void testCalculerScenario1() throws Exception {
        Joueur joueur1 = new Joueur("Joueur 1");

        joueur1.initialiseNouvelleFrame();
        joueur1.lancer(8);
        joueur1.lancer(1);
        joueur1.lancer(1);

        joueur1.initialiseNouvelleFrame();
        joueur1.lancer(8);
        joueur1.lancer(7);

        joueur1.initialiseNouvelleFrame();
        joueur1.lancer(1);
        joueur1.lancer(2);
        joueur1.lancer(1);

        joueur1.initialiseNouvelleFrame();
        joueur1.lancer(15);

        joueur1.initialiseNouvelleFrame();
        joueur1.lancer(1);
        joueur1.lancer(2);
        joueur1.lancer(1);

        List<ScoreContainer> scoreJoueur1 = ScoreManager.calculer(joueur1.getFrames());

        assertNotNull(scoreJoueur1);
        assertEquals(5, scoreJoueur1.size());

        final ScoreContainer scoreFrame1 = scoreJoueur1.get(0);
        assertEquals(1, scoreFrame1.getFrameNumber());
        assertEquals(10, scoreFrame1.getFrameScore());
        assertEquals(10, scoreFrame1.getTotalScore());

        List<String> lancersScores = scoreFrame1.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(3, lancersScores.size());
        assertEquals("8", lancersScores.get(0));
        assertEquals("1", lancersScores.get(1));
        assertEquals("1", lancersScores.get(2));

        ScoreContainer scoreFrame2 = scoreJoueur1.get(1);
        assertEquals(2, scoreFrame2.getFrameNumber());
        assertEquals(18, scoreFrame2.getFrameScore());
        assertEquals(28, scoreFrame2.getTotalScore());

        lancersScores = scoreFrame2.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(3, lancersScores.size());
        assertEquals("8", lancersScores.get(0));
        assertEquals("/", lancersScores.get(1));
        assertEquals(StringUtils.EMPTY, lancersScores.get(2));

        ScoreContainer scoreFrame3 = scoreJoueur1.get(2);
        assertEquals(3, scoreFrame3.getFrameNumber());
        assertEquals(4, scoreFrame3.getFrameScore());
        assertEquals(32, scoreFrame3.getTotalScore());

        lancersScores = scoreFrame3.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(3, lancersScores.size());
        assertEquals("1", lancersScores.get(0));
        assertEquals("2", lancersScores.get(1));
        assertEquals("1", lancersScores.get(2));

        ScoreContainer scoreFrame4 = scoreJoueur1.get(3);
        assertEquals(4, scoreFrame4.getFrameNumber());
        assertEquals(19, scoreFrame4.getFrameScore());
        assertEquals(51, scoreFrame4.getTotalScore());

        lancersScores = scoreFrame4.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(3, lancersScores.size());
        assertEquals("X", lancersScores.get(0));
        assertEquals(StringUtils.EMPTY, lancersScores.get(1));
        assertEquals(StringUtils.EMPTY, lancersScores.get(2));

        ScoreContainer scoreFrame5 = scoreJoueur1.get(4);
        assertEquals(5, scoreFrame5.getFrameNumber());
        assertEquals(4, scoreFrame5.getFrameScore());
        assertEquals(55, scoreFrame5.getTotalScore());

        lancersScores = scoreFrame5.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(3, lancersScores.size());
        assertEquals("1", lancersScores.get(0));
        assertEquals("2", lancersScores.get(1));
        assertEquals("1", lancersScores.get(2));
    }

    @Test
    public void testCalculerScenario2() throws Exception {
        Joueur joueur1 = new Joueur("Joueur 1");

        joueur1.initialiseNouvelleFrame();
        joueur1.lancer(15);

        joueur1.initialiseNouvelleFrame();
        joueur1.lancer(8);
        joueur1.lancer(1);
        joueur1.lancer(2);

        joueur1.initialiseNouvelleFrame();
        joueur1.lancer(1);
        joueur1.lancer(2);
        joueur1.lancer(12);

        joueur1.initialiseNouvelleFrame();
        joueur1.lancer(6);
        joueur1.lancer(4);
        joueur1.lancer(1);

        joueur1.initialiseNouvelleFrame();
        joueur1.lancer(15);
        joueur1.lancer(8);
        joueur1.lancer(2);
        joueur1.lancer(3);

        List<ScoreContainer> scoreJoueur1 = ScoreManager.calculer(joueur1.getFrames());

        assertNotNull(scoreJoueur1);
        assertEquals(5, scoreJoueur1.size());

        final ScoreContainer scoreFrame1 = scoreJoueur1.get(0);
        assertEquals(1, scoreFrame1.getFrameNumber());
        assertEquals(26, scoreFrame1.getFrameScore());
        assertEquals(26, scoreFrame1.getTotalScore());

        List<String> lancersScores = scoreFrame1.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(3, lancersScores.size());
        assertEquals("X", lancersScores.get(0));
        assertEquals(StringUtils.EMPTY, lancersScores.get(1));
        assertEquals(StringUtils.EMPTY, lancersScores.get(2));

        ScoreContainer scoreFrame2 = scoreJoueur1.get(1);
        assertEquals(2, scoreFrame2.getFrameNumber());
        assertEquals(11, scoreFrame2.getFrameScore());
        assertEquals(37, scoreFrame2.getTotalScore());

        lancersScores = scoreFrame2.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(3, lancersScores.size());
        assertEquals("8", lancersScores.get(0));
        assertEquals("1", lancersScores.get(1));
        assertEquals("2", lancersScores.get(2));

        ScoreContainer scoreFrame3 = scoreJoueur1.get(2);
        assertEquals(3, scoreFrame3.getFrameNumber());
        assertEquals(25, scoreFrame3.getFrameScore());
        assertEquals(62, scoreFrame3.getTotalScore());

        lancersScores = scoreFrame3.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(3, lancersScores.size());
        assertEquals("1", lancersScores.get(0));
        assertEquals("2", lancersScores.get(1));
        assertEquals("/", lancersScores.get(2));

        ScoreContainer scoreFrame4 = scoreJoueur1.get(3);
        assertEquals(4, scoreFrame4.getFrameNumber());
        assertEquals(11, scoreFrame4.getFrameScore());
        assertEquals(73, scoreFrame4.getTotalScore());

        lancersScores = scoreFrame4.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(3, lancersScores.size());
        assertEquals("6", lancersScores.get(0));
        assertEquals("4", lancersScores.get(1));
        assertEquals("1", lancersScores.get(2));

        ScoreContainer scoreFrame5 = scoreJoueur1.get(4);
        assertEquals(5, scoreFrame5.getFrameNumber());
        assertEquals(28, scoreFrame5.getFrameScore());
        assertEquals(101, scoreFrame5.getTotalScore());

        lancersScores = scoreFrame5.getLancersScores();
        assertNotNull(lancersScores);
        assertEquals(4, lancersScores.size());
        assertEquals("X", lancersScores.get(0));
        assertEquals("8", lancersScores.get(1));
        assertEquals("2", lancersScores.get(2));
        assertEquals("3", lancersScores.get(3));
    }
}