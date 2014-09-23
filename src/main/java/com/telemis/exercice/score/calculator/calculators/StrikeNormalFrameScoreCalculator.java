package com.telemis.exercice.score.calculator.calculators;

import com.telemis.exercice.game.Frame;
import com.telemis.exercice.game.Lancer;
import com.telemis.exercice.score.ScoreContainer;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 * <p/>
 * Classe permettant de calculer le score d'une frame lors d'un strike ayant lieu dans la cinquième frame.
 */

//TODO unit test
public class StrikeNormalFrameScoreCalculator extends StrikeScoreCalculator {
    private static final StrikeScoreCalculator INSTANCE = new StrikeNormalFrameScoreCalculator();

    private StrikeNormalFrameScoreCalculator() {

    }

    public static StrikeScoreCalculator getInstance() {
        return INSTANCE;
    }

    int calculateStrikeScore(ScoreContainer container, List<Frame> frames, Frame frame) {
        int launch = 0;
        int strikeScore = 0;

        List<Frame> frames1 = frames.subList(frames.indexOf(frame) + 1, frames.size());

        container.getLancersScores().add(StringUtils.EMPTY);
        container.getLancersScores().add(StringUtils.EMPTY);

        for (Frame frame1 : frames1) {
            List<Lancer> lancers = frame1.getLancers();

            for (Lancer lancer : lancers) {
                strikeScore += lancer.getFallenPins();
                ++launch;

                if (launch >= 3) {
                    return strikeScore;
                }
            }
        }

        return strikeScore;
    }
}
