package com.telemis.exercice.score;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 * <p/>
 * Classe contenant la représentation détaillée du score d'une frame.
 */
public class ScoreContainer {

    private final int frameNumber;

    private final List<String> lancersScores = new ArrayList<>();

    private int frameScore;

    public ScoreContainer(final int frameNumber) {
        this.frameNumber = frameNumber;
    }

    /**
     * Renvoie le numéro d'ordre de la frame.
     *
     * @return le numéro d'ordre de la frame
     */
    public int getFrameNumber() {
        return frameNumber;
    }

    /**
     * Renvoie la liste des points marqués à chaque lancés de la frame.
     *
     * @return la liste des points marqués à chaque lancés
     */
    public List<String> getLancersScores() {
        return lancersScores;
    }

    /**
     * Renvoie le score total de la frame.
     *
     * @return le score total de la frame
     */
    public int getFrameScore() {
        return frameScore;
    }

    /**
     * Set le score total de la frame.
     *
     * @param frameScore le score total de la frame
     */
    public void setFrameScore(int frameScore) {
        this.frameScore = frameScore;
    }
}
