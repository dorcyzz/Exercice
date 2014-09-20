package com.telemis.exercice.score.calculator.calculators;

import com.telemis.exercice.game.Frame;
import com.telemis.exercice.game.Lancer;
import com.telemis.exercice.score.ScoreContainer;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 */
public class StrikeScoreCalculator implements ScoreCalculator {
    public static final String STRIKE_SYMBOL = "X";

    private static final StrikeScoreCalculator INSTANCE = new StrikeScoreCalculator();

    private StrikeScoreCalculator() {
        super();
    }

    public static StrikeScoreCalculator getInstance() {
        return INSTANCE;
    }

    @Override
    public ScoreContainer calculer(List<Frame> frames, int currentTotalScore, int framePosition) {
        ScoreContainer container = new ScoreContainer(framePosition + 1);
        Frame frame = frames.get(framePosition);
        int frameScore = 0;

        if (framePosition == 4) {
            container.getLancersScores().add(STRIKE_SYMBOL);
            frameScore += 15;

            for (int i = 1; i < 4; ++i) {
                final int quilleAbattue = frame.getLancers().get(i).getQuilleAbattue();
                frameScore += quilleAbattue;
                container.getLancersScores().add(Integer.toString(quilleAbattue));
            }
        } else {
            frameScore += frame.getLancers().get(0).getQuilleAbattue();
            container.getLancersScores().add(STRIKE_SYMBOL);
            container.getLancersScores().add(StringUtils.EMPTY);
            container.getLancersScores().add(StringUtils.EMPTY);

            List<Lancer> nextFrameLancers = frames.get(framePosition + 1).getLancers();

            for (int i = 0; i < 3; ++i) {
                frameScore += nextFrameLancers.get(i).getQuilleAbattue();
            }
        }

        container.setFrameScore(frameScore);
        container.setTotalScore(currentTotalScore + container.getFrameScore());

        return container;
    }
}
