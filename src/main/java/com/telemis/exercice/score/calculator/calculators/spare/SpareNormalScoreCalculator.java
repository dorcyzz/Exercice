package com.telemis.exercice.score.calculator.calculators.spare;

import com.telemis.exercice.game.Launch;
import com.telemis.exercice.game.frame.Frame;
import com.telemis.exercice.score.ScoreContainer;
import com.telemis.exercice.score.calculator.ScoreCalculatorFactory;
import com.telemis.exercice.score.calculator.calculators.ScoreCalculator;
import com.telemis.exercice.score.calculator.enums.ScoreCalculatorType;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 28/09/2014.
 * <p/>
 * Classe permettant de calculer le score d'une frame lors d'un spare ayant lieu dans la troisième frame.
 */
public class SpareNormalScoreCalculator extends SpareScoreCalculator {

    private static final SpareNormalScoreCalculator INSTANCE = new SpareNormalScoreCalculator();

    private SpareNormalScoreCalculator() {
    }

    public static SpareNormalScoreCalculator getInstance() {
        return INSTANCE;
    }

    @Override
    /**
     * @see com.telemis.exercice.score.calculator.calculators.ScoreCalculator#calculate(java.util.List, com.telemis.exercice.game.frame.Frame)
     */
    public ScoreContainer calculate(List<Frame> frames, Frame currentFrame) {
        ScoreCalculator scoreCalculator = ScoreCalculatorFactory.createScoreCalculator(ScoreCalculatorType.NORMAL);
        ScoreContainer container = scoreCalculator.calculate(frames, currentFrame);

        container.setFrameScore(calculateScore(container, frames, currentFrame));

        return container;
    }

    private int calculateScore(ScoreContainer container, List<Frame> frames, Frame currentFrame) {
        int launch = 0;
        int strikeScore = container.getFrameScore();

        List<Frame> framesFromCurrentFrame = frames.subList(frames.indexOf(currentFrame) + 1, frames.size());

        completeRepresentation(container);

        for (Frame frame : framesFromCurrentFrame) {
            List<Launch> launches = frame.getLaunches();

            for (Launch lancer : launches) {
                strikeScore += lancer.getFallenPins();
                ++launch;

                if (launch >= 2) {
                    return strikeScore;
                }
            }
        }

        return strikeScore;
    }

    private void completeRepresentation(ScoreContainer container) {
        final List<String> lancersScores = container.getLancersScores();

        lancersScores.set(lancersScores.size() - 1, SPARE_SYMBOL);

        if (lancersScores.size() == 2) {
            lancersScores.add(StringUtils.EMPTY);
        }

    }
}
