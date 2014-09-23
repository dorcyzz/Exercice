package com.telemis.exercice.score.calculator.calculators;

import com.telemis.exercice.game.Frame;
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
        super();
    }

    public static StrikeScoreCalculator getInstance() {
        return INSTANCE;
    }

    int calculateStrikeScore(ScoreContainer container, List<Frame> frames, Frame frame) {
        int frameScore = 0;

        for (int i = 1; i < 4; ++i) {
            //Prend toujours la dernière frame
            final int fallenPins = frames.get(frames.size() - 1).getLancers().get(i).getFallenPins();
            frameScore += fallenPins;
            container.getLancersScores().add(Integer.toString(fallenPins));
        }

        return frameScore;
    }
}
