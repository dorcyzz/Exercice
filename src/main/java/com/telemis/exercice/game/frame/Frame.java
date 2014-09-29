package com.telemis.exercice.game.frame;

import com.telemis.exercice.game.Launch;
import com.telemis.exercice.game.enums.ScoreType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 23/09/2014.
 * <p/>
 * Classe abstraite représentant une frame.
 */
public abstract class Frame {

    public static final int TOTAL_NUMBER_OF_PINS = 15;

    private int standingPins = TOTAL_NUMBER_OF_PINS;

    private final List<Launch> launches = new ArrayList<>();

    private ScoreType scoreType = ScoreType.NORMAL;

    /**
     * Ajoute le lancé à la frame en vérifiant que le nombre de lancers maximum n'a pas été atteint. Modifie le type de score suite au lancer, s'il y a lieu.
     *
     * @param launch le lancer effectué
     */
    public void addLaunch(Launch launch) {
        checkMaximumLaunchesAuthorized();

        this.launches.add(launch);
        this.standingPins -= launch.getFallenPins();

        if (this.standingPins < 0) {
            this.standingPins = 0;
        }

        checkIfSpecialScore();
    }

    private void checkIfSpecialScore() {
        if (this.standingPins == 0) {
            if (launches.size() == 1) {
                scoreType = ScoreType.STRIKE;
            } else if (scoreType != ScoreType.STRIKE) {
                scoreType = ScoreType.SPARE;
            }
        }
    }

    /**
     * Vérifie que le nombre maximum de lancer autorisés n'est pas dépassé.
     */
    abstract void checkMaximumLaunchesAuthorized();

    /**
     * Renvoie la liste des lancers déjà effectués dans cette frame.
     *
     * @return la liste des lancers déjà effectués dans cette frame
     */
    public List<Launch> getLaunches() {
        return Collections.unmodifiableList(this.launches);
    }

    /**
     * Renvoie le nombre de quilles encore debout dans cette frame.
     *
     * @return le nombre de quilles encore debout dans cette frame
     */
    public int getStandingPins() {
        return this.standingPins;
    }

    void setStandingPins(int standingPins) {
        this.standingPins = standingPins;
    }

    /**
     * Renvoie le type de score.
     *
     * @return le type de score
     * @see com.telemis.exercice.game.enums.ScoreType
     */
    public ScoreType getScoreType() {
        return scoreType;
    }

    @Override
    /**
     * @see Object#toString()
     */
    public String toString() {
        return "Frame{" + "standingPins=" + standingPins + ", lancers=" + launches + ", scoreType=" + scoreType + '}';
    }
}
