package com.telemis.exercice.score.calculator;

import com.telemis.exercice.score.calculator.calculators.NormalScoreCalculator;
import com.telemis.exercice.score.calculator.calculators.ScoreCalculator;
import com.telemis.exercice.score.calculator.calculators.SpareScoreCalculator;
import com.telemis.exercice.score.calculator.calculators.StrikeScoreCalculator;
import com.telemis.exercice.score.calculator.enums.ScoreCalculatorType;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 */
public class ScoreCalculatorFactory {
    public static ScoreCalculator createScoreCalculator(ScoreCalculatorType calculatorType) {
        switch (calculatorType) {
            case NORMAL:
                return NormalScoreCalculator.getInstance();
            case SPARE:
                return SpareScoreCalculator.getInstance();
            case STRIKE:
                return StrikeScoreCalculator.getInstance();
            default:
                throw new IllegalArgumentException("Type de calculateur inconnu");
        }
    }
}
