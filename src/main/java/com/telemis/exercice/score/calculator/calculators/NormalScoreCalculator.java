package com.telemis.exercice.score.calculator.calculators;

import com.telemis.exercice.game.Lancer;
import com.telemis.exercice.game.frame.Frame;
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
     * @see com.telemis.exercice.score.calculator.calculators.ScoreCalculator#calculate(java.util.List, com.telemis.exercice.game.frame.Frame)
     */
    public ScoreContainer calculate(List<Frame> frames, Frame frame) {
        ScoreContainer container = new ScoreContainer(frames.indexOf(frame) + 1);
        int frameScore = 0;

        for (Lancer lancer : frame.getLancers()) {
            final int fallenPins = lancer.getFallenPins();
            frameScore += fallenPins;
            container.getLancersScores().add(Integer.toString(fallenPins));
        }

        container.setFrameScore(frameScore);

        return container;
    }
}