package com.telemis.exercice.score.calculator.calculators;

import com.telemis.exercice.game.Frame;
import com.telemis.exercice.game.Lancer;
import com.telemis.exercice.score.ScoreContainer;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 *
 * Classe permettant de calculer le calculateStrikeScore d'une frame lors d'un strike.
 */
public class StrikeScoreCalculator implements ScoreCalculator {
    private static final String STRIKE_SYMBOL = "X";

    private static final StrikeScoreCalculator INSTANCE = new StrikeScoreCalculator();

    private StrikeScoreCalculator() {
        super();
    }

    public static StrikeScoreCalculator getInstance() {
        return INSTANCE;
    }

    @Override
    /**
     * @see com.telemis.exercice.score.calculator.calculators.ScoreCalculator#calculate(java.util.List, int, int)
     */
    public ScoreContainer calculate(List<Frame> frames, int currentTotalScore, int framePosition) {
        ScoreContainer container = new ScoreContainer(framePosition + 1);
        Frame frame = frames.get(framePosition);

        int frameScore = frame.getLancers().get(0).getFallenQuilles();
        container.getLancersScores().add(STRIKE_SYMBOL);

        if (framePosition == 4) {
            for (int i = 1; i < 4; ++i) {
                final int fallenQuille = frame.getLancers().get(i).getFallenQuilles();
                frameScore += fallenQuille;
                container.getLancersScores().add(Integer.toString(fallenQuille));
            }
        } else {
            frameScore += calculateStrikeScore(frames.subList(framePosition + 1, frames.size()));
            container.getLancersScores().add(StringUtils.EMPTY);
            container.getLancersScores().add(StringUtils.EMPTY);
        }

        container.setFrameScore(frameScore);
        container.setTotalScore(currentTotalScore + container.getFrameScore());

        return container;
    }

    //TODO améliorer
    private int calculateStrikeScore(List<Frame> frames) {
        int launch = 0;
        int strikeScore = 0;

        for (Frame frame : frames) {
            List<Lancer> lancers = frame.getLancers();

            for (Lancer lancer : lancers) {
                strikeScore += lancer.getFallenQuilles();
                ++launch;

                if (launch >= 3) {
                    return strikeScore;
                }
            }
        }

        return strikeScore;
    }
}
