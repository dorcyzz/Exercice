package com.telemis.exercice.score.calculator.calculators;

import com.telemis.exercice.game.Frame;
import com.telemis.exercice.score.ScoreContainer;

import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 *
 * Classe permettant de calculer le calculateStrikeScore d'une frame lors d'un strike.
 */
public abstract class StrikeScoreCalculator implements ScoreCalculator {
    private static final String STRIKE_SYMBOL = "X";

    @Override
    /**
     * @see com.telemis.exercice.score.calculator.calculators.ScoreCalculator#calculate(java.util.List, int)
     */
    //TODO passer frame plut�t que frameposition
    public ScoreContainer calculate(List<Frame> frames, int framePosition) {
        ScoreContainer container = new ScoreContainer(framePosition + 1);
        Frame frame = frames.get(framePosition);

        int frameScore = frame.getLancers().get(0).getFallenPins();
        container.getLancersScores().add(STRIKE_SYMBOL);
        container.setFrameScore(frameScore + calculateStrikeScore(container, frames, frame));

        return container;
    }

    abstract int calculateStrikeScore(ScoreContainer container, List<Frame> frames, Frame frame);
}
