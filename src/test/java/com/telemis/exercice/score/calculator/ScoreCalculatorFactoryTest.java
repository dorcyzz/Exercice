package com.telemis.exercice.score.calculator;

import com.telemis.exercice.score.calculator.calculators.ScoreCalculator;
import com.telemis.exercice.score.calculator.calculators.normal.NormalScoreCalculator;
import com.telemis.exercice.score.calculator.calculators.spare.SpareLastFrameScoreCalculator;
import com.telemis.exercice.score.calculator.calculators.spare.SpareNormalScoreCalculator;
import com.telemis.exercice.score.calculator.calculators.strike.StrikeLastFrameScoreCalculator;
import com.telemis.exercice.score.calculator.calculators.strike.StrikeNormalFrameScoreCalculator;
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
    public void testCreateSpareNormalScoreCalculator() throws Exception {
        ScoreCalculator scoreCalculator = ScoreCalculatorFactory.createScoreCalculator(ScoreCalculatorType.SPARE_NORMAL);
        assertNotNull(scoreCalculator);
        assertTrue(scoreCalculator instanceof SpareNormalScoreCalculator);
    }

    @Test
    public void testCreateSpareLastFrameScoreCalculator() throws Exception {
        ScoreCalculator scoreCalculator = ScoreCalculatorFactory.createScoreCalculator(ScoreCalculatorType.SPARE_LAST_FRAME);
        assertNotNull(scoreCalculator);
        assertTrue(scoreCalculator instanceof SpareLastFrameScoreCalculator);
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