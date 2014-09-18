package com.telemis.exercice.score;

import com.telemis.exercice.game.Frame;
import com.telemis.exercice.game.Lancer;

import java.util.List;

/**
 * Created by sebastien.vandamme on 17/09/2014.
 */
public class ScoreManager {

    private ScoreManager() {

    }

    public static int calculer(List<Frame> frames) {
        for (Frame frame : frames) {
            if (frame.isStrike()) {

            } else if (frame.isSpare()) {

            } else {
                ScoreContainer container = new ScoreContainer(0);
                int frameScore = 0;

                for (Lancer lancer : frame.getLancers()) {
                    final int quilleAbattue = lancer.getQuilleAbattue();
                    container.getLancersScores().add(quilleAbattue);
                    frameScore += quilleAbattue;
                }

                container.setFrameScore(frameScore);
            }
        }

        return 0;
    }
}
