package com.telemis.exercice.game.frame;

import com.telemis.exercice.game.Lancer;
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

    private final List<Lancer> lancers = new ArrayList<>();

    private ScoreType scoreType = ScoreType.NORMAL;

    /**
     * Ajoute le lanceé à la frame en vérifiant que le nombre de lancers maximum n'a pas été atteint. Modifie le type de score suite au lancer, s'il y a lieu.
     *
     * @param lancer le lancer effectué
     */
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

    /**
     * Renvoie la liste des lancers déjà effectués dans cette frame.
     *
     * @return la liste des lancers déjà effectués dans cette frame
     */
    public List<Lancer> getLancers() {
        return Collections.unmodifiableList(this.lancers);
    }

    /**
     * Renvoie le nombre de quilles encore debout dans cette frame.
     *
     * @return le nombre de quilles encore debout dans cette frame
     */
    public int getStandingPins() {
        return this.standingPins;
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
        return "Frame{" + "standingPins=" + standingPins + ", lancers=" + lancers + ", scoreType=" + scoreType + '}';
    }
}
