package com.telemis.exercice.score.calculator.calculators;

import com.telemis.exercice.game.Lancer;
import com.telemis.exercice.game.frame.Frame;
import com.telemis.exercice.score.ScoreContainer;

import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 * <p/>
 * Classe permettant de calculer le score d'une frame lors d'un strike ayant lieu dans la cinquième frame.
 */
public class StrikeLastFrameScoreCalculator extends StrikeScoreCalculator {
    private static final StrikeScoreCalculator INSTANCE = new StrikeLastFrameScoreCalculator();

    private StrikeLastFrameScoreCalculator() {

    }

    public static StrikeScoreCalculator getInstance() {
        return INSTANCE;
    }

    int calculateStrikeScore(ScoreContainer container, List<Frame> frames, Frame frame) {
        int frameScore = 0;

        for (Lancer lancer : frame.getLancers()) {
            int fallenPins = lancer.getFallenPins();
            frameScore += fallenPins;

            if (fallenPins == 15) {
                container.getLancersScores().add(STRIKE_SYMBOL);
            } else {
                container.getLancersScores().add(Integer.toString(lancer.getFallenPins()));
            }
        }

        return frameScore;
    }
}
