package com.telemis.exercice.score.calculator.calculators;

import com.telemis.exercice.game.Frame;
import com.telemis.exercice.game.Lancer;
import com.telemis.exercice.score.ScoreContainer;

import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 * <p/>
 * Classe permettant de calculer le score d'une frame normale.
 */
public class NormalScoreCalculator implements ScoreCalculator {

    private static final NormalScoreCalculator INSTANCE = new NormalScoreCalculator();

    private NormalScoreCalculator() {

    }

    public static NormalScoreCalculator getInstance() {
        return INSTANCE;
    }

    @Override
    /**
     * @see com.telemis.exercice.score.calculator.calculators.ScoreCalculator#calculate(java.util.List, int, int)
     */
    public ScoreContainer calculate(List<Frame> frames, int framePosition) {
        ScoreContainer container = new ScoreContainer(framePosition + 1);
        Frame frame = frames.get(framePosition);
        int frameScore = 0;

        for (Lancer lancer : frame.getLancers()) {
            final int fallenPins = lancer.getFallenPins();
            container.getLancersScores().add(Integer.toString(fallenPins));
            frameScore += fallenPins;
        }

        container.setFrameScore(frameScore);

        return container;
    }
}