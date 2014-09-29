package com.telemis.exercice.score.calculator.calculators.normal;

import com.telemis.exercice.game.Launch;
import com.telemis.exercice.game.frame.Frame;
import com.telemis.exercice.score.ScoreContainer;
import com.telemis.exercice.score.calculator.calculators.ScoreCalculator;

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

        for (Launch launch : frame.getLaunches()) {
            final int fallenPins = launch.getFallenPins();
            frameScore += fallenPins;
            container.getLancersScores().add(Integer.toString(fallenPins));
        }

        container.setFrameScore(frameScore);

        return container;
    }
}