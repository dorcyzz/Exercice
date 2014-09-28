package com.telemis.exercice.score.calculator.calculators.strike;

import com.telemis.exercice.game.Lancer;
import com.telemis.exercice.game.frame.Frame;
import com.telemis.exercice.score.ScoreContainer;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 * <p/>
 * Classe permettant de calculer le score d'une frame lors d'un strike ayant lieu dans la troisième frame.
 */
public class StrikeNormalFrameScoreCalculator extends StrikeScoreCalculator {
    private static final StrikeScoreCalculator INSTANCE = new StrikeNormalFrameScoreCalculator();

    private StrikeNormalFrameScoreCalculator() {

    }

    public static StrikeScoreCalculator getInstance() {
        return INSTANCE;
    }

    int calculateStrikeScore(ScoreContainer container, List<Frame> frames, Frame currentFrame) {
        int launch = 0;
        int strikeScore = currentFrame.getLancers().get(0).getFallenPins();

        List<Frame> framesFromCurrentFrame = frames.subList(frames.indexOf(currentFrame) + 1, frames.size());

        completeRepresentation(container);

        for (Frame frame : framesFromCurrentFrame) {
            List<Lancer> lancers = frame.getLancers();

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

    private void completeRepresentation(ScoreContainer container) {
        container.getLancersScores().add(STRIKE_SYMBOL);
        container.getLancersScores().add(StringUtils.EMPTY);
        container.getLancersScores().add(StringUtils.EMPTY);
    }
}
