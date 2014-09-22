package com.telemis.exercice.score.calculator.calculators;

import com.telemis.exercice.game.Frame;
import com.telemis.exercice.game.Lancer;
import com.telemis.exercice.score.ScoreContainer;

import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 *
 * Classe permettant de calculer le score d'une frame normale.
 */
public class NormalScoreCalculator implements ScoreCalculator {

    private static final NormalScoreCalculator INSTANCE = new NormalScoreCalculator();

    private NormalScoreCalculator() {
        super();
    }

    public static NormalScoreCalculator getInstance() {
        return INSTANCE;
    }

    @Override
    /**
     * @see com.telemis.exercice.score.calculator.calculators.ScoreCalculator#calculate(java.util.List, int, int)
     */
    public ScoreContainer calculate(List<Frame> frames, int currentTotalScore, int framePosition) {
        ScoreContainer container = new ScoreContainer(framePosition + 1);
        Frame frame = frames.get(framePosition);
        int frameScore = 0;

        for (Lancer lancer : frame.getLancers()) {
            final int quilleAbattue = lancer.getFallenQuilles();
            container.getLancersScores().add(Integer.toString(quilleAbattue));
            frameScore += quilleAbattue;
        }

        container.setFrameScore(frameScore);
        container.setTotalScore(currentTotalScore + container.getFrameScore());

        return container;
    }
}