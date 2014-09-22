package com.telemis.exercice.score;

import com.telemis.exercice.game.Frame;
import com.telemis.exercice.score.calculator.ScoreCalculatorFactory;
import com.telemis.exercice.score.calculator.calculators.ScoreCalculator;
import com.telemis.exercice.score.calculator.enums.ScoreCalculatorType;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 18/09/2014.
 */
public class ScoreManager {

    private static final Logger LOGGER = Logger.getLogger(ScoreManager.class);

    private ScoreManager() {

    }

    public static List<ScoreContainer> calculer(List<Frame> frames) {
        List<ScoreContainer> scoreHistory = new ArrayList<>();

        int framePosition = 0;
        int totalScore = 0;
        ScoreCalculator scoreCalculator;

        for (Frame frame : frames) {
            ScoreContainer container;

            if (frame.isStrike()) {
                scoreCalculator = ScoreCalculatorFactory.createScoreCalculator(ScoreCalculatorType.STRIKE);
                container = scoreCalculator.calculate(frames, totalScore, framePosition);
            } else if (frame.isSpare()) {
                scoreCalculator = ScoreCalculatorFactory.createScoreCalculator(ScoreCalculatorType.SPARE);
                container = scoreCalculator.calculate(frames, totalScore, framePosition);
            } else {
                scoreCalculator = ScoreCalculatorFactory.createScoreCalculator(ScoreCalculatorType.NORMAL);
                container = scoreCalculator.calculate(frames, totalScore, framePosition);
            }

            totalScore += container.getFrameScore();

            scoreHistory.add(container);
            ++framePosition;
        }

        return scoreHistory;
    }

    public static void displayScore(List<ScoreContainer> scoreHistory) {
        for (ScoreContainer container : scoreHistory) {
            LOGGER.info("Frame " + container.getFrameNumber());
            List<String> lancersScores = container.getLancersScores();
            LOGGER.info(lancersScores.get(0) + " | " + lancersScores.get(1) + " | " + lancersScores.get(2)
                    + ((lancersScores.size() == 4) ? " | " + lancersScores.get(3) : StringUtils.EMPTY));
            LOGGER.info("Frame score = " + container.getFrameScore() + " (total score = " + container.getTotalScore() + ")");
            LOGGER.info(StringUtils.EMPTY);
        }
    }
}
