package com.telemis.exercice.score.calculator.calculators;

import com.telemis.exercice.game.frame.Frame;
import com.telemis.exercice.score.ScoreContainer;

import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 * <p/>
 * Classe permettant de calculer le score d'une frame lors d'un strike.
 */
public abstract class StrikeScoreCalculator implements ScoreCalculator {
    static final String STRIKE_SYMBOL = "X";

    @Override
    /**
     * @see com.telemis.exercice.score.calculator.calculators.ScoreCalculator#calculate(java.util.List, com.telemis.exercice.game.frame.Frame)
     */
    public ScoreContainer calculate(List<Frame> frames, Frame frame) {
        ScoreContainer container = new ScoreContainer(frames.indexOf(frame) + 1);

        container.setFrameScore(calculateStrikeScore(container, frames, frame));

        return container;
    }

    abstract int calculateStrikeScore(ScoreContainer container, List<Frame> frames, Frame frame);
}
