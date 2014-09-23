package com.telemis.exercice.score;

import com.telemis.exercice.game.FourLaunchFrame;
import com.telemis.exercice.game.Frame;
import com.telemis.exercice.game.ScoreType;
import com.telemis.exercice.game.ThreeLaunchFrame;
import com.telemis.exercice.score.calculator.ScoreCalculatorFactory;
import com.telemis.exercice.score.calculator.calculators.ScoreCalculator;
import com.telemis.exercice.score.calculator.enums.ScoreCalculatorType;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        Map<ScoreCalculatorType, ScoreCalculator> calculators = createCalculatorMap();

        for (Frame frame : frames) {
            ScoreContainer container;

            if (ScoreType.STRIKE == frame.getScoreType() && frame instanceof ThreeLaunchFrame) {
                container = calculators.get(ScoreCalculatorType.STRIKE_NORMAL).calculate(frames, framePosition);
            } else if (ScoreType.STRIKE == frame.getScoreType() && frame instanceof FourLaunchFrame) {
                container = calculators.get(ScoreCalculatorType.STRIKE_LAST_FRAME).calculate(frames, framePosition);
            } else if (ScoreType.SPARE == frame.getScoreType()) {
                container = calculators.get(ScoreCalculatorType.SPARE).calculate(frames, framePosition);
            } else {
                container = calculators.get(ScoreCalculatorType.NORMAL).calculate(frames, framePosition);
            }

            totalScore += container.getFrameScore();

            scoreHistory.add(container);
            ++framePosition;
        }

        return scoreHistory;
    }

    private static Map<ScoreCalculatorType, ScoreCalculator> createCalculatorMap() {
        Map<ScoreCalculatorType, ScoreCalculator> calculators = new HashMap<>();

        calculators.put(ScoreCalculatorType.NORMAL, ScoreCalculatorFactory.createScoreCalculator(ScoreCalculatorType.NORMAL));
        calculators.put(ScoreCalculatorType.SPARE, ScoreCalculatorFactory.createScoreCalculator(ScoreCalculatorType.SPARE));
        calculators.put(ScoreCalculatorType.STRIKE_NORMAL, ScoreCalculatorFactory.createScoreCalculator(ScoreCalculatorType.STRIKE_NORMAL));
        calculators.put(ScoreCalculatorType.STRIKE_LAST_FRAME, ScoreCalculatorFactory.createScoreCalculator(ScoreCalculatorType.STRIKE_LAST_FRAME));

        return calculators;
    }

    public static void displayScore(List<ScoreContainer> scoreHistory) {
        int totalScore = 0;

        for (ScoreContainer container : scoreHistory) {
            LOGGER.info("Frame " + container.getFrameNumber());
            List<String> lancersScores = container.getLancersScores();
            LOGGER.info(lancersScores.get(0) + " | " + lancersScores.get(1) + " | " + lancersScores.get(2)
                    + ((lancersScores.size() == 4) ? " | " + lancersScores.get(3) : StringUtils.EMPTY));
            LOGGER.info("Frame score = " + container.getFrameScore() + " (total score = " + (totalScore += container.getFrameScore()) + ")");
            LOGGER.info(StringUtils.EMPTY);
        }
    }
}
