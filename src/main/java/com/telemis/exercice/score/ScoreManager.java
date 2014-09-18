package com.telemis.exercice.score;

import com.telemis.exercice.game.Frame;
import com.telemis.exercice.game.Lancer;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sebastien.vandamme on 17/09/2014.
 */
public class ScoreManager {

    private static final Logger LOGGER = Logger.getLogger(ScoreManager.class);


    private ScoreManager() {

    }

    public static void calculer(List<Frame> frames) {
        List<ScoreContainer> scoreHistory = new ArrayList<>();

        int framePosition = 0;
        int totalScore = 0;

        for (Frame frame : frames) {
            ScoreContainer container = new ScoreContainer(framePosition + 1);

            if (frame.isStrike()) {
                int frameScore = 0;


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

                container.setFrameScore(frameScore);
            } else if (frame.isSpare()) {
                int frameScore = 0;

                final List<Lancer> lancers = frame.getLancers();
                for (Lancer lancer : lancers) {
                    final int quilleAbattue = lancer.getQuilleAbattue();
                    container.getLancersScores().add(quilleAbattue + "");
                    frameScore += quilleAbattue;
                }

                container.getLancersScores().set(lancers.size() - 1, "/");

                if (container.getLancersScores().size() == 2) {
                    container.getLancersScores().add("");
                }

                List<Lancer> nextFrameLancers = frames.get(framePosition + 1).getLancers();

                for (int i = 0; i < 2; ++i) {
                    final int quilleAbattue = nextFrameLancers.get(i).getQuilleAbattue();
                    frameScore += quilleAbattue;
                }

                container.setFrameScore(frameScore);
            } else {
                int frameScore = 0;

                for (Lancer lancer : frame.getLancers()) {
                    final int quilleAbattue = lancer.getQuilleAbattue();
                    container.getLancersScores().add(quilleAbattue + "");
                    frameScore += quilleAbattue;
                }

                container.setFrameScore(frameScore);
            }

            totalScore += container.getFrameScore();

            container.setTotalScore(totalScore);

            scoreHistory.add(container);
            ++framePosition;
        }

        for (ScoreContainer container : scoreHistory) {
            LOGGER.info("Frame " + container.getFrameNumber());
            List<String> lancersScores = container.getLancersScores();
            LOGGER.info(lancersScores.get(0) + " | " + lancersScores.get(1) + " | " + lancersScores.get(2) + ((lancersScores.size() == 4) ? " | " + lancersScores.get(3) : ""));
            LOGGER.info("Frame score = " + container.getFrameScore() + " (total score = " + container.getTotalScore() + ")");
            LOGGER.info("");
        }
    }
}
