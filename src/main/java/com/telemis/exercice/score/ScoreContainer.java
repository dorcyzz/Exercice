package com.telemis.exercice.score;

import com.telemis.exercice.game.Frame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 18/09/2014.
 */
public class ScoreContainer {

    private final int frameNumber;

    private final List<Integer> lancersScores =  new ArrayList<>();

    private int frameScore;

    public ScoreContainer(final int frameNumber) {
        this.frameNumber = frameNumber;
    }

    public int getFrameNumber() {
        return frameNumber;
    }

    public List<Integer> getLancersScores() {
        return lancersScores;
    }

    public int getFrameScore() {
        return frameScore;
    }

    public void setFrameScore(int frameScore) {
        this.frameScore = frameScore;
    }
}
