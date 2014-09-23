package com.telemis.exercice.score.calculator;

import com.telemis.exercice.score.calculator.calculators.*;
import com.telemis.exercice.score.calculator.enums.ScoreCalculatorType;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 *
 * Classe fournissant une implémentation d'un calculateur de score sur base d'un type.
 */
public class ScoreCalculatorFactory {

    /**
     * Méthode fournissant une implémentation d'un calculateur de score sur base d'un type passé en paramètre.
     *
     * @param calculatorType le type de calculateur désiré
     * @return une implémentation d'un calculateur de score
     */
    public static ScoreCalculator createScoreCalculator(ScoreCalculatorType calculatorType) {
        if (calculatorType == null) {
            throw new IllegalArgumentException("Type de calculateur ne peut être null");
        }

        switch (calculatorType) {
            case NORMAL:
                return NormalScoreCalculator.getInstance();
            case SPARE:
                return SpareScoreCalculator.getInstance();
            case STRIKE_NORMAL:
                return StrikeNormalFrameScoreCalculator.getInstance();
            case STRIKE_LAST_FRAME:
                return StrikeLastFrameScoreCalculator.getInstance();
            default:
                throw new IllegalArgumentException("Type de calculateur inconnu");
        }
    }
}
