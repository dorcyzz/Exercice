package com.telemis.exercice.score.calculator;

import com.telemis.exercice.score.calculator.calculators.*;
import com.telemis.exercice.score.calculator.enums.ScoreCalculatorType;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ScoreCalculatorFactoryTest {

    @Test
    public void testCreateNormalScoreCalculator() throws Exception {
        ScoreCalculator scoreCalculator = ScoreCalculatorFactory.createScoreCalculator(ScoreCalculatorType.NORMAL);
        assertNotNull(scoreCalculator);
        assertTrue(scoreCalculator instanceof NormalScoreCalculator);
    }

    @Test
    public void testCreateSpareScoreCalculator() throws Exception {
        ScoreCalculator scoreCalculator = ScoreCalculatorFactory.createScoreCalculator(ScoreCalculatorType.SPARE);
        assertNotNull(scoreCalculator);
        assertTrue(scoreCalculator instanceof SpareScoreCalculator);
    }

    @Test
    public void testCreateStrikeNormalScoreCalculator() throws Exception {
        ScoreCalculator scoreCalculator = ScoreCalculatorFactory.createScoreCalculator(ScoreCalculatorType.STRIKE_NORMAL);
        assertNotNull(scoreCalculator);
        assertTrue(scoreCalculator instanceof StrikeNormalFrameScoreCalculator);
    }

    @Test
    public void testCreateStrikeLastFrameScoreCalculator() throws Exception {
        ScoreCalculator scoreCalculator = ScoreCalculatorFactory.createScoreCalculator(ScoreCalculatorType.STRIKE_LAST_FRAME);
        assertNotNull(scoreCalculator);
        assertTrue(scoreCalculator instanceof StrikeLastFrameScoreCalculator);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateScoreCalculatorWithNull() throws Exception {
        ScoreCalculatorFactory.createScoreCalculator(null);
    }
}