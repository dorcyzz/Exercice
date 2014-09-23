package com.telemis.exercice.game.frame;

import com.telemis.exercice.game.Lancer;
import com.telemis.exercice.game.enums.ScoreType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 23/09/2014.
 */
public abstract class Frame {

    public static final int TOTAL_NUMBER_OF_PINS = 15;

    private int standingPins = TOTAL_NUMBER_OF_PINS;

    private final List<Lancer> lancers = new ArrayList<>();

    private ScoreType scoreType = ScoreType.NORMAL;

    public void addLancer(Lancer lancer) {
        checkMaximumLaunch();

        this.lancers.add(lancer);

        this.standingPins -= lancer.getFallenPins();

        if (this.standingPins < 0) {
            this.standingPins = 0;
        }

        if (this.standingPins == 0) {
            if (lancers.size() == 1) {
                scoreType = ScoreType.STRIKE;
            } else if (scoreType != ScoreType.STRIKE) {
                scoreType = ScoreType.SPARE;
            }
        }
    }

    abstract void checkMaximumLaunch();

    public List<Lancer> getLancers() {
        return Collections.unmodifiableList(this.lancers);
    }

    public int getStandingPins() {
        return this.standingPins;
    }

    public ScoreType getScoreType() {
        return scoreType;
    }
}
