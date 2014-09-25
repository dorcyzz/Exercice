package com.telemis.exercice.score;

import com.telemis.exercice.game.enums.ScoreType;
import com.telemis.exercice.game.frame.FourLaunchFrame;
import com.telemis.exercice.game.frame.Frame;
import com.telemis.exercice.game.frame.ThreeLaunchFrame;
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
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 * <p/>
 * Classe utilitaire gérant le calcul et l'affichage du score.
 */
public class ScoreManager {

    private static final Logger LOGGER = Logger.getLogger(ScoreManager.class);

    private ScoreManager() {

    }

    /**
     * Renvoie une liste d'objet ScoreContainer représentant le score détaillé de chaque frame.
     *
     * @param frames la liste des frames représentant la prtie d'un joueur
     * @return une liste d'objet ScoreContainer représentant le score détaillé de chaque frame
     */
    public static List<ScoreContainer> calculer(List<Frame> frames) {
        List<ScoreContainer> scoreHistory = new ArrayList<>();

        Map<ScoreCalculatorType, ScoreCalculator> calculators = createCalculatorMap();

        for (Frame frame : frames) {
            ScoreContainer container;

            if (ScoreType.STRIKE == frame.getScoreType() && frame instanceof ThreeLaunchFrame) {
                container = calculators.get(ScoreCalculatorType.STRIKE_NORMAL).calculate(frames, frame);
            } else if (ScoreType.STRIKE == frame.getScoreType() && frame instanceof FourLaunchFrame) {
                container = calculators.get(ScoreCalculatorType.STRIKE_LAST_FRAME).calculate(frames, frame);
            } else if (ScoreType.SPARE == frame.getScoreType()) {
                container = calculators.get(ScoreCalculatorType.SPARE).calculate(frames, frame);
            } else {
                container = calculators.get(ScoreCalculatorType.NORMAL).calculate(frames, frame);
            }

            scoreHistory.add(container);
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

    /**
     * Affiche le score détaillé d'une partie.
     *
     * @param scoreHistory une liste d'objet ScoreContainer représentant le score détaillé de chaque frame
     */
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
