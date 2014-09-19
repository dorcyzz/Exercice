package com.telemis.exercice.score;

import com.telemis.exercice.game.Frame;
import com.telemis.exercice.game.Lancer;
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

        for (Frame frame : frames) {
            ScoreContainer container = new ScoreContainer(framePosition + 1);
            int frameScore = 0;

            if (frame.isStrike()) {
                frameScore = calculerScoreStrike(frames, framePosition, frame, container, frameScore);
            } else if (frame.isSpare()) {
                frameScore = calculerScoreSpare(frames, framePosition, frame, container);
            } else {
                frameScore = calculerScoreNormal(frame.getLancers(), container);
            }

            container.setFrameScore(frameScore);
            totalScore += container.getFrameScore();

            container.setTotalScore(totalScore);

            scoreHistory.add(container);
            ++framePosition;
        }

        return scoreHistory;
    }

    private static int calculerScoreSpare(List<Frame> frames, int framePosition, Frame frame, ScoreContainer container) {
        int frameScore;
        final List<Lancer> lancers = frame.getLancers();

        frameScore = calculerScoreNormal(lancers, container);

        container.getLancersScores().set(lancers.size() - 1, "/");

        if (container.getLancersScores().size() == 2) {
            container.getLancersScores().add("");
        }

        List<Lancer> nextFrameLancers = frames.get(framePosition + 1).getLancers();

        for (int i = 0; i < 2; ++i) {
            final int quilleAbattue = nextFrameLancers.get(i).getQuilleAbattue();
            frameScore += quilleAbattue;
        }
        return frameScore;
    }

    private static int calculerScoreStrike(List<Frame> frames, int framePosition, Frame frame, ScoreContainer container, int frameScore) {
        if (framePosition == 4) {
            container.getLancersScores().add("X");
            frameScore += 15;

            for (int i = 1; i < 4; ++i) {
                final int quilleAbattue = frame.getLancers().get(i).getQuilleAbattue();
                frameScore += quilleAbattue;
                container.getLancersScores().add(quilleAbattue + "");
            }
        } else {
            for (Lancer lancer : frame.getLancers()) {
                final int quilleAbattue = lancer.getQuilleAbattue();
                container.getLancersScores().add("X");
                frameScore += quilleAbattue;
            }

            List<Lancer> nextFrameLancers = frames.get(framePosition + 1).getLancers();

            for (int i = 0; i < 3; ++i) {
                final int quilleAbattue = nextFrameLancers.get(i).getQuilleAbattue();
                frameScore += quilleAbattue;
            }
            container.getLancersScores().add("");
            container.getLancersScores().add("");
        }
        return frameScore;
    }

    private static int calculerScoreNormal(List<Lancer> lancers, ScoreContainer container) {
        int frameScore = 0;

        for (Lancer lancer : lancers) {
            final int quilleAbattue = lancer.getQuilleAbattue();
            container.getLancersScores().add(quilleAbattue + "");
            frameScore += quilleAbattue;
        }

        return frameScore;
    }

    public static void displayScore(List<ScoreContainer> scoreHistory) {
        for (ScoreContainer container : scoreHistory) {
            LOGGER.info("Frame " + container.getFrameNumber());
            List<String> lancersScores = container.getLancersScores();
            LOGGER.info(lancersScores.get(0) + " | " + lancersScores.get(1) + " | " + lancersScores.get(2) + ((lancersScores.size() == 4) ? " | " + lancersScores.get(3) : ""));
            LOGGER.info("Frame score = " + container.getFrameScore() + " (total score = " + container.getTotalScore() + ")");
            LOGGER.info("");
        }
    }
}
