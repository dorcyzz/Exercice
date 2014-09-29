package com.telemis.exercice.score.calculator.calculators.spare;

import com.telemis.exercice.game.frame.Frame;
import com.telemis.exercice.score.ScoreContainer;
import com.telemis.exercice.score.calculator.ScoreCalculatorFactory;
import com.telemis.exercice.score.calculator.calculators.ScoreCalculator;
import com.telemis.exercice.score.calculator.enums.ScoreCalculatorType;

import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 28/09/2014.
 * <p/>
 * Classe permettant de calculer le score d'une frame lors d'un spare ayant lieu dans la cinquième frame.
 */
public class SpareLastFrameScoreCalculator extends SpareScoreCalculator {

    private static final SpareLastFrameScoreCalculator INSTANCE = new SpareLastFrameScoreCalculator();

    private SpareLastFrameScoreCalculator() {
    }

    public static SpareLastFrameScoreCalculator getInstance() {
        return INSTANCE;
    }

    @Override
    /**
     * @see com.telemis.exercice.score.calculator.calculators.ScoreCalculator#calculate(java.util.List, com.telemis.exercice.game.frame.Frame)
     */
    public ScoreContainer calculate(List<Frame> frames, Frame currentFrame) {
        ScoreCalculator scoreCalculator = ScoreCalculatorFactory.createScoreCalculator(ScoreCalculatorType.NORMAL);
        ScoreContainer container = scoreCalculator.calculate(frames, currentFrame);

        completeRepresentation(container);

        return container;
    }

    private void completeRepresentation(ScoreContainer container) {
        final List<String> lancersScores = container.getLancersScores();

        int currentScore = 0;

        for (int i = 0; i < lancersScores.size(); ++i) {
            currentScore += Integer.valueOf(lancersScores.get(i));

            if (currentScore == Frame.TOTAL_NUMBER_OF_PINS) {
                lancersScores.set(i, SPARE_SYMBOL);
                break;
            }
        }
    }
}
