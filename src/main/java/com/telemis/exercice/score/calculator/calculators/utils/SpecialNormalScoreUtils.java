package com.telemis.exercice.score.calculator.calculators.utils;

import com.telemis.exercice.game.Launch;
import com.telemis.exercice.game.frame.Frame;

import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 29/09/2014.
 */
public final class SpecialNormalScoreUtils {

    private SpecialNormalScoreUtils() {

    }

    public static int calculateScoreInNextFramesPart(List<Frame> framesFromCurrentFrame, int currentFrameScore, int numberOfLaunchesFromNextFrames) {
        int currentScore = currentFrameScore;
        int numberOfLaunchesAdded = 0;

        for (Frame frame : framesFromCurrentFrame) {

            for (Launch launch : frame.getLaunches()) {
                currentScore += launch.getFallenPins();
                ++numberOfLaunchesAdded;

                if (numberOfLaunchesAdded >= numberOfLaunchesFromNextFrames) {
                    return currentScore;
                }
            }
        }

        return currentScore;
    }
}
